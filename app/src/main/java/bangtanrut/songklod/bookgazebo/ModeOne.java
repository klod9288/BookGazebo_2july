package bangtanrut.songklod.bookgazebo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import bangtanrut.songklod.bookgazebo.adapter.MyPagerAdapter;

public class ModeOne extends AppCompatActivity {

    private String[] loginStrings;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_modeone_layout);

        //setup constant
        setupConstant();

        //Initial View
        initialView();

        //Create Controller
        createController();

    }//Main Method

    private void createController() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initialView() {
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.my_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.mode_one)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.mode_two)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.mode_three)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);//center constant

        viewPager = (ViewPager) findViewById(R.id.my_viewpager);

    }

    private void setupConstant() {
        loginStrings = getIntent().getStringArrayExtra("Login");
    }

}//Main Class
