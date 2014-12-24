// ResultCallback.aidl
package com.example.android.aidlserver;

// Declare any non-default types here with import statements

interface ResultCallback {
    String success(String result);
    String failure(String error);
}
