package repository;

import model.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurRepository {

    public boolean inscription (Utilisateur utilisateur) throws SQLException {
        Connection maConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/javafx","root",""
        );

        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String email = utilisateur.getEmail();
        String password = utilisateur.getPassword();

        PreparedStatement requetePrepareInsert =
                maConnection.prepareStatement(
                        "INSERT INTO utilisateur(nom,prenom,email,mdpmot_de_passe) " +
                                "VALUES (?,?,?,?,?)"
                );
        requetePrepareInsert.setString(1, nom);
        requetePrepareInsert.setString(2, prenom);
        requetePrepareInsert.setString(3, email);
        requetePrepareInsert.setString(4, password);
        requetePrepareInsert.executeUpdate();

        if (requetePrepareInsert.executeUpdate() == 1) {
            return true;
        }
        else {
            return true;
        }
    }
}


