package com.example.android.aidltestclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.aidlserver.Person;
import com.example.android.aidlserver.ResultCallback;
import com.example.android.aidlserver.mAidlInterface;


public class MainActivity extends Activity {

    private mAidlInterface mInterface;
    private Button bindButton;
    private Button unbindButton;
    private Button helloButton;
    private Person person;
    private final static String TAG = "aidltestclient";

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mInterface = mAidlInterface.Stub.asInterface(service);
            Log.i(TAG, "Service Connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "Service Disconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new Person();
        person.name = "Han";
        person.age = "23";
        person.gender = "male";
        bindButton = (Button)findViewById(R.id.bindButton);
        bindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.AIDLService");
                //for android 5.0 and later, service intent must be explicit
                intent.setPackage("com.example.android.aidlserver");
                bindService(intent, conn, Context.BIND_AUTO_CREATE);
                unbindButton.setEnabled(true);
                helloButton.setEnabled(true);
                bindButton.setEnabled(false);
            }
        });
        unbindButton = (Button)findViewById(R.id.unbind_button);
        unbindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
                unbindButton.setEnabled(false);
                bindButton.setEnabled(true);
                helloButton.setEnabled(false);
            }
        });
        helloButton = (Button)findViewById(R.id.hello_button);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String helloText = mInterface.greet("Rimon");
                    String niceText = mInterface.introduce(person, result);
                    Toast.makeText(MainActivity.this, helloText, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, niceText, Toast.LENGTH_SHORT).show();
                }catch (RemoteException e){
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private final ResultCallback.Stub result = new ResultCallback.Stub() {
        @Override
        public void response(Person person) throws RemoteException {
            Toast.makeText(MainActivity.this, person.gender, Toast.LENGTH_LONG).show();
        }

        @Override
        public String success(String result) throws RemoteException {
            Log.i(TAG, result);
            return result;
        }

        @Override
        public String failure(String error) throws RemoteException {
            Log.i(TAG, error);
            return error;
        }
    };
}
