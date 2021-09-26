package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignTeacherToCoursePanel extends JPanel implements ActionListener {
    int screenWidth, screenHeight, buttonWidth;
    public JComboBox<String> courseList, teacherListDropdown;
    JButton assignTeacherButton;
    DataController DB;
    String[] subjectList = { "Maths", "Java", "Science", "English" };
    String[] teacherList = { "Teacher 1", "Teacher 2", "Teacher 3", "Teacher 4" };

    public AssignTeacherToCoursePanel() {
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

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel selectCourseLabel = new JLabel("Select Course");
        selectCourseLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        selectCourseLabel.setSize(300, 100);
        add(selectCourseLabel, constraints);

        constraints.gridx = 1;
        courseList = new JComboBox<>(subjectList);
        add(courseList, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel selectTeacherLabel = new JLabel("Select Teacher");
        selectTeacherLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        selectTeacherLabel.setSize(300, 100);
        add(selectTeacherLabel, constraints);

        constraints.gridx = 1;
        teacherListDropdown = new JComboBox<>(teacherList);
        add(teacherListDropdown, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        assignTeacherButton = new JButton("Assign Teacher");
        add(assignTeacherButton, constraints);

        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Assign Teacher"));

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
