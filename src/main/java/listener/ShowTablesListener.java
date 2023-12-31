package listener;

import service.BookService;
import service.GenreService;
import service.InformationService;
import service.impl.BookImpl;
import service.impl.GenreImpl;
import service.impl.InformationImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ShowTablesListener implements ActionListener {
    private JComboBox comboBox;
    private  String[] items;
    private JDialog dialog;
    private JScrollPane scrollBook;
    private JScrollPane scrollGenre;
    private JScrollPane scrollInformation;
    private JScrollPane scrollBookGenre;
    private JScrollPane scrollBookInformation;
    private JScrollPane scrollAll;
    public ShowTablesListener(JComboBox comboBox, String[] items, JDialog dialog) {
        this.comboBox = comboBox;
        this.items = items;
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        BookService bookService = new BookImpl();
        InformationService informationService = new InformationImpl();
        GenreService genreService = new GenreImpl();

            if (comboBox.getSelectedItem().equals("Book table")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
                    dialog.remove(scrollAll);
                DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"Title", "Author"};
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
                String title = "";
                String author = "";
                try {
                    ResultSet rs = bookService.getAllDataBook();
                    int i = 0;
                    while (rs.next()) {
                        title = rs.getString("title");
                        author = rs.getString("author");
                        model.addRow(new Object[]{title, author});
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

            if (comboBox.getSelectedItem().equals("Genre table")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
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
                String genre = "";
                try {
                    ResultSet rs = genreService.getAllDataGenre();
                    int i = 0;
                    while (rs.next()) {
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

            if (comboBox.getSelectedItem().equals("Information table")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
                    dialog.remove(scrollAll);
                DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"ID book", "Cost", "Circulation"};
                model.setColumnIdentifiers(columnNames);
                JTable table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                scrollInformation = new JScrollPane(table);
                scrollInformation.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollInformation.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                int idBook;
                int cost;
                int circulation;
                try {
                    ResultSet rs = informationService.getAllDataInformation();
                    int i = 0;
                    while (rs.next()) {
                        idBook = Integer.parseInt(rs.getString("id_book"));
                        cost = Integer.parseInt(rs.getString("cost"));
                        circulation = Integer.parseInt(rs.getString("circulation"));
                        model.addRow(new Object[]{idBook, cost, circulation});
                        i++;
                    }
                    if (i < 1) {
                        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dialog.add(scrollInformation);
                dialog.pack();
            }

            if (comboBox.getSelectedItem().equals("Book and genre tables")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
                    dialog.remove(scrollAll);
                DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"Title", "Author", "Genre"};
                model.setColumnIdentifiers(columnNames);
                JTable table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                scrollBookGenre = new JScrollPane(table);
                scrollBookGenre.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBookGenre.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                String title = "";
                String author = "";
                String genre = "";
                try {
                    ResultSet rs = bookService.getAllDataBookGenre();
                    int i = 0;
                    while (rs.next()) {
                        title = rs.getString("title");
                        author = rs.getString("author");
                        genre = rs.getString("genre");
                        model.addRow(new Object[]{title, author, genre});
                        i++;
                    }
                    if (i < 1) {
                        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dialog.add(scrollBookGenre);
                dialog.pack();
            }

            if (comboBox.getSelectedItem().equals("Book and information tables")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
                    dialog.remove(scrollAll);
                DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"Title", "Author", "Cost", "Circulation"};
                model.setColumnIdentifiers(columnNames);
                JTable table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                scrollBookInformation = new JScrollPane(table);
                scrollBookInformation.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBookInformation.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                String title = "";
                String author = "";
                int cost;
                int circulation;

                try {
                    ResultSet rs = bookService.getAllDataBookInformation();
                    int i = 0;
                    while (rs.next()) {
                        title = rs.getString("title");
                        author = rs.getString("author");
                        cost = Integer.parseInt(rs.getString("cost"));
                        circulation = Integer.parseInt(rs.getString("circulation"));
                        model.addRow(new Object[]{title, author, cost, circulation});
                        i++;
                    }
                    if (i < 1) {
                        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dialog.add(scrollBookInformation);
                dialog.pack();
            }

            if (comboBox.getSelectedItem().equals("All tables")) {
                if (scrollBook != null)
                    dialog.remove(scrollBook);
                if (scrollGenre != null)
                    dialog.remove(scrollGenre);
                if (scrollInformation != null)
                    dialog.remove(scrollInformation);
                if (scrollBookGenre != null)
                    dialog.remove(scrollBookGenre);
                if (scrollBookInformation != null)
                    dialog.remove(scrollBookInformation);
                if (scrollAll != null)
                    dialog.remove(scrollAll);
                DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"Title", "Author", "Genre", "Cost", "Circulation"};
                model.setColumnIdentifiers(columnNames);
                JTable table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                scrollAll = new JScrollPane(table);
                scrollAll.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollAll.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                String title = "";
                String author = "";
                String genre = "";
                int cost;
                int circulation;
                try {
                    ResultSet rs = bookService.getAllData();
                    int i = 0;
                    while (rs.next()) {
                        title = rs.getString("title");
                        author = rs.getString("author");
                        cost = Integer.parseInt(rs.getString("cost"));
                        circulation = Integer.parseInt(rs.getString("circulation"));
                        genre = rs.getString("genre");
                        model.addRow(new Object[]{title, author, genre, cost, circulation});
                        i++;
                    }
                    if (i < 1) {
                        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dialog.add(scrollAll);
                dialog.pack();
            }

    }

}
