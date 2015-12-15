package com.example.sve15138.vaccinator;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.example.sve15138.vaccinator.SecondTab.MainActivity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import Persistance.Model.BabyInfo;


public class Card_Scan_write extends Activity {


    Tag mytag;
    String push_NFC;
    Activity ctx;
    private NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;
    private IntentFilter[] mIntentFilters;
    private String[][] mNFCTechLists;




    private String childName;
    private boolean childGender = false;                                //True for Male. False for Female
    private String dateOfBirth;
    private String fatherName;
    private String fatherCNIC;
    private String fatherMobile;
    private String childAddress;
    private String District;
    private String Tehsil;
    private String Child_id;

    private int VisitNum;
    private String NextDueDate;

    private ImageView imgV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardwrite);

        ctx=this;
        imgV= (ImageView)findViewById(R.id.scan_image_view_write);


        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter != null) {
            imgV.setBackgroundColor(Color.BLACK);
        } else {
            imgV.setBackgroundColor(Color.RED);
        }


        Intent curr_intent=getIntent();


        Child_id=curr_intent.getExtras().getString("Child_ID");
        BabyInfo info = new Select().from(BabyInfo.class).where("ChildID = ?" , Child_id).executeSingle();
        childName=info.childName;
        dateOfBirth=info.childDOB;

        childGender=info.childGender;


        fatherName=info.fatherName;
        fatherCNIC=info.fatherCNIC;
        fatherMobile=info.contactNumber;
        childAddress=info.address;
        District=info.district;
        Tehsil=info.tehsil;
        NextDueDate=info.nextDueDate;
        VisitNum=info.visitNumber;


        push_NFC= Child_id+"#"+childName+"#"+dateOfBirth+"#"+childGender+"#"+fatherName+"#"+ fatherCNIC+"#"+ fatherMobile+"#"+childAddress +"#"+District +"#"+Tehsil+"#"+VisitNum+"#"+"000@@"+"#"+NextDueDate;








        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        // set an intent filter for all MIME data
        IntentFilter ndefIntent = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefIntent.addDataType("*/*");
            mIntentFilters = new IntentFilter[] { ndefIntent,new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED) };
        } catch (Exception e) {

            Toast.makeText(ctx, "adding ndefintent", Toast.LENGTH_LONG).show();
        }

        mNFCTechLists = new String[][] { new String[] { NfcF.class.getName() } };

        Button btn=(Button)findViewById(R.id.Push_nfc_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Push_into_NFC();
            }
        });


    }











    public int Push_into_NFC()
    {

        int loop_check=0;
        // making string for NFC storage


        //nfc try catch
        try {
            if (mytag == null) {
                Toast.makeText(this, "Please Bring phone near to a tag", Toast.LENGTH_LONG).show();
            } else {
                write(push_NFC, mytag);

                Toast.makeText(this, "Save in NFC", Toast.LENGTH_LONG).show();
                Intent myintent = new Intent(this, MainActivity.class);

                myintent.putExtra("childid",Child_id);

                ctx.finish();


                startActivity(myintent);
                return 1;
            }
        } catch (IOException e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (FormatException e) {
            Toast.makeText(this, "Error3", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }// nfc try catch end

        return 0;
    }








    @Override
    public void onNewIntent(Intent intent) {
        mytag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        imgV.setBackgroundColor(Color.parseColor("#00cc00"));
/*
        // Saving child record in NFC
        if(Push_into_NFC()==1) {

            /// Saving Child Record in DB
            BabyInfo newBabyRegistration = new BabyInfo(Child_id, childName, dateOfBirth, childGender, fatherName,
                    fatherCNIC, fatherMobile, childAddress, District, Tehsil);

            newBabyRegistration.save();


            // Fetching CHild Record from DB

            BabyInfo query = new Select().from(BabyInfo.class).executeSingle();
            Toast.makeText(this, query.childName + " " + query.fatherName + "" + query.district, Toast.LENGTH_LONG).show();


            // Calling Vaccine_record
            Intent intent_2 = new Intent(this, Vaccine_record.class);
            intent_2.putExtra("data", push_NFC);
            intent_2.putExtra("scan_flag", 1);

            startActivity(intent_2);
            ctx.finish();
        }*/
    }



    // Functions onwards are for NFC ignore them
    private NdefRecord createRecord(String text) throws UnsupportedEncodingException {

        //create the message in according with the standard
        String lang = "en";
        byte[] textBytes = text.getBytes();
        byte[] langBytes = lang.getBytes("US-ASCII");
        int langLength = langBytes.length;
        int textLength = textBytes.length;

        byte[] payload = new byte[1 + langLength + textLength];
        payload[0] = (byte) langLength;

        // copy langbytes and textbytes into payload
        System.arraycopy(langBytes, 0, payload, 1, langLength);
        System.arraycopy(textBytes, 0, payload, 1 + langLength, textLength);

        NdefRecord recordNFC = new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], payload);
        return recordNFC;
    }

    private void write(String text, Tag tag) throws IOException, FormatException {

        NdefRecord[] records = { createRecord(text) };
        NdefMessage message = new NdefMessage(records);
        Ndef ndef = Ndef.get(tag);
        ndef.connect();
        ndef.writeNdefMessage(message);
        ndef.close();
    }
    @Override
    public void onResume() {
        super.onResume();

        if (mNfcAdapter != null)
            mNfcAdapter.enableForegroundDispatch(this, mPendingIntent, mIntentFilters, mNFCTechLists);
    }
    @Override
    public void onPause() {
        super.onPause();

        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }



}
