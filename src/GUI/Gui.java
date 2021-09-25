package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui {

    JFrame frame;
    JPanel student;
    JButton addStudent,viewStudent,addTeacher,viewTeacher,addCourse,viewCourse,assignTeacherToCourse,assignStudentToCourse;

    public Gui()
    {
        frame = new JFrame("School Administrator System");

        // Button
        buttonInit();

        // panel
        studentPanelInit();

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
        frame.add(addStudent);

        viewStudent =new JButton("View Student");
        viewStudent.setBounds(180,30,120,40);
        viewStudent.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(viewStudent);


        addTeacher =new JButton("Add Teacher");
        addTeacher.setBounds(320,30,120,40);
        addTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(addTeacher);

        viewTeacher =new JButton("View Teacher");
        viewTeacher.setBounds(460,30,120,40);
        viewTeacher.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(viewTeacher);

        addCourse =new JButton("Add Course");
        addCourse.setBounds(600,30,120,40);
        addCourse.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(addCourse);

        viewCourse =new JButton("View Course");
        viewCourse.setBounds(740,30,120,40);
        viewCourse.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(viewCourse);

        assignTeacherToCourse =new JButton("Assign Teacher");
        assignTeacherToCourse.setBounds(880,30,120,40);
        assignTeacherToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(assignTeacherToCourse);

        assignStudentToCourse =new JButton("Assign Student");
        assignStudentToCourse.setBounds(1020,30,120,40);
        assignStudentToCourse.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(assignStudentToCourse);

    }

    public void studentPanelInit()
    {
        student =new JPanel();
        student.setBounds(100,100,1000,600);
        student.setBackground(Color.lightGray);

        /*
        JButton b1=new JButton("Button 1");
        b1.setBounds(50,100,80,30);
        b1.setBackground(Color.yellow);
        student.add(b1);*/

        frame.add(student);
    }


}
