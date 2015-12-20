package com.example.sve15138.vaccinator.DashBoard.vaccine_process;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;

import com.activeandroid.query.Select;

import java.util.List;

import Persistance.Model.VaccinationSchedule;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_FifthVisit;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_FourthVisit;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_SixthVisit;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_ThirdVisit;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_SecondVisit;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.DayFragments.Fragment_BirthVisit;

/**
 * Created by SVE15138 on 11/24/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter
{
    public static TabsPagerAdapter instance;
    public static VaccineRecord vaccineRecord;

    String childIDParam;

    public TabsPagerAdapter(FragmentManager fm, VaccineRecord Vaccinerecord )
    {
        super(fm);

        instance = this;
        vaccineRecord = Vaccinerecord;

        childIDParam = vaccineRecord.childIDParam;

        List<VaccinationSchedule> info = new Select().from(VaccinationSchedule.class).where("ChildID = ?" , childIDParam).execute();
    }

    @Override
    public Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return Fragment_BirthVisit.newInstance("", "") ;
            case 1:
                return Fragment_SecondVisit.newInstance("", "");
            case 2:
                return Fragment_FourthVisit.newInstance("", "");
            case 3:
                return  Fragment_FifthVisit.newInstance("", "");
            case 4:
                return Fragment_ThirdVisit.newInstance("", "");
            case 5:
                return Fragment_SixthVisit.newInstance("", "");
        }
        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        int temp = position + 1;
        return "Visit " + temp;
    }
}
