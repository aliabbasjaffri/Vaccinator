package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Dashboard");

        Button registerChild = (Button)findViewById(R.id.registerChildDashBoard);
        Button updateChildInfo = (Button)findViewById(R.id.updateChildInfoDashBoard);
        Button scanCard = (Button)findViewById(R.id.scanCardDashBoard);
        Button lostCard = (Button)findViewById(R.id.lostCardDashBoard);
        Button planMyDay = (Button)findViewById(R.id.planMyDayDashBoard);

        registerChild.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Dashboard_Activity.this, RegisterChild_Activity.class);
                // i.putExtra("vaccinator_id", vaccinator_id);
                startActivity(i);
                //finish();
            }
        });

        updateChildInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               /* Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
                //finish();*/
            }
        });


        scanCard.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Dashboard_Activity.this, SearchChild_Activity.class);
                // i.putExtra("vaccinator_id", vaccinator_id);
                // i.putExtra("parent_key", 1); // parent activity main
                startActivity(i);
                //	finish();*/

            }
        });

        lostCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              /*  Intent i = new Intent(Main_activity.this, PlanMyDay.class);
                i.putExtra("vaccinator_id", vaccinator_id);
                startActivity(i);
                //finish();*/
            }
        });
        planMyDay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                /*Intent i = new Intent(Main_activity.this, Search_child_update.class);
                i.putExtra("vaccinator_id", vaccinator_id);
                startActivity(i);
                //finish();*/


            }
        });






    }





}
