/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/rimon_kou/AndroidStudioProjects/AIDLServer/app/src/main/aidl/com/example/android/aidlserver/mAidlInterface.aidl
 */
package com.example.android.aidltestclient;

import com.example.android.aidlserver.ResultCallback;

public interface mAidlInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.android.aidltestclient.mAidlInterface
{
private static final String DESCRIPTOR = "com.example.android.aidlserver.mAidlInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.android.aidlserver.mAidlInterface interface,
 * generating a proxy if needed.
 */
public static com.example.android.aidltestclient.mAidlInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.android.aidltestclient.mAidlInterface))) {
return ((com.example.android.aidltestclient.mAidlInterface)iin);
}
return new com.example.android.aidltestclient.mAidlInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_greet:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _result = this.greet(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_introduce:
{
data.enforceInterface(DESCRIPTOR);
com.example.android.aidltestclient.Person _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.android.aidltestclient.Person.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
ResultCallback _arg1;
_arg1 = ResultCallback.Stub.asInterface(data.readStrongBinder());
String _result = this.introduce(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.android.aidltestclient.mAidlInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
@Override public String greet(String someone) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(someone);
mRemote.transact(Stub.TRANSACTION_greet, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public String introduce(com.example.android.aidltestclient.Person person, ResultCallback result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((person!=null)) {
_data.writeInt(1);
person.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((result!=null))?(result.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_introduce, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_greet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_introduce = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public String greet(String someone) throws android.os.RemoteException;
public String introduce(com.example.android.aidltestclient.Person person, com.example.android.aidlserver.ResultCallback result) throws android.os.RemoteException;
}
