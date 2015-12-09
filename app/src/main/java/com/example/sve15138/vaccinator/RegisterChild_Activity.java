package com.example.sve15138.vaccinator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.activeandroid.query.Select;
import Persistance.Model.BabyInfo;

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

    Spinner tehseelspinner ;
    Spinner districtspinner ;

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

                if( !query.equals(null) )
                    startActivity(new Intent(RegisterChild_Activity.this, Card_Scan_write.class).putExtra("Child_ID", childID));
                else
                    Toast.makeText(RegisterChild_Activity.this , "Please enter all required values" , Toast.LENGTH_SHORT).show();
            }
        });

        Set_all_spinners();
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

        dateOfBirth = dateofbirth.getText().toString();
        fatherName = fathername.getText().toString();
        fatherCNIC = fathercnic.getText().toString();
        fatherMobile = fathermobile.getText().toString();
        childAddress = childaddress.getText().toString();
        district1 = district.getSelectedItem().toString();
        tehsil1 = tehsil.getSelectedItem().toString();
        // @@@@@@@@@@@@@@@@@@@@@@@@@@ -- Temporary Setting childID -- @@@@@@@@@@@@@@@@@@@@@@@@@@
        childID = fatherCNIC;
        BabyInfo newBabyRegistration = new BabyInfo( childID , childName, dateOfBirth, childGender,
                fatherCNIC, fatherName, fatherMobile, childAddress, district1, tehsil1);
        newBabyRegistration.save();
    }

    public void Set_all_spinners()
    {
        districtspinner = (Spinner)findViewById(R.id.districtSpinnerRegisterChild);
        tehseelspinner = (Spinner)findViewById(R.id.tehseelSpinnerRegisterChild);
        districtspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3)
            {
                // TODO Auto-generated method stub
                String val = (String) parent.getItemAtPosition(arg2);

                ArrayAdapter<CharSequence> adapter_tehseel = null;
                switch (val) {
                    case "Bahawalnagar":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.Bahawalnagar_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "Bahawalpur":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.Bahawalpur_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "Rahim Yar Khan":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.Rahim_Yar_Khan_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "DERA GHAZI KHAN":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.DERA_GHAZI_KHAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LAYYAH":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.LAYYAH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MUZAFFAR GARH":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.MUZAFFAR_GARH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "RAJAN PUR":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.RAJAN_PUR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "FAISALABAD":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.FAISALABAD_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "JHANG":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.JHANG_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "TOBA TEK SINGH":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.T_T_SINGH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "CHINIOT":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.CHINIOT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "GUJRANWALA":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.GUJRANWALA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "GUJRAT":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.GUJRAT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SIALKOT":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.SIALKOT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "NAROWAL":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.NAROWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "HAFIZABAD":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.HAFIZABAD_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MANDI BAHUDDIN":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.MANDI_BAHUDDIN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KASUR":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.KASUR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LAHORE":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.LAHORE_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SHEIKHUPURA":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.SHEIKHUPURA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "NANKANA SAHIB":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.NANKANA_SAHIB_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MULTAN":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.MULTAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KHANEWAL":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.KHANEWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "VEHARI":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.VEHARI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LODHRAN":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.LODHRAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "ATTOCK":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.ATTOCK_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "JHELUM":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.JHELUM_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "RAWALPINDI":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.RAWALPINDI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "CHAKWAL":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.CHAKWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "OKARA":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.OKARA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SAHIWAL":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.SAHIWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "PAKPATTAN":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.PAKPATTAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "BHAKKAR":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.BHAKKAR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KHUSHAB":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.KHUSHAB_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MIANWALI":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.MIANWALI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SARGODHA":
                        adapter_tehseel =
                                ArrayAdapter.createFromResource(
                                        RegisterChild_Activity.this, R.array.SARGODHA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                }
                adapter_tehseel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tehseelspinner.setAdapter(adapter_tehseel);
                ((BaseAdapter) tehseelspinner.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
