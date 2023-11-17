import listener.DeleteListener;
import listener.InsertListener;
import listener.ShowListener;
import listener.UpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel jPanel = null;
    private JButton inputButton = null;
    private  JButton deleteButton = null;
    private JButton updateButton = null;

    private JButton showButton = null;

    public Menu() {
        super("Системное меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenuBar menuBar = new JMenuBar();
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(jPanel);
        inputButton = new JButton("INSERT");
        deleteButton = new JButton("DELETE");
        updateButton = new JButton("UPDATE");
        showButton = new JButton("SHOW");

        jPanel.add(inputButton);
        jPanel.add(deleteButton);
        jPanel.add(updateButton);
        jPanel.add(showButton);

        InsertListener insertListener = new InsertListener();
        inputButton.addActionListener(insertListener);

        DeleteListener deleteListener = new DeleteListener();
        deleteButton.addActionListener(deleteListener);

        UpdateListener updateListener = new UpdateListener();
        updateButton.addActionListener(updateListener);

        ShowListener showListener = new ShowListener();
        showButton.addActionListener(showListener);

        setJMenuBar(menuBar);
        //setSize(300, 200);
        pack();
        setVisible(true);
    }
}
