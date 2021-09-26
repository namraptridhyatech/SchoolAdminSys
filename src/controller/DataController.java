package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import util.UtilityClass.*;

public class DataController {

    FileReader reader;
    BufferedReader bufferedReader;
    File file;

    public DataController() {
        file = new File("./src/masterFile.txt");

    }

    public void readFile() {

        try {
            FileReader reader = new FileReader(file);

            bufferedReader = new BufferedReader(reader);
            String line;
            while (true) {
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception ex) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printConsole(ex.getMessage());
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkStudent(String studentID) {
        boolean isStudentAvailable = false;
        try {

            FileReader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] student = line.split("@");
                if (student[0].equals("Student")) {
                    String[] studentdata = student[1].split(":");
                    if (studentID.equals(studentdata[0])) {
                        isStudentAvailable = true;
                        break;
                    }
                }
                if (isStudentAvailable)
                    break;
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printConsole(ex.getMessage());
        }
        return isStudentAvailable;
    }

    public boolean checkTeacher(String studentID) {
        boolean isteacherAvailable = false;
        try {

            FileReader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] teacher = line.split("@");
                if (teacher[0].equals("Teacher")) {
                    String[] studentdata = teacher[1].split(":");
                    if (studentID.equals(studentdata[0])) {
                        isteacherAvailable = true;
                        break;
                    }
                }
                if (isteacherAvailable)
                    break;
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printConsole(ex.getMessage());
        }
        return isteacherAvailable;
    }

    public void addStudent(String studentID, String studentFullName, String listOfCourse) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(
                    "Student@" + studentID + ":" + studentFullName + ":" + listOfCourse + "attandence:90%;grade:A++");
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printConsole("Add student : Confirm...");
    }

    public void addTeacher(String teacherID, String teacherFullName, String listOfCourse) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Teacher@" + teacherID + ":" + teacherFullName + ":" + listOfCourse);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printConsole("Add teacher : Confirm...");
    }

    public void addCourse(String CourseID, String courseName, String startDate, String endDate, String preRequisite) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(
                    "Course@" + CourseID + ":" + courseName + ":" + startDate + ":" + endDate + ":" + preRequisite);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printConsole("Add Course : Confirm...");
    }

    public List<String> listOfPastCourse() {
        List<String> list = new ArrayList<String>();
        try {

            FileReader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] Course = line.split("@");
                if (Course[0].equals("Course")) {
                    String[] Variable = Course[1].split(":");
                    // printConsole(Variable[3]);
                    String[] EDate = Variable[3].split("-"); // date format : DD-MM-YYYY
                    if (Integer.parseInt(EDate[0]) < CurrentDay() && Integer.parseInt(EDate[1]) <= CurrentMonth()
                            && Integer.parseInt(EDate[2]) <= CurrentYear())
                        ;
                    {
                        list.add(Variable[0] + ":" + Variable[1]);
                        // printConsole("Filtered Past course : "+line);
                    }
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printConsole(ex.getMessage());
        }
        return list;
    }

    // common message print gateway
    public static void printConsole(String msg) {
        System.out.println(msg);
    }

}
