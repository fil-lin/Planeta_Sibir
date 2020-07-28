package com.example.planetsib;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class WebCon extends AsyncTask <String, Void, String>{

    private int id;
    private Context context;
    private TextView text;

    public WebCon(int id, TextView text){
        this.id = id;
        this.text = text;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            String href = "https://postavte-5-po-fizike.000webhostapp.com/getMyInfo.php";
            URL url = new URL(href);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

            out.write(id);
            out.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null){
                sb.append(line);
                break;
            }

            return sb.toString();
        }catch (Exception e){

        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.text.setText(Html.fromHtml(s));
    }

}
