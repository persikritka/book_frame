package listener;

import createTable.MenuTable;
import service.BookService;
import service.impl.BookImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteListener implements ActionListener {
    private JTable jTable;
    private JPanel panel;
    private JButton insertButton;
    private JButton updateTableButton;
    private JButton showButton;
    public DeleteListener(JTable jTable, JPanel panel, JButton insertButton, JButton updateTableButton, JButton showButton) {
        this.jTable = jTable;
        this.panel = panel;
        this.insertButton = insertButton;
        this.updateTableButton = updateTableButton;
        this.showButton = showButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String title = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
        BookService bookService = new BookImpl();
        try {
            int idBook = bookService.getID(title);
            bookService.delete(idBook);
            panel.removeAll();
            panel.add(insertButton);
            panel.add(updateTableButton);
            panel.add(showButton);
            MenuTable menuTable = new MenuTable(panel, insertButton, showButton, updateTableButton);
            panel.add(menuTable);
            panel.revalidate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
