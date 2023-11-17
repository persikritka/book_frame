package service.impl;

import database.ConnectorToDatabase;
import service.BookService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookImpl implements BookService {
    private final ConnectorToDatabase connectorToDatabase;
    public BookImpl(){
        connectorToDatabase=new ConnectorToDatabase();
    }
    @Override
    public ResultSet getAllDataBook() {
        try {
            return connectorToDatabase.getStatement().executeQuery("select * from book");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllDataBookGenre() {
        try {
            return connectorToDatabase.getStatement().executeQuery("SELECT title, author, id_genre, genre FROM book INNER JOIN genre ON id_genre = genre.id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllDataBookInformation() {
        try {
            return connectorToDatabase.getStatement().executeQuery("SELECT title, author, id_genre, id_book, cost, circulation FROM book INNER JOIN information ON book.id = id_book");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllData() {
        try {
            return connectorToDatabase.getStatement().executeQuery(" SELECT title, author, id_genre, genre, id_book, cost, circulation FROM book INNER JOIN genre ON id_genre = genre.id INNER JOIN information ON book.id = id_book");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String title, String author, int idGenre) throws SQLException {
        String str = "insert into book(title, author, id_genre) values("+"'"
                + title + "'" + ","
                + "'" + author + "'" +","
                +"'"+ idGenre +"'"+")";
        connectorToDatabase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idBook) throws SQLException {
        connectorToDatabase.getStatement().executeUpdate("delete from information where id = '" + idBook +"'");
    }

    @Override
    public void update(int idBook, String title, String author, int idGenre) throws SQLException {
        String q1 = "UPDATE book set title = '" + title + "', author = '" + author + "', id_genre = '" + idGenre + "' WHERE id = " + idBook;
        connectorToDatabase.getStatement().executeUpdate(q1);
    }
}
