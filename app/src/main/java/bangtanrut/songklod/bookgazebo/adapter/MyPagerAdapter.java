package bangtanrut.songklod.bookgazebo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bangtanrut.songklod.bookgazebo.fragment.Process1Fragment;
import bangtanrut.songklod.bookgazebo.fragment.Process2Fragment;
import bangtanrut.songklod.bookgazebo.fragment.Process3Fragment;

/**
 * Created by Administrator on 2/7/2560.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter{

    private FragmentManager fragmentManager;
    private int anInt;

    public MyPagerAdapter(FragmentManager fragmentManager, int anInt) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.anInt = anInt;
    }//Method

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Process1Fragment process1Fragment = new Process1Fragment();
                return process1Fragment;
            case 1:
                Process2Fragment process2Fragment = new Process2Fragment();
                return process2Fragment;
            case 2:
                Process3Fragment process3Fragment = new Process3Fragment();
                return process3Fragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return anInt;
    }
}//Main Class
