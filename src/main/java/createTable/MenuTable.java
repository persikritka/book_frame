package createTable;

import database.ConnectorToDatabase;
import service.BookService;
import service.impl.BookImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuTable extends JTable{
    private BookService bookService;
    private JPanel panel;
    public MenuTable(JPanel panel) throws SQLException {
        super();
        this.panel = panel;
        //ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        bookService = new BookImpl();

        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Title", "Author", "Genre", "Cost", "Circulation"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scrollBook = new JScrollPane(table);
        scrollBook.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBook.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String title = "";
        String author = "";
        String genre;
        int cost;
        int circulation;

        try {
            ResultSet rs = bookService.getAllData();
            int i = 0;
            while (rs.next()) {
                title = rs.getString("title");
                author = rs.getString("author");
                genre = rs.getString("genre");
                cost = Integer.parseInt(rs.getString("cost"));
                circulation = Integer.parseInt(rs.getString("circulation"));
                model.addRow(new Object[]{title, author, genre, cost, circulation});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        panel.add(scrollBook);
        //setVisible(true);
    }

}
