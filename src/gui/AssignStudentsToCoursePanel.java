package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignStudentsToCoursePanel extends JPanel implements ActionListener {

    int screenWidth, screenHeight, buttonWidth;
    public JComboBox<String> courseList;
    JList<String> studentListDropdown;
    JButton assignStudentsButton;
    DataController DB;
    String[] subjectList = { "Maths", "Java", "Science", "English" };
    String[] studentList = { "Student 1", "Student 2", "Student 3", "Student 4" };

    public AssignStudentsToCoursePanel() {
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
        JLabel selectStudentLabel = new JLabel("Select Student");
        selectStudentLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(selectStudentLabel, constraints);

        constraints.gridx = 1;
        studentListDropdown = new JList<>(studentList);
        studentListDropdown.setPreferredSize(studentListDropdown.getPreferredSize());
        studentListDropdown.setFixedCellHeight(15);
        studentListDropdown.setFixedCellWidth(100);
        studentListDropdown.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        studentListDropdown.setVisibleRowCount(4);
        add(new JScrollPane(studentListDropdown), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        assignStudentsButton = new JButton("Assign Students");
        add(assignStudentsButton, constraints);

        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Assign Students"));

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
