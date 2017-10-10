package bangtanrut.songklod.bookgazebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bangtanrut.songklod.bookgazebo.DetailActivity;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by masterung on 11/10/2017 AD.
 */

public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Create Toolbar
        createToolbar();

        //Create ListView
        createListView();

    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarDetail);
        ((DetailActivity)getActivity()).setSupportActionBar(toolbar);
        ((DetailActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((DetailActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((DetailActivity)getActivity()).getSupportActionBar().setTitle("Detail");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.livDetail);
        String[] strings = getActivity().getIntent().getStringArrayExtra("DataSent");
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(stringArrayAdapter);
    }
}
