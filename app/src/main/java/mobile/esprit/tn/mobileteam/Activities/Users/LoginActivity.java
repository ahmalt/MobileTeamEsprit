package mobile.esprit.tn.mobileteam.Activities.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.Utile.DefaultCallback;
import mobile.esprit.tn.mobileteam.Utile.Defaults;
import mobile.esprit.tn.mobileteam.Utile.LoadingCallback;
import mobile.esprit.tn.mobileteam.Utile.SocialCallback;
import mobile.esprit.tn.mobileteam.Utile.Validator;


/**
 * Handles user login:
 * - by email and password
 * - with Facebook account
 * - with Twitter account
 */
public class LoginActivity extends Activity {
    private static final int REGISTER_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //initialise backendless call
        if (Defaults.APPLICATION_ID.equals("") || Defaults.SECRET_KEY.equals("") || Defaults.VERSION.equals("")) {
            // show alert declared downbellow
            Validator.showAlert(this, "Missing application ID and secret key arguments. Login to Backendless Console, select your app and get the ID and key from the Manage - App Settings screen. Copy/paste the values into the Backendless.initApp call");
            return;
        }

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(this, Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);
        Backendless.UserService.isValidLogin(new DefaultCallback<Boolean>(this) {
            @Override
            public void handleResponse(Boolean isValidLogin) {
                if (isValidLogin && Backendless.UserService.CurrentUser() == null) {
                    String currentUserId = Backendless.UserService.loggedInUser();

                    if (!currentUserId.equals("")) {
                        Backendless.UserService.findById(currentUserId, new DefaultCallback<BackendlessUser>(LoginActivity.this, "Logging in...") {
                            @Override
                            public void handleResponse(BackendlessUser currentUser) {
                                super.handleResponse(currentUser);
                                Backendless.UserService.setCurrentUser(currentUser);
                                Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                                myIntent.putExtra("user", currentUser);
                                startActivity(myIntent);
                                Log.v("current user", String.valueOf(currentUser));
                                Toast.makeText(LoginActivity.this, "LOGGED IN SUCCESSFULLY ", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
                    }
                }

                super.handleResponse(isValidLogin);
            }
        });
        // end of initialisation
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(createLoginButtonListener());

        Button loginFacebookButton = (Button) findViewById(R.id.loginFacebookButton);
        loginFacebookButton.setOnClickListener(createLoginWithFacebookButtonListener());

        // Button loginTwitterButton = (Button) findViewById( R.id.loginTwitterButton );
        // loginTwitterButton.setOnClickListener( createLoginWithTwitterButtonListener() );

        Button googleButton = (Button) findViewById(R.id.loginGoogleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginWithGoogleButtonClicked();
            }
        });


        makeRegistrationLink();
        makePasswordLink();
    }


    public void onLoginWithGoogleButtonClicked() {

        Map<String, String> googleFieldsMapping = new HashMap<>();
        googleFieldsMapping.put("name", "name");
        googleFieldsMapping.put("gender", "gender");
        googleFieldsMapping.put("email", "email");


        List<String> googlePermissions = new ArrayList<>();

        Backendless.UserService.loginWithGooglePlus(LoginActivity.this, null, googleFieldsMapping, googlePermissions, new SocialCallback<BackendlessUser>(LoginActivity.this) {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {


                Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);

                startActivity(myIntent);

                Toast.makeText(LoginActivity.this, "LOGGED IN SUCCESSFULLY WITH GOOGLE PLUS", Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }

    /**
     * Makes registration link clickable and assigns it a click listener.
     */
    public void makeRegistrationLink() {
        SpannableString registrationPrompt = new SpannableString(getString(R.string.register_prompt));

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startRegistrationActivity();
            }
        };

        String linkText = getString(R.string.register_link);
        int linkStartIndex = registrationPrompt.toString().indexOf(linkText);
        int linkEndIndex = linkStartIndex + linkText.length();
        registrationPrompt.setSpan(clickableSpan, linkStartIndex, linkEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView registerPromptView = (TextView) findViewById(R.id.registerPromptText);
        registerPromptView.setText(registrationPrompt);
        registerPromptView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Makes password link clickable and assigns it a click listener.
     */
    public void makePasswordLink() {
        SpannableString PasswordPrompt = new SpannableString(getString(R.string.forget_password_prompt));

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                EnterEmail();
            }
        };


        String linkText = getString(R.string.forget_password_link);
        int linkStartIndex = PasswordPrompt.toString().indexOf(linkText);
        int linkEndIndex = linkStartIndex + linkText.length();
        PasswordPrompt.setSpan(clickableSpan, linkStartIndex, linkEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView PasswordPromptView = (TextView) findViewById(R.id.forgetpasswordPromptText);
        PasswordPromptView.setText(PasswordPrompt);
        PasswordPromptView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void EnterEmail() {
        Intent i = new Intent(LoginActivity.this, EnterEmail.class);
        startActivity(i);
        // TODO Auto-generated method stub

    }

    /**
     * Sends a request for registration to RegistrationActivity,
     * expects for result in onActivityResult.
     */
    public void startRegistrationActivity() {
        Intent registrationIntent = new Intent(this, RegistraionActivity.class);
        startActivityForResult(registrationIntent, REGISTER_REQUEST_CODE);
    }

    //get the logged user email property


    /**
     * Sends a request to Backendless to log in user by email and password.
     *
     * @param email         user's email
     * @param password      user's password
     * @param loginCallback a callback, containing actions to be executed on request result
     */
    public void loginUser(String email, String password, AsyncCallback<BackendlessUser> loginCallback) {
        Backendless.UserService.login(email, password, loginCallback);
    }

    /**
     * Sends a request to Backendless to log in user with Facebook account.
     * Fetches Facebook user's name and saves it on Backendless.
     *
     * @param loginCallback a callback, containing actions to be executed on request resulté
     */
    public void loginFacebookUser(AsyncCallback<BackendlessUser> loginCallback) {
        Map<String, String> fieldsMappings = new HashMap<>();
        fieldsMappings.put("name", "name");
        fieldsMappings.put("email", "email");

        List<String> permissions = new ArrayList<>();
        permissions.add("email");

        Backendless.UserService.loginWithFacebook(this, null, fieldsMappings, permissions, loginCallback);
    }

    /**
     * Sends a request to Backendless to log in user with Twitter account.
     * Fetches Twitter user's name and saves it on Backendless.
     *
     * @param loginCallback a callback, containing actions to be executed on request result
     */
   /* public void loginTwitterUser( AsyncCallback<BackendlessUser> loginCallback )
    {
        Map<String, String> fieldsMappings = new HashMap<>();
        fieldsMappings.put( "name", "name" );
        fieldsMappings.put( "email", "email" );

        Backendless.UserService.loginWithTwitter( this, null, fieldsMappings, loginCallback );
    }*/

    /**
     * Creates a listener, which proceeds with login by email and password on button click.
     *
     * @return a listener, handling login button click
     */
    public View.OnClickListener createLoginButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailField = (EditText) findViewById(R.id.emailField);
                EditText passwordField = (EditText) findViewById(R.id.passwordField);

                CharSequence email = emailField.getText();
                CharSequence password = passwordField.getText();

                if (isLoginValuesValid(email, password)) {
                    LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                    loginCallback.showLoading();
                    loginUser(email.toString(), password.toString(), loginCallback);
                }
            }
        };
    }

    /**
     * Creates a listener, which proceeds with login with Facebook on button click.
     *
     * @return a listener, handling login with Facebook button click
     */
    public View.OnClickListener createLoginWithFacebookButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                loginCallback.showLoading();
                loginFacebookUser(loginCallback);
            }
        };
    }
    /**
     * Creates a listener, which proceeds with login with Twitter on button click.
     *
     * @return a listener, handling login with Facebook button click
     */
  /*  public View.OnClickListener createLoginWithTwitterButtonListener()
    {
        return new View.OnClickListener()
        {

            @Override
            public void onClick( View v )
            {
                LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                loginCallback.showLoading();
                loginTwitterUser( loginCallback );
            }
        };
    }*/

    /**
     * Validates the values, which user entered on login screen.
     * Shows Toast with a warning if something is wrong.
     *
     * @param email    user's email
     * @param password user's password
     * @return true if all values are OK, false if something is wrong
     */
    public boolean isLoginValuesValid(CharSequence email, CharSequence password) {
        return Validator.isEmailValid(this, email) && Validator.isPasswordValid(this, password);
    }

    /**
     * Creates a callback, containing actions to be executed on login request result.
     * Shows a Toast with BackendlessUser's objectId on success,
     * show a dialog with an error message on failure.
     *
     * @return a callback, containing actions to be executed on login request result
     */
    public LoadingCallback<BackendlessUser> createLoginCallback() {
        return new LoadingCallback<BackendlessUser>(this, getString(R.string.loading_login)) {
            @Override
            public void handleResponse(BackendlessUser loggedInUser) {
                super.handleResponse(loggedInUser);
                Toast.makeText(LoginActivity.this, String.format(getString(R.string.info_logged_in), loggedInUser.getObjectId()), Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REGISTER_REQUEST_CODE:
                    String email = data.getStringExtra(BackendlessUser.EMAIL_KEY);
                    EditText emailField = (EditText) findViewById(R.id.emailField);
                    emailField.setText(email);

                    EditText passwordField = (EditText) findViewById(R.id.passwordField);
                    passwordField.requestFocus();

                    Toast.makeText(this, getString(R.string.info_registered_success), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
