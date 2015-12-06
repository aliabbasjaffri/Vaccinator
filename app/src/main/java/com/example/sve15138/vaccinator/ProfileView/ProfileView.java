package com.example.sve15138.vaccinator.ProfileView;

import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import com.example.sve15138.vaccinator.R;
import android.support.annotation.Nullable;

public class ProfileView extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profileview , container , false);



        return view;
    }
}
