package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTeacherPanel extends JPanel implements ActionListener {
    DataController DB;
    int screenWidth, screenHeight, buttonWidth;
    public JComboBox<String> teacherIdDropdown;
    public JButton viewTeacherButton;
    String[] teacherIdList = { "1", "2", "3", "4" };

    public ViewTeacherPanel() {
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
        JLabel teacherIdLabel = new JLabel("Teacher ID");
        teacherIdLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        teacherIdLabel.setSize(300, 30);
        teacherIdLabel.setLocation(300, 30);
        add(teacherIdLabel, constraints);

        constraints.gridx = 1;
        teacherIdDropdown = new JComboBox<>(teacherIdList);
        teacherIdDropdown.setPrototypeDisplayValue("Select teacher");
        add(teacherIdDropdown, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        viewTeacherButton = new JButton("View Teacher");

        add(viewTeacherButton, constraints);

        viewTeacherButton.addActionListener(this);
        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Teacher"));

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
