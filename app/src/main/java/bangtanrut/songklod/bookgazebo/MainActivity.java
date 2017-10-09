package bangtanrut.songklod.bookgazebo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;
    private boolean urlAdminABoolean = true; // ปกติ ไม่ได้เช็ค Admin จะใช้ userTABLE แต่ถ้า เช็ค Admin จะใช้ userAdminTABLE


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Inflace XML activity_main

        //Initial View
        initialView();

        //Controller
        controller();

        //ForAdmin Controller
        forAdminController();

    }   // Main Method

    private void forAdminController() {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.chbAdmin);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {

                } else {
                }
            }
        });
    }

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }


    //ผูกความสัมพันธ์ รัหว่างตัวแปรและวิวที่อยู่บน activity
    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtRegister);
        button = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View view) {

        //For TextView
        if (view == textView) {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        }

        //for button
        if (view == button) {

          //Get Value From Edit Text
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("") || passwordString.equals("")) {
                // Have Space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.message_HaveSpace));
            } else {
                // No Space
                checkUserAnPassword();
            }

        }

    }   // onClick


    //Synchronize Value From MySQL Server Check Authen
    private void checkUserAnPassword() {

        boolean b = true;
        MyConstant myConstant = new MyConstant();
        String[] columnUserStrings = myConstant.getColumnUserStrings();
        String[] loginStrings = new String[columnUserStrings.length];
        MyAlert myAlert = new MyAlert(MainActivity.this);

        try {

            GetData getData = new GetData(MainActivity.this);
            getData.execute(myConstant.getUrlGetUser());
            String strJSON = getData.get();
            Log.d("23AprilV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnUserStrings[6]))) {
                    b = !b;
                    for (int i1=0;i1<columnUserStrings.length;i1++) {
                        loginStrings[i1] = jsonObject.getString(columnUserStrings[i1]);
                        Log.d("23AprilV1", "loginString(" + i1 + ") ==> " + loginStrings[i1]);
                    }   // for
                }   // if

            }   // for

            if (b) {
                //User False
                myAlert.myDialog(getResources().getString(R.string.title_UserFalse),
                        getResources().getString(R.string.message_UserFalse));
            } else if (passwordString.equals(loginStrings[7])) {
                //Password True
                Toast.makeText(MainActivity.this, "Welcome " + loginStrings[1],
                        Toast.LENGTH_SHORT).show();

                intentToService(loginStrings);


            } else {
                //Password False
                myAlert.myDialog(getResources().getString(R.string.title_PassFalse),
                        getResources().getString(R.string.message_PassFalse));
            }

        } catch (Exception e) {
            Log.d("23AprilV1", "e checkUser ==> " + e.toString());
        }

    }   // checkUserAnPassword

    private void intentToService(String[] loginStrings) {

        int i = Integer.parseInt(loginStrings[8]);
        switch (i) {
            case 0: // For User
                Intent intent = new Intent(MainActivity.this, ModeOne.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);
                finish();
                break;
            case 1: // For Admin
                Intent intent1 = new Intent(MainActivity.this, WaitAdmin.class);
                intent1.putExtra("Login", loginStrings);
                startActivity(intent1);
                finish();
                break;
        }

    }

}   // Main Class
