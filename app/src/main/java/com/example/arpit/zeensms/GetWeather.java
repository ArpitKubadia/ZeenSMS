package com.example.arpit.zeensms;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWeather {
    JSONObject data=null;
    String weather;
    String app_id="3d6bbf028a8b03ad66cdab5dd3c35175";
    public String getJSON(final String lat,final String lon) {


        /*new AsyncTask<Void, Void, Void>() {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Void doInBackground(Void... params) {*/
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&units=metric&APPID="+app_id);
            Log.d("Called","Method called");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";

            while((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            data = new JSONObject(json.toString());

            if(data.getInt("cod") != 200) {
                System.out.println("Cancelled");
                return null;
            }
            weather=parseJSON();
            Log.d("Weather is ","This "+weather);
            return weather;


        } catch (Exception e) {

            System.out.println("Exception "+ e.getMessage());
            return null;
        }

        //return null;


            /*@Override
            protected void onPostExecute(Void Void) {
                if(data!=null){
                    Log.d("my weather received",data.toString());


                }

            }
        }.execute();
*/

        // Log.d("Weather is ","This is return"+weather);

    }

    public String parseJSON(){
        String main=null;
        if(data!=null){
            try{
                JSONObject jsonObject=new JSONObject();
                jsonObject=data;
                JSONArray weather=jsonObject.getJSONArray("weather");
                if(weather!=null) {
                    JSONObject w=weather.getJSONObject(0);
                    main=w.getString("main");
                    Log.d("Main",main);

                }
            }catch (final JSONException e) {
                Log.e("JSONERROR", "Json parsing error: " + e.getMessage());
            }
        };
        return main;
    }

}