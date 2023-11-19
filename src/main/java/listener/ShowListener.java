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
        String[] items = {"Book table", "Genre table", "Information table", "Book and genre tables",
                            "Book and information tables", "All tables"
        };
        JComboBox comboBox = new JComboBox(items);
        dialog.add(comboBox);
        ShowTablesListener showTablesListener = new ShowTablesListener(comboBox, items, dialog);

        comboBox.addActionListener(showTablesListener);

        dialog.pack();
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
