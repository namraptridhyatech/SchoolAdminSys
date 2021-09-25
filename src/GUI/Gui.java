package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    JFrame frame;
    JPanel addstudentPnl,viewStudentPnl,addTeacherPnl;
    JButton addStudent,viewStudent,addTeacher,viewTeacher,addCourse,viewCourse,assignTeacherToCourse,assignStudentToCourse;

    public Gui()
    {
        frame = new JFrame("School Administrator System");

        // Button
        buttonInit();

        // panel
        addStudentPanelInit();
        viewStudentPanelInit();
        addTeacherPanelInit();

        frame.setSize(1200,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buttonInit() {
        addStudent =new JButton("Add Student");
        addStudent.setBounds(50,30,120,40);
        addStudent.setFont(new Font("Serif", Font.BOLD, 14));
        addStudent.addActionListener(this);
        frame.add(addStudent);

        viewStudent =new JButton("View Student");
        viewStudent.setBounds(180,30,120,40);
        viewStudent.setFont(new Font("Serif", Font.BOLD, 14));
        viewStudent.addActionListener(this);
        frame.add(viewStudent);


        addTeacher =new JButton("Add Teacher");
        addTeacher.setBounds(320,30,120,40);
        addTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        addTeacher.addActionListener(this);
        frame.add(addTeacher);

        viewTeacher =new JButton("View Teacher");
        viewTeacher.setBounds(460,30,120,40);
        viewTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        viewTeacher.addActionListener(this);
        frame.add(viewTeacher);

        addCourse =new JButton("Add Course");
        addCourse.setBounds(600,30,120,40);
        addCourse.setFont(new Font("Serif", Font.BOLD, 14));
        addCourse.addActionListener(this);
        frame.add(addCourse);

        viewCourse =new JButton("View Course");
        viewCourse.setBounds(740,30,120,40);
        viewCourse.setFont(new Font("Serif", Font.BOLD, 14));
        viewCourse.addActionListener(this);
        frame.add(viewCourse);

        assignTeacherToCourse =new JButton("Assign Teacher");
        assignTeacherToCourse.setBounds(880,30,120,40);
        assignTeacherToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        assignTeacherToCourse.addActionListener(this);
        frame.add(assignTeacherToCourse);

        assignStudentToCourse =new JButton("Assign Student");
        assignStudentToCourse.setBounds(1020,30,120,40);
        assignStudentToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        assignStudentToCourse.addActionListener(this);
        frame.add(assignStudentToCourse);

    }


    // panel init
    public void addStudentPanelInit()
    {
        addstudentPnl =new JPanel();
        addstudentPnl.setBounds(100,100,1000,600);
        addstudentPnl.setBackground(Color.lightGray);

        JLabel l1=new JLabel("add Student");
        l1.setBounds(50,50, 100,30);
        addstudentPnl.add(l1);

        frame.add(addstudentPnl);
    }

    public void viewStudentPanelInit()
    {
        viewStudentPnl=new JPanel();
        viewStudentPnl.setBounds(100,100,1000,600);
        viewStudentPnl.setBackground(Color.lightGray);

        JLabel l2=new JLabel("View Student");
        l2.setBounds(50,50, 100,30);
        viewStudentPnl.add(l2);

        frame.add(viewStudentPnl);
    }

    public void addTeacherPanelInit()
    {
        addTeacherPnl=new JPanel();
        addTeacherPnl.setBounds(100,100,1000,600);
        addTeacherPnl.setBackground(Color.lightGray);

        JLabel l2=new JLabel("Add Teacher");
        l2.setBounds(50,50, 100,30);
        addTeacherPnl.add(l2);

        frame.add(addTeacherPnl);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addStudent)
        {
            hidePanel();
            addstudentPnl.setVisible(true);
        }
        else if(e.getSource() == viewStudent)
        {
            hidePanel();
            viewStudentPnl.setVisible(true);
        }
        else if(e.getSource() == addTeacher)
        {
            hidePanel();
            addTeacherPnl.setVisible(true);
        }
        else if(e.getSource() == viewTeacher)
        {

        }
        else if(e.getSource() == addCourse)
        {

        }
        else if(e.getSource() == assignTeacherToCourse)
        {

        }
        else if(e.getSource() == assignStudentToCourse)
        {

        }
    }

    public void hidePanel()
    {
        addstudentPnl.setVisible(false);
        viewStudentPnl.setVisible(false);
        addTeacherPnl.setVisible(false);
    }

}
