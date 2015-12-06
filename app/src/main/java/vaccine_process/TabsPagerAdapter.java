package vaccine_process;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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
    public static TabsPagerAdapter instance;
    public static VaccineRecord vaccineRecord;

    public TabsPagerAdapter(FragmentManager fm, Context context, VaccineRecord Vaccinerecord )
    {
        super(fm);

        instance = this;
        vaccineRecord = Vaccinerecord;
        this.context = context;
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
