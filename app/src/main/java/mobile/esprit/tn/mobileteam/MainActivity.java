package mobile.esprit.tn.mobileteam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.backendless.Backendless;

import mobile.esprit.tn.mobileteam.Activities.Project.ProjectsDisplay;
import mobile.esprit.tn.mobileteam.Utile.Defaults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    //
    /** Called when the user clicks the Send button to go to Display Projects */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ProjectsDisplay.class);
        startActivity(intent);
    }
    //
    // the show alert method
    public static void showAlert( final Activity context, String message )
    {
        new AlertDialog.Builder( context ).setTitle( "An error occurred" ).setMessage( message ).setPositiveButton( "OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick( DialogInterface dialogInterface, int i )
            {
                context.finish();
            }
        } ).show();
    }
}
