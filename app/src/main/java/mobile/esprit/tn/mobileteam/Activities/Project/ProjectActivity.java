package mobile.esprit.tn.mobileteam.Activities.Project;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindBool;
import butterknife.ButterKnife;
import mobile.esprit.tn.mobileteam.Fragments.Project.ProjectDeatilFragment;
import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;

public class ProjectActivity extends AppCompatActivity {
    @BindBool(R.bool.is_tablet)
    boolean isTablet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ButterKnife.bind(this);
        if (isTablet && savedInstanceState == null) {
            loadDetailFragmentWith("null");
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    private void loadDetailFragmentWith(String projectId) {
        ProjectDeatilFragment fragment = new ProjectDeatilFragment();
        Bundle args = new Bundle();
        args.putString(TeamUpApp.PROJECT_ID, projectId);
        Log.v("project id is ", projectId);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_detail_project, fragment).commit();
    }
}




