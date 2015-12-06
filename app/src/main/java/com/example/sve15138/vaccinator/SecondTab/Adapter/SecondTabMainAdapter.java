package com.example.sve15138.vaccinator.SecondTab.Adapter;

import java.util.ArrayList;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sve15138.vaccinator.R;
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

        childID.setText( data.get(position).getChildID() );
        childName.setText( data.get(position).getChildName() );
        fatherName.setText( data.get(position).getFatherName() );
        status.setText( data.get(position).getStatus() );

        return row;
    }
}
