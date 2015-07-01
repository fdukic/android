package example.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginSignup extends AppCompatActivity{

    Button loginButton;
    Button signupButton;
    String usernameTxt;
    String passwordTxt;
    EditText password;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        loginButton = (Button)findViewById(R.id.login);
        signupButton = (Button)findViewById(R.id.signup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();

                ParseUser.logInInBackground(usernameTxt, passwordTxt, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null){
                            Intent intent = new Intent(LoginSignup.this, Welcome.class);
                            startActivity(intent);
                            finish();
                        }

                        else{
                            Toast.makeText(getApplicationContext(), "This user does not exist. Please try again or sign up.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();

                if(usernameTxt.equals("") && passwordTxt.equals("")){
                    Toast.makeText(getApplicationContext(), "Please complete the sign up form.", Toast.LENGTH_SHORT).show();
                }

                else{
                    ParseUser user = new ParseUser();
                    user.setUsername(usernameTxt);
                    user.setPassword(passwordTxt);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                Toast.makeText(getApplicationContext(), "You have been signed up!", Toast.LENGTH_SHORT).show();
                            }

                            else{
                                Toast.makeText(getApplicationContext(), "Error Signing Up", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
