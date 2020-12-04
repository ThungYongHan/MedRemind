package com.example.medremind;

import android.app.Application;
import android.content.Intent;

public class App extends Application {
    @Override
    public void onCreate() {
        // called before any activity or service is created
        super.onCreate();
        // start MyService
        startService(new Intent(this, MyService.class));
    }
}
