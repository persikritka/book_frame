package listener;

import database.ConnectorToDatabase;
import service.BookService;
import service.impl.BookImpl;
import tables.newTable.CreateNewTables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InsertListener implements ActionListener {
    private Connection connection;
    private Statement statement;
    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        CreateNewTables createNewTables = new CreateNewTables();
        createNewTables.create();

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

        JLabel idGenreLabel = new JLabel("ID genre");
        JTextField idGenreField = new JTextField(10);
        dialog.add(idGenreLabel);
        dialog.add(idGenreField);

        JLabel costLabel = new JLabel("Cost");
        JTextField costField = new JTextField(10);
        dialog.add(costLabel);
        dialog.add(costField);

        JLabel circulationLabel = new JLabel("Circulation");
        JTextField circulationField = new JTextField(10);
        dialog.add(circulationLabel);
        dialog.add(circulationField);

        JButton btn = new JButton("OK");

        BookService bookService = new BookImpl();

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                int cost = Integer.parseInt(costField.getText());
                int circulation = Integer.parseInt(circulationField.getText());
                int idGenre = Integer.parseInt(idGenreField.getText());
                try {
                    bookService.insert(title, author, idGenre);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
