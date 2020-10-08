package constants;

import constants.Constants;

import java.util.Calendar;

public class CommonMethods {

    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        String strDate = Constants.MD_FORMAT.format(calendar.getTime());
        System.out.println(strDate);
        return strDate.trim();
    }
}
