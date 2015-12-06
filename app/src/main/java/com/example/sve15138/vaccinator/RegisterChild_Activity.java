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

import com.activeandroid.query.Select;

import Persistance.Model.BabyInfo;
import vaccine_process.Vaccine_record;

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

        Button registerChild = (Button) findViewById(R.id.BtnChildRecordSubmit);
        registerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveBaby();

                BabyInfo query = new Select().from(BabyInfo.class).where("ChildName = ?", childname.getText().toString()).executeSingle();

                Log.i("Father Name" , query.fatherName );
                Log.i("Name", query.childName);
                Log.i("Father CNIC", query.fatherCNIC);


                //Toast.makeText(RegisterChild_Activity.this , query.childName + " " + query.fatherName + "" + query.district, Toast.LENGTH_LONG ).show();
                startActivity(new Intent(RegisterChild_Activity.this, Vaccine_record.class));
            }
        });
    }

    private void saveBaby()
    {
        String childName = childname.getText().toString();
        String childgender = radioButton.getText().toString();

        boolean childGender = false;
        switch(childgender)
        {
            case "male": childGender = true; break;
            case "female": childGender = false; break;
            default: childGender = true; break;
        }

        String dateOfBirth = dateofbirth.getText().toString();
        String fatherName = fathername.getText().toString();
        String fatherCNIC = fathercnic.getText().toString();
        String fatherMobile = fathermobile.getText().toString();
        String childAddress = childaddress.getText().toString();
        String district1 = district.getSelectedItem().toString();
        String tehsil1 = tehsil.getSelectedItem().toString();

        Log.i("Name at Save" , childName );
        Log.i("Father Name at Save" , fatherName );
        Log.i("Father CNIC at Save" , fatherCNIC );

        BabyInfo newBabyRegistration = new BabyInfo( district1 + "111" , childName, dateOfBirth, childGender,
                fatherCNIC, fatherName, fatherMobile, childAddress, district1, tehsil1);
        newBabyRegistration.save();
    }
}
