package com.example.sve15138.vaccinator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class SearchChild_Activity extends AppCompatActivity
{
    private EditText childID_editText;
    private EditText childname;
    private RadioGroup radioSearchGroup;
    private RadioButton radioSearchButton;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText fathername;
    private EditText fathercnic;
    private EditText fathermobile;
    private Spinner district;
    private Spinner tehsil;
    private Button searchNormal;

    String childName;
    String childID;
    boolean childGender;
    String fatherName;
    String fatherCNIC;
    String fatherMobile;
    String district1;
    String tehsil1;
    String searchType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchchild);
        setTitle("Search Child");

        childID_editText = (EditText) findViewById(R.id.search_ChildID);
        radioSearchGroup = (RadioGroup) findViewById(R.id.radioSearchGroup);
        searchNormal = (Button) findViewById(R.id.search_normalSearchButton);
        searchNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                normalSearch();
            }
        });

        radioSearchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioSearchButton = (RadioButton) findViewById(checkedId);
                searchType = radioSearchButton.getText().toString();

                if(searchType.equals("Advanced"))
                {
                    advancedSearch();
                }
            }
        });
    }

    private void normalSearch()
    {
        childID = childID_editText.getText().toString();

        if(childID.trim().equals(""))
        {
            Toast.makeText(SearchChild_Activity.this, "Please enter a valid Child ID", Toast.LENGTH_SHORT).show();
            return;
        }

        BabyInfo childRecord = new Select().from(BabyInfo.class).where("ChildID = ?" , childID).executeSingle();

        if( childRecord.equals(null) )
        {
            Toast.makeText(SearchChild_Activity.this, "No Such Child Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        //startActivity(new Intent( SearchChild_Activity.this , ProfileView.class).putExtra("ChildID" , childID));
    }

    private void advancedSearch()
    {
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(SearchChild_Activity.this);
        View promptView = layoutInflater.inflate(R.layout.advanced_search, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SearchChild_Activity.this);
        alertDialogBuilder.setView(promptView);

        childname = (EditText) promptView.findViewById(R.id.advancedSearch_childName);
        radioSexGroup = (RadioGroup) promptView.findViewById(R.id.advancedSearch_radioGroupGender);
        radioSexButton = (RadioButton) promptView.findViewById(radioSexGroup.getCheckedRadioButtonId()) ;
        fathername = (EditText) promptView.findViewById(R.id.advancedSearch_fatherName);
        fathercnic = (EditText) promptView.findViewById(R.id.advancedSearch_fatherCNIC);
        fathermobile = (EditText) promptView.findViewById(R.id.advancedSearch_fatherMobile);
        district = (Spinner) promptView.findViewById(R.id.advancedSearch_districtSpinner2);
        tehsil = (Spinner) promptView.findViewById(R.id.advancedSearch_tehsilSpinner2);

        setAllSpinners();

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        childName = childname.getText().toString();
                        switch (radioSexButton.getText().toString()) {
                            case "Male":
                                childGender = true;
                                break;
                            case "Female":
                                childGender = false;
                                break;
                        }
                        fatherName = fathername.getText().toString();
                        fatherCNIC = fathercnic.getText().toString();
                        fatherMobile = fathermobile.getText().toString();
                        district1 = district.getSelectedItem().toString();
                        tehsil1 = tehsil.getSelectedItem().toString();

                        BabyInfo childRecord = new Select().from(BabyInfo.class)
                                .where("ChildName = ? OR FatherName = ? OR FatherCNIC = ? OR ContactNumber = ? OR District = ? OR Tehsil = ? AND ChildGender = ?", childName, fatherName, fatherCNIC, fatherMobile, district1, tehsil1, childGender).executeSingle();

                        if (childRecord.equals(null)) {
                            Toast.makeText(SearchChild_Activity.this, "No Such Child Exists", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Toast.makeText(SearchChild_Activity.this, "Child Exists!", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        radioSearchButton = (RadioButton)SearchChild_Activity.this.findViewById(R.id.search_radioButtonNormal);
                        radioSearchButton.toggle();
                        dialog.cancel();
                    }
                });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void setAllSpinners()
    {
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3)
            {
                // TODO Auto-generated method stub
                String val = (String) parent.getItemAtPosition(arg2);

                ArrayAdapter<CharSequence> tehsilAdapter = null;
                switch (val) {
                    case "Bahawalnagar":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.Bahawalnagar_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "Bahawalpur":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.Bahawalpur_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "Rahim Yar Khan":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.Rahim_Yar_Khan_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "DERA GHAZI KHAN":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.DERA_GHAZI_KHAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LAYYAH":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.LAYYAH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MUZAFFAR GARH":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.MUZAFFAR_GARH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "RAJAN PUR":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.RAJAN_PUR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "FAISALABAD":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.FAISALABAD_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "JHANG":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.JHANG_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "TOBA TEK SINGH":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.T_T_SINGH_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "CHINIOT":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.CHINIOT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "GUJRANWALA":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.GUJRANWALA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "GUJRAT":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.GUJRAT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SIALKOT":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.SIALKOT_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "NAROWAL":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.NAROWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "HAFIZABAD":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.HAFIZABAD_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MANDI BAHUDDIN":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.MANDI_BAHUDDIN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KASUR":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.KASUR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LAHORE":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.LAHORE_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SHEIKHUPURA":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.SHEIKHUPURA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "NANKANA SAHIB":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.NANKANA_SAHIB_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MULTAN":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.MULTAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KHANEWAL":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.KHANEWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "VEHARI":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.VEHARI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "LODHRAN":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.LODHRAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "ATTOCK":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.ATTOCK_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "JHELUM":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.JHELUM_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "RAWALPINDI":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.RAWALPINDI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "CHAKWAL":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.CHAKWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "OKARA":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.OKARA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SAHIWAL":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.SAHIWAL_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "PAKPATTAN":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.PAKPATTAN_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "BHAKKAR":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.BHAKKAR_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "KHUSHAB":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.KHUSHAB_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "MIANWALI":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.MIANWALI_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                    case "SARGODHA":
                        tehsilAdapter =
                                ArrayAdapter.createFromResource(
                                        SearchChild_Activity.this, R.array.SARGODHA_Tehseelname, android.R.layout.simple_spinner_item);
                        break;
                }
                tehsilAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tehsil.setAdapter(tehsilAdapter);
                ((BaseAdapter) tehsil.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
