package service.impl;

import database.ConnectorToDatabase;
import service.InformationService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InformationImpl implements InformationService {
    private final ConnectorToDatabase connectorToDatabase;
    public InformationImpl(){
        connectorToDatabase=new ConnectorToDatabase();
    }
    @Override
    public ResultSet getAllDataInformation() {
        try {
            return connectorToDatabase.getStatement().executeQuery("select * from information");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getID(int idBook) throws SQLException {
        ResultSet idRS = connectorToDatabase.getStatement().executeQuery("SELECT id FROM information WHERE id_book = '" + idBook + "'");
        int id = 0;
        if(idRS.next())
            id = Integer.parseInt(idRS.getString("id"));
        return id;
    }

    @Override
    public void insert(int idBook, int cost, int circulation) throws SQLException {
        String str = "insert into information(id_book, cost, circulation) values("+"'"
                + idBook + "'" + ","
                + "'" + cost + "'" +","
                +"'"+ circulation +"'"+")";
        connectorToDatabase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idInformation) throws SQLException {
        connectorToDatabase.getStatement().executeUpdate("delete from information where id = '" + idInformation +"'");
    }

    @Override
    public void update(int idInformation, int idBook, int cost, int circulation) throws SQLException {
        String q1 = "UPDATE information set id_book = '" + idBook + "', cost = '" + cost + "', circulation = '" + circulation + "' WHERE id = " + idInformation;
        connectorToDatabase.getStatement().executeUpdate(q1);
    }
}
