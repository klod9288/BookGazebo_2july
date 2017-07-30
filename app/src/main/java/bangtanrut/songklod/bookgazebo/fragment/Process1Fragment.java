package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyAlert;
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
            buenBodyString, moveBodyString, montLeadString = "0", placeReceiveBodyString = "0",
            carReceiveBodyString = "0", packageBodyString = "",flowerString="0";
    private TextView dateTextView, timeTextView;
    private int dayAnInt, monthAnInt, yearAnInt, hourAnInt, minusAnInt;
    private TextView pricePavilienTextView, placeReceiveBodyTextView, carReceiveBodyTextView,
            packageBodyTextView,flowerTextView;
    private EditText flowerEditText;
    private boolean flowerABoolean = false;
    private Button flowerButton;


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

        //Burn Body Spinner
        burnBodySpinner();

        //Choose Price Pavilien
        choosePricePavilien();


        //Create Sent Controller
        createSentController();

        //PlaceReceiveBody CheckBox
        placeReceiveBody();

        //CarReceiveBody
        carReceiveBody();

        //PackageBody
        packageBody();

        //Flower Controller
        flowerController();


    }//on Activity Create

    private void flowerController() {
        final CheckBox checkBox = (CheckBox) getView().findViewById(R.id.chbFlower);
        flowerEditText = (EditText) getView().findViewById(R.id.edtFlower);
        flowerButton = (Button) getView().findViewById(R.id.btnOK);
        flowerTextView = (TextView) getView().findViewById(R.id.txtFlower);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked()) {
                    flowerButton.setClickable(true);
                    flowerButtonController();
                } else {
                    flowerButton.setClickable(false);
                }

            }//OnClick
        });

        calculatePrice();

    }//Flower

    private void flowerButtonController() {
        flowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFlower = flowerEditText.getText().toString().trim();
                if (strFlower.equals("")) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                            getResources().getString(R.string.message_HaveSpace));
                } else {
                    flowerTextView.setText(strFlower);
                    calculatePrice();
                }
            }
        });
    }

    private void packageBody() {
        final CheckBox checkBox = (CheckBox) getView().findViewById(R.id.chbPackageBody);
        packageBodyTextView = (TextView) getView().findViewById(R.id.txtPackageBody);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked()) {
                    choosePackageBody(true);
                } else {
                    choosePackageBody(false);
                }

            }   // onClick
        });


    }   // packageBody

    private void choosePackageBody(boolean bolStatus) {

        RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.ragPackageBody);
        RadioButton radioButton0 = (RadioButton) getView().findViewById(R.id.radPackage0);
        RadioButton radioButton1 = (RadioButton) getView().findViewById(R.id.radPackage1);
        RadioButton radioButton2 = (RadioButton) getView().findViewById(R.id.radPackage2);
        RadioButton radioButton3 = (RadioButton) getView().findViewById(R.id.radPackage3);

        if (!bolStatus) {
            radioGroup.clearCheck();
            packageBodyTextView.setText("0");
            packageBodyString = "";
        } else {
            radioButton0.setChecked(true);
            packageBodyTextView.setText("8500");
            packageBodyString = "0";
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {

                    case R.id.radPackage0:
                        packageBodyTextView.setText("8500");
                        packageBodyString = "0";
                        break;
                    case R.id.radPackage1:
                        packageBodyTextView.setText("8000");
                        packageBodyString = "1";
                        break;
                    case R.id.radPackage2:
                        packageBodyTextView.setText("7000");
                        packageBodyString = "2";
                        break;
                    case R.id.radPackage3:
                        packageBodyTextView.setText("6000");
                        packageBodyString = "3";
                        break;

                }   // switch

                calculatePrice();

            }   // onCheck
        });

        calculatePrice();

    }   // choosePackage

    private void carReceiveBody() {
        final CheckBox carReceiveBodyCheckBox = (CheckBox) getView().findViewById(R.id.carReceiveBody);
        carReceiveBodyTextView = (TextView) getView().findViewById(R.id.txtCarReceiveBody);

        carReceiveBodyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (carReceiveBodyCheckBox.isChecked()) {
                    carReceiveBodyString = "1";
                    carReceiveBodyTextView.setText("1200");
                } else {
                    carReceiveBodyString = "0";
                    carReceiveBodyTextView.setText("0");
                }
                calculatePrice();
            }   // View
        });


    }   // carReceive

    private void placeReceiveBody() {
        final CheckBox placeReceiveBodyCheckBox = (CheckBox) getView().findViewById(R.id.chbPlaceReceiveBody);
        placeReceiveBodyTextView = (TextView) getView().findViewById(R.id.txtPlaceReceiveBody);
        placeReceiveBodyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeReceiveBodyCheckBox.isChecked()) {
                    placeReceiveBodyString = "1";
                    placeReceiveBodyTextView.setText("1200");
                } else {
                    placeReceiveBodyString = "0";
                    placeReceiveBodyTextView.setText("0");
                }
                calculatePrice();

            }   // View
        });
    }   // placeRecive

    private void choosePricePavilien() {
        RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.ragPavilien);
        pricePavilienTextView = (TextView) getView().findViewById(R.id.txtPricePavilien);
        final String[] strPrice = {null};
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {

                    case R.id.radPavilien:
                        strPrice[0] = "2200";
                        break;
                    case R.id.radPavilien10:
                        strPrice[0] = "3000";
                        break;
                }   // switch
                pricePavilienTextView.setText(strPrice[0]);
                calculatePrice();
            }   // onCheck
        });


    }

    private void calculatePrice() {

        TextView textView = (TextView) getView().findViewById(R.id.txtTotalPrice);

        int intTotalPrice = 0;

        intTotalPrice = intTotalPrice + Integer.parseInt(pricePavilienTextView.getText().toString());
        intTotalPrice = intTotalPrice + Integer.parseInt(placeReceiveBodyTextView.getText().toString());
        intTotalPrice = intTotalPrice + Integer.parseInt(carReceiveBodyTextView.getText().toString());
        intTotalPrice = intTotalPrice + Integer.parseInt(packageBodyTextView.getText().toString());
        intTotalPrice = intTotalPrice + Integer.parseInt(flowerTextView.getText().toString());

        textView.setText(Integer.toString(intTotalPrice));
    }   // calculatePrice

    private void burnBodySpinner() {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spnBurnbody);
        final TextView textView = (TextView) getView().findViewById(R.id.txtMoveBody);
        final String[] strings = myConstant.getTimeWashAndBurn();
        final String[] timeMoveStrings1 = myConstant.getTimeMoveBody();
        moveBodyString = timeMoveStrings1[0];
        textView.setText(moveBodyString);
        buenBodyString = strings[0];
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                buenBodyString = strings[i];
                moveBodyString = timeMoveStrings1[i];
                textView.setText(moveBodyString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                buenBodyString = strings[0];
                moveBodyString = timeMoveStrings1[0];
                textView.setText(moveBodyString);
            }


        });


    }

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
                checkBoxController();

                showLog();


            }//OnClick
        });
    }

    private void showLog() {

        String tag = "30JulyV1";
        Log.d(tag, "ชื่อ นามสกุลผู้ตาย ==> " + nameString);
        Log.d(tag, "ศาลา ==> " + pavilionString);
        Log.d(tag, "เจ้าภาพนำมาส่ง ==> " + radioString);
        Log.d(tag, "Data ==> " + dateString);
        Log.d(tag, "Time ==> " + timeString);
        Log.d(tag, "เวลาในการตั้งสวด ==> " + timeWorkString);
        Log.d(tag, "ศพมาจาก ==> " + bodyWhereString);
        Log.d(tag, "ใบมรณะ ==> " + deadCardString);
        Log.d(tag, "รดน้ำศพ ==> " + timeWashBodyString);
        Log.d(tag, "บรรจุศพ ==> " + "19:00");
        Log.d(tag, "เวลาเผา ==> " + buenBodyString);
        Log.d(tag, "เวลาเครื่อนย้าย ==> " + moveBodyString);
        Log.d(tag, "นิมนต์พระนำศพ ==> " + montLeadString);
        Log.d(tag, "ค่าสถานที่รับศพ ==> " + placeReceiveBodyString);
        Log.d(tag, "รถรับศพ ==> " + carReceiveBodyString);
        Log.d(tag, "หีบศพที่เลือก ==>"+packageBodyString);


    }   // showLog

    private void checkBoxController() {


        //ใบมรณะ
        CheckBox deadCardCheckBox = (CheckBox) getView().findViewById(R.id.chbDeadCard);
        if (deadCardCheckBox.isChecked()) {
            deadCardString = "1";
        } else {
            deadCardString = "0";
        }

        //นิมนต์พระนำศพ
        CheckBox montLeadCheckBox = (CheckBox) getView().findViewById(R.id.chbMontLead);
        if (montLeadCheckBox.isChecked()) {
            montLeadString = "1";
        } else {
            montLeadString = "0";
        }


    }//Check box

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
        pavilionString = pavilionStrings[0];
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