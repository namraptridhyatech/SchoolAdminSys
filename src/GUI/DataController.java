package GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static GUI.UtilityClass.*;

public class DataController {

    FileReader reader;
    BufferedReader bufferedReader;
    File file;

    public DataController()
    {
        file = new File("./src/masterFile.txt");


    }

    public void readFile()
    {

        try {
            FileReader reader = new FileReader(file);

            bufferedReader = new BufferedReader(reader);
            String line;
            while (true) {
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }catch (Exception ex)
        {
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

    public void addStudent(String studentID,String studentFullName,String listOfCourse){
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Student@"+studentID+":"+studentFullName+":"+listOfCourse);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printConsole("Add student : Confirm...");
    }

    public void addCourse(String CourseID, String courseName, String startDate, String endDate,String preRequisite){
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Course@"+CourseID+":"+courseName+":"+startDate+":"+endDate+":"+preRequisite);
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
                    if(Course[0].equals("Course"))
                    {
                        String[] Variable = Course[1].split(":");
                        //printConsole(Variable[3]);
                        String[] EDate = Variable[3].split("-"); // date format : DD-MM-YYYY
                        if(Integer.parseInt(EDate[0]) < CurrentDay() && Integer.parseInt(EDate[1]) <= CurrentMonth() && Integer.parseInt(EDate[2]) <= CurrentYear());
                        {
                            list.add(Variable[0]+":"+Variable[1]);
                            //printConsole("Filtered Past course : "+line);
                        }
                    }
                }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception ex)
        {
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
    public static void printConsole(String msg){
        System.out.println(msg);
    }


}
