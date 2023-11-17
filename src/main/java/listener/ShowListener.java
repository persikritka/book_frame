package listener;

import database.ConnectorToDatabase;
import service.BookService;
import service.GenreService;
import service.InformationService;
import service.impl.BookImpl;
import service.impl.GenreImpl;
import service.impl.InformationImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ShowListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, true);
        dialog.setLayout(new FlowLayout(FlowLayout.LEFT));
        String[] items = {"Book table", "Genre table", "Information table", "Book and Genre tables",
                            "Book and information tables", "All tables"
        };
        JComboBox comboBox = new JComboBox(items);
        dialog.add(comboBox);
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();
        BookService bookService = new BookImpl();
        GenreService genreService = new GenreImpl();
        InformationService informationService = new InformationImpl();
        ActionListener showTableListener = new ActionListener() {
            JScrollPane scrollBook;
            JScrollPane scrollGenre;
            JScrollPane scrollInformation;
            JScrollPane scrollBookGenre;
            JScrollPane scrollBookInformation;
            JScrollPane scrollAll;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("Book table")){
                    if(scrollBook != null)
                        dialog.remove(scrollBook);
                    if(scrollGenre != null)
                        dialog.remove(scrollGenre);
                    if(scrollInformation != null)
                        dialog.remove(scrollInformation);
                    if(scrollBookGenre != null)
                        dialog.remove(scrollBookGenre);
                    if(scrollBookInformation != null)
                        dialog.remove(scrollBookInformation);
                    if(scrollAll != null)
                        dialog.remove(scrollAll);
                    DefaultTableModel model = new DefaultTableModel();
                    String[] columnNames = {"Title", "Author", "ID genre"};
                    model.setColumnIdentifiers(columnNames);
                    JTable table = new JTable();
                    table.setModel(model);
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    table.setFillsViewportHeight(true);
                    scrollBook = new JScrollPane(table);
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
                            idGenre = Integer.parseInt(rs.getString("id_genre"));
                            model.addRow(new Object[]{title, author, idGenre});
                            i++;
                        }
                        if (i < 1) {
                            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dialog.add(scrollBook);
                    dialog.pack();
                }

                if(comboBox.getSelectedItem().equals("Genre table")){
                    if(scrollBook != null)
                        dialog.remove(scrollBook);
                    if(scrollGenre != null)
                        dialog.remove(scrollGenre);
                    if(scrollInformation != null)
                        dialog.remove(scrollInformation);
                    if(scrollBookGenre != null)
                        dialog.remove(scrollBookGenre);
                    if(scrollBookInformation != null)
                        dialog.remove(scrollBookInformation);
                    if(scrollAll != null)
                        dialog.remove(scrollAll);
                    DefaultTableModel model = new DefaultTableModel();
                    String[] columnNames = {"Genre"};
                    model.setColumnIdentifiers(columnNames);
                    JTable table = new JTable();
                    table.setModel(model);
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    table.setFillsViewportHeight(true);
                    scrollGenre = new JScrollPane(table);
                    scrollGenre.setHorizontalScrollBarPolicy(
                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollGenre.setVerticalScrollBarPolicy(
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    //from = (String) c1.getSelectedItem();
                    String genre = "";
                    try {
                        ResultSet rs = genreService.getAllDataGenre();
                        int i = 0;
                        if (rs.next()) {
                            genre = rs.getString("genre");
                            model.addRow(new Object[]{genre});
                            i++;
                        }
                        if (i < 1) {
                            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dialog.add(scrollGenre);
                    dialog.pack();
                }
            }
        };

        comboBox.addActionListener(showTableListener);


        dialog.pack();
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
