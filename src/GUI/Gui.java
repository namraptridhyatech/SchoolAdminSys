package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Gui implements ActionListener {

    JFrame frame;
    JPanel addstudentPnl, viewStudentPnl, addTeacherPnl, viewTeacherPnl, addCoursePnl, viewCoursePnl,
            assignTeacherToCoursePnl, assignStudentToCoursePnl;
    JButton addStudent, viewStudent, addTeacher, viewTeacher, addCourse, viewCourse, assignTeacherToCourse,
            assignStudentToCourse;
    int screenWidth, screenHeight, buttonWidth, buttonHeight;

    public Gui() {
        frame = new JFrame("School Administrator System");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        buttonWidth = screenWidth / 10;
        buttonHeight = screenHeight / 25;

        // Button
        buttonInit();

        // panel
        addStudentPanelInit();
        viewStudentPanelInit();
        addTeacherPanelInit();
        viewTeacherPanelInit();
        addCoursePanelInit();
        viewCoursePanelInit();
        assignTeacherToCoursePanelInit();
        assignStudentToCoursePanelInit();

        frame.setSize(screenWidth, screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        hidePanel();
        addstudentPnl.setVisible(true);
    }

    private void buttonInit() {

        System.out.println(buttonWidth);
        addStudent = new JButton("Add Student");
        int x = screenWidth / 25;
        int y = screenHeight / 25;
        addStudent.setBounds(x, y, buttonWidth, buttonHeight);
        addStudent.setFont(new Font("Serif", Font.BOLD, 14));
        addStudent.addActionListener(this);
        frame.add(addStudent);

        viewStudent = new JButton("View Student");

        viewStudent.setBounds(x + (buttonWidth) + 10, y, buttonWidth, buttonHeight);
        viewStudent.setFont(new Font("Serif", Font.BOLD, 14));
        viewStudent.addActionListener(this);
        frame.add(viewStudent);

        addTeacher = new JButton("Add Teacher");
        addTeacher.setBounds(x + (buttonWidth * 2) + 20, y, buttonWidth, buttonHeight);
        addTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        addTeacher.addActionListener(this);
        frame.add(addTeacher);

        viewTeacher = new JButton("View Teacher");
        viewTeacher.setBounds(x + (buttonWidth * 3) + 30, y, buttonWidth, buttonHeight);
        viewTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        viewTeacher.addActionListener(this);
        frame.add(viewTeacher);

        addCourse = new JButton("Add Course");
        addCourse.setBounds(x + (buttonWidth * 4) + 40, y, buttonWidth, buttonHeight);
        addCourse.setFont(new Font("Serif", Font.BOLD, 14));
        addCourse.addActionListener(this);
        frame.add(addCourse);

        viewCourse = new JButton("View Course");
        viewCourse.setBounds(x + (buttonWidth * 5) + 50, y, buttonWidth, buttonHeight);
        viewCourse.setFont(new Font("Serif", Font.BOLD, 14));
        viewCourse.addActionListener(this);
        frame.add(viewCourse);

        assignTeacherToCourse = new JButton("Assign Teacher");
        assignTeacherToCourse.setBounds(x + (buttonWidth * 6) + 60, y, buttonWidth, buttonHeight);
        assignTeacherToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        assignTeacherToCourse.addActionListener(this);
        frame.add(assignTeacherToCourse);

        assignStudentToCourse = new JButton("Assign Student");
        assignStudentToCourse.setBounds(x + (buttonWidth * 7) + 70, y, buttonWidth, buttonHeight);
        assignStudentToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        assignStudentToCourse.addActionListener(this);
        frame.add(assignStudentToCourse);

    }

    // panel init
    public void addStudentPanelInit() {
        addstudentPnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);

        addstudentPnl.setBounds(100, 100, x, y);
        addstudentPnl.setBackground(Color.lightGray);

        String subjectList[] = { "Maths", "Java", "Science", "English" };
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Student ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        addstudentPnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter student");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("");
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        addstudentPnl.add(sId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Student Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        addstudentPnl.add(sNameLable, constraints);

        constraints.gridx = 1;
        JTextField sName = new JTextField("Enter student name");
        sName.setPreferredSize(sId.getPreferredSize());
        sName.setText("");
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 100);
        addstudentPnl.add(sName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel postSubjectLable = new JLabel("Select Subject");
        postSubjectLable.setFont(new Font("Serif", Font.PLAIN, 14));
        postSubjectLable.setSize(300, 100);
        addstudentPnl.add(postSubjectLable, constraints);

        constraints.gridx = 1;
        JComboBox subjectlistbox = new JComboBox(subjectList);
        subjectlistbox.setPreferredSize(sId.getPreferredSize());
        subjectlistbox.setFont(new Font("Serif", Font.PLAIN, 14));
        subjectlistbox.setSize(300, 100);
        addstudentPnl.add(subjectlistbox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton addStudentButton = new JButton("Add Student");
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 30);
        sName.setLocation(500, 30);
        addstudentPnl.add(addStudentButton, constraints);

        // set border for the panel
        addstudentPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Student"));

        frame.add(addstudentPnl);
    }

    public void viewStudentPanelInit() {
        viewStudentPnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        viewStudentPnl.setBounds(100, 100, x, y);
        viewStudentPnl.setBackground(Color.lightGray);

        String subjectList[] = { "Maths", "Java", "Science", "English" };
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Student ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        viewStudentPnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Displaying student id ");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3456789");
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        sId.setEditable(false);
        viewStudentPnl.add(sId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Student Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        viewStudentPnl.add(sNameLable, constraints);

        constraints.gridx = 1;
        JTextField sName = new JTextField("Dishant Desai   ");
        sName.setPreferredSize(sId.getPreferredSize());
        sId.setEditable(false);
        sName.setEditable(false);
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 100);
        viewStudentPnl.add(sName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel postSubjectLable = new JLabel("Selected Subject");
        postSubjectLable.setFont(new Font("Serif", Font.PLAIN, 14));
        postSubjectLable.setSize(300, 100);
        viewStudentPnl.add(postSubjectLable, constraints);

        constraints.gridx = 1;
        JComboBox subjectlistbox = new JComboBox(subjectList);
        subjectlistbox.setPreferredSize(sId.getPreferredSize());
        subjectlistbox.setFont(new Font("Serif", Font.PLAIN, 14));
        subjectlistbox.setSize(300, 100);
        viewStudentPnl.add(subjectlistbox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel avgGradeLable = new JLabel("Student Grade");
        avgGradeLable.setFont(new Font("Serif", Font.PLAIN, 14));
        avgGradeLable.setSize(300, 100);
        viewStudentPnl.add(avgGradeLable, constraints);

        constraints.gridx = 1;
        JTextField avgGrade = new JTextField("  A++   ");
        avgGrade.setPreferredSize(sId.getPreferredSize());
        avgGrade.setEditable(false);
        avgGrade.setFont(new Font("Serif", Font.PLAIN, 14));
        avgGrade.setSize(300, 100);
        viewStudentPnl.add(avgGrade, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel attendanceLable = new JLabel("Student Attandence");
        attendanceLable.setFont(new Font("Serif", Font.PLAIN, 14));
        attendanceLable.setSize(300, 100);
        viewStudentPnl.add(attendanceLable, constraints);

        constraints.gridx = 1;
        JTextField attendance = new JTextField("  90 %    ");
        attendance.setPreferredSize(sId.getPreferredSize());
        attendance.setEditable(false);
        attendance.setFont(new Font("Serif", Font.PLAIN, 14));
        attendance.setSize(300, 100);
        viewStudentPnl.add(attendance, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton addStudentButton = new JButton("View Student");
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 30);
        sName.setLocation(500, 30);
        viewStudentPnl.add(addStudentButton, constraints);

        // set border for the panel
        viewStudentPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Student"));

        frame.add(viewStudentPnl);
    }

    public void addTeacherPanelInit() {
        addTeacherPnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        addTeacherPnl.setBounds(100, 100, x, y);
        addTeacherPnl.setBackground(Color.lightGray);

        String subjectList[] = { "Maths", "Java", "Science", "English" };
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Teacher ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        addTeacherPnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("");
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        addTeacherPnl.add(sId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Teacher Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        addTeacherPnl.add(sNameLable, constraints);

        constraints.gridx = 1;
        JTextField sName = new JTextField("Enter teacher name");
        sName.setPreferredSize(sId.getPreferredSize());
        sName.setText("");
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 100);
        addTeacherPnl.add(sName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel postSubjectLable = new JLabel("Select Subject");
        postSubjectLable.setFont(new Font("Serif", Font.PLAIN, 14));
        postSubjectLable.setSize(300, 100);
        addTeacherPnl.add(postSubjectLable, constraints);

        constraints.gridx = 1;
        JComboBox subjectlistbox = new JComboBox(subjectList);
        subjectlistbox.setPreferredSize(sId.getPreferredSize());
        subjectlistbox.setFont(new Font("Serif", Font.PLAIN, 14));
        subjectlistbox.setSize(300, 100);
        addTeacherPnl.add(subjectlistbox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.setFont(new Font("Serif", Font.PLAIN, 14));
        addTeacherButton.setSize(300, 30);
        addTeacherButton.setLocation(500, 30);
        addTeacherPnl.add(addTeacherButton, constraints);

        // set border for the panel
        addTeacherPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Teacher"));

        frame.add(addTeacherPnl);
    }

    public void viewTeacherPanelInit() {
        viewTeacherPnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        viewTeacherPnl.setBounds(100, 100, x, y);
        viewTeacherPnl.setBackground(Color.lightGray);

        String subjectList[] = { "Maths", "Java", "Science", "English" };
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Teacher ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        viewTeacherPnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3453453");
        sId.setEditable(false);
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        viewTeacherPnl.add(sId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Teacher Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        viewTeacherPnl.add(sNameLable, constraints);

        constraints.gridx = 1;
        JTextField sName = new JTextField("Enter teacher name");
        sName.setPreferredSize(sId.getPreferredSize());
        sName.setText("The Greate Dishant");
        sId.setEditable(false);
        sName.setFont(new Font("Serif", Font.PLAIN, 14));
        sName.setSize(300, 100);
        viewTeacherPnl.add(sName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel postSubjectLable = new JLabel("Select Subject");
        postSubjectLable.setFont(new Font("Serif", Font.PLAIN, 14));
        postSubjectLable.setSize(300, 100);
        viewTeacherPnl.add(postSubjectLable, constraints);

        constraints.gridx = 1;
        JComboBox subjectlistbox = new JComboBox(subjectList);
        subjectlistbox.setPreferredSize(sId.getPreferredSize());
        subjectlistbox.setFont(new Font("Serif", Font.PLAIN, 14));
        subjectlistbox.setSize(300, 100);
        viewTeacherPnl.add(subjectlistbox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton addTeacherButton = new JButton("View Teacher");
        addTeacherButton.setFont(new Font("Serif", Font.PLAIN, 14));
        addTeacherButton.setSize(300, 30);
        addTeacherButton.setLocation(500, 30);
        viewTeacherPnl.add(addTeacherButton, constraints);

        // set border for the panel
        viewTeacherPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Teacher"));

        frame.add(viewTeacherPnl);
    }

    public void addCoursePanelInit() {
        addCoursePnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        addCoursePnl.setBounds(100, 100, x, y);
        addCoursePnl.setBackground(Color.lightGray);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Course ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        addCoursePnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3453453");
        sId.setEditable(false);
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        addCoursePnl.add(sId, constraints);

        // set border for the panel
        addCoursePnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "add Course"));

        frame.add(addCoursePnl);
    }

    public void viewCoursePanelInit() {
        viewCoursePnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        viewCoursePnl.setBounds(100, 100, x, y);
        viewCoursePnl.setBackground(Color.lightGray);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Course ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        viewCoursePnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3453453");
        sId.setEditable(false);
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        viewCoursePnl.add(sId, constraints);

        // set border for the panel
        viewCoursePnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "view Course"));

        frame.add(viewCoursePnl);
    }

    public void assignTeacherToCoursePanelInit() {
        assignTeacherToCoursePnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        assignTeacherToCoursePnl.setBounds(100, 100, x, y);
        assignTeacherToCoursePnl.setBackground(Color.lightGray);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Course ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        assignTeacherToCoursePnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3453453");
        sId.setEditable(false);
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        assignTeacherToCoursePnl.add(sId, constraints);

        // set border for the panel
        assignTeacherToCoursePnl
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Assign Teacher"));

        frame.add(assignTeacherToCoursePnl);
    }

    public void assignStudentToCoursePanelInit() {
        assignStudentToCoursePnl = new JPanel(new GridBagLayout());
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);
        assignStudentToCoursePnl.setBounds(100, 100, x, y);
        assignStudentToCoursePnl.setBackground(Color.lightGray);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel sIdLable = new JLabel("Course ID");
        sIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sIdLable.setSize(300, 30);
        sIdLable.setLocation(300, 30);
        assignStudentToCoursePnl.add(sIdLable, constraints);

        constraints.gridx = 1;
        JTextField sId = new JTextField("Please enter teacher");
        sId.setPreferredSize(sId.getPreferredSize());
        sId.setText("3453453");
        sId.setEditable(false);
        sId.setFont(new Font("Serif", Font.PLAIN, 14));
        sId.setSize(300, 100);
        assignStudentToCoursePnl.add(sId, constraints);

        // set border for the panel
        assignStudentToCoursePnl
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Assign Student"));

        frame.add(assignStudentToCoursePnl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addStudent) {
            hidePanel();
            addstudentPnl.setVisible(true);
        } else if (e.getSource() == viewStudent) {
            hidePanel();
            viewStudentPnl.setVisible(true);
        } else if (e.getSource() == addTeacher) {
            hidePanel();
            addTeacherPnl.setVisible(true);
        } else if (e.getSource() == viewTeacher) {
            hidePanel();
            viewTeacherPnl.setVisible(true);
        } else if (e.getSource() == addCourse) {
            hidePanel();
            addCoursePnl.setVisible(true);
        } else if (e.getSource() == viewCourse) {
            hidePanel();
            viewCoursePnl.setVisible(true);
        } else if (e.getSource() == assignTeacherToCourse) {
            hidePanel();
            assignTeacherToCoursePnl.setVisible(true);
        } else if (e.getSource() == assignStudentToCourse) {
            hidePanel();
            assignStudentToCoursePnl.setVisible(true);
        }
    }

    public void hidePanel() {
        addstudentPnl.setVisible(false);
        viewStudentPnl.setVisible(false);
        addTeacherPnl.setVisible(false);
        viewTeacherPnl.setVisible(false);
        addCoursePnl.setVisible(false);
        viewCoursePnl.setVisible(false);
        assignTeacherToCoursePnl.setVisible(false);
        assignStudentToCoursePnl.setVisible(false);
    }

}
