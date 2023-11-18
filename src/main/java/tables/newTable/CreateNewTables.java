package tables.newTable;

import database.ConnectorToDatabase;

import java.sql.*;

public class CreateNewTables {
    private Connection connection;
    private Statement statement;

    public void create() {
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        connection = connectorToDatabase.getConnection();
        statement = connectorToDatabase.getStatement();
        DatabaseMetaData md = null;
        try {
            md = connection.getMetaData();
            ResultSet rsBook = md.getTables(null, null, "book", null);
            ResultSet rsGenre = md.getTables(null, null, "genre", null);
            ResultSet rsInformation = md.getTables(null, null, "information", null);
            if (!rsBook.next()) {
                String myTableName = "CREATE TABLE book ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "title VARCHAR(20),"
                        + "author VARCHAR(20),"
                        + "id_genre INT)";
                try {
                    statement = connection.createStatement();
                    //The next line has the issue
                    statement.executeUpdate(myTableName);
                    System.out.println("Table Created");
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if (!rsGenre.next()) {
                String myTableName = "CREATE TABLE genre ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "genre VARCHAR(20))";
                try {
                    statement = connection.createStatement();
                    //The next line has the issue
                    statement.executeUpdate(myTableName);
                    System.out.println("Table Created");
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if (!rsInformation.next()) {
                String myTableName = "CREATE TABLE information ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "id_book INT,"
                        + "cost INT,"
                        + "circulation INT)";
                try {
                    statement = connection.createStatement();
                    //The next line has the issue
                    statement.executeUpdate(myTableName);
                    System.out.println("Table Created");
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
