package mobile.esprit.tn.mobileteam.Utile;

import android.graphics.Typeface;

import java.util.Hashtable;

import mobile.esprit.tn.mobileteam.TeamUpApp;

/**
 * Created by ahlem_daoud on 31/12/2016.
 */
public class FontUtil {
    public static final String ROBOTO_REGULAR = "fonts/Roboto-Regular.ttf";
    public static final String ROBOTO_LIGHT = "fonts/Roboto-Light.ttf";
    public static final String ROBOTO_BOLD = "fonts/Roboto-Bold.ttf";
    // Cache fonts in hash table
    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    // Constructor
    private FontUtil() {
    }

    public static Typeface getTypeface(String name) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(TeamUpApp.getAppContext().getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
