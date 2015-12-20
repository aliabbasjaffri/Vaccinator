package com.example.sve15138.vaccinator.DashBoard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sve15138.vaccinator.DashBoard.CardScan.CardScan_Activity;
import com.example.sve15138.vaccinator.DashBoard.ChildSearch.SearchChild_Activity;
import com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.CurrentChildren_Activity;
import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.DashBoard.RegisterChild.RegisterChild_Activity;

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
        Button searchChild = (Button)findViewById(R.id.searchChildDashBoard);
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
                startActivity(new Intent( Dashboard_Activity.this , CurrentChildren_Activity.class));
            }
        });


        scanCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent( Dashboard_Activity.this , CardScan_Activity.class));
            }
        });

        searchChild.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard_Activity.this, SearchChild_Activity.class));
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
