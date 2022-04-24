package gui;

import com.j256.ormlite.stmt.query.In;
import persistence.dao.*;
import persistence.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Main extends JFrame {
    private static final BirthDao birthDao = (BirthDao) DaoFactory.getDao("BirthDao");
    private static final DeathDao deathDao = (DeathDao) DaoFactory.getDao("DeathDao");

    Main() {
        // Create the main window.
        super("Births and Deaths in New Zealand");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setupButtons();
        setVisible(true);
    }

    private void setupButtons() {
        JButton birthsButton = new JButton("Show Birth Records");
        birthsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        birthsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showBirths();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }
        );

        JButton deathsButton = new JButton("Show Death Records");
        deathsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deathsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showDeaths();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }
        );

        JButton addUpdateBirth = new JButton("Add or Update a Birth Record");
        addUpdateBirth.setAlignmentX(Component.CENTER_ALIGNMENT);
        addUpdateBirth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createOrUpdateBirthRec();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }
        );

        JButton addUpdateDeath = new JButton("Add or Update a Death Record");
        addUpdateDeath.setAlignmentX(Component.CENTER_ALIGNMENT);
        addUpdateDeath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createOrUpdateDeathRec();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }
        );

        JButton findButton = new JButton("Find a Record");
        findButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findRecord();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }
        );

        add(Box.createVerticalGlue());
        add(birthsButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(deathsButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(addUpdateBirth);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(addUpdateDeath);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(findButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(Box.createVerticalGlue());
    }

    private void showBirths() throws SQLException {
        // Create a new window to show the birth records.
        List<BirthRecord> birthRecords = birthDao.queryForAll();
        JFrame window = new JFrame("Birth Records");
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(container);
        window.setSize(400, 400);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        for (BirthRecord birthRecord : birthRecords) {
            JLabel label = new JLabel(birthRecord.getPeriod() + " " + birthRecord.getRegion() + " "
                                      + birthRecord.getBirth_count());
            container.add(label);
        }
        window.add(scrollPane);
        window.setVisible(true);
    }

    private void showDeaths() throws SQLException {
        // Create a new window to show the death records.
        List<DeathRecord> deathRecords = deathDao.queryForAll();
        JFrame window = new JFrame("Death Records");
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(container);
        window.setSize(400, 400);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        for (DeathRecord deathRecord : deathRecords) {
            JLabel label = new JLabel(deathRecord.getPeriod() + " " + deathRecord.getRegion() + " "
                    + deathRecord.getDeath_count());
            container.add(label);
        }
        window.add(scrollPane);
        window.setVisible(true);
    }

    private void createOrUpdateBirthRec() throws SQLException {
        // Update a birth record or create a new one.
        JFrame window = new JFrame("Add/Update a Birth Record");
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        window.setSize(400, 400);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel periodLabel = new JLabel("Period:");
        JLabel regionLabel = new JLabel("Region:");
        JLabel birthsLabel = new JLabel("Births:");
        JTextField periodField = new JTextField(10);
        JTextField regionField = new JTextField(10);
        JTextField birthsField = new JTextField(10);
        JButton addOrUpdateButton = new JButton("Add/Update");
        addOrUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int period = Integer.parseInt(periodField.getText());
                    String region = regionField.getText();
                    int births = Integer.parseInt(birthsField.getText());
                    BirthRecord birthRecord = new BirthRecord(period, region, births);
                    assert birthDao != null;
                    birthDao.createOrUpdateRec(birthRecord);
                    window.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            }
        );
        container.add(periodLabel);
        container.add(periodField);
        container.add(regionLabel);
        container.add(regionField);
        container.add(birthsLabel);
        container.add(birthsField);
        container.add(addOrUpdateButton);
        window.add(container);
        window.setVisible(true);
    }

    private void createOrUpdateDeathRec() throws SQLException {
        // Update a death record or create a new one.
        JFrame window = new JFrame("Add/Update a Death Record");
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        window.setSize(400, 400);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel periodLabel = new JLabel("Period:");
        JLabel regionLabel = new JLabel("Region:");
        JLabel deathsLabel = new JLabel("Deaths:");
        JTextField periodField = new JTextField(10);
        JTextField regionField = new JTextField(10);
        JTextField deathsField = new JTextField(10);
        JButton addOrUpdateButton = new JButton("Add/Update");
        addOrUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int period = Integer.parseInt(periodField.getText());
                    String region = regionField.getText();
                    int deaths = Integer.parseInt(deathsField.getText());
                    DeathRecord deathRecord = new DeathRecord(period, region, deaths);
                    assert deathDao != null;
                    deathDao.createOrUpdateRec(deathRecord);
                    window.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            }
        );
        container.add(periodLabel);
        container.add(periodField);
        container.add(regionLabel);
        container.add(regionField);
        container.add(deathsLabel);
        container.add(deathsField);
        container.add(addOrUpdateButton);
        window.add(container);
        window.setVisible(true);
    }

    private void findRecord() throws SQLException {
        // Find a record.
        JFrame window = new JFrame("Find a Record");
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        window.setSize(400, 400);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel periodLabel = new JLabel("Period:");
        JLabel regionLabel = new JLabel("Region:");
        JTextField periodField = new JTextField(10);
        JTextField regionField = new JTextField(10);
        JButton findButton = new JButton("Find");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int period = Integer.parseInt(periodField.getText());
                    String region = regionField.getText();
                    assert birthDao != null;
                    BirthRecord birthRecord = birthDao.findByPeriodAndRegion(period, region);
                    assert deathDao != null;
                    DeathRecord deathRecord = deathDao.findByPeriodAndRegion(period, region);
                    if (birthRecord != null && deathRecord != null) {
                        JOptionPane.showMessageDialog(window, "Birth: " + birthRecord.getBirth_count() + "\nDeath: " + deathRecord.getDeath_count());
                    } else {
                        JOptionPane.showMessageDialog(window, "No record found.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            }
        );
        container.add(periodLabel);
        container.add(periodField);
        container.add(regionLabel);
        container.add(regionField);
        container.add(findButton);
        window.add(container);
        window.setVisible(true);
    }

    private static void start() {
        new Main();
    }

    public static void main(String[] args) throws Exception {
        start();
    }
}
