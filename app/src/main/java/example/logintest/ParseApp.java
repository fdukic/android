package example.logintest;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Dukic on 10-Jun-15.
 */
public class ParseApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "a8S5GnG803JxoLF0RpIaCzKLuU8P9LttwYkBNs8o", "K9oVuFjzdohMoJzka14oR0e9lQj0Z2X1bAauGvpk");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
