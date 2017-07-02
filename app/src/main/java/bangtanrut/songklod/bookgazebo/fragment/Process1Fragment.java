package bangtanrut.songklod.bookgazebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */

public class Process1Fragment extends Fragment{

    //Explicit
    private Spinner spinner;
    private MyConstant myConstant;
    private String[] pavilionStrings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.process1_layout, container, false);
        return view;
    }//on Create View

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Setup Constance
        setupConstance();

        //Create pavilion Spinner
        createPavilionSpinner();

    }//on Activity Create

    private void createPavilionSpinner() {
        pavilionStrings = myConstant.getPavilionStrings();
        Spinner spinner =  (Spinner) getView().findViewById(R.id.spnPavilion);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,pavilionStrings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void setupConstance() {
        myConstant = new MyConstant();
    }
}//Main Class
