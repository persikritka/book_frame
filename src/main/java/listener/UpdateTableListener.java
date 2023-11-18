package listener;

import createTable.MenuTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateTableListener implements ActionListener {
    private JPanel panel;
    private JButton insertButton;
    private JButton updateTableButton;
    private JButton showButton;
    public UpdateTableListener(JPanel panel, JButton insertButton, JButton updateTableButton, JButton showButton) {
        this.panel = panel;
        this.insertButton = insertButton;
        this.updateTableButton = updateTableButton;
        this.showButton = showButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            panel.removeAll();
            panel.add(insertButton);
            panel.add(updateTableButton);
            panel.add(showButton);
            MenuTable menuTable = new MenuTable(panel, insertButton, showButton, updateTableButton);
            panel.add(menuTable);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
