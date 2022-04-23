package gui;

import persistence.dao.BirthDao;
import persistence.dao.DaoFactory;
import persistence.dao.DeathDao;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

    }

    Main() {
        // Create the main window.
        super("Births and Deaths in New Zealand");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton birthsButton = new JButton("Show Birth Records");
        birthsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JButton deathsButton = new JButton("Show Death Records");
        deathsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton createButton = new JButton("Add a Record");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton deleteButton = new JButton("Delete a Record");
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton findButton = new JButton("Find a Record");
        findButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(birthsButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(deathsButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(createButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(deleteButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(findButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(Box.createVerticalGlue());

        setVisible(true);
    }
}
