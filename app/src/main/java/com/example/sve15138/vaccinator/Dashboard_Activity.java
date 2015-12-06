package com.example.sve15138.vaccinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sve15138.vaccinator.SecondTab.MainActivity;

public class Dashboard_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Dashboard");

        Button registerChild = (Button)findViewById(R.id.registerChildDashBoard);
        Button currentUCChildren = (Button)findViewById(R.id.currentUCChildrenDashBoard);
        Button scanCard = (Button)findViewById(R.id.scanCardDashBoard);
        Button lostCard = (Button)findViewById(R.id.lostCardDashBoard);
        Button planMyDay = (Button)findViewById(R.id.planMyDayDashBoard);

        registerChild.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard_Activity.this, RegisterChild_Activity.class));
            }
        });

        currentUCChildren.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                startActivity(new Intent( Dashboard_Activity.this , MainActivity.class));
            }
        });


        scanCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
            }
        });

        lostCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Dashboard_Activity.this, SearchChild_Activity.class);
                startActivity(i);
            }
        });

        planMyDay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {

            }
        });
    }
}
