package appli.todolistjx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.sql.SQLException;

public class InscriptionController {

    @FXML
    private TextField conf;

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button register;

    @FXML
    private Label labelErreur;

    private boolean champVide(String str) {
        return str == null || str.trim().isEmpty();
    }

    @FXML
    public void onRegisterClickButton(ActionEvent event) throws SQLException {

        String nomUser = nom.getText();
        String prenomUser = prenom.getText();
        String emailUser = email.getText();
        String motDePasseUser = mdp.getText();
        String motDePasseConfirmerUser = conf.getText();

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
            nom.clear();
            prenom.clear();
            email.clear();
            mdp.clear();
        } else {
            labelErreur.setText("Erreur !");
        }
    }
}
