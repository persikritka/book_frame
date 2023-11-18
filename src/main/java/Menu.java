import createTable.MenuTable;
import listener.DeleteListener;
import listener.InsertListener;
import listener.ShowListener;
import listener.UpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    private JPanel jPanel = null;
    private JButton inputButton = null;
    private JButton showButton = null;

    public Menu() throws SQLException {
        super("Системное меню");

        setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenuBar menuBar = new JMenuBar();
        JFrame frame = new JFrame();
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.add(jPanel);
        inputButton = new JButton("INSERT");
        showButton = new JButton("SHOW");

        jPanel.add(inputButton);
        jPanel.add(showButton);

        InsertListener insertListener = new InsertListener();
        inputButton.addActionListener(insertListener);

        ShowListener showListener = new ShowListener();
        showButton.addActionListener(showListener);

        MenuTable menuTable = new MenuTable();
        jPanel.add(menuTable);

        frame.setJMenuBar(menuBar);
        //setSize(300, 200);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
