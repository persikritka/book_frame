package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        dialog.pack();
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
