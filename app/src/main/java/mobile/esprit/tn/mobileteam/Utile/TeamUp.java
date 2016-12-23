package mobile.esprit.tn.mobileteam.Utile;

import android.app.Application;
import android.content.Context;

/**
 * Created by ahlem_daoud on 23/12/2016.
 */
public class TeamUp extends Application {

    // To access context from any class
    private static Context mAppContext;

    public static Context getAppContext() {
        return mAppContext;
    }

    // Initialize context
    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
    }
}
