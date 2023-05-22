package com.example.healthcare;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1= "create table users(username text,email text,password text)";
        db.execSQL(qry1);
        String qry2= "create table cart(username text,product text,price float,otype text)";
        db.execSQL(qry2);
        String qry3= "create table orderplaced(username text,fullname text,contact text,pincode text,date text,time text,amount float,otype text)";
        db.execSQL(qry3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void  register(String username , String email , String password){
        ContentValues cv = new ContentValues();
        cv.put("Username", username);
        cv.put("Email", email);
        cv.put("Password", password);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("users", null,cv);
        db.close();
    }
    public int login(String username , String password){
        int result = 0;
        String str[]= new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c= db.rawQuery("select * from users where username=? and password=? ",str);
        if (c.moveToFirst()){
            result =1;
        }
        return  result;
    }
    public  void  addCart(String username , String product ,Float price , String otype){
        ContentValues cv= new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();
    }

    public int checkCart(String username , String product){
        int result = 0;
        String str[]= new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c= db.rawQuery("select * from cart where username=? and product=? ",str);
        if (c.moveToFirst()){
            result =1;
        }
        db.close();
        return  result;
    }
    public int removeCart(String username , String otype){
        int result = 0;
        String str[]= new String[2];
        str[0] = username;
        str[1] = otype;
        SQLiteDatabase db = getReadableDatabase();
        db.delete( "cart" ,"username=? and otype=? ",str);
        db.close();
        return  result;
    }
    public ArrayList<String> getCartData(String username , String otype){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        String str[]=new  String[2];
        str[0]= username;
        str[1]= otype;
        Cursor c= db.rawQuery("select * from cart where username=? and otype=? ",str);
        if(c.moveToFirst()){
            do{
                String prodcut = c.getString(1);
                String price = c.getString(2);
                arr.add(prodcut+"$"+price);
            }while (c.moveToNext());
        }
        db.close();
        return  arr;
    }

    public void addOrder(String s, String username , String fullname , String contact, int pincode, String date, String time, Float amount , String otype){
        ContentValues cv= new ContentValues();
        cv.put("username",username);
        cv.put("name",fullname);
        cv.put("date",date);
        cv.put("contact",contact);
        cv.put("time",time);
        cv.put("pincode",pincode);
        cv.put("amount",amount);
        cv.put("otype",otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplaced",null,cv);
        db.close();
    }

}

