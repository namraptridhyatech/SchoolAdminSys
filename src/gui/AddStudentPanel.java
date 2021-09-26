package gui;

import controller.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel implements ActionListener {
    int screenWidth, screenHeight, buttonWidth;
    public JTextField addStudent_sId,addStudent_sName;
    public JComboBox<String> addStudent_subjects;
    public JButton addStudentButton;
    DataController DB;
    String[] subjectList = { "Maths", "Java", "Science", "English" };

    public AddStudentPanel() {
        DB = new DataController();
        setLayout(new GridBagLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        buttonWidth = screenWidth / 10;
        createComponent();
    }

    private void createComponent() {
        int x = screenWidth - (screenWidth / 8);
        int y = screenHeight - (screenHeight / 4);

        setBounds(100, 100, x, y);
        setBackground(Color.lightGray);

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
        add(sIdLable, constraints);

        constraints.gridx = 1;
        addStudent_sId = new JTextField("Please enter student");
        addStudent_sId.setPreferredSize(addStudent_sId.getPreferredSize());
        addStudent_sId.setText("");
        addStudent_sId.setFont(new Font("Serif", Font.PLAIN, 14));
        addStudent_sId.setSize(300, 100);
        add(addStudent_sId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel sNameLable = new JLabel("Student Name");
        sNameLable.setFont(new Font("Serif", Font.PLAIN, 14));
        sNameLable.setSize(300, 100);
        add(sNameLable, constraints);

        constraints.gridx = 1;
        addStudent_sName = new JTextField("Enter student name");
        addStudent_sName.setPreferredSize(addStudent_sId.getPreferredSize());
        addStudent_sName.setText("");
        addStudent_sName.setFont(new Font("Serif", Font.PLAIN, 14));
        addStudent_sName.setSize(300, 100);
        add(addStudent_sName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel postSubjectLable = new JLabel("Select Subject");
        postSubjectLable.setFont(new Font("Serif", Font.PLAIN, 14));
        postSubjectLable.setSize(300, 100);
        add(postSubjectLable, constraints);

        constraints.gridx = 1;
        addStudent_subjects = new JComboBox<>(subjectList);
        addStudent_subjects.setPreferredSize(addStudent_sId.getPreferredSize());
        addStudent_subjects.setFont(new Font("Serif", Font.PLAIN, 14));
        addStudent_subjects.setSize(300, 100);
        add(addStudent_subjects, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addStudentButton = new JButton("Add Student");
        add(addStudentButton, constraints);

        addStudentButton.addActionListener(this);

        // set border for the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Student"));

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addStudentButton) {
            addStudentSubmit();
        }
    }

    private void addStudentSubmit() {
        if(addStudent_sId.getText() != "" && addStudent_sName.getText() != "")
        {
            if(addStudent_sId.getText().matches("^[0-9]*"))
            {
                //DB.addStudent(addStudent_sId.getText(),addStudent_sName.getText(),"Maths;Science;States");
//                DB.addCourse("2092","Advance Data Communication","12-6-2021","16-10-2021","None");
                System.out.println("\nAns : ");
            }
            else
            {
                // -----  Student id must be only number
            }
        }
        else
        {
            //------- all field mandatory
        }
    }
}
