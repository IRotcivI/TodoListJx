package database;

import eu.hansolo.fx.countries.tools.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    private String server = "localhost";
    private String nomDeLaBase;
    private String utilisateur;
    private String password;

    public database(String server, String nomDeLaBase, String utilisateur, String password) {
        this.server = server;
        this.nomDeLaBase = nomDeLaBase;
        this.utilisateur = utilisateur;
        this.password = password;
    }

    private String getUrl (){
        return "jdbc:mysql://"+server+"/"+nomDeLaBase;
    }

    public Connection getConnection (){
        try {
            Connection cnx = (Connection) DriverManager.getConnection(this.getUrl(),this.utilisateur,this.password);
            System.out.print("Etat de la connexion : ");
            System.out.print(((java.sql.Connection) cnx).isClosed()?"fermée":"ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la tentative de connexion à la base de données.");
            e.printStackTrace();
            return null;
        }
    }
}
