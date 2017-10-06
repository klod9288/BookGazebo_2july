package bangtanrut.songklod.bookgazebo.fragment;

import android.app.DatePickerDialog;
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
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bangtanrut.songklod.bookgazebo.MyConstant;
import bangtanrut.songklod.bookgazebo.PostProcess3;
import bangtanrut.songklod.bookgazebo.R;

/**
 * Created by Administrator on 2/7/2560.
 */

public class Process3Fragment extends Fragment {

    //Explicit
    private String dateString = "", tumBunString = "", salaString = "", nameBodyString = "",
            nameContactString = "", phoneString = "", timePhathed = "",
            timeSungkatand = "", amountSungkatand = "",
            timeSundmonn = "", amoundSundmonn = "",
            timePackageBody = "",
            amountKondin = "", amountFlower = "",
            amoundBucha = "", amoundThaitan = "",
            amoundWaterDrink = "", amountIce = "", amoundFood = "", amoundBow = "";
    private boolean aBoolean = true;


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

        //Phathed Controller
        phathedController();

        //Sankathan Controller
        sankathanController();


        //Sundmon Controller
        sundmonController();


        //PackBody Controller
        packBodyController();

        //Kondin Controller
        kondinController();

        //Flower Controller
        flowerController();

        //Bucha Controller
        buchaController();

        //ThaiTan Controller
        thaiTanController();

        //WaterDrink Controller
        waterDrink();

        //Ice Controller
        iceController();

        //Food Controller
        foodController();

        //Bow Controller
        bowController();


