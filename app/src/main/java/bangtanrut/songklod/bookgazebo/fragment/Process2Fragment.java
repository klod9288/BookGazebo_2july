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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyAlert;
import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.PostProcess2;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */


public class Process2Fragment extends Fragment {
    //View
    private CheckBox cremationCheckBox, intermentCheckBox, coffeeGroupCheckBox, bwchnafiCheckBox;
    private EditText nameEditText, bodyWhereEditText, amountBwchnafiEditText, amountChantPlant;
    private Spinner pavilionSpinner, timeBodyWhereSpinner, timeSongSpinner, timeBwchanafiSpinner;
    private TextView showdateTextView, showTimeTextView, burnBuildTextView, burnOldTextView,
            burnBananaTextView, salaPriceTextView, manageBurnBuildTextView, carBodyTextView,
            flowerTextView, flower0TextView, flower1TextView, powerSoundTextView, powerBandTextView,
            waterDrinkTextView, iceTextView, foodTextView, candyTextView, bowTextView;
    private ImageView setDateTimeImageView;

    //Other
    private MyConstant myConstant;
    private MyAlert myAlert;

    private String cremationString, intermentString = "0", nameString = "", pavilionString = "",
            dateString = "", timeString = "", bodyWhereString = "", timeBodyWhereString = "",
            timeSongString = "", coffeeGroupString = "0", amountBwchanfiString = "0", bwchnafiString = "0",
            timeBwchnafiString = "", timeMonkSongString = "", monkSongString = "0",
            amountChantPlantString = "0", chantPlantString = "0", chutnatfaiString = "0",
            burnBuildString = "0", burnOldString = "0", burnBananaString = "0", bunSagungTimeString = "",
            sabondString = "0", rungString = "0", pintoString = "0",
            bunsagoonString = "0", amountBunsagonString = "0";


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

        //Cremation Controller  พระราชทานเพลงศพ
        cremationController();

        //Interment Controller  ปณกิจ
        intermentController();

        //Create pavilion   ศาลา
        createPavilion();

        //SetDateTime Controller
        setDateTimeController();

        //Set TimeBodyWhere เวลา เชิญศพจาก
        setTimeBodyWhere();

        //Set TimeSong  สวดอภิธรรท
        setTimeSong();

        //CoffeeGroup Controller    สบง-ชุดกาแฟ
        coffeeGroupController();

        //TimeBwchnafi Controller   เวลาบวชหน้าไฟ
        timeBwchanafiController();

        //Bwchnafi CheckBox
        bwchnafiCheckBox();

        //MonkSong Time
        monkSongTime(); // เวลาพระเทศน์

        //MoknSong CheckBox
        moknSongCheckBox(); //  พระเทศน์

        //ChantPlan CheckBox
        chantPlanCheckBox();    // ฉันเพล

        //Bunsagun Checkbox
        bunsagunCheckbox(); // บังสกุล

        //ChutNatFai CheckBox
        chutNatFaiCheckBox();

        //BurnBuild CheckBox
        burnBuildCheckBox();    //ค่าณาปนกิจ

        //BurnOld CheckBox
        burnOldCheckBox();  //ค่าน้ำมันเผา

        //BurnBanana CheckBox
        burnBananaCheckBox();   // ค่าหยวก

        //SalaPrice Radio
        salaPriceRadio();


        //ManageBurnBuild CheckBox
        manageBurnBuildChekcBox();  //ค่าจัดสถานที่เผ่า


        //CarBody CheckBox
        carBodyCheckBox();  // รถรับศพ


        //Flowerbody CheckBox
        flowerbodyCheckBox();   // จัดดอกไม้หน้าศพ


        //Flower Moon
        flowerMoon();   //ดอกไม่้จันทร์


        //Flower Moon President
        flowerMoonPresident();  //ช่อประธาน


        //PowerSound
        powerSound();   //เครื่องเสียง


        //Power Band
        powerBand();    // พินพาท

        //Water Drink
        waterDrink();   // น้ำดื่ม

        //Ice Controller
        iceController();    // น้ำแข็ง

        //Food Controller
        foodController();   // อาหารถวายพระ

        //Candy Controller
        candyController();  // อาหารว่าง

        //Bow Controller
        bowController();    // ยืมถ้วย


        //BungSagung Spinner
        bungSagungSpinner();


        //Sabung
        sabung();


        //Rung
        rung();


        //Pinto
        pinto();


