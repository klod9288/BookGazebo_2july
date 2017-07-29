package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */

public class Process1Fragment extends Fragment {

    //Explicit
    private Spinner spinner;
    private MyConstant myConstant;
    private String[] pavilionStrings;
    private String nameString, pavilionString, radioString = "0", dateString, timeString,
            timeWorkString, bodyWhereString, deadCardString = "0", timeWashBodyString,
            buenBodyString, moveBodyString;
    private TextView dateTextView, timeTextView;
    private int dayAnInt, monthAnInt, yearAnInt, hourAnInt, minusAnInt;


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

        //Create RadioGroup
        createRadioGroup();

        //Setup dateTime
        setupDateTime();

        //Create Date Time Picker
        creatDateTimePicker();

        //Create TimeWork Spinner
        createTimeWorkSpinner();

        //Wash bady Spinner
        washBadySpinner();


        //Create Sent Controller
        createSentController();


    }//on Activity Create

    private void washBadySpinner() {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spnWashBody);
        final String[] strings = myConstant.getTimeWashAndBurn();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        timeWashBodyString = strings[0];

        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeWashBodyString = strings[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                timeWashBodyString = strings[0];
            }
        });

    }

    private void createSentController() {
        Button button = (Button) getView().findViewById(R.id.btnSentData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From edit Text
                EditText nameEditText = (EditText) getView().findViewById(R.id.edtName);
                nameString = nameEditText.getText().toString().trim();

                EditText bodyWhereEditText = (EditText) getView().findViewById(R.id.edtBodyWhere);
                bodyWhereString = bodyWhereEditText.getText().toString().trim();


                //Get Value From Check Box
                CheckBox deadCardCheckBox = (CheckBox) getView().findViewById(R.id.chbDeadCard);
                if (deadCardCheckBox.isChecked()) {
                    deadCardString = "1";
                } else {
                    deadCardString = "0";
                }
            }//OnClick
        });
    }

    private void createTimeWorkSpinner() {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spnTimeWork);
        final String[] strings = myConstant.getTimeWork();
        timeWorkString = strings[0];

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeWorkString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeWorkString = strings[0];

            }
        });

    }

    private void creatDateTimePicker() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imvDateTime);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int intYear, int intMonth, int intDay) {
                showDate(intDay, intMonth, intYear);
                showTimeDialog();
            }
        }, yearAnInt, monthAnInt, dayAnInt);
        datePickerDialog.show();
    }

    private void showTimeDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int intHour, int intMinus) {
                showTime(intHour, intMinus);

            }
        }, hourAnInt, minusAnInt, false);
        timePickerDialog.show();
    }

    private void setupDateTime() {
        Calendar calendar = Calendar.getInstance();
        dayAnInt = calendar.get(Calendar.DAY_OF_MONTH);
        monthAnInt = calendar.get(Calendar.MONTH);
        yearAnInt = calendar.get(Calendar.YEAR);
        hourAnInt = calendar.get(Calendar.HOUR_OF_DAY);
        minusAnInt = calendar.get(Calendar.MINUTE);

        showDate(dayAnInt, monthAnInt, yearAnInt);

        showTime(hourAnInt, minusAnInt);

    }

    private void showTime(int hourAnInt, int minusAnInt) {
        timeTextView = (TextView) getView().findViewById(R.id.txtTime);
        timeString = Integer.toString(hourAnInt) + " : " + Integer.toString(minusAnInt);
        timeTextView.setText(timeString);
    }

    private void showDate(int dayAnInt, int monthAnInt, int yearAnInt) {
        dateTextView = (TextView) getView().findViewById(R.id.txtDate);
        dateString = Integer.toString(dayAnInt) + "/" + Integer.toString(monthAnInt + 1) + "/" + Integer.toString(yearAnInt);
        dateTextView.setText(dateString);
    }

    private void createRadioGroup() {
        RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.ragGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rad0:
                        //เจ้าภาพนำศพมาเอง
                        radioString = "0";
                        break;
                    case R.id.rad1:
                        //วัดไปรับ
                        radioString = "1";
                        break;
                }
            }
        });
    }

    private void createPavilionSpinner() {
        pavilionStrings = myConstant.getPavilionStrings();
        Spinner spinner = (Spinner) getView().findViewById(R.id.spnPavilion);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, pavilionStrings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pavilionString = pavilionStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pavilionString = pavilionStrings[0];
            }
        });

    }

    private void setupConstance() {
        myConstant = new MyConstant();
    }
}//Main Class
