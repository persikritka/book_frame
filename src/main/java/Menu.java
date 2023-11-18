import createTable.MenuTable;
import database.ConnectorToDatabase;
import listener.*;
import service.BookService;
import service.impl.BookImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu extends JFrame {
    private JPanel jPanel = null;
    private JButton inputButton = null;
    private JButton showButton = null;
    private JButton updateTableJButton = null;

    public Menu() throws SQLException {
        super("Системное меню");

        setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenuBar menuBar = new JMenuBar();
        JFrame frame = new JFrame();
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.add(jPanel);
        inputButton = new JButton("INSERT");
        showButton = new JButton("SHOW");
        updateTableJButton = new JButton("UPDATE TABLE");

        jPanel.add(inputButton);
        jPanel.add(showButton);
        jPanel.add(updateTableJButton);

        InsertListener insertListener = new InsertListener();
        inputButton.addActionListener(insertListener);

        ShowListener showListener = new ShowListener();
        showButton.addActionListener(showListener);

        MenuTable menuTable = new MenuTable(jPanel, inputButton, showButton, updateTableJButton);
        jPanel.add(menuTable);
        UpdateTableListener updateTableListener = new UpdateTableListener(jPanel, inputButton, showButton, updateTableJButton);
        updateTableJButton.addActionListener(updateTableListener);

        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
