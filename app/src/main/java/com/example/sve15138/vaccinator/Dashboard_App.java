package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard_App extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button loginVerification = (Button) findViewById(R.id.Login_Submit);
        TextView forgetPassword = (TextView) findViewById(R.id.Forgetpassword);

        loginVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_fpass = new Intent(Dashboard_App.this, Home_activity.class);
                startActivity(intent_fpass);
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_fpass = new Intent(Dashboard_App.this, Forget_pass_activity.class);
                startActivity(intent_fpass);
            }
        });
    }
}
