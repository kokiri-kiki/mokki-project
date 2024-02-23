package org.example.mokkiproject;

import java.sql.*;

public class DB {

    private static final String url = "jdbc:mysql://mokki-project.mysql.database.azure.com:3306/vn?useSSL=true&requireSSL=false&serverSslCert=/Users/anastasiia/Documents/Ohjelmistotuotanto I (Software Engineering I)/DigiCertGlobalRootCA.crt.pem";
    private static final String username = "dbadmin";
    private static final String password = "Kuopio1234";

    // SQL-запросы
    /*
    private static final String SEARCH_QUERY = "SELECT * FROM asiakas WHERE (etunimi LIKE ?) AND (sukunimi LIKE ?) AND (puhelinnro LIKE ?) AND (email LIKE ?) AND (postinro LIKE ?) AND (lahiosoite LIKE ?)";
    private static final String INSERT_QUERY = "INSERT INTO asiakas (etunimi, sukunimi, puhelinnro, email, postinro, lahiosoite) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE asiakas SET etunimi = ?, sukunimi = ?, puhelinnro = ?, email = ?, postinro = ?, lahiosoite = ? WHERE etunimi = ? AND sukunimi = ? AND puhelinnro = ? AND email = ? AND postinro = ? AND lahiosoite = ?";
    */
    public static void DB_connect() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DBinsert(String insertString) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement = connection.prepareStatement(insertString)) {
            statement.executeUpdate();
        }
    }

    public static String DBsearch(String searchString) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuilder alue = new StringBuilder();
        try (PreparedStatement statement = connection.prepareStatement(searchString)) {


            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nimi = resultSet.getString("nimi");
                    alue.append(nimi);
                }
            }
        }
        return alue.toString();
    }

}
