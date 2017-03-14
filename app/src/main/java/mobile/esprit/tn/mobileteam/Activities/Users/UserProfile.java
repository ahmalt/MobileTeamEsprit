package mobile.esprit.tn.mobileteam.Activities.Users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import mobile.esprit.tn.mobileteam.R;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Bundle extras = getIntent().getExtras();
        String result = extras.getString("EXTRA_User_ID");

        Log.v("the user id ", result);
        Backendless.Persistence.of(BackendlessUser.class).findById(result,
                new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {

                        Log.v("user profile", response.getEmail());


                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        // an error has occurred, the error code can be retrieved with fault.getCode()
                    }
                });

    }
}
