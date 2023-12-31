package listener;

import createTable.MenuTable;
import service.BookService;
import service.GenreService;
import service.InformationService;
import service.impl.BookImpl;
import service.impl.GenreImpl;
import service.impl.InformationImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateListener implements ActionListener {
    private JTable jTable;
    private JPanel panel;
    private JButton insertButton;
    private JButton updateTableButton;
    private JButton showButton;
    public UpdateListener(JTable jTable, JPanel panel, JButton insertButton, JButton updateTableButton, JButton showButton) {
        this.jTable = jTable;
        this.panel = panel;
        this.insertButton = insertButton;
        this.updateTableButton = updateTableButton;
        this.showButton = showButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, true);
        GridLayout grid = new GridLayout(6, 2, 5, 12);
        dialog.setLayout(grid);

        JLabel titleLabel = new JLabel("Title");
        String title = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
        JTextField titleField = new JTextField(title, 10);
        dialog.add(titleLabel);
        dialog.add(titleField);

        JLabel authorLabel = new JLabel("Author");
        String author = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
        JTextField authorField = new JTextField(author, 10);
        dialog.add(authorLabel);
        dialog.add(authorField);

        GenreService genreService = new GenreImpl();
        BookService bookService = new BookImpl();
        InformationService informationService = new InformationImpl();

        JLabel genreLabel = new JLabel("Genre");
        String genre = jTable.getValueAt(jTable.getSelectedRow(), 2).toString();
        JTextField genreField = new JTextField(genre,10);
        dialog.add(genreLabel);
        dialog.add(genreField);

        JLabel costLabel = new JLabel("Cost");
        String cost = jTable.getValueAt(jTable.getSelectedRow(), 3).toString();
        JTextField costField = new JTextField(cost, 10);
        dialog.add(costLabel);
        dialog.add(costField);

        JLabel circulationLabel = new JLabel("Circulation");
        String circulation = jTable.getValueAt(jTable.getSelectedRow(), 4).toString();
        JTextField circulationField = new JTextField(circulation,10);
        dialog.add(circulationLabel);
        dialog.add(circulationField);

        JButton btn = new JButton("OK");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titleNew = titleField.getText();
                String authorNew = authorField.getText();
                int costNew = Integer.parseInt(costField.getText());
                int circulationNew = Integer.parseInt(circulationField.getText());
                String genreNew = genreField.getText();
                try {
                    int idBook = bookService.getID(title);
                    int idGenre = genreService.getGenre(genreNew);
                    bookService.update(idBook, titleNew, authorNew, idGenre);
                    int idInformation = informationService.getID(idBook);
                    informationService.update(idInformation, idBook, costNew, circulationNew);
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
