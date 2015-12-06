package vaccine_process;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

import vaccine_process.Fragments.Fragment_09months;
import vaccine_process.Fragments.Fragment_10week;
import vaccine_process.Fragments.Fragment_14week;
import vaccine_process.Fragments.Fragment_15months;
import vaccine_process.Fragments.Fragment_6week;
import vaccine_process.Fragments.Fragment_birth;

/**
 * Created by SVE15138 on 11/24/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter
{
    private Context context;
    public static TabsPagerAdapter inst;
    public static Vaccine_record Vac;
    Bundle b;
    //	Fragment_child_info f=new Fragment_child_info();
    Fragment_birth f0=new Fragment_birth();
    Fragment_6week f1=new Fragment_6week();
    Fragment_10week f2=new Fragment_10week();
    Fragment_14week f3=new Fragment_14week();
    Fragment_09months f4=new Fragment_09months();
    Fragment_15months f5=new Fragment_15months();


    public TabsPagerAdapter(FragmentManager fm,Context context,Vaccine_record Vrecord,int child_id, int vaccinator_id,String gps)
    {
        super(fm);

        inst =this;
        Vac=Vrecord;
        this.context=context;

        b=new Bundle();
        b.putInt("childid", child_id);
        b.putInt("vaccinator_id", vaccinator_id);
        b.putString("gps", gps);
    }


    @Override
    public Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return Fragment_birth.newInstance("","") ;
            case 1:
                return Fragment_6week.newInstance("","");
            case 2:
                //f2.setArguments(b);
                return Fragment_10week.newInstance("","");
            case 3:
              //  f3.setArguments(b);
                return  Fragment_14week.newInstance("","");
            case 4:
               //f4.setArguments(b);
                return Fragment_09months.newInstance("","");
            case 5:
                //f5.setArguments(b);
                return Fragment_15months.newInstance("","");
        }
        return null;
    }


    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        int temp=position+1;
        return "Visit " + temp;
    }


}
