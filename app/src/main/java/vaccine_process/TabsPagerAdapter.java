package vaccine_process;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

import vaccine_process.Fragments.Fragment_FifthVisit;
import vaccine_process.Fragments.Fragment_FourthVisit;
import vaccine_process.Fragments.Fragment_SixthVisit;
import vaccine_process.Fragments.Fragment_ThirdVisit;
import vaccine_process.Fragments.Fragment_SecondVisit;
import vaccine_process.Fragments.Fragment_BirthVisit;

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
    Fragment_BirthVisit f0=new Fragment_BirthVisit();
    Fragment_SecondVisit f1=new Fragment_SecondVisit();
    Fragment_FourthVisit f2=new Fragment_FourthVisit();
    Fragment_FifthVisit f3=new Fragment_FifthVisit();
    Fragment_ThirdVisit f4=new Fragment_ThirdVisit();
    Fragment_SixthVisit f5=new Fragment_SixthVisit();


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
                return Fragment_BirthVisit.newInstance("", "") ;
            case 1:
                return Fragment_SecondVisit.newInstance("", "");
            case 2:
                //f2.setArguments(b);
                return Fragment_FourthVisit.newInstance("", "");
            case 3:
              //  f3.setArguments(b);
                return  Fragment_FifthVisit.newInstance("", "");
            case 4:
               //f4.setArguments(b);
                return Fragment_ThirdVisit.newInstance("", "");
            case 5:
                //f5.setArguments(b);
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
    public CharSequence getPageTitle(int position) {

        int temp=position+1;
        return "Visit " + temp;
    }


}
