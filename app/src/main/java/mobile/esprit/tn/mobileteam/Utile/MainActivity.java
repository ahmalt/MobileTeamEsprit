package mobile.esprit.tn.mobileteam.Utile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.backendless.Backendless;

import java.util.ArrayList;

import mobile.esprit.tn.mobileteam.Activities.Project.ProjectActivity;
import mobile.esprit.tn.mobileteam.Activities.Users.LoginActivity;
import mobile.esprit.tn.mobileteam.Activities.Users.ProfileActivity;
import mobile.esprit.tn.mobileteam.Activities.Users.RegistraionActivity;
import mobile.esprit.tn.mobileteam.R;
import za.co.riggaroo.materialhelptutorial.TutorialItem;
import za.co.riggaroo.materialhelptutorial.tutorial.MaterialTutorialActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1234;

    // the show alert method
    public static void showAlert(final Activity context, String message) {
        new AlertDialog.Builder(context).setTitle("An error occurred").setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.finish();
            }
        }).show();
    }
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.header_logo);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadTutorial();
            }
        });


//initialise backendless call
        if( Defaults.APPLICATION_ID.equals( "" ) || Defaults.SECRET_KEY.equals( "" ) || Defaults.VERSION.equals( "" ) )
        {
            // show alert declared downbellow
            showAlert( this, "Missing application ID and secret key arguments. Login to Backendless Console, select your app and get the ID and key from the Manage - App Settings screen. Copy/paste the values into the Backendless.initApp call" );
            return;
        }
        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(this, Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);
    }

    /** Called when the user clicks the Send button to go to Display Projects */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ProjectActivity.class);
        startActivity(intent);
    }

    //
    public void connect(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void SignUp(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegistraionActivity.class);
        startActivity(intent);
    }

    public void LogIN(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

public void loadTutorial() {
        Intent mainAct = new Intent(this, MaterialTutorialActivity.class);
        mainAct.putParcelableArrayListExtra(MaterialTutorialActivity.MATERIAL_TUTORIAL_ARG_TUTORIAL_ITEMS, getTutorialItems(this));
        startActivityForResult(mainAct, REQUEST_CODE);

        }

private ArrayList<TutorialItem> getTutorialItems(Context context ) {
        TutorialItem tutorialItem1 = new TutorialItem(R.string.slide_1_APP, R.string.slide_1_african_story_books_subtitle,
        R.color.start_stream_background, R.drawable.slide1forground,  R.drawable.slide1background);

        TutorialItem tutorialItem2 = new TutorialItem(R.string.slide_2_volunteer_professionals, R.string.slide_2_volunteer_professionals_subtitle,
        R.color.view_stream_background,  R.drawable.tut_page_2_front,  R.drawable.tut_page_2_background);

        TutorialItem tutorialItem3 = new TutorialItem(context.getString(R.string.slide_3_download_and_go), null,
        R.color.settings_background,R.drawable.idea);

        TutorialItem tutorialItem4 = new TutorialItem(R.string.slide_4_different_languages, R.string.slide_4_different_languages_subtitle,
        R.color.how_to_use_background,  R.drawable.tut_page_4_foreground, R.drawable.tut_page_4_background);

        ArrayList<TutorialItem> tutorialItems = new ArrayList<>();
        tutorialItems.add(tutorialItem1);
        tutorialItems.add(tutorialItem2);
        tutorialItems.add(tutorialItem3);
        tutorialItems.add(tutorialItem4);

        return tutorialItems;
        }

    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //    super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            Toast.makeText(this, "Thank you", Toast.LENGTH_LONG).show();

        }
    }
}
