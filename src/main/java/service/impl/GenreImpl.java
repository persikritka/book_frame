package service.impl;

import database.ConnectorToDatabase;
import service.GenreService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreImpl implements GenreService {
    private final ConnectorToDatabase connectorToDatabase;
    public GenreImpl(){
        connectorToDatabase=new ConnectorToDatabase();
    }
    @Override
    public ResultSet getAllDataGenre() {
        try {
            return connectorToDatabase.getStatement().executeQuery("select * from genre");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String genre) throws SQLException {
        String str = "insert into genre(genre) values("+"'"
                + genre + "'" + ")";
        connectorToDatabase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idGenre) throws SQLException {
        connectorToDatabase.getStatement().executeUpdate("delete from genre where id = '" + idGenre +"'");
    }

    @Override
    public void update(int idGenre, String genre) throws SQLException {
        String q1 = "UPDATE genre set genre = '" + genre + "' WHERE id = " + idGenre;
        connectorToDatabase.getStatement().executeUpdate(q1);
    }
}
