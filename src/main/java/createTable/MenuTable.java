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
    public MenuTable() throws SQLException {
        super();

        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        bookService = new BookImpl();

        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Title", "Author"};
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
        //from = (String) c1.getSelectedItem();
        String title = "";
        String author = "";
        int idGenre;

        try {
            ResultSet rs = bookService.getAllDataBook();
            int i = 0;
            if (rs.next()) {
                title = rs.getString("title");
                author = rs.getString("author");
                model.addRow(new Object[]{title, author});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        add(scrollBook);
        setVisible(true);
    }

}
