package bangtanrut.songklod.bookgazebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by masterung on 9/10/2017 AD.
 */

public class ListViewProcess1Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview_process1, container, false);
        return view;
    }
}
