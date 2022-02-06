package com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class userData {
    Connection connexion;

    //Load DataBase and connect
    private void loadDatabase() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Retrieve value from Database and check if user have correct credentials
    public int checkUserIsDefined(String username,String password){
        Statement statement = null;
        ResultSet resultat = null;
        int state = 0;

        loadDatabase();

        try {
            statement = connexion.createStatement();


            resultat = statement.executeQuery("SELECT username, password FROM users;");


            while (resultat.next()) {
                String returnUsername = resultat.getString("username");
                String  returnPassword = resultat.getString("password");
                System.out.println((returnUsername));
                System.out.println(username);
                System.out.println(password);

               if(Objects.equals(returnUsername, username)&&Objects.equals(returnPassword, password)){

                   state = 1;
               }
            }

        } catch (SQLException e) {
        } finally {

            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        return state;
    }
}
