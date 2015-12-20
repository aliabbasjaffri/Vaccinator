package com.example.sve15138.vaccinator.DashBoard.CardScan;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.CurrentChildren_Activity;
import com.example.sve15138.vaccinator.R;

import java.util.Arrays;


public class CardScan_Activity extends Activity {

    private NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;
    TextView Scan_txt;

    private IntentFilter[] mIntentFilters;
    private String[][] mNFCTechLists;
    Tag mytag;
    Context ctx;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardscan);
        ctx=this;

        imgV= (ImageView)findViewById(R.id.scan_image_view);


        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter != null) {
            imgV.setBackgroundColor(Color.BLACK);
        } else {
            imgV.setBackgroundColor(Color.RED);
        }



        mPendingIntent = PendingIntent.getActivity(this, 1,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),PendingIntent.FLAG_UPDATE_CURRENT);

        // set an intent filter for all MIME data
        IntentFilter ndefIntent = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefIntent.addDataType("*/*");
            mIntentFilters = new IntentFilter[] { ndefIntent };
        } catch (Exception e) {

            Toast.makeText(ctx, "adding ndefintent", Toast.LENGTH_LONG).show();
        }

        mNFCTechLists = new String[][] { new String[] { NfcF.class.getName() } };


    }




    @Override
    public void onNewIntent(Intent intent) {
        String s="";
        String action = intent.getAction();
        //if (mWriteMode && NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())
        // Tag mytag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        mytag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        Parcelable[] data = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        if (data != null) {
            try {
                for (int i = 0; i < data.length; i++) {
                    NdefRecord[] recs = ((NdefMessage)data[i]).getRecords();
                    for (int j = 0; j < recs.length; j++) {
                        if (recs[j].getTnf() == NdefRecord.TNF_WELL_KNOWN &&
                                Arrays.equals(recs[j].getType(), NdefRecord.RTD_TEXT)) {
                            byte[] payload = recs[j].getPayload();
                            String textEncoding =((payload[0] & 0200)==0) ? "UTF-8":"UTF-16";

                            int langCodeLen = payload[0] & 0077;
                            s= new String(payload, langCodeLen + 1, payload.length - langCodeLen - 1,
                                    textEncoding);
                            if(s.equals("0")) {
                                // Intent myintent = new Intent(this, RegisterChild.class);
                                //myintent.pu
                                // startActivityForResult(myintent, 0);
                            }else{
//                                mTextView.setText(s);
                                parseintent(s);
                                Toast.makeText(ctx, "parseintent S", Toast.LENGTH_LONG).show();

                            }

                        }
                    }
                }
            } catch (Exception e) {
                Toast.makeText(ctx, "Tag dispatch on new intent", Toast.LENGTH_LONG).show();
            }
        }



        Intent myintent = new Intent(this, CurrentChildren_Activity.class);


        String Arry[] = s.split("#");

        myintent.putExtra("childid",Arry[0]);

        this.finish();


        startActivity(myintent);

    }



    @Override
    public void onResume() {
        super.onResume();

        if (mNfcAdapter != null)
            mNfcAdapter.enableForegroundDispatch(this, mPendingIntent, mIntentFilters, mNFCTechLists);
    }



    public void parseintent(String s){
        imgV.setBackgroundColor(Color.GREEN);
        Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();


    }
    @Override
    public void onPause() {
        super.onPause();

        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }












}
