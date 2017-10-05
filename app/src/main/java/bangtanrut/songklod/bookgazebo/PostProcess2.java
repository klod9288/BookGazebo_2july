package bangtanrut.songklod.bookgazebo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterung on 5/10/2017 AD.
 */

public class PostProcess2 extends AsyncTask<String, Void, String>{
    private Context context;

    public PostProcess2(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("cremation", params[0])
                    .add("interment", params[1])
                    .add("name", params[2])
                    .add("pavilion", params[3])
                    .add("showTime", params[4])
                    .add("setDateTime", params[5])
                    .add("bodyWhere", params[6])
                    .add("timeBodyWhere", params[7])
                    .add("timeSong", params[8])
                    .add("coffeeGroup", params[9])
                    .add("amountBwchnafi", params[10])
                    .add("timeBwchanafi", params[11])
                    .add("bwchnafi", params[12])
                    .add("amountChantPlant", params[13])
                    .add("burnBuild", params[14])
                    .add("burnOld", params[15])
                    .add("burnBanana", params[16])
                    .add("salaPrice", params[17])
                    .add("manageBurnBuild", params[18])
                    .add("carBody", params[19])
                    .add("flower", params[20])
                    .add("flower0", params[21])
                    .add("flower1", params[22])
                    .add("powerSound", params[23])
                    .add("powerBand", params[24])
                    .add("waterDrink", params[25])
                    .add("ice", params[26])
                    .add("food", params[27])
                    .add("candy", params[28])
                    .add("bow", params[29])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[30]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("5octV1", "e doin==> " + e.toString());
        }
        return null;
    }
}
