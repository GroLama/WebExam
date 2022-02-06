package com.database;
import java.sql.*;
import java.util.Objects;

public class examListData {
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

    //Retrieve value from Database and create array of exam list
    public String[] retrieveExamsList(){
        Statement statement = null;
        ResultSet resultat = null;
        int state = 0;
        String[] list;
        loadDatabase();

        try {
            statement = connexion.createStatement();


            resultat = statement.executeQuery("SELECT examType FROM exam;");
            int count = 0;

            while (resultat.next()) {
                count++;
            }
            list = new String[count];
            int atIndex = 0;
            while (resultat.next()){
                list[atIndex]=resultat.getString("examType");
                atIndex++;
            }

        } catch (SQLException e) {
        } finally {
            list = new String[0];
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
        return list;
    }
}
