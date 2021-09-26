package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacherPanel extends JPanel implements ActionListener {
    DataController DB;
    int screenWidth, screenHeight, buttonWidth;
    public JTextField teacherIdTxtField, teacherNameTxtField;
    public JButton addTeacherButton;
    public JLabel msgLable;
    String teacherID, teacherFullName, ListofCourse;

    public AddTeacherPanel() {
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
        JLabel teacherIdLable = new JLabel("Teacher ID");
        teacherIdLable.setFont(new Font("Serif", Font.PLAIN, 14));
        teacherIdLable.setSize(300, 30);
        teacherIdLable.setLocation(300, 30);
        add(teacherIdLable, constraints);

        constraints.gridx = 1;
        teacherIdTxtField = new JTextField("Please enter teacher");
        teacherIdTxtField.setPreferredSize(teacherIdTxtField.getPreferredSize());
        teacherIdTxtField.setText("");
        teacherIdTxtField.setFont(new Font("Serif", Font.PLAIN, 14));
        teacherIdTxtField.setSize(300, 100);
        add(teacherIdTxtField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Teacher Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        add(sNameLable, constraints);

        constraints.gridx = 1;
        teacherNameTxtField = new JTextField("Enter teacher name");
        teacherNameTxtField.setPreferredSize(teacherNameTxtField.getPreferredSize());
        teacherNameTxtField.setText("");
        teacherNameTxtField.setFont(new Font("Serif", Font.PLAIN, 14));
        teacherNameTxtField.setSize(300, 100);
        add(teacherNameTxtField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.setFont(new Font("Serif", Font.PLAIN, 14));
        addTeacherButton.setSize(300, 30);
        addTeacherButton.setLocation(500, 30);
        add(addTeacherButton, constraints);
        addTeacherButton.addActionListener(this);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        msgLable = new JLabel("");
        msgLable.setFont(new Font("Serif", Font.PLAIN, 14));
        msgLable.setSize(500, 100);
        add(msgLable, constraints);

        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Teacher"));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addTeacherButton) {
            addTeacherSubmit();
        }
    }

    private void addTeacherSubmit() {
        teacherID = teacherIdTxtField.getText().trim();
        teacherFullName = teacherNameTxtField.getText().trim();
        ListofCourse = "";

        if (!teacherID.equals("") && !teacherFullName.equals("")) {
            if (teacherID.matches("^[0-9]*")) 
            {

                if (DB.checkTeacher(teacherID)) {
                    msgLable.setText("Teacher id already exist.");
                } else {
                    DB = new DataController();
                    DB.addTeacher(teacherID, teacherFullName, "None");
                    msgLable.setText("Teacher Added Successfully.");
                }

            } else 
            {
                msgLable.setText("Teacher id must be only number.");
            }
        } else {
            msgLable.setText("All fields are mendetory.");
        }
    }

}
