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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel buttonContainer = new JLabel();
        JButton birthsButton = new JButton("Show Birth Records");
        birthsButton.setBounds(50,100,95,30);
        birthsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton deathsButton = new JButton("Show Death Records");
        deathsButton.setBounds(50,100,95,30);
        deathsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton createButton = new JButton("Add a Record");
        createButton.setBounds(50,100,95,30);
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton deleteButton = new JButton("Delete a Record");
        deleteButton.setBounds(50,100,95,30);
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton findButton = new JButton("Find a Record");
        findButton.setBounds(50,100,95,30);
        findButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(birthsButton);
        add(deathsButton);
        add(createButton);
        add(deleteButton);
        add(findButton);

        setVisible(true);
    }
}
