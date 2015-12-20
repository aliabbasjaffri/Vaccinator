package com.example.sve15138.vaccinator.LoginModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sve15138.vaccinator.R;

public class ForgetPassword_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        setTitle("Forget Password");

        EditText resetEmailAddress = (EditText) findViewById(R.id.email_reset);
        final String resetAddress = resetEmailAddress.getText().toString();

        Button resetPasswordButton = (Button) findViewById(R.id.Reset_Submit);
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (resetAddress != null && resetAddress.contains("@"))
                {
                    Toast.makeText(ForgetPassword_Activity.this , "A password reset request has been sent to your mentioned Email Address" , Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
