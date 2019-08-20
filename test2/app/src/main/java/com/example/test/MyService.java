package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG = "SERVICE";
    public MyService() {
    }
    @Override
    public void onCreate(){
        Log.d(TAG, "등록완료");
    }
    @Override
    public void onDestroy(){
        Log.d(TAG, "서비스 회수");
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
