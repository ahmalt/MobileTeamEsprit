package mobile.esprit.tn.mobileteam.Activities.Users;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.Utile.Defaults;
import mobile.esprit.tn.mobileteam.Utile.Validator;

public class EnterEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_email);
        //initialise backendless call
        if (Defaults.APPLICATION_ID.equals("") || Defaults.SECRET_KEY.equals("") || Defaults.VERSION.equals("")) {
            // show alert declared downbellow
            Validator.showAlert(this, "Missing application ID and secret key arguments. Login to Backendless Console, select your app and get the ID and key from the Manage - App Settings screen. Copy/paste the values into the Backendless.initApp call");
            return;
        }

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(this, Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);

        // end of initialisation
        Button submitEmail = (Button) findViewById(R.id.sendEmailButton);
        submitEmail.setOnClickListener(createsubmitEmailButtonListener());
    }

    private View.OnClickListener createsubmitEmailButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailField = (EditText) findViewById(R.id.submitEmailFeild);

                String email = emailField.getText().toString();
                Log.v("The Logged user email: ", String.valueOf(email));
                Backendless.UserService.restorePassword(email, new AsyncCallback<Void>() {


                    @Override
                    public void handleResponse(Void response) {
                        Toast.makeText(EnterEmail.this, " Backendless has completed the operation - an email has been sent to the user", Toast.LENGTH_SHORT).show();
                        startLoginActivity();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(EnterEmail.this, "password revovery failed", Toast.LENGTH_SHORT).show();
                        Log.v("The fault detail: ", String.valueOf(fault.getDetail()));
                        Log.v("The fault code: ", String.valueOf(fault.getCode()));
                        Log.v("The fault Message: ", String.valueOf(fault.getMessage()));
                    }
                });
            }
        };
    }

    public void startLoginActivity() {
        Intent LoginIntent = new Intent(this, LoginActivity.class);
        startActivity(LoginIntent);
    }


}