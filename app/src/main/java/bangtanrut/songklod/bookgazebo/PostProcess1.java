package bangtanrut.songklod.bookgazebo;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 20/8/2560.
 */

public class PostProcess1 extends AsyncTask<String,Void,String> {
    private Context context;

    public PostProcess1(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", strings[0])
                    .add("Pavilion", strings[1])
                    .add("Radio", strings[2])
                    .add("Date", strings[3])
                    .add("Time", strings[4])
                    .add("Timework", strings[5])
                    .add("Bodywere", strings[6])
                    .add("Deadcard", strings[7])
                    .add("Timewashbody", strings[8])
                    .add("Timepackage", strings[9])
                    .add("Buenbody", strings[10])
                    .add("Movebody", strings[11])
                    .add("Montlead", strings[12])
                    .add("Placrecive", strings[13])
                    .add("Carrecive", strings[14])
                    .add("Packagebody", strings[15])
                    .add("Flower", strings[16])
                    .add("Cinamal", strings[17])
                    .add("Thaitum", strings[18])
                    .add("Waterdrink", strings[19])
                    .add("Ice1", strings[20])
                    .add("Ice2", strings[21])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[22]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}//Main Class
