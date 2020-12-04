package com.example.medremind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class WaterDBHelper {
    private Context context;
    private DatabaseHelper databasehelper;
    private SQLiteDatabase database;
    public WaterDBHelper(Context context){
        this.context = context;
        databasehelper = new DatabaseHelper(context);
    }

    public boolean setWaterModel(WaterModel waterModel){
        String newWater = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_WATER_INTAKE,newWater);
        contentValues.put(DatabaseHelper.COL_WATER_TAG, DatabaseHelper.COL_WATER_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_WATER_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateWaterModel(WaterModel waterModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempWater = Integer.parseInt(waterModel.getWaterIntake()) + 1;
        String stringWater = String.valueOf(tempWater);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_WATER_INTAKE,stringWater);
        contentValues.put(DatabaseHelper.COL_WATER_TAG, DatabaseHelper.COL_WATER_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_WATER_NAME,contentValues,DatabaseHelper.COL_WATER_ID+"=?",new String[]{"1"});
        sqLiteDatabase.close();
        return true;
    }

    public String fetchWaterIntake(int waterID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_WATER_INTAKE + " FROM " + DatabaseHelper.TABLE_WATER_NAME + " WHERE " + DatabaseHelper.COL_WATER_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"1"});
        String intake="";
        if(cursor.moveToFirst()){
            intake=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_WATER_INTAKE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return intake;
    }

    public int countWater(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_WATER_ID + " FROM " + DatabaseHelper.TABLE_WATER_NAME + " WHERE " + DatabaseHelper.COL_WATER_TAG+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_WATER_STATUS});
        return cursor.getCount();
    }

    public boolean removeWaterIntake(int waterID){
        String removeWater = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_WATER_INTAKE,removeWater);
        sqLiteDatabase.update(DatabaseHelper.TABLE_WATER_NAME,contentValues,DatabaseHelper.COL_WATER_ID+"=?",
                new String[]{"1"});
        sqLiteDatabase.close();
        return true;
    }
}
