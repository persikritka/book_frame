package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface InformationService {
    public ResultSet getAllDataInformation();
    public int getID(int idBook) throws SQLException;
    public void insert(int idBook, int cost, int circulation) throws SQLException;
    public void delete(int idInformation) throws SQLException;
    public void update(int idInformation, int idBook, int cost, int circulation) throws SQLException;
}
