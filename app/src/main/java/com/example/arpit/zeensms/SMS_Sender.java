package com.example.arpit.zeensms;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SMS_Sender {
    private static Context context;
    public SMS_Sender(Context context) {
    this.context=context;
    }
    GetWeather getWeather=new GetWeather();

    String name,number,area,weather,lat,lon;
    static List<String> existingAddress=new ArrayList<String>();
    static List<String> existingWeather=new ArrayList<String>();

    public void getData(String name,String number,String area,String lat,String lon)
    {
        this.name=name;
        this.number=number;
        this.area=area;
        this.lat=lat;
        this.lon=lon;

        dataExists();
    }

    public void dataExists()
    {
        int i=existingAddress.indexOf(area);
        if(i==-1)
        {
            existingAddress.add(area);
            //logic to add weather
            getWeather.getJSON(lat,lon);
            existingWeather.add(weather);

        }
        else
        {
            weather=existingWeather.get(i);
        }
        Log.d("ExistingAddress","Size "+existingAddress.size());

        for(int j=0;j<existingAddress.size();j++)
        {
            Log.d("DataExists",existingAddress.get(j));
        }



    }

}