        // Sent Data
        sentData();

    }   // onActivityCreate

    private void flowerController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFlowerP3);
        final TextView textView = getView().findViewById(R.id.txtFlowerP3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 10, amountFlower);
                } else {
                    textView.setText("0.00");
                    amountFlower = "0";
                }

            }
        });
    }

    private void easyCheck(final TextView textView, final int intPrice, final String strSave) {
        CharSequence[] charSequences = new CharSequence[]{"1", "2", "3", "4", "5"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("Choose Amount");
        builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int intAnswer = intPrice * (which + 1);
                textView.setText(Integer.toString(intAnswer) + ".00");
                assigeString(strSave, Integer.toString(which + 1));
                calculatePrice();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void calculatePrice() {

        TextView kondinTextView = getView().findViewById(R.id.txtKondin);
        TextView flowdrTextView = getView().findViewById(R.id.txtFlowerP3);
        TextView buchaTextView = getView().findViewById(R.id.txtBucha);
        TextView thaitanTextView = getView().findViewById(R.id.txtThaitan);
        TextView waterTextView = getView().findViewById(R.id.txtWaterDrinkP3);
        TextView iceTextView = getView().findViewById(R.id.txtIceP3);
        TextView foodTextView = getView().findViewById(R.id.txtFoodP3);
        TextView totalTextView = getView().findViewById(R.id.txtTotel);

        int intTotal = findInt(kondinTextView.getText().toString()) +
                findInt(flowdrTextView.getText().toString()) +
                findInt(buchaTextView.getText().toString()) +
                findInt(thaitanTextView.getText().toString()) +
                findInt(waterTextView.getText().toString()) +
                findInt(iceTextView.getText().toString()) +
                findInt(foodTextView.getText().toString());
        totalTextView.setText(Integer.toString(intTotal) + ".00");


    }

    private int findInt(String strText) {

        String[] strings = strText.split("\\.");

        return Integer.parseInt(strings[0]);
    }

    private void assigeString(String strSave, String s) {
        strSave = s;
    }

    private void bowController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBow);
        final TextView textView = getView().findViewById(R.id.txtBow);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    textView.setText("300.00");
                    amoundBow = "1";
                } else {
                    textView.setText("0.00");
                    amoundBow = "0";
                }

            }
        });
    }

    private void foodController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbFoodP3);
        final TextView textView = getView().findViewById(R.id.txtFoodP3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 50, amoundFood);
                } else {
                    textView.setText("0.00");
                    amoundFood = "0";
                }

            }
        });
    }

    private void iceController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbIceP3);
        final TextView textView = getView().findViewById(R.id.txtIceP3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 70, amountIce);
                } else {
                    textView.setText("0.00");
                    amountIce = "0";
                }

            }
        });
    }

    private void waterDrink() {
        final CheckBox checkBox = getView().findViewById(R.id.chbWaterDrinkP3);
        final TextView textView = getView().findViewById(R.id.txtWaterDrinkP3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 140, amoundWaterDrink);
                } else {
                    textView.setText("0.00");
                    amoundWaterDrink = "0";
                }

            }
        });
    }

    private void thaiTanController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbThaitan);
        final TextView textView = getView().findViewById(R.id.txtThaitan);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 300, amoundThaitan);
                } else {
                    textView.setText("0.00");
                    amoundThaitan = "0";
                }

            }
        });
    }

    private void buchaController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbBucha);
        final TextView textView = getView().findViewById(R.id.txtBucha);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 30, amoundBucha);
                } else {
                    textView.setText("0.00");
                    amoundBucha = "0";
                }

            }
        });
    }

    private void kondinController() {
        final CheckBox checkBox = getView().findViewById(R.id.chbKondin);
        final TextView textView = getView().findViewById(R.id.txtKondin);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    easyCheck(textView, 3, amountKondin);
                } else {
                    textView.setText("0.00");
                    amountKondin = "0";
                }

            }
        });
    }

    private void packBodyController() {
        Spinner spinner = getView().findViewById(R.id.spnPackbody);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getBwchnafiStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timePackageBody = strings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                timePackageBody = strings[0];
            }
        });
    }

    private void sundmonController() {
        Spinner spinner = getView().findViewById(R.id.spnSungmon);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getBwchnafiStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeSundmonn = strings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                timeSundmonn = strings[0];
            }
        });
    }

    private void sankathanController() {
        Spinner spinner = getView().findViewById(R.id.spnSangkathan);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getBwchnafiStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeSungkatand = strings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                timeSungkatand = strings[0];
            }
        });
    }

    private void phathedController() {
        Spinner spinner = getView().findViewById(R.id.spnPhathed);
        MyConstant myConstant = new MyConstant();
        final String[] strings = myConstant.getBwchnafiStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timePhathed = strings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                timePhathed = strings[0];
            }
        });
    }

    private void sentData() {
        Button button = getView().findViewById(R.id.btnSetnDataProcess3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameBodyEditText = getView().findViewById(R.id.edtNameBody);
                nameBodyString = nameBodyEditText.getText().toString().trim();

                EditText nameContactEditText = getView().findViewById(R.id.edtNameContact);
                nameContactString = nameContactEditText.getText().toString().trim();

                EditText phoneEditText = getView().findViewById(R.id.edtPhone);
                phoneString = phoneEditText.getText().toString().trim();

                EditText sangkatanEditText = getView().findViewById(R.id.edtSangkathan);
                amountSungkatand = sangkatanEditText.getText().toString().trim();

                EditText songmonEditText = getView().findViewById(R.id.edtSungmon);
                amoundSundmonn = songmonEditText.getText().toString().trim();

                if (aBoolean) {
                    uploadToServer();
                } else {
                    Toast.makeText(getActivity(), "อัพโหลดไปแล้ว", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void uploadToServer() {

        try {
            String tag = "7octV1";
            MyConstant myConstant = new MyConstant();
            PostProcess3 postProcess3 = new PostProcess3(getActivity());
            postProcess3.execute(dateString, tumBunString, salaString, nameBodyString,
                    nameContactString, phoneString, timePhathed, timeSungkatand,
                    amountSungkatand, timeSundmonn, amoundSundmonn, timePackageBody,
                    amountKondin, amountFlower, amoundBucha, amoundThaitan, amoundWaterDrink,
                    amountIce, amoundFood, amoundBow, myConstant.getUrlPostProcess3());
            String result = postProcess3.get();
            Log.d(tag, "result ==> " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }


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
