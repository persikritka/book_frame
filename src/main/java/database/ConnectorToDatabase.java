package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorToDatabase {
    private Connection connection;
    private Statement statement;
    private final String URL_TO_CONNECT = "jdbc:mysql://localhost:3306/schooldatabase";
    private final String USER = "root";
    private final String PASSWORD = "margo1339834";
    public ConnectorToDatabase(){
        try {
            connection =  DriverManager.getConnection(URL_TO_CONNECT, USER, PASSWORD);
            statement =connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}