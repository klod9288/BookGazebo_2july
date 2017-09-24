package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyAlert;
import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.PostProcess1;
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
            carReceiveBodyString = "0", packageBodyString = "", cinamalString="0",thaiTumString="0",
    waterSDrinkString="0",ice1String="0",ice2String="0";
    private TextView dateTextView, timeTextView;
    private int dayAnInt, monthAnInt, yearAnInt, hourAnInt, minusAnInt;
    private TextView pricePavilienTextView, placeReceiveBodyTextView, carReceiveBodyTextView,
            packageBodyTextView, flowerTextView, cinamalTextView, thaiTumTextView, waterDrinkTextView, ice1TextView, ice2TextView;
    private EditText flowerEditText;
    private boolean flowerABoolean = false,statusABoolean=true;
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

        //Create Sent Controller
        createSentController();

        //PlaceReceiveBody CheckBox
        placeReceiveBody();

        //PackageBody
        packageBody();

        //Flower Controller
        flowerController();

        //Cinamal ConTroller
        cinamalConTroller();


        //ThaiTum Controller
        thaiTum();

        //WaterDrink Controller
        waterDrinkController();

        //Ice1 Controller
        ice1Controller();

        //Ice2 Controller
        ice2Controller();

    }//on Activity Create

    private void ice2Controller() {
        final CheckBox checkBox = getView().findViewById(R.id.chbIce2);
        ice2TextView = getView().findViewById(R.id.txtIce2);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    singleChooseItem(4);
                } else {
                    ice2String = "0";
                    ice2TextView.setText("0");
                }
                calculatePrice(ice2TextView.getText().toString());
            }
        });
    }


    private void ice1Controller() {
        final CheckBox checkBox = getView().findViewById(R.id.chbIce1);
        ice1TextView = getView().findViewById(R.id.txtIce1);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    singleChooseItem(3);
                } else {
                    ice1String = "0";
                    ice1TextView.setText("0");
                }
                calculatePrice(ice1TextView.getText().toString());
            }
        });
    }

    private void waterDrinkController() {
        final CheckBox checkBox = (CheckBox) getView().findViewById(R.id.chbWaterDrink);
        waterDrinkTextView = (TextView) getView().findViewById(R.id.txtWaterDrink);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    waterSDrinkString = "1";
                    singleChooseItem(2);
                } else {
                    waterSDrinkString = "0";
                    waterDrinkTextView.setText("0");
                }
                calculatePrice(waterDrinkTextView.getText().toString());
            }//OnClick
        });
    }

    private void thaiTum() {
        final CheckBox checkBox = (CheckBox) getView().findViewById(R.id.chbThaiTum);
        thaiTumTextView = (TextView) getView().findViewById(R.id.txtThaiTum);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    thaiTumString = "1";
                    singleChooseItem(1);
                } else {
                    thaiTumString = "0";
                    thaiTumTextView.setText("0");
                }
                calculatePrice(thaiTumTextView.getText().toString());
            }
        });
    }

    private void cinamalConTroller() {
        final String tag = "27AugV1";
        final CheckBox checkBox = (CheckBox) getView().findViewById(R.id.chbCinamol);
        cinamalTextView = (TextView) getView().findViewById(R.id.txtCinamol);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    cinamalString = "1";
                    singleChooseItem(0);//0==>น้ำอบ
                } else {
                    cinamalString = "0";
                    cinamalTextView.setText("0");
                }
                calculatePrice(cinamalTextView.getText().toString());
            }//On Click
        });
    }//Method Cinamal

    private void singleChooseItem(final int index) {


        CharSequence[] charSequences = null;
        switch (index) {
            case 0://==>น้ำอบ
                charSequences = new CharSequence[]{"1 ขวด","2 ขวด","3 ขวด","4 ขวด","5 ขวด",};
                break;
            case 1://==>ไทยธรรม
                charSequences = new CharSequence[]{"1 ชุด","2 ชุด","3 ชุด","4 ชุด","5 ชุด",};
                break;
            case 2://==>น้ำถ้วย
                charSequences = new CharSequence[]{"1 ลัง","2 ลัง","3 ลัง","4 ลัง","5 ลัง",};
                break;
            case 3://==>น้ำแข็ง
                charSequences = new CharSequence[]{"1 ถุง","2 ถุง","3 ถุง","4 ถุง","5 ถุง",};
                break;
            case 4://==>น้ำแข็งบด
                charSequences = new CharSequence[]{"1 ถุง","2 ถุง","3 ถุง","4 ถุง","5 ถุง",};
                break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);
        builder.setTitle(getResources().getString(R.string.title_alert));
        builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (index) {
                    case 0:
                        cinamalString=Integer.toString((i + 1));
                        double v = Double.parseDouble(Integer.toString((i + 1) * 30));
                        cinamalTextView.setText(Double.toString(v)+ "0");
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        thaiTumString=Integer.toString((i + 1));
                        double v1 = Double.parseDouble(Integer.toString((i+1)*300));
                        thaiTumTextView.setText(Double.toString(v1) + "0");
                        dialogInterface.dismiss();
                        break;
                    case 2:
                        waterSDrinkString=Integer.toString((i + 1));
                        double v2 = Double.parseDouble(Integer.toString((i+1)*150));
                        waterDrinkTextView.setText(Double.toString(v2) + "0");
                        dialogInterface.dismiss();
                        break;
                    case 3:
                        ice1String = Integer.toString((i + 1));
                        double v3 = Double.parseDouble(Integer.toString((i+1)*70));
                        ice1TextView.setText(Double.toString(v3) + "0");
                        dialogInterface.dismiss();
                        break;
                    case 4:
                        ice2String=Integer.toString((i + 1));
                        double v4 = Double.parseDouble(Integer.toString((i+1)*70));
                        ice2TextView.setText(Double.toString(v4) + "0");
                        dialogInterface.dismiss();
                        break;
                }

            }
        });

        builder.show();

    }

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

        calculatePrice(flowerTextView.getText().toString());

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
                    flowerTextView.setText(strFlower+".00");
                    calculatePrice(flowerTextView.getText().toString());
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
            packageBodyTextView.setText("8500.00");
            packageBodyString = "0";
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {

                    case R.id.radPackage0:
                        packageBodyTextView.setText("8500.00");
                        packageBodyString = "0";
                        break;
                    case R.id.radPackage1:
                        packageBodyTextView.setText("8000.00");
                        packageBodyString = "1";
                        break;
                    case R.id.radPackage2:
                        packageBodyTextView.setText("7000.00");
                        packageBodyString = "2";
                        break;
                    case R.id.radPackage3:
                        packageBodyTextView.setText("6000.00");
                        packageBodyString = "3";
                        break;

                }   // switch

                calculatePrice(packageBodyTextView.getText().toString());

            }   // onCheck
        });

        calculatePrice(packageBodyTextView.getText().toString());

    }   // choosePackage



    private void placeReceiveBody() {
        final CheckBox placeReceiveBodyCheckBox = (CheckBox) getView().findViewById(R.id.chbPlaceReceiveBody);
        placeReceiveBodyTextView = (TextView) getView().findViewById(R.id.txtPlaceReceiveBody);
        placeReceiveBodyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeReceiveBodyCheckBox.isChecked()) {
                    placeReceiveBodyString = "1";
                    placeReceiveBodyTextView.setText("1200.00");
                } else {
                    placeReceiveBodyString = "0";
                    placeReceiveBodyTextView.setText("0");
                }
                calculatePrice(placeReceiveBodyTextView.getText().toString());

            }   // View
        });
    }   // placeRecive

    private void choosePricePavilien(String strPricePavilien) {

        pricePavilienTextView = (TextView) getView().findViewById(R.id.txtPricePavilien);
        pricePavilienTextView.setText(strPricePavilien);
        calculatePrice(pricePavilienTextView.getText().toString());

    }//ChoosePricePavilien

    private void calculatePrice(String strTextView) {

        String tag = "27AugV1";
        Log.d(tag, "strTextView ที่รับมา ==>" + strTextView);
        TextView textView = (TextView) getView().findViewById(R.id.txtTotalPrice);
        String strResult = null;
        double priceADouble = 0;

        try {
            priceADouble = priceADouble +
                    Double.parseDouble(checkText(pricePavilienTextView.getText().toString()))+
                    Double.parseDouble(placeReceiveBodyTextView.getText().toString())+
                    Double.parseDouble(carReceiveBodyTextView.getText().toString())+
                    Double.parseDouble(packageBodyTextView.getText().toString())+
                    Double.parseDouble(flowerTextView.getText().toString())+
                    Double.parseDouble(cinamalTextView.getText().toString())+
                    Double.parseDouble(thaiTumTextView.getText().toString())+
                    Double.parseDouble(waterDrinkTextView.getText().toString())+
                    Double.parseDouble(ice1TextView.getText().toString())+
                    Double.parseDouble(ice2TextView.getText().toString());



            textView.setText(Double.toString(priceADouble));

        } catch (Exception e) {
            Log.d(tag, "e calculate ==>" + e.toString());
        }
    }   // calculatePrice

    private String checkText(String s) {

        String strResult = s;
        if (strResult.equals("0")) {
            strResult = "0.0";
        }

        return strResult;
    }

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
        Log.d(tag, "ค่าสถานที่รับศพ ==> " + placeReceiveBodyString);
        Log.d(tag, "รถรับศพ ==> " + carReceiveBodyString);
        Log.d(tag, "หีบศพที่เลือก ==>" + packageBodyString);
        Log.d(tag, "ดอกไม้ที่เลือก ==>" + flowerTextView.getText().toString());
        Log.d(tag, "น้ำอบไทย ==>" + cinamalString);
        Log.d(tag, "ไทยธรรม ==>" + thaiTumString);
        Log.d(tag, "น้ำดื่ม ==>" + waterSDrinkString);
        Log.d(tag, "น้ำแข็ง ==>" + ice1String);
        Log.d(tag, "น้ำแข็งบด ==>" + ice2String);

        //ส่่วนที่ต้องทำหลังจาก String ทุกตัว OK
       preUpdateToServer();

    }   // showLog

    private void preUpdateToServer() {
        if (statusABoolean) {
            //Can Upload Value to server
            uploadValueToServer();
        } else {
            //Cannot Uplpad
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog(getString(R.string.titi_upload),getString(R.string.message_upload));

        }
    }

    private void uploadValueToServer() {

        String tag = "20AugV1";

        try {
            MyConstant myConstant = new MyConstant();
            PostProcess1 postProcess1 = new PostProcess1(getActivity());
            postProcess1.execute(

                    nameString,
                    pavilionString,
                    dateString,
                    timeString,
                    timeWorkString,
                    bodyWhereString,
                    deadCardString,
                    timeWashBodyString,
                    buenBodyString,
                    moveBodyString,
                    placeReceiveBodyString,
                    carReceiveBodyString,
                    packageBodyString,
                    flowerTextView.getText().toString(),
                    cinamalString,
                    thaiTumString,
                    waterSDrinkString,
                    ice1String,
                    ice2String,
                    myConstant.getUrlPostProcess1()
            );
            if (Boolean.parseBoolean(postProcess1.get())) {
                statusABoolean = false;
            } else {
                Toast.makeText(getActivity(),"Please Try Again False",
                        Toast.LENGTH_LONG).show();
            }
            Log.d(tag, "Result ==>" + postProcess1.get());
            Log.d(tag, "Status ==>" + statusABoolean);

        } catch (Exception e) {
            Log.d(tag, "e upload==>" + e.toString());
        }

    }

    private void checkBoxController() {

        //ใบมรณะ
        CheckBox deadCardCheckBox = (CheckBox) getView().findViewById(R.id.chbDeadCard);
        if (deadCardCheckBox.isChecked()) {
            deadCardString = "1";
        } else {
            deadCardString = "0";
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
        final TextView textView = getView().findViewById(R.id.txtItemCarReceiveBody);
        final TextView carTextView1 = getView().findViewById(R.id.txtCarReceiveBody);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rad0:
                        //เจ้าภาพนำศพมาเอง
                        carReceiveBodyString = "0";
                        textView.setText(getResources().getString(R.string.rad1));
                        carTextView1.setText("0");
                        break;
                    case R.id.rad1:
                        //วัดไปรับ
                        carReceiveBodyString = "1";
                        textView.setText(getResources().getString(R.string.detail5));
                        carTextView1.setText("1200.00");
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

        //Show Text
        final TextView textView = getView().findViewById(R.id.txtChooseSala);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pavilionString = pavilionStrings[i];
                textView.setText(pavilionString);
                if (i == 9) {
                    choosePricePavilien("3000.00");
                } else {
                    choosePricePavilien("2200.00");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pavilionString = pavilionStrings[0];
                textView.setText(pavilionString);
                choosePricePavilien("2200.00");
            }




        });

    }

    private void setupConstance() {
        myConstant = new MyConstant();
    }
}//Main Class