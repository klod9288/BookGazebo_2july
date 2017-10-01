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
    private CheckBox cremationCheckBox, intermentCheckBox, coffeeGroupCheckBox, bwchnafiCheckBox;
    private EditText nameEditText, bodyWhereEditText, amountBwchnafiEditText, amountChantPlant;
    private Spinner pavilionSpinner, timeBodyWhereSpinner, timeSongSpinner, timeBwchanafiSpinner;
    private TextView showdateTextView, showTimeTextView,
            burnBuildTextView, burnOldTextView, burnBananaTextView, salaPriceTextView,
            manageBurnBuildTextView, carBodyTextView;
    private ImageView setDateTimeImageView;

    //Other
    private MyConstant myConstant;
    private MyAlert myAlert;

    private String cremationString, intermentString, nameString, pavilionString,
            dateString, timeString, bodyWhereString, timeBodyWhereString,
            timeSongString, coffeeGroupString, amountBwchanfiString, bwchnafiString,
            timeBwchnafiString, timeMonkSongString, monkSongString,
            amountChantPlantString, chantPlantString, chutnatfaiString,
            burnBuildString, burnOldString, burnBananaString;


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

        //Cremation Controller
        cremationController();

        //Interment Controller
        intermentController();

        //Create pavilion
        createPavilion();

        //SetDateTime Controller
        setDateTimeController();

        //Set TimeBodyWhere
        setTimeBodyWhere();

        //Set TimeSong
        setTimeSong();

        //CoffeeGroup Controller
        coffeeGroupController();

        //TimeBwchnafi Controller
        timeBwchanafiController();

        //Bwchnafi CheckBox
        bwchnafiCheckBox();

        //MonkSong Time
        monkSongTime();

        //MoknSong CheckBox
        moknSongCheckBox();

        //ChantPlan CheckBox
        chantPlanCheckBox();

        //ChutNatFai CheckBox
        chutNatFaiCheckBox();

        //BurnBuild CheckBox
        burnBuildCheckBox();

        //BurnOld CheckBox
        burnOldCheckBox();

        //BurnBanana CheckBox
        burnBananaCheckBox();

        //SalaPrice Radio
        salaPriceRadio();


        //ManageBurnBuild CheckBox
        manageBurnBuildChekcBox();


        //CarBody CheckBox
        carBodyCheckBox();


        //Sent Data Controller
        sentDataController();


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
                if (checkBox.isChecked()) {
                    chantPlantString = "1";
                } else {
                    chantPlantString = "0";
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
                } else {
                    monkSongString = "0";
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
                if (bwchnafiCheckBox.isChecked()) {
                    bwchnafiString = "1";
                } else {
                    bwchnafiString = "0";
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
                } else {
                    coffeeGroupString = "0";
                }
            }
        });
    }

    private void sentDataController() {
        Button button = getView().findViewById(R.id.btnSentData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                nameString = nameEditText.getText().toString().trim();
                bodyWhereString = bodyWhereEditText.getText().toString().trim();
                amountBwchanfiString = amountBwchnafiEditText.getText().toString().trim();
                amountChantPlantString = amountChantPlant.getText().toString().trim();


            }
        });
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int intYear, int intMonth, int intDay) {
                        dateString = Integer.toString(intDay) + "/" +
                                Integer.toString(intMonth + 1) + "/" +
                                Integer.toString(intYear);

                        showdateTextView.setText(dateString);
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


    }
}//Main Class
