package mobile.esprit.tn.mobileteam.Utile;

import mobile.esprit.tn.mobileteam.R;

/**
 * Created by ahlem_daoud on 23/12/2016.
 */
public class DimenUtil {
    private DimenUtil() {
    }

    // Check if device is a tablet
    public static boolean isTablet() {
        return TeamUp.getAppContext().getResources().getBoolean(R.bool.is_tablet);
    }
}
