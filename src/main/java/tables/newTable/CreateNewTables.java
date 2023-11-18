package tables.newTable;

import database.ConnectorToDatabase;
import service.BookService;
import service.GenreService;
import service.InformationService;
import service.impl.BookImpl;
import service.impl.GenreImpl;
import service.impl.InformationImpl;

import java.sql.*;

public class CreateNewTables {
    private Connection connection;
    private Statement statement;
    private BookService bookService;
    private GenreService genreService;
    private InformationService informationService;

    public void create() {
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        connection = connectorToDatabase.getConnection();
        statement = connectorToDatabase.getStatement();
        bookService = new BookImpl();
        genreService = new GenreImpl();
        informationService = new InformationImpl();
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
                    statement.executeUpdate(myTableName);
                    bookService.insert("Master and Margarita", "Bulgakov", 1);
                    bookService.insert("Idiot", "Dostoevskiy", 1);
                    bookService.insert("Lirika", "Pasternak", 2);
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
                    statement.executeUpdate(myTableName);
                    genreService.insert("Roman");
                    genreService.insert("Poezia");
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if (!rsInformation.next()) {
                String myTableName = "CREATE TABLE information ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "id_book INT,"
                        + "cost INT,"
                        + "circulation INT,"
                        +"FOREIGN KEY(id_book) REFERENCES book(id))";
                try {
                    statement = connection.createStatement();
                    statement.executeUpdate(myTableName);
                    informationService.insert(1, 35, 100);
                    informationService.insert(2, 20, 300);
                    informationService.insert(3, 40, 200);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
