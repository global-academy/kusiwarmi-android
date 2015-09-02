package com.kusi_warmi.www.kusiwarmi;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Daniel on 9/1/2015.
 */
public class KusiwarmiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(getApplicationContext());
        // Add your initialization code here
        Parse.initialize(this, "BrHIDT29PccogyQfMlHoiiMOhRoBLoCEGMKrMsvg", "b3mJfgPuMx215yppdWNXcXopPByKZO69hKp26QZ9");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
