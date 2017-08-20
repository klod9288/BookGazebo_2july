package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyAlert;
import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */

public class Process2Fragment extends Fragment {
    //View
    private CheckBox cremationCheckBox, intermentCheckBox;
    private EditText nameEditText;
    private Spinner pavilionSpinner;
    private TextView showdateTextView, showTimeTextView;
    private ImageView setDateTimeImageView;

    //Other
    private MyConstant myConstant;
    private MyAlert myAlert;
    private String cremationString,intermentString, pavilionString,dateString,timeString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.process2_layout, container, false);
        return view;
    }//onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Setup Constance
        setupConstance();

        //Initial view
        initialView();

        //Create pavilion
        createPavilion();

        //SetDateTime Controller
        setDateTimeController();

    }

    private void setDateTimeController() {
        setDateTimeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar = Calendar.getInstance();
                int dayAint = calendar.get(Calendar.DAY_OF_MONTH);
                int monthAint = calendar.get(Calendar.MONTH);
                int yearAint = calendar.get(Calendar.YEAR);
                final int hourAint = calendar.get(Calendar.HOUR_OF_DAY);
                final int minusAint = calendar.get(Calendar.MINUTE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int intYear, int intMonth, int intDay) {
                        dateString = Integer.toString(intDay) + "/" +
                                Integer.toString(intMonth + 1) + "/" +
                                Integer.toString(intYear);

                        showdateTextView.setText(dateString);
                        setTime(hourAint, minusAint,calendar);

                    }
                },yearAint,monthAint,dayAint);
                datePickerDialog.show();
            }//onClick
        });
    }

    private void  setTime(int hourAint, int minusAint, final Calendar calendar) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int intHour, int iMinus) {

                calendar.set(calendar.HOUR_OF_DAY, intHour);
                calendar.set(calendar.MINUTE, iMinus);

                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                timeString = dateFormat.format(calendar.getTime());
                showTimeTextView.setText(timeString);
            }
        },hourAint,minusAint,false);
        timePickerDialog.show();

    }

    private void createPavilion() {
        final String[] strings = myConstant.getPavilionStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strings
        );
        pavilionSpinner.setAdapter(stringArrayAdapter);
        pavilionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pavilionString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pavilionString = strings[0];
            }
        });
    }

    private void setupConstance() {
        myConstant = new MyConstant();
        myAlert = new MyAlert(getActivity());
    }

    private void initialView() {
        cremationCheckBox = getActivity().findViewById(R.id.chbCremation);
        intermentCheckBox = getActivity().findViewById(R.id.chbinterment);
        nameEditText = getView().findViewById(R.id.edtName);
        pavilionSpinner = getView().findViewById(R.id.spnPavilion);
        showdateTextView = getView().findViewById(R.id.txtShowDate);
        showTimeTextView = getView().findViewById(R.id.txtShowTime);
        setDateTimeImageView = getView().findViewById(R.id.imvSetDateTime);
    }
}//Main Class
