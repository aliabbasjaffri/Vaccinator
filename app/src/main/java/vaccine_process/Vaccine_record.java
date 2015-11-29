package vaccine_process;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sve15138.vaccinator.R;





/**
 * Created by SVE15138 on 11/24/2015.
 */
public class Vaccine_record extends AppCompatActivity implements Fragment_birth.OnFragmentInteractionListener, Fragment_15months.OnFragmentInteractionListener, Fragment_14week.OnFragmentInteractionListener, Fragment_10week.OnFragmentInteractionListener, Fragment_09months.OnFragmentInteractionListener, Fragment_6week.OnFragmentInteractionListener {

    CustomViewPager mViewPager;
    TabsPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;


   public TextView mTitle;
    Toolbar toolbar;
    protected  Vaccine_record instance;



    int child_id;

    private String[] tabs = {/*"Info",*/ "Visit 1", "Visit 2", "Visit 3","Visit 4","Visit 5","Visit 6" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_xml);


        instance= this;

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        child_id=124;//getIntent().getExtras().getInt("childid");
        int server_id=111;//getIntent().getExtras().getInt("serverid");
        int vaccinator_id=4191;//getIntent().getExtras().getInt("vaccinator_id");



        // calling and attaching stuffs
        //viewPager = (ViewPager) findViewById(R.id);
       // this.getApplicationContext() , instance

        mViewPager = (CustomViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this.getApplicationContext() , instance,123,99,"abc" );
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setPagingEnabled(true);


        mViewPager.setOffscreenPageLimit(viewPagerAdapter.getCount() - 2);
        mViewPager.setBackgroundColor(Color.parseColor("#3f355b"));

        //toolbar = (Toolbar) findViewById(R.id.baseActivityToolbarInclude);
        //mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

            tabLayout = (TabLayout) findViewById(R.id.VaccineProcessActivityTabLayoutInclude);
      tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#f3f5f9"));





       // setToolbar("Visit 1", false);




        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                clearBackStack();
                String title ="Visit 1";
                setToolbar(title, false);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });





    }


    public void setToolbar(String title, boolean backButton)
    {
        if (toolbar != null && mTitle != null)
        {
            mTitle.setText(title);
            setSupportActionBar(toolbar);

            Log.d("BackButton", " " + backButton);

            if (backButton)
            {

                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
            else
            {
                toolbar.setNavigationIcon(null);
                getSupportActionBar().setHomeButtonEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setDisplayShowHomeEnabled(false);
            }

            toolbar.setNavigationOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    onBackPressed();
                }
            });
        }
    }



















    @Override
    protected void onResume() {
        super.onResume();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e("Error" + Thread.currentThread().getStackTrace()[2], paramThrowable.getLocalizedMessage());
                System.gc();
                System.exit(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_student_portal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStop() {
        super.onStop();

    }


    @Override
    public void onBackPressed()
    {
        viewPagerAdapter.notifyDataSetChanged();
        super.onBackPressed();
    }


    @Override
    public void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }



    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }




    public void clearBackStack()
    {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


    @Override
    protected void onDestroy()
    {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onDestroy();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }


    @Override
    public void onFragmentInteraction14(Uri uri) {

    }

    @Override
    public void onFragmentInteraction9(Uri uri) {

    }

    @Override
    public void onFragmentInteraction6(Uri uri) {

    }

    @Override
    public void onFragmentInteractionBirth(Uri uri) {

    }

    @Override
    public void onFragmentInteraction10(Uri uri) {

    }

    @Override
    public void onFragmentInteraction15(Uri uri) {

    }
}
