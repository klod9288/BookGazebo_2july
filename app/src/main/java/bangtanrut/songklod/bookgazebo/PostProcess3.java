package bangtanrut.songklod.bookgazebo;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterung on 7/10/2017 AD.
 */

public class PostProcess3 extends AsyncTask<String, Void, String>{
    private Context context;

    public PostProcess3(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("dateString", params[0])
                    .add("tumBunString", params[1])
                    .add("salaString", params[2])
                    .add("nameBodyString", params[3])
                    .add("nameContactString", params[4])
                    .add("phoneString", params[5])
                    .add("timePhathed", params[6])
                    .add("timeSungkatand", params[7])
                    .add("amountSungkatand", params[8])
                    .add("timeSundmonn", params[9])
                    .add("amoundSundmonn", params[10])
                    .add("timePackageBody", params[11])
                    .add("amountKondin", params[12])
                    .add("amountFlower", params[13])
                    .add("amoundBucha", params[14])
                    .add("amoundThaitan", params[15])
                    .add("amoundWaterDrink", params[16])
                    .add("amountIce", params[17])
                    .add("amoundFood", params[18])
                    .add("amoundBow", params[19])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[20]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
