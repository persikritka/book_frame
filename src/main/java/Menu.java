import createTable.MenuTable;
import database.ConnectorToDatabase;
import listener.DeleteListener;
import listener.InsertListener;
import listener.ShowListener;
import listener.UpdateListener;
import service.BookService;
import service.impl.BookImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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

       // MenuTable menuTable = new MenuTable();
       // jPanel.add(menuTable);

        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        BookService bookService = new BookImpl();
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
        jPanel.add(scrollBook);

        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
