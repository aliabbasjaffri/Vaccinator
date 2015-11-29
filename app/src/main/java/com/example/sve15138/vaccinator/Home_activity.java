package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        setTitle("My Day");

        Button b1,b2,b3,b4,b5;
        b1=(Button)findViewById(R.id.registorchild1);
        b3=(Button)findViewById(R.id.scancard1);
        b2=(Button)findViewById(R.id.scancard12);
        b4=(Button)findViewById(R.id.plan_button);
        b5=(Button)findViewById(R.id.update_child_info);



        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              Intent i = new Intent(Home_activity.this, RegisterChild.class);
               // i.putExtra("vaccinator_id", vaccinator_id);
                startActivity(i);
                //finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               /* Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
                //finish();*/
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent i=new Intent(Home_activity.this,SearchChild.class);
               // i.putExtra("vaccinator_id", vaccinator_id);
               // i.putExtra("parent_key", 1); // parent activity main
                startActivity(i);
                //	finish();*/

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              /*  Intent i = new Intent(Main_activity.this, PlanMyDay.class);
                i.putExtra("vaccinator_id", vaccinator_id);
                startActivity(i);
                //finish();*/
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

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
