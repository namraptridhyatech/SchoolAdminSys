package GUI;

import java.io.*;

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



    // common message print gateway
    static void printConsole(String msg){
        System.out.println(msg);
    }


}
