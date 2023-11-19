package listener;

import createTable.MenuTable;
import database.ConnectorToDatabase;
import service.BookService;
import service.GenreService;
import service.InformationService;
import service.impl.BookImpl;
import service.impl.GenreImpl;
import service.impl.InformationImpl;
import tables.newTable.CreateNewTables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InsertListener implements ActionListener {
    private Connection connection;
    private Statement statement;
    private JPanel panel;
    private JButton insertButton;
    private JButton updateTableButton;
    private JButton showButton;
    public InsertListener(JPanel panel, JButton insertButton, JButton updateTableButton, JButton showButton) {
        this.panel = panel;
        this.insertButton = insertButton;
        this.updateTableButton = updateTableButton;
        this.showButton = showButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();

        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, true);
        GridLayout grid = new GridLayout(6, 2, 5, 12);
        dialog.setLayout(grid);
        JLabel titleLabel = new JLabel("Title");
        JTextField titleField = new JTextField(10);
        dialog.add(titleLabel);
        dialog.add(titleField);

        JLabel authorLabel = new JLabel("Author");
        JTextField authorField = new JTextField(10);

        dialog.add(authorLabel);
        dialog.add(authorField);

        JLabel genreLabel = new JLabel("Genre");
        JTextField genreField = new JTextField(10);
        dialog.add(genreLabel);
        dialog.add(genreField);

        JLabel costLabel = new JLabel("Cost");
        JTextField costField = new JTextField(10);
        dialog.add(costLabel);
        dialog.add(costField);

        JLabel circulationLabel = new JLabel("Circulation");
        JTextField circulationField = new JTextField(10);
        dialog.add(circulationLabel);
        dialog.add(circulationField);

        JButton btn = new JButton("OK");

        CreateNewTables createNewTables = new CreateNewTables();
        createNewTables.create();

        BookService bookService = new BookImpl();
        InformationService informationService = new InformationImpl();
        GenreService genreService = new GenreImpl();
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                int cost = Integer.parseInt(costField.getText());
                int circulation = Integer.parseInt(circulationField.getText());
                String genre = genreField.getText();
                int idGenre = 0;
                try {
                    idGenre = genreService.getGenre(genre);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    bookService.insert(title, author, idGenre);
                    int idBook = bookService.getID(title);
                    informationService.insert(idBook, cost, circulation);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                panel.removeAll();
                panel.add(insertButton);
                panel.add(updateTableButton);
                panel.add(showButton);
                MenuTable menuTable = null;
                try {
                    menuTable = new MenuTable(panel, insertButton, showButton, updateTableButton);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                panel.add(menuTable);
                panel.revalidate();
                dialog.setVisible(false);
            }
        });

        dialog.add(btn);
        dialog.pack();
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
