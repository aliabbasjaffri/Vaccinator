package com.example.sve15138.vaccinator.SecondTab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.SecondTab.Fragment.SecondTabMainFragment;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondtab_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondtab_main_frameLayout, new SecondTabMainFragment())
                .commit();
    }
}
