package appli.todolistjx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.sql.SQLException;

public class InscriptionController {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private PasswordField motDePasse;
    @FXML
    private PasswordField motDePasseConfirmer;
    @FXML
    private Label labelErreur;

    private boolean champVide(String str) {
        return str == null || str.trim().isEmpty();
    }

    @FXML
    public void inscrireUtilisateur() throws SQLException {

        String nomUser = nom.getText();
        String prenomUser = prenom.getText();
        String emailUser = email.getText();
        String motDePasseUser = motDePasse.getText();
        String motDePasseConfirmerUser = motDePasseConfirmer.getText();

        if (champVide(nomUser) || champVide(prenomUser) || champVide(emailUser) || champVide(motDePasseUser) || champVide(motDePasseConfirmerUser)) {
            labelErreur.setText("Veuillez remplir tous les champs !");
            return;
        }

        if (!motDePasseUser.equals(motDePasseConfirmerUser)) {
            labelErreur.setText("Erreur, les mots de passe ne sont pas identique!");
            return;
        }

        Utilisateur nouvelUtilisateur = new Utilisateur(nomUser,prenomUser, emailUser, motDePasseUser);
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

        boolean ajoutReussi = utilisateurRepository.inscription(nouvelUtilisateur);

        if (ajoutReussi) {
            labelErreur.setText("Utilisateur ajouté !");
        } else {
            labelErreur.setText("Erreur !");
        }
    }
}
