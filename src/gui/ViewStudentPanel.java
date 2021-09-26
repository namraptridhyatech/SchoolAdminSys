package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudentPanel extends JPanel implements ActionListener {
    DataController DB;
    int screenWidth, screenHeight, buttonWidth;
    public JComboBox<String> studentIdDropdown;
    public JButton viewStudentButton;
    String[] studentIdList = { "1", "2", "3", "4" };

    public ViewStudentPanel() {
        DB = new DataController();
        setLayout(new GridBagLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        buttonWidth = screenWidth / 10;

        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);

        setBounds(100, 100, x, y);
        setBackground(Color.lightGray);
        createComponent();
    }

    private void createComponent() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLabel = new JLabel("Student ID");
        sIdLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLabel.setSize(300, 30);
        sIdLabel.setLocation(300, 30);
        add(sIdLabel, constraints);

        constraints.gridx = 1;
        studentIdDropdown = new JComboBox<>(studentIdList);
        studentIdDropdown.setPrototypeDisplayValue("Select student");
        add(studentIdDropdown, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        viewStudentButton = new JButton("View Student");

        add(viewStudentButton, constraints);

        viewStudentButton.addActionListener(this);
        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Student"));

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        viewStudent();
    }
    private void viewStudent() {
        System.out.println("View Student");
    }
}
