package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenreService {
    public ResultSet getAllDataGenre();
    public void insert(String Genre) throws SQLException;
    public void delete(int idGenre) throws SQLException;
    public void update(int idGenre, String genre) throws SQLException;
}
