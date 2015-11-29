package com.example.sve15138.vaccinator;

/**
 * Created by aliabbasjaffri on 30/11/15.
 */
import com.activeandroid.ActiveAndroid;
import android.app.Application;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