        //Sent Data Controller
        sentDataController();


    }

    private void bunsagunCheckbox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBunSagoon);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = getView().findViewById(R.id.edtBunsagoon);
                amountBunsagonString = editText.getText().toString().trim();
                if (checkBox.isChecked()) {
                    bunsagoonString = "1";
                } else {
                    bunsagoonString = "0";
                }
                calcualteMoney();
            }
        });
    }

    private void pinto() {
        final CheckBox checkBox = getView().findViewById(R.id.chbPinto);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    pintoString = "1";
                } else {
                    pintoString = "0";
                }
                calcualteMoney();
            }
        });
    }

    private void rung() {
        final CheckBox checkBox = getView().findViewById(R.id.chbRung);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    rungString = "1";
                } else {
                    rungString = "0";
                }
                calcualteMoney();
            }
        });
    }

    private void sabung() {
        final CheckBox checkBox = getView().findViewById(R.id.chbSabon);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    sabondString = "1";
                } else {
                    sabondString = "0";
                }
                calcualteMoney();
            }
        });
    }

    private void bungSagungSpinner() {
        Spinner spinner = getView().findViewById(R.id.spnSabon);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getBungSagunStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bunSagungTimeString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bunSagungTimeString = strings[0];
            }
        });
    }

    private void bowController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBow);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    bowTextView.setText("300.00");
                } else {
                    bowTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void candyController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbCandy);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked()) {
                    EditText editText = getView().findViewById(R.id.edtCandy);
                    String amountString = editText.getText().toString().trim();
                    int amountAint = Integer.parseInt(amountString);
                    int answerAint = amountAint * 50;
                    candyTextView.setText(Integer.toString(answerAint) + ".00");
                } else {
                    candyTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void foodController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFood);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {

                    CharSequence[] charSequences = new CharSequence[]{
                            "อาหารถวายพระ 9-10 รูป แขกไม่เกิน 20 ท่าน",
                            "อาหารถวายพระ 9-10 รูป แขกไม่เกิน 50 ท่าน"};
                    chooseItem(foodTextView, 300, charSequences, false);
                    calcualteMoney();
                } else {
                    foodTextView.setText("0");
                    calcualteMoney();
                }

            }
        });
    }

    private void iceController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbIce);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    CharSequence[] charSequences = new CharSequence[]{"1", "2", "3", "4", "5"};
                    chooseItem(iceTextView, 70, charSequences, true);
                } else {
                    iceTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void waterDrink() {
        final CheckBox checkBox = getView().findViewById(R.id.chbWaterDring);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    CharSequence[] charSequences = new CharSequence[]{"1", "2", "3", "4", "5"};
                    chooseItem(waterDrinkTextView, 140, charSequences, true);
                } else {
                    waterDrinkTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void chooseItem(final TextView objTextView, final int intPrice, CharSequence[] charSequences, final boolean status) {


        final int[] amountInts = new int[]{0};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);
        builder.setTitle("Please Choose Item");
        builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (status) {
                    amountInts[0] = i + 1;
                    int intAnswer = amountInts[0] * intPrice;
                    objTextView.setText(Integer.toString(intAnswer) + ".00");
                } else {
                    switch (i) {
                        case 0:
                            objTextView.setText("9000.00");
                            break;
                        case 1:
                            objTextView.setText("13500.00");
                            break;
                    }
                }
                calcualteMoney();
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }

    private void powerBand() {
        final CheckBox checkBox = getView().findViewById(R.id.chbPowerSound2);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    powerBandTextView.setText("5000.00");
                } else {
                    powerBandTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void powerSound() {
        final CheckBox checkBox = getView().findViewById(R.id.chbPowerSound);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    powerSoundTextView.setText("300.00");
                } else {
                    powerSoundTextView.setText("0");
                }
                calcualteMoney();
            }
        });

    }

    private void flowerMoonPresident() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFlower1);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    flower1TextView.setText("30.00");
                } else {
                    flower1TextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void flowerMoon() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFlower0);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    flower0TextView.setText("400.00");
                } else {
                    flower0TextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void flowerbodyCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFlower);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = getView().findViewById(R.id.edtFlower);
                String strFlower = editText.getText().toString().trim();

                if (checkBox.isChecked()) {
                    flowerTextView.setText(strFlower);
                } else {
                    flowerTextView.setText("0");
                }
                calcualteMoney();
            }
        });

    }

    private void carBodyCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbCarBody);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    carBodyTextView.setText("1200.00");
                } else {
                    carBodyTextView.setText("0");
                }
                calcualteMoney();
            }
        });

    }

    private void manageBurnBuildChekcBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbManageBurnBuild);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    manageBurnBuildTextView.setText("1000.00");
                } else {
                    manageBurnBuildTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void salaPriceRadio() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragSalaPrice);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rad3000:
                        salaPriceTextView.setText("3000.00");
                        break;
                    case R.id.rad2200:
                        salaPriceTextView.setText("2200.00");
                        break;
                }
                calcualteMoney();
            }
        });
    }

    private void burnBananaCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBurnBanana);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    burnBananaString = "1";
                    burnBananaTextView.setText("700.00");
                } else {
                    burnBananaString = "0";
                    burnBananaTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void burnOldCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbButnOld);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    burnOldString = "1";
                    burnOldTextView.setText("3000.00");
                } else {
                    burnOldString = "0";
                    burnOldTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void burnBuildCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBurnBuild);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    burnBuildString = "1";
                    burnBuildTextView.setText("3300.00");
                } else {
                    burnBuildString = "0";
                    burnBuildTextView.setText("0");
                }
                calcualteMoney();
            }
        });
    }

    private void chutNatFaiCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbChuitnatFai);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    chutnatfaiString = "1";
                } else {
                    chutnatfaiString = "0";
                }
            }
        });
    }

    private void chantPlanCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbChantPlant);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountChantPlantString = amountChantPlant.getText().toString().trim();
                if (checkBox.isChecked()) {
                    chantPlantString = "1";
                    calcualteMoney();
                } else {
                    chantPlantString = "0";
                    calcualteMoney();
                }
            }
        });
    }

    private void moknSongCheckBox() {
        final CheckBox checkBox = getView().findViewById(R.id.chbMonkSong);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    monkSongString = "1";
                    calcualteMoney();
                } else {
                    monkSongString = "0";
                    calcualteMoney();
                }
            }
        });
    }

    private void monkSongTime() {
        Spinner spinner = getView().findViewById(R.id.spnMonkSong);
        final String[] strings = myConstant.getTimeBodyWhere();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeMonkSongString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeMonkSongString = strings[0];
            }
        });
    }

    private void bwchnafiCheckBox() {
        bwchnafiCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amountBwchanfiString = amountBwchnafiEditText.getText().toString().trim();

                if (bwchnafiCheckBox.isChecked()) {
                    bwchnafiString = "1";
                    calcualteMoney();
                } else {
                    bwchnafiString = "0";
                    calcualteMoney();
                }
            }
        });
    }

    private void timeBwchanafiController() {

        final String[] strings = myConstant.getBwchnafiStrings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);

        timeBwchanafiSpinner.setAdapter(stringArrayAdapter);

        timeBwchanafiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeBwchnafiString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeBwchnafiString = strings[0];
            }
        });
    }

    private void coffeeGroupController() {
        coffeeGroupCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coffeeGroupCheckBox.isChecked()) {
                    coffeeGroupString = "1";
                    calcualteMoney();
                } else {
                    coffeeGroupString = "0";
                    calcualteMoney();
                }
            }
        });
    }

    private void calcualteMoney() {

        int moneyAnInt = 0;     // จำนวนที่ต้องจ่าย
        String tag = "1OctV1";

        try {

            //Add สบง-ชุดกาแฟ
            int[] coffeeGroupInts = new int[]{0, 300};
            moneyAnInt = moneyAnInt + coffeeGroupInts[Integer.parseInt(coffeeGroupString)];

            //Add บวชหน้าไฟ
            Log.d(tag, "บวชหน้าไฟ ==> " + bwchnafiString);
            if (bwchnafiString.equals("1")) {
                Log.d(tag, "บวชหน้าไฟ True");
                Log.d(tag, "จำนวนผู้บวช ==> " + amountBwchanfiString);
                moneyAnInt = moneyAnInt + (600 * Integer.parseInt(amountBwchanfiString));
            } else {
                Log.d(tag, "บวชหน้าไฟ false");
            }

            //พระเทศน์นิมนต์
            if (monkSongString.equals("1")) {
                moneyAnInt = moneyAnInt + 600;
            }

            // สวดฉันเพล
            if (chantPlantString.equals("1")) {
                Log.d(tag, "ฉันเพล ==> " + amountChantPlantString);
                moneyAnInt = moneyAnInt + (300 * Integer.parseInt(amountChantPlantString));
            }


            //ซักผ้าบังสกุล
            if (bunsagoonString.equals("1")) {
                moneyAnInt = moneyAnInt + (800 * Integer.parseInt(amountBunsagonString));
            }


            //ค่าณาปนกิจ
            if (burnBuildString.equals("1")) {
                moneyAnInt = moneyAnInt + 3300;
            }


            //ค่าน้ำมันเผา
            if (burnOldString.equals("1")) {
                moneyAnInt = moneyAnInt + 3000;
            }


            //หยวก
            if (burnBananaString.equals("1")) {
                moneyAnInt = moneyAnInt + 700;
            }

            //ศาลาตั่ง
            moneyAnInt = moneyAnInt + myFindAmount(salaPriceTextView.getText().toString());


            //ค่าจัดสถานที่เผา
            moneyAnInt = moneyAnInt + myFindAmount(manageBurnBuildTextView.getText().toString());


            //รถรับศพ
            moneyAnInt = moneyAnInt + myFindAmount(carBodyTextView.getText().toString());


            //จัดดอกไม้หน้าศพ
            moneyAnInt = moneyAnInt + myFindAmount(flowerTextView.getText().toString());


            //ดอกไม่้จันทร์
            moneyAnInt = moneyAnInt + myFindAmount(flower0TextView.getText().toString());


            //ช่อประธาน
            moneyAnInt = moneyAnInt + myFindAmount(flower1TextView.getText().toString());


            //เครื่องเสียง
            moneyAnInt = moneyAnInt + myFindAmount(powerSoundTextView.getText().toString());

            //พินพาทย์
            moneyAnInt = moneyAnInt + myFindAmount(powerBandTextView.getText().toString());


            //น้ำดื่ม
            moneyAnInt = moneyAnInt + myFindAmount(waterDrinkTextView.getText().toString());


            //น้ำแข็ง
            moneyAnInt = moneyAnInt + myFindAmount(iceTextView.getText().toString());


            //อาหารถวายพระ
            moneyAnInt = moneyAnInt + myFindAmount(foodTextView.getText().toString());

            //อาหารว่าง
            moneyAnInt = moneyAnInt + myFindAmount(candyTextView.getText().toString());

            //ยืมถ้วย
            moneyAnInt = moneyAnInt + myFindAmount(bowTextView.getText().toString());

            //บังสกุลที่เมรุ
            if (sabondString.equals("1")) {
                moneyAnInt = moneyAnInt + 150;
            }


            //ลุ้งผ้าขาว
            if (rungString.equals("1")) {
                moneyAnInt = moneyAnInt + 300;
            }

            // ปิ่นโต
            if (pintoString.equals("1")) {
                moneyAnInt = moneyAnInt + 350;
            }

            //Show Text
            TextView textView = getView().findViewById(R.id.txtShowMoney);
            textView.setText(Integer.toString(moneyAnInt));

        } catch (Exception e) {
            Log.d(tag, "e Calculate ==> " + e.toString());
        }

    }

    private int myFindAmount(String strNumber) {

        if (strNumber.equals("0")) {
            return 0;
        } else {
            String[] strings = strNumber.split("\\.");
            return Integer.parseInt(strings[0]);
        }

    }

    private void sentDataController() {
        Button button = getView().findViewById(R.id.btnSentData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                nameString = nameEditText.getText().toString().trim();
                bodyWhereString = bodyWhereEditText.getText().toString().trim();


                uploadToServer();
            }
        });
    }

    private void uploadToServer() {

        String tag = "5octV1";
        Log.d(tag, cremationString);
        Log.d(tag, intermentString);
        Log.d(tag, nameString);
        Log.d(tag, pavilionString);
        Log.d(tag, dateString);
        Log.d(tag, timeString);
        Log.d(tag, bodyWhereString);
        Log.d(tag, timeBodyWhereString);
        Log.d(tag, timeSongString);
        Log.d(tag, amountBwchanfiString);
        Log.d(tag, bwchnafiString);
        Log.d(tag, timeBwchnafiString);
        Log.d(tag, timeMonkSongString);
        Log.d(tag, monkSongString);
        Log.d(tag, amountChantPlantString);
        Log.d(tag, chantPlantString);
        Log.d(tag, chutnatfaiString);
        Log.d(tag, burnBuildString);
        Log.d(tag, burnOldString);
        Log.d(tag, burnBananaString);
        Log.d(tag, bunSagungTimeString);
        Log.d(tag, sabondString);
        Log.d(tag, rungString);
        Log.d(tag, pintoString);
        Log.d(tag, bunsagoonString);
        Log.d(tag, amountBunsagonString);

        try {

            MyConstant myConstant = new MyConstant();
            PostProcess2 postProcess2 = new PostProcess2(getActivity());
            postProcess2.execute(cremationString, intermentString, nameString, pavilionString,
                    dateString, timeString, "setDatetime", bodyWhereString, timeBodyWhereString,
                    timeSongString, "coffeeGroup", amountBwchanfiString, timeBwchnafiString,
                    amountChantPlantString, burnBuildString, burnOldString, burnBananaString,
                    "salaPrice", "manageBurnBuild", "carBody", "flower", "flower0", "flower1",
                    "powerSound", "powerBand", "waterDrink", "ice", "food", "candy",
                    "bow", myConstant.getUrlPostProcess2());

            Log.d(tag, "Result ==> " + postProcess2.get());

        } catch (Exception e) {
            Log.d(tag, "e ==> " + e.toString());
        }


    }

    private void intermentController() {
        intermentCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intermentCheckBox.isChecked()) {
                    intermentString = "1";
                } else {
                    intermentString = "0";
                }
            }
        });
    }

    private void cremationController() {
        cremationCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cremationCheckBox.isChecked()) {
                    cremationString = "1";
                } else {
                    cremationString = "0";
                }
            }
        });
    }

    private void setTimeSong() {
        final String[] strings = myConstant.getTimeSong();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strings
        );
        timeSongSpinner.setAdapter(stringArrayAdapter);
        timeSongSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeSongString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeSongString = strings[0];
            }
        });
    }

    private void setTimeBodyWhere() {
        final String[] strings = myConstant.getTimeBodyWhere();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strings
        );
        timeBodyWhereSpinner.setAdapter(stringArrayAdapter);
        timeBodyWhereSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeBodyWhereString = strings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeBodyWhereString = strings[0];
            }
        });
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int intYear, int intMonth, int intDay) {
                                dateString = Integer.toString(intDay) + "/" +
                                        Integer.toString(intMonth + 1) + "/" +
                                        Integer.toString(intYear);

                                showdateTextView.setText(dateString);

                                TextView textView = getView().findViewById(R.id.txtDate2);
                                textView.setText(dateString);

                                setTime(hourAint, minusAint, calendar);

                            }
                        }, yearAint, monthAint, dayAint);
                datePickerDialog.show();
            }//onClick
        });
    }

    private void setTime(int hourAint, int minusAint, final Calendar calendar) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int intHour, int iMinus) {

                calendar.set(calendar.HOUR_OF_DAY, intHour);
                calendar.set(calendar.MINUTE, iMinus);

                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                timeString = dateFormat.format(calendar.getTime());
                showTimeTextView.setText(timeString);
            }
        }, hourAint, minusAint, false);
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
        cremationCheckBox = getView().findViewById(R.id.chbCremation);
        intermentCheckBox = getView().findViewById(R.id.chbinterment);
        nameEditText = getView().findViewById(R.id.edtName);
        pavilionSpinner = getView().findViewById(R.id.spnPavilion);
        showdateTextView = getView().findViewById(R.id.txtShowDate);
        showTimeTextView = getView().findViewById(R.id.txtShowTime);
        setDateTimeImageView = getView().findViewById(R.id.imvSetDateTime);
        bodyWhereEditText = getView().findViewById(R.id.edtBodyWhere);
        timeBodyWhereSpinner = getView().findViewById(R.id.spnTimeBodyWhere);
        timeSongSpinner = getView().findViewById(R.id.spnTimeSong);
        coffeeGroupCheckBox = getView().findViewById(R.id.chbCoffeeGroup);
        amountBwchnafiEditText = getView().findViewById(R.id.edtBwchnafi);
        timeBwchanafiSpinner = getView().findViewById(R.id.spnBwchnafi);
        bwchnafiCheckBox = getView().findViewById(R.id.chbBwchnafi);
        amountChantPlant = getView().findViewById(R.id.edtChantPlant);
        burnBuildTextView = getView().findViewById(R.id.txtBurnBuild);
        burnOldTextView = getView().findViewById(R.id.txtBurnOld);
        burnBananaTextView = getView().findViewById(R.id.txtBurnBanana);
        salaPriceTextView = getView().findViewById(R.id.txtSalaPrice);
        manageBurnBuildTextView = getView().findViewById(R.id.txtManageBurnBuild);
        carBodyTextView = getView().findViewById(R.id.txtCarBody);
        flowerTextView = getView().findViewById(R.id.txtFlower);
        flower0TextView = getView().findViewById(R.id.txtFlower0);
        flower1TextView = getView().findViewById(R.id.txtFlower1);
        powerSoundTextView = getView().findViewById(R.id.txtSound0);
        powerBandTextView = getView().findViewById(R.id.txtSound1);
        waterDrinkTextView = getView().findViewById(R.id.txtWaterDrink0);
        iceTextView = getView().findViewById(R.id.txtIce0);
        foodTextView = getView().findViewById(R.id.txtFood0);
        candyTextView = getView().findViewById(R.id.txtCandy0);
        bowTextView = getView().findViewById(R.id.txtBow);


    }
}//Main Class
