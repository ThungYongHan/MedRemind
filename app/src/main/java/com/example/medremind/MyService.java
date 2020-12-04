package com.example.medremind;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    public MyService() {
    }
    // should only be called on Android Version Oreo or higher
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    // called each time Context.startService(Intent) is called
    public int onStartCommand(Intent intent, int flags, int startId) {
        onTaskRemoved(intent);
        startMedRemindForeground();
        // the system will eventually restart the service if it is killed
        return START_STICKY;
    }

    @Override
    // returns communication channel
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    // called if the service is running and the user removed a task
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        startService(restartServiceIntent);
        super.onTaskRemoved(rootIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startMedRemindForeground() {
        String NOTIFICATION_CHANNEL_ID = "com.example.medremind";
        // construct notification channel with unique channel id, name and importance level
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "MedremindForegroundService", NotificationManager.IMPORTANCE_NONE);
        // retrieve a NotificationManager instance
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(chan);
        Notification notification=new Notification.Builder(getApplicationContext(),NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.notificon)
                .setContentTitle("MedRemind is running in background")
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        // if service is running, make service run in the foreground
        startForeground(2, notification);
    }
}

