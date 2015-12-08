package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.activeandroid.query.Select;

import Persistance.Model.BabyInfo;
import vaccine_process.VaccineRecord;

public class RegisterChild_Activity extends AppCompatActivity
{
    private EditText childname;
    private RadioGroup radioSexGroup;
    private RadioButton radioButton;
    private EditText dateofbirth;
    private EditText fathername;
    private EditText fathercnic;
    private EditText fathermobile;
    private EditText childaddress;
    private Spinner district;
    private Spinner tehsil;

    String childName;
    String childID;
    String childgender;
    String dateOfBirth;
    String fatherName;
    String fatherCNIC;
    String fatherMobile;
    String childAddress;
    String district1;
    String tehsil1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerchild);
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

        childName = childgender = dateOfBirth = fatherName = fatherCNIC = fatherMobile = childAddress = district1 = tehsil1 = "";

        Button registerChild = (Button) findViewById(R.id.BtnChildRecordSubmit);
        registerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveBaby();

                BabyInfo query = new Select().from(BabyInfo.class).where("ChildName = ?", childname.getText().toString()).executeSingle();

                if( query.childID != "" && query.childName != "" && query.fatherName != "" ){
                    startActivity(new Intent(RegisterChild_Activity.this, VaccineRecord.class)
                            .putExtra("childID", childID )
                            .putExtra("childName" , childName )
                            .putExtra("fatherName" , fatherName ));
                }
                else
                    Toast.makeText(RegisterChild_Activity.this , "Please enter all required values" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveBaby()
    {
        childName = childname.getText().toString();
        childgender = radioButton.getText().toString();

        boolean childGender = false;
        switch(childgender)
        {
            case "male": childGender = true; break;
            case "female": childGender = false; break;
            default: childGender = true; break;
        }

        childID = district1 + "111";
        dateOfBirth = dateofbirth.getText().toString();
        fatherName = fathername.getText().toString();
        fatherCNIC = fathercnic.getText().toString();
        fatherMobile = fathermobile.getText().toString();
        childAddress = childaddress.getText().toString();
        district1 = district.getSelectedItem().toString();
        tehsil1 = tehsil.getSelectedItem().toString();

        BabyInfo newBabyRegistration = new BabyInfo( childID , childName, dateOfBirth, childGender,
                fatherCNIC, fatherName, fatherMobile, childAddress, district1, tehsil1);
        newBabyRegistration.save();
    }
}
