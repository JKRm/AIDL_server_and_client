package com.example.android.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AIDLServer extends Service {

    private final static String TAG = "aidlService";

    private final mAidlInterface.Stub mbinder = new mAidlInterface.Stub() {
        @Override
        public String greet(String someone) throws RemoteException {
            return "hello " + someone;
        }

        @Override
        public String introduce(Person person, ResultCallback result) throws RemoteException {
            String nice = "";
            try{
                nice = "nice to meet you, " + person.name;
                nice += " " + result.success("success");
            }catch(Exception e){
                nice += result.failure("error");
            }
            return nice;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind() is called");
        return true;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy() is called");
        super.onDestroy();
    }
}
