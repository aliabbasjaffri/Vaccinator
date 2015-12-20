package com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import com.example.sve15138.vaccinator.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_ThirdVisit.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_ThirdVisit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_ThirdVisit extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_ThirdVisit.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_ThirdVisit newInstance(String param1, String param2) {
        Fragment_ThirdVisit fragment = new Fragment_ThirdVisit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_ThirdVisit() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thirdvisit, container, false);
    }
}
