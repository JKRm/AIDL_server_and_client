// mAidlInterface.aidl
package com.example.android.aidlserver;

// Declare any non-default types here with import statements
import com.example.android.aidlserver.Person;
import com.example.android.aidlserver.ResultCallback;
interface mAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     String greet(String someone);
     String introduce(in Person person, in ResultCallback result);
}
