package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
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
    }
}
