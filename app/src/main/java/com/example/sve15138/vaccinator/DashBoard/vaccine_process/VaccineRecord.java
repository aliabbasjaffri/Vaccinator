package com.example.sve15138.vaccinator.DashBoard.vaccine_process;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sve15138.vaccinator.R;
import com.example.sve15138.vaccinator.DashBoard.vaccine_process.ProfileView.ProfileView;


/**
 * Created by SVE15138 on 11/24/2015.
 */
public class VaccineRecord extends AppCompatActivity
{

    private CustomViewPager mViewPager;
    private TabsPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    public TextView mTitle;
    private Toolbar toolbar;
    protected VaccineRecord instance;

    String childIDParam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_xml);

        instance = this;

        childIDParam = getIntent().getStringExtra("childID");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, ProfileView.newInstance( childIDParam ))
                .addToBackStack(ProfileView.class.getName())
                .commit();

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        mViewPager = (CustomViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), instance );
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setPagingEnabled(false);

        mViewPager.setOffscreenPageLimit(viewPagerAdapter.getCount() - 2);

        tabLayout = (TabLayout) findViewById(R.id.VaccineProcessActivityTabLayoutInclude);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                String title = "Visit 1";
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
    public void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    protected void onDestroy()
    {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onDestroy();
    }
}
