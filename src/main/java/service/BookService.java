package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookService {
    public ResultSet getAllDataBook();
    public ResultSet getAllDataBookGenre();
    public ResultSet getAllDataBookInformation();
    public ResultSet getAllData();
    public int getID(String title) throws SQLException;
    public void insert(String title, String author, int idGenre) throws SQLException;
    public void delete(int idBook) throws SQLException;
    public void update(int idBook, String title, String author, int idGenre) throws SQLException;
}
