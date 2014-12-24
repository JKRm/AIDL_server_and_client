// ResultCallback.aidl
package com.example.android.aidlserver;

// Declare any non-default types here with import statements
import com.example.android.aidlserver.Person;
interface ResultCallback {
    String success(String result);
    String failure(String error);
    void response(in Person person);
}
