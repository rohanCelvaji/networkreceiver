package com.example.networkreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
       NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

       if(activeNetwork != null && activeNetwork.isConnected()){
           if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
               Toast.makeText(context,"Connected to Wifi",Toast.LENGTH_SHORT).show();
           }else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
               Toast.makeText(context, "Connected to Mobile Data", Toast.LENGTH_SHORT).show();
           }

       } else{
           Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
       }
    }
}