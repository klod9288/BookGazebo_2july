package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */

public class Process3Fragment extends Fragment {

    //Explicit
    private String dateString, tumBunString, salaString, nameBodyString = "",
            nameContactString = "", phoneString = "", timePhathed,
            timeSungkatand, amountSungkatand,
            timeSundmonn, amoundSundmonn, timePackageBody, amountKondin, amountFlower,
            amoundBucha, amoundThaitan, amoundWaterDrink, amoundFood, amoundBow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.process3_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //SetDate Controller
        setDateController();

        //Tumbun Controller
        tumbunController();

        //Sala Controller
        salaController();

    }

    private void salaController() {
        Spinner spinner = getView().findViewById(R.id.spnSala);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getPavilionStrings();
        salaString = strings[0];

        salaString = strings[0];
        ArrayAdapter<String> stringArrayList = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                salaString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                salaString = strings[0];
            }
        });

    }

    private void tumbunController() {
        tumBunString = "";
        RadioGroup radioGroup = getView().findViewById(R.id.ragTumBun);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radBuild1:
                        tumBunString = getResources().getString(R.string.church);
                        break;
                    case R.id.radBuild2:
                        tumBunString = getResources().getString(R.string.Temple);
                        break;
                    case R.id.radBuild3:
                        tumBunString = getResources().getString(R.string.museum);
                        break;
                }
            }
        });
    }

    private void setDateController() {
        final Calendar calendar = Calendar.getInstance();
        final int intDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int intMonth = calendar.get(Calendar.MONTH);
        final int intYear = calendar.get(Calendar.YEAR);

        showDateTime(calendar);

        ImageView imageView = getView().findViewById(R.id.imvSetDateTime);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        calendar.set(Calendar.DAY_OF_MONTH, day);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.YEAR, year);

                        showDateTime(calendar);


                    }
                }, intYear, intMonth, intDay);
                datePickerDialog.show();
            }
        });


    }

    private void showDateTime(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");

        TextView dateTextView = getView().findViewById(R.id.txtShowDate);
        dateString = dateFormat.format(calendar.getTime());
        dateTextView.setText(dateString);


        TextView timeTextView = getView().findViewById(R.id.txtShowTime);
        timeTextView.setText(timeFormat.format(calendar.getTime()));

    }
}//Main Class
