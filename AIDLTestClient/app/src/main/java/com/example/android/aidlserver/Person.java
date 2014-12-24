package com.example.android.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rimon_kou on 14-12-23.
 */
public class Person implements Parcelable{

    public String name;
    public String gender;
    public String age;

    public static final  Creator<Person> CREATOR
            = new  Creator<Person>(){
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    private Person(Parcel in){
        name = in.readString();
        gender = in.readString();
        age = in.readString();
    }

    public Person(){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
