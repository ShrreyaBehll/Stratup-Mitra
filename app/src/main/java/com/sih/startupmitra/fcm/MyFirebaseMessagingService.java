package com.sih.startupmitra.fcm;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.sih.startupmitra.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
  

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Create and show notification
        Log.d(TAG, "Refreshed token: " + remoteMessage.getNotification().toString());
        Log.d(TAG, "Refreshed token: " + remoteMessage.getNotification().getTitle());
        Log.d(TAG, "Refreshed token: " + remoteMessage.getNotification().getBody());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        String titleName = remoteMessage.getData().get("name").toString();
        String title = remoteMessage.getData().get("organisation").toString();
        Log.d(TAG, "Refreshed token: " +title);
        Log.d(TAG, "Refreshed token: " +titleName);


    }

}