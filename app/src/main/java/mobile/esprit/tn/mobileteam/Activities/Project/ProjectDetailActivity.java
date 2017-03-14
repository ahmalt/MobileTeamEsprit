package mobile.esprit.tn.mobileteam.Activities.Project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mobile.esprit.tn.mobileteam.Fragments.Project.ProjectDeatilFragment;
import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;

public class ProjectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        if (savedInstanceState == null) {
            String projectId;
            Intent intent = getIntent();
            Uri data = intent.getData();

            if (data == null) {
                // Not loading from deep link
                projectId = getIntent().getStringExtra(TeamUpApp.PROJECT_ID);
                loadProjectDetailsOf(projectId);
            }
        }
    }

    private void loadProjectDetailsOf(String projectId) {
        ProjectDeatilFragment fragment = new ProjectDeatilFragment();
        Bundle args = new Bundle();
        args.putString(TeamUpApp.PROJECT_ID, projectId);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.movie_detail_container, fragment).commit();

    }
}
