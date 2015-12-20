package com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.Adapter.SecondTabMainAdapter;
import com.example.sve15138.vaccinator.DashBoard.CurrentUCChildren.Model.SecondTabMainModel;

import java.util.ArrayList;
import java.util.List;

import Persistance.Model.BabyInfo;

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

        List<BabyInfo> info = new Select().from(BabyInfo.class).execute();

        for(int i = 0; i < info.size(); i++)
            data.add(new SecondTabMainModel(info.get(i).childID , info.get(i).childName , info.get(i).fatherName , "Active"));

        ListView listView = (ListView) view.findViewById(R.id.listView_secondtab_main);
        SecondTabMainAdapter adapter = new SecondTabMainAdapter(getContext() , R.layout.secondtab_main_row , data);
        listView.setAdapter(adapter);

        return view;
    }
}
