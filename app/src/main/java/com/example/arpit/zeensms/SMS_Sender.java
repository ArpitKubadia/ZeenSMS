package com.example.arpit.zeensms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SMS_Sender {
    private static Context context;
    public SMS_Sender(Context context) {
    this.context=context;
    }
    GetWeather getWeather=new GetWeather();

    String name,number,area,lat,lon;
    String weather[]=new String[2];
    static List<String> existingAddress=new ArrayList<String>();
    static List<String> existingWeather=new ArrayList<String>();
    static List<String> existingTemp=new ArrayList<String>();

    public String getData(String custom_msg,String name,String number,String area,String lat,String lon)
    {
        this.name=name;
        this.number=number;
        this.area=area;
        this.lat=lat;
        this.lon=lon;

        dataExists();
        Log.d("Custom message 1 is",custom_msg);
        String message=sendSMS(custom_msg);
        return message;
    }

    public void dataExists()
    {
        int i=existingAddress.indexOf(area);
        if(i==-1)
        {
            existingAddress.add(area);
            //logic to add weather
            weather=getWeather.getJSON(lat,lon);
            existingWeather.add(weather[0]);
            existingTemp.add(weather[1]);

        }
        else
        {
            weather[0]=existingWeather.get(i);
            weather[1]=existingTemp.get(i);
        }
        Log.d("ExistingAddress","Size "+existingAddress.size());

        for(int j=0;j<existingAddress.size();j++)
        {
            Log.d("DataExists",existingAddress.get(j));
        }



    }

    public String sendSMS(String custom_msg)
    {
        SmsManager sms=SmsManager.getDefault();
        marathiTranslation translation=new marathiTranslation();
        String message;
        weather[0]=translation.getMarathiTranslation(weather[0]);
        Log.d("Custom message is",custom_msg);
        if(custom_msg.equals("Enter Custom Message")){
            message=area+" येथे हवामान: "+weather[0]+"\n"+"तापमान: "+weather[1]+"°C\n\n"+"-प्रोजेक्ट ज़ीण";
        }
        else
            message=custom_msg;

        PendingIntent sentPI = PendingIntent.getBroadcast(context, 0, new Intent("SMS_SENT"), 0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0, new Intent("SMS_DELIVERED"), 0);


        ArrayList<String> parts = sms.divideMessage(message);
        ArrayList<PendingIntent> sendList = new ArrayList<>();
        sendList.add(sentPI);

        ArrayList<PendingIntent> deliverList = new ArrayList<>();
        deliverList.add(deliveredPI);

        //sms.sendMultipartTextMessage(number, null, parts, sendList, deliverList);


        return message;
    }
}
