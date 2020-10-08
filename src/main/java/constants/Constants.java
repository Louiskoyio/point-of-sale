package constants;

import java.text.SimpleDateFormat;

public class Constants {
    public static Constants _INSTANCE = new Constants();

    public static final String ACCOUNT_ID = "account_id";
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static int USER = 0;
    public static SimpleDateFormat MD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static String CONNECTION_URL = "jdbc:postgresql://localhost:5432/pos";




    public Constants() {

    }

    public static Constants getInstance() {
        return _INSTANCE;
    }
}
