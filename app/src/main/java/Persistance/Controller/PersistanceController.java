package Persistance.Controller;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by aliabbasjaffri on 29/11/15.
 */
public class PersistanceController extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
