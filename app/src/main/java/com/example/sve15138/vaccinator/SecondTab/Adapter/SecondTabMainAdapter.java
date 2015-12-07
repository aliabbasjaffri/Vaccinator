package com.example.sve15138.vaccinator.SecondTab.Adapter;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import java.util.ArrayList;
import android.widget.Button;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import com.example.sve15138.vaccinator.R;
import android.support.v7.app.AppCompatActivity;
import com.example.sve15138.vaccinator.ProfileView.ProfileView;
import com.example.sve15138.vaccinator.SecondTab.MainActivity;
import com.example.sve15138.vaccinator.SecondTab.Model.SecondTabMainModel;

/**
 * Created by aliabbasjaffri on 06/12/15.
 */
public class SecondTabMainAdapter extends ArrayAdapter
{
    Context context;
    int XML_ID;
    ArrayList<SecondTabMainModel> data;

    public SecondTabMainAdapter(Context context, int resource , ArrayList<SecondTabMainModel> Data)
    {
        super(context, resource , Data);

        this.context = context;
        XML_ID = resource;
        data = Data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
        View row = inflater.inflate(XML_ID, parent, false);

        TextView childID =  (TextView) row.findViewById(R.id.secondtab_row_childID);
        TextView childName =  (TextView) row.findViewById(R.id.secondtab_row_childName);
        TextView fatherName =  (TextView) row.findViewById(R.id.secondtab_row_fatherName);
        TextView status =  (TextView) row.findViewById(R.id.secondtab_row_status);
        Button details = (Button) row.findViewById(R.id.secondtab_row_details);

        childID.setText( data.get(position).getChildID() );
        childName.setText( data.get(position).getChildName() );
        fatherName.setText( data.get(position).getFatherName() );
        status.setText( data.get(position).getStatus() );
        details.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondtab_main_frameLayout, new ProfileView())
                        .addToBackStack(ProfileView.class.getName())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        return row;
    }
}
