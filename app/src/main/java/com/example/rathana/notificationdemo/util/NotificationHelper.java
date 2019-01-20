package com.example.rathana.notificationdemo.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.PrecomputedText;

import com.example.rathana.notificationdemo.DetailActivity;
import com.example.rathana.notificationdemo.R;

public class NotificationHelper {

    private Context mContext;

    public static  final String CHANNEL_ID_1="USER 1 ID";
    public static  final String CHANNEL_NAME_1="USER 1";

    public NotificationHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel=
                    new NotificationChannel(CHANNEL_ID_1,CHANNEL_NAME_1,
                            NotificationManager.IMPORTANCE_HIGH);

            channel.setShowBadge(true);
            channel.enableLights(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.setDescription("this channel use for manager each user in app");
            channel.enableVibration(true);

            NotificationManager manager= (NotificationManager)
                    mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);

        }

    }

    public void pushSimpleNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(mContext,CHANNEL_ID_1);

        builder.setContentTitle("Hello!");
        builder.setContentText("New app just release");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setNumber(1);
        /*builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.ic_launcher));*/
        //builder.setAutoCancel(true);

        // create pending Intent

        Intent intent =new Intent(mContext,DetailActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(mContext,1,
                intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationManager manager= (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        int id= (int) (System.currentTimeMillis()/1000);
        manager.notify(id,builder.build());

    }


    public void pushBigTextStyleNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(mContext,CHANNEL_ID_1);

        builder.setContentTitle("Hello!");
        builder.setContentText("New app just release");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setNumber(1);
        /*builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.ic_launcher));*/
        //builder.setAutoCancel(true);

        // create pending Intent

        Intent intent =new Intent(mContext,DetailActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(mContext,1,
                intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        //bigtext style

        NotificationCompat.BigTextStyle  style=new NotificationCompat.BigTextStyle();
        style.bigText("New app just release New app just release New app just release New app just release New app just release New app just release");

        builder.setStyle(style);

        NotificationManager manager= (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        int id= (int) (System.currentTimeMillis()/1000);
        manager.notify(id,builder.build());

    }


    public void pushBigPictureStyleNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(mContext,CHANNEL_ID_1);

        builder.setContentTitle("Hello!");
        builder.setContentText("New app just release");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setNumber(1);
        /*builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.ic_launcher));*/
        //builder.setAutoCancel(true);

        // create pending Intent

        Intent intent =new Intent(mContext,DetailActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(mContext,1,
                intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        //bigtext style

       NotificationCompat.BigPictureStyle style =new NotificationCompat.BigPictureStyle();
       style.bigLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher));
       style.bigPicture(BitmapFactory.decodeResource(mContext.getResources(),R.drawable.kung_fu_panda));
       builder.setStyle(style);

        NotificationManager manager= (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        int id= (int) (System.currentTimeMillis()/1000);
        manager.notify(id,builder.build());

    }


}
