package com.example.sve15138.vaccinator.LoginModule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sve15138.vaccinator.DashBoard.Dashboard_Activity;
import com.example.sve15138.vaccinator.R;

public class Login_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginVerification = (Button) findViewById(R.id.Login_Submit);
        TextView forgetPassword = (TextView) findViewById(R.id.Forgetpassword);

        loginVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_fpass = new Intent(Login_Activity.this, Dashboard_Activity.class);
                startActivity(intent_fpass);
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_fpass = new Intent(Login_Activity.this, ForgetPassword_Activity.class);
                startActivity(intent_fpass);
            }
        });
    }
}
