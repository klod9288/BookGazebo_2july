package bangtanrut.songklod.bookgazebo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bangtanrut.songklod.bookgazebo.fragment.ListViewProcess1Fragment;
import bangtanrut.songklod.bookgazebo.fragment.ListViewProcess2Fragment;
import bangtanrut.songklod.bookgazebo.fragment.ListViwProcess3Fragment;

/**
 * Created by masterung on 9/10/2017 AD.
 */

public class ProcessPagerAdapter extends FragmentStatePagerAdapter{

    private FragmentManager fragmentManager;
    private int anInt;

    public ProcessPagerAdapter(FragmentManager fragmentManager, int anInt) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.anInt = anInt;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ListViewProcess1Fragment listViewProcess1Fragment = new ListViewProcess1Fragment();
                return listViewProcess1Fragment;
            case 1:
                ListViewProcess2Fragment listViewProcess2Fragment = new ListViewProcess2Fragment();
                return listViewProcess2Fragment;
            case 2:
                ListViwProcess3Fragment listViwProcess3Fragment = new ListViwProcess3Fragment();
                return listViwProcess3Fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return anInt;
    }
}
