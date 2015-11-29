package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.activeandroid.query.Select;

import Persistance.Model.BabyInfo;
import vaccine_process.Vaccine_record;

public class RegisterChild extends AppCompatActivity
{
    private String childName;
    private boolean childGender = false;                                //True for Male. False for Female
    private String dateOfBirth;
    private String fatherName;
    private String fatherCNIC;
    private String fatherMobile;
    private String childAddress;
    private String District;
    private String Tehsil;

    EditText childname;
    RadioGroup radioSexGroup;
    RadioButton radioButton;
    EditText dateofbirth;
    EditText fathername;
    EditText fathercnic;
    EditText fathermobile;
    EditText childaddress;
    Spinner district;
    Spinner tehsil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_child);
        setTitle("Register Child");

        childname = (EditText) findViewById(R.id.childNameRegisterChild);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton = (RadioButton) findViewById(radioSexGroup.getCheckedRadioButtonId());


        dateofbirth = (EditText) findViewById(R.id.dateofBirthRegisterChild);


        fathername = (EditText) findViewById(R.id.fatherNameRegisterChild);


        fathercnic = (EditText) findViewById(R.id.fatherCnicRegisterChild);


        fathermobile = (EditText) findViewById(R.id.fatherMobileRegisterChild);


        childaddress = (EditText) findViewById(R.id.addressRegisterChild);


        district = (Spinner) findViewById(R.id.districtSpinnerRegisterChild);


        tehsil = (Spinner) findViewById(R.id.tehseelSpinnerRegisterChild);


        Button registerChild = (Button) findViewById(R.id.BtnChildRecordSubmit);
        registerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveBaby();

                BabyInfo query = new Select().from(BabyInfo.class).executeSingle();
                Toast.makeText(RegisterChild.this , query.childName + " " + query.fatherName + "" + query.district, Toast.LENGTH_LONG ).show();
                startActivity(new Intent(RegisterChild.this, Vaccine_record.class));
            }
        });
    }

    public void saveBaby()
    {
        childName = childname.getText().toString();

        String childgender = radioButton.getText().toString();

        switch(childgender)
        {
            case "male": childGender = true; break;
            case "female": childGender = false; break;
            default: childGender = true; break;
        }

        dateOfBirth = dateofbirth.getText().toString();

        fatherName = fathername.getText().toString();

        fatherCNIC = fathercnic.getText().toString();

        fatherMobile = fathermobile.getText().toString();

        childAddress = childaddress.getText().toString();

        District = district.getSelectedItem().toString();

        Tehsil = tehsil.getSelectedItem().toString();

        BabyInfo newBabyRegistration = new BabyInfo( District + "111" , childName , dateOfBirth, childGender ,
                fatherCNIC , fatherMobile , childAddress , District , Tehsil);
        newBabyRegistration.save();
    }
}
