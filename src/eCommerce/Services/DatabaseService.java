package eCommerce.Services;

import java.sql.*;

// establishes connections; connection variables and closes connections.
public class DatabaseService {

    // imported from java.sql. Not part of the Java library
    private Connection connection = null;
    private Statement statement = null;

    // CONNECT TO mySQL
    public Connection mySQLConnect() throws Exception {
        // load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // CONNECT - DIAL UP TONE COMMENCE!
        connection = DriverManager.getConnection("jdbc:mysql://localhost/eCommerce?" +
                "user=root&password="enter_password"@&useSSL=false&serverTimezone=UTC");
        // in the url: port; link; server; database,which table; username/password; serverTimezone
        return connection;
    }

    // OPENS CONNECTION TO PULL DATA
    public Statement sqlStatement() throws Exception {
        // load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // CONNECT - DIAL UP TONE COMMENCE!
        connection = DriverManager.getConnection("jdbc:mysql://localhost/eCommerce?" +
                "user=root&password="enter_password"@&useSSL=false&serverTimezone=UTC");
        // in the url: port; link; server; database,which table; username/password; serverTimezone
        statement = connection.createStatement();
        // return connection "statement"
        return statement;
    }

    // CLOSE CONNECTIONS
    public void closeMySQL(Statement statement, Connection connection) {
        try {
                statement.close();
                connection.close();
                // handles exceptions with disconnecting to mySQL
        } catch (SQLException e) {
            System.out.println("Error disconnecting from mySQL");
            e.printStackTrace();
        }
    }
    // overload statement and connections to ensure disconnect
    private void close(PreparedStatement preparedStatement, Connection connection) {
        try {
            preparedStatement.close();
            connection.close();
                // handles exceptions with disconnecting to mySQL
        } catch (SQLException e) {
            System.out.println("Error disconnecting from mySQL");
            e.printStackTrace();
        }
    }
}
