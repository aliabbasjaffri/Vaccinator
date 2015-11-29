package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard_App extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        // setting launcher image of injection.
        ImageView launch_img=(ImageView)findViewById(R.id.Logo_Main);

        launch_img.setImageResource(R.drawable.childimmunizationprogram);







    }
    public void  Login_Verification(View v)
    {
        Intent intent_fpass = new Intent(this, Home_activity.class);
        startActivity(intent_fpass);

    }




    public void  Forget_Password(View v)
    {
        Intent intent_fpass = new Intent(this,Forget_pass_activity.class);
        startActivity(intent_fpass);


    }





}
