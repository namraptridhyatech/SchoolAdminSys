package GUI;

import java.util.Calendar;
import java.util.Date;

public class UtilityClass {



    public static int CurrentDay()
    {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int CurrentMonth()
    {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return (cal.get(Calendar.MONTH) + 1);
    }

    public static int CurrentYear()
    {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.YEAR);
    }


}



// https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
