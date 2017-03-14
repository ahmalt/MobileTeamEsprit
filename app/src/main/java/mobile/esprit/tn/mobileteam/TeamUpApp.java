package mobile.esprit.tn.mobileteam;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import mobile.esprit.tn.mobileteam.helper.MyPreferenceManager;

/**
 * Created by ahlem_daoud on 29/12/2016.
 */

public class TeamUpApp extends Application {


    private MyPreferenceManager pref;
    private static TeamUpApp mInstance;
    public static volatile Handler applicationHandler = null;

    // Tag for fragment manager
    public static final String TAG_GRID_FRAGMENT = "movie_grid_fragment";
    // SharedPreference Keys
    public static final String TABLE_USER = "user_settings";
    public static final String LAST_SELECTED = "last_drawer_selection";
    public static final String THUMBNAIL_SIZE = "thumbnail_size";
    public static final String VIEW_MODE = "view_mode";
    public static final String VIEW_TYPE = "view_type";
    public static final int VIEW_MODE_GRID = 1;
    public static final int VIEW_MODE_LIST = 2;
    public static final int VIEW_MODE_COMPACT = 3;
    public static final int VIEW_TYPE_POPULAR = 1;
    public static final int VIEW_TYPE_RATED = 2;
    public static final int VIEW_TYPE_UPCOMING = 3;
    public static final int VIEW_TYPE_PLAYING = 4;
    public static final int VIEW_TYPE_WATCHED = 5;
    public static final int VIEW_TYPE_TO_SEE = 6;
    // Constants // Intent Extra + Bundle Argument + Saved Instance State
    public static final String TOOLBAR_TITLE = "toolbar_title";
    public static final String PROJECT_ID = "project_id";
    public static final String PROJECT_NAME = "project_name";
    public static final String PROJECT_OBJECT = "project_object";
    public static final String PROJECT_LIST = "project_list";
    public static final String REVIEW_LIST = "review_list";
    public static final String VIDEO_LIST = "video_list";
    public static final String PHOTO_LIST = "photo_list";
    public static final String CREDIT_TYPE = "credit_type";
    public static final String CREDIT_LIST = "credit_list";
    public static final String SEARCH_QUERY = "search_query";
    public static final String PAGE_TO_DOWNLOAD = "page_to_download";
    public static final String TOTAL_PAGES = "total_pages";
    public static final String IS_LOADING = "is_loading";
    public static final String IS_LOCKED = "is_locked";
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
        mInstance = this;
        applicationHandler = new Handler(getInstance().getMainLooper());
    }

    public static synchronized TeamUpApp getInstance() {
        return mInstance;
    }

    public MyPreferenceManager getPrefManager() {
        if (pref == null) {
            pref = new MyPreferenceManager(this);
        }

        return pref;
    }
}

