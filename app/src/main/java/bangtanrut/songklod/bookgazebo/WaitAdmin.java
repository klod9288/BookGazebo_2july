package bangtanrut.songklod.bookgazebo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import bangtanrut.songklod.bookgazebo.adapter.ProcessPagerAdapter;

public class WaitAdmin extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_admin);

        //Create Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbarListProcess);
        setSupportActionBar(toolbar);

        //Create TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabListProcess);
        tabLayout.addTab(tabLayout.newTab().setText("Process1"));
        tabLayout.addTab(tabLayout.newTab().setText("Process2"));
        tabLayout.addTab(tabLayout.newTab().setText("Process3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Create ViewPager
        viewPager = (ViewPager) findViewById(R.id.pagerListProcess);
        ProcessPagerAdapter processPagerAdapter = new ProcessPagerAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount()
        );
        viewPager.setAdapter(processPagerAdapter);
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
}
