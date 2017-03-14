package mobile.esprit.tn.mobileteam.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;


/**
 * Created by Lincoln on 07/01/16.
 */
public class MyPreferenceManager {

    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "MobileTeam";

    private static final String KEY_ID_MEMBRE = "membre_id";

    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setIdMembre(String id) {
        editor.putString(KEY_ID_MEMBRE, id);
        editor.commit();

    }
    public String getIdMembre(){
        if (pref.getString(KEY_ID_MEMBRE, null) != null) {
            String query;
            query = pref.getString(KEY_ID_MEMBRE,null);
            return query;
        }
        return null;
    }




    public void clear() {
        Log.e(TAG, "clear shared preferences. ");
        editor.clear();
        editor.commit();
    }
}