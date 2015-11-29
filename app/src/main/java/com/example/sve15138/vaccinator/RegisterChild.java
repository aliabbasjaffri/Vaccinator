package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vaccine_process.Vaccine_record;

public class RegisterChild extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_child);
        setTitle("Register Child");
    }

    public void  Register_Child(View v)
    {
        Intent intent_Reg = new Intent(this, Vaccine_record.class);
        startActivity(intent_Reg);
    }
}
