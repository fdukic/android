package example.logintest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())){
            Intent intent = new Intent(MainActivity.this, LoginSignup.class);
            startActivity(intent);
            finish();
        }

        else{
            ParseUser currentUser = ParseUser.getCurrentUser();

            if(currentUser != null){
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            }

            else{
                Intent intent = new Intent(MainActivity.this, LoginSignup.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
