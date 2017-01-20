package mobile.esprit.tn.mobileteam.Utile;

/**
 * Created by ahlem_daoud on 31/12/2016.
 */

public class TextUtils {
    // Constructor
    private TextUtils() {
    }

    // Check if given string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.equals("null") || str.equals(""));
    }
}
