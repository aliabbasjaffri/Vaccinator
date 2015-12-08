package com.example.sve15138.vaccinator.ProfileView;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;

import com.activeandroid.query.Select;
import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.SecondTab.MainActivity;

import android.support.annotation.Nullable;
import android.widget.Toast;

import Persistance.Model.BabyInfo;
import vaccine_process.VaccineRecord;

public class ProfileView extends Fragment
{
    private TextView childName;
    private TextView childID;
    private TextView fatherName;
    private TextView fatherCNIC;
    private TextView address;
    private TextView district;
    private TextView tehsil;
    private Button childVaccinationHistory;

    private static final String ARG_PARAM = "param";

    // TODO: Rename and change types of parameters
    private String childIDParam;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Fragment_BirthVisit.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileView newInstance(String param1) {
        ProfileView fragment = new ProfileView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            childIDParam = getArguments().getString(ARG_PARAM);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profileview , container , false);

        BabyInfo info = new Select().from(BabyInfo.class).where("ChildID = ?" , childIDParam).executeSingle();

        Toast.makeText(getActivity().getApplicationContext() , info.childName + " " + info.district , Toast.LENGTH_LONG).show();

        childName = (TextView) view.findViewById(R.id.profile_childName);
        childName.setText(info.childName);

        childID = (TextView) view.findViewById(R.id.profile_childID);
        childID.setText(info.childID);

        fatherName = (TextView) view.findViewById(R.id.profile_fatherName);
        fatherName.setText(info.fatherName);

        fatherCNIC = (TextView) view.findViewById(R.id.profile_fatherID);
        fatherCNIC.setText(info.fatherCNIC);

        address = (TextView) view.findViewById(R.id.profile_address);
        address.setText(info.address);

        district = (TextView) view.findViewById(R.id.profile_district);
        district.setText(info.district);

        tehsil = (TextView) view.findViewById(R.id.profile_tehsil);
        tehsil.setText(info.tehsil);

        childVaccinationHistory = (Button) view.findViewById(R.id.profile_vaccinationHistory);
        


        childVaccinationHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent itn=new Intent(getActivity(),VaccineRecord.class);

                itn.putExtra("childID", childID.getText().toString());
                itn.putExtra("childName", childName.getText().toString());
                itn.putExtra("fatherName", fatherName.getText().toString());
                startActivity(itn);


            }
        });

        return view;
    }
}
