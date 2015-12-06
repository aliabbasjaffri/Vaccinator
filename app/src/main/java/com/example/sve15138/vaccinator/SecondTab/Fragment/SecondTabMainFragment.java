package com.example.sve15138.vaccinator.SecondTab.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.SecondTab.Adapter.SecondTabMainAdapter;
import com.example.sve15138.vaccinator.SecondTab.Model.SecondTabMainModel;

import java.util.ArrayList;

/**
 * Created by aliabbasjaffri on 06/12/15.
 */
public class SecondTabMainFragment extends Fragment
{
    public SecondTabMainFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_secondtab_listview, container, false);

        ArrayList<SecondTabMainModel> data = new ArrayList<>();
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));
        data.add(new SecondTabMainModel("Bahawpur111" , "Shehryar Rao" , "Ajeeb Rao" , "Active"));

        ListView listView = (ListView) view.findViewById(R.id.listView_secondtab_main);
        SecondTabMainAdapter adapter = new SecondTabMainAdapter(getContext() , R.layout.secondtab_main_row , data);
        listView.setAdapter(adapter);

        return view;
    }
}
