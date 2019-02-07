import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {

    public static void main(String args[]){


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MMMM/dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
       // calendar.add(Calendar.DATE);
        String yesterdayAsString = dateFormat.format(calendar.getTime());
          System.out.println(dateFormat.format(calendar.getTime()));

//        Calendar c = Calendar.getInstance(Locale.ENGLISH);
//
//        final int day = c.get(Calendar.DAY_OF_MONTH);
//        int month = c.get(Calendar.MONTH)+1;
//        int year = c.get(Calendar.YEAR);
//
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(day);

    }
}
