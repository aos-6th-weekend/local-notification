package com.example.rathana.notificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rathana.notificationdemo.util.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationHelper=new NotificationHelper(this);
        notificationHelper.createNotificationChannel();
    }



    public void onPushSimpleNotification(View view){
        notificationHelper.pushSimpleNotification();
    }

    public void onPushWithBigTextStyleNotification(View view){
        notificationHelper.pushBigTextStyleNotification();
    }

    public void onPushWithBigPictureStyleNotification(View view){
        notificationHelper.pushBigPictureStyleNotification();
    }
}
