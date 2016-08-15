package mobile.esprit.tn.mobileteam.Activities.Project;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mobile.esprit.tn.mobileteam.Models.Project;
import mobile.esprit.tn.mobileteam.R;

public class Project_detail_activity extends AppCompatActivity {
    public static final String EXTRA_NAME = "project_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_detail_activity);
        Intent intent = getIntent();

        final String projectName = intent.getStringExtra(EXTRA_NAME);

    }

}
