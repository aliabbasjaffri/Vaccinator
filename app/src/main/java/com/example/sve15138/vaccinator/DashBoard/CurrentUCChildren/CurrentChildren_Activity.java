package com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sve15138.vaccinator.DashBoard.vaccine_process.ProfileView.ProfileView;
import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.Fragment.SecondTabMainFragment;

public class CurrentChildren_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondtab_main);



        if(getIntent().hasExtra("childID")) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.secondtab_main_frameLayout, ProfileView.newInstance(getIntent().getStringExtra("childID")))
                    .commit();

        }
        else
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.secondtab_main_frameLayout, new SecondTabMainFragment())
                    .commit();
        }


    }
}
