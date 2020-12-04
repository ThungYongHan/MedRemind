package com.example.medremind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AptDBHelper {
    private Context context;
    private DatabaseHelper databasehelper;
    private SQLiteDatabase database;
    public AptDBHelper(Context context){
        this.context = context;
        databasehelper = new DatabaseHelper(context);
    }

    public boolean addNewAppointment(AppointmentModel appointmentModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_APT_TITLE,appointmentModel.getAptTitle());
        contentValues.put(DatabaseHelper.COL_APT_DATETIME,appointmentModel.getAptDateTime());
        contentValues.put(DatabaseHelper.COL_APT_TAG, DatabaseHelper.COL_APT_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_APT_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public String fetchAptDateTime(int aptID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_APT_DATETIME + " FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(aptID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_DATETIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchAptTitle(int aptID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_APT_TITLE + " FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(aptID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_TITLE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public int fetchAptID(String aptTitle){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_APT_ID + " FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_TITLE+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{aptTitle});
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_APT_ID));
    }

    public ArrayList<String> fetchAptStrings(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<String> appointmentModels=new ArrayList<>();
        String query="SELECT " + DatabaseHelper.COL_APT_TITLE+ " FROM " + DatabaseHelper.TABLE_APT_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        while (cursor.moveToNext()){
            appointmentModels.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_TITLE)));
        }
        cursor.close();
        sqLiteDatabase.close();
        return appointmentModels;
    }

    public boolean removeApt(int aptID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        sqLiteDatabase.delete(DatabaseHelper.TABLE_APT_NAME, DatabaseHelper.COL_APT_ID+"=?",new String[]{String.valueOf(aptID)});
        sqLiteDatabase.close();
        return true;
    }

    public int countAppointments(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_APT_ID + " FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_TAG+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_APT_STATUS});
        return cursor.getCount();
    }

    public ArrayList<AppointmentModel> fetchAllAppointments(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<AppointmentModel> appointmentModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_TAG+"=? ORDER BY " + DatabaseHelper.COL_APT_DATETIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_APT_STATUS});
        while(cursor.moveToNext()){
            AppointmentModel appointmentModel=new AppointmentModel();
            appointmentModel.setAptID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_APT_ID)));
            appointmentModel.setAptTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_TITLE)));
            appointmentModel.setAptDateTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_DATETIME)));
            appointmentModels.add(appointmentModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return appointmentModels;
    }

    // fetch appointments with due date of today
    public ArrayList<AppointmentModel> fetchTodayAppointments(){
        // get current date with "YYYY-MM-dd" format
        String nowdate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        // initialize appointmentModels ArrayList
        ArrayList<AppointmentModel> appointmentModels=new ArrayList<>();
        // select all appointments with due date of today and sort it in ascending order of datetime
        String query="SELECT * FROM " + DatabaseHelper.TABLE_APT_NAME + " WHERE " + DatabaseHelper.COL_APT_DATETIME
                +" LIKE ? ORDER BY " + DatabaseHelper.COL_APT_DATETIME + " ASC";
        // runs provided query and returns cursor over the result set
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{nowdate + "%"});
        // moves the cursor through the all the rows in the result set
        while(cursor.moveToNext()){
            AppointmentModel appointmentModel=new AppointmentModel();
            // set data into appointmentModel
            appointmentModel.setAptID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_APT_ID)));
            appointmentModel.setAptTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_TITLE)));
            appointmentModel.setAptDateTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_APT_DATETIME)));
            appointmentModels.add(appointmentModel);
        }
        // closes the Cursor and releases all its resources, preventing memory leaks
        cursor.close();
        // close sqLiteDatabase object
        sqLiteDatabase.close();
        return appointmentModels;
    }

    public boolean removeAllApt(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        sqLiteDatabase.delete(DatabaseHelper.TABLE_APT_NAME,DatabaseHelper.COL_APT_TAG+"=?",new String[]{DatabaseHelper.COL_APT_STATUS});
        sqLiteDatabase.close();
        return true;
    }

    // update appointment after editing
    public boolean updateApt(AppointmentModel appointmentModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_APT_TITLE,appointmentModel.getAptTitle());
        contentValues.put(DatabaseHelper.COL_APT_DATETIME,appointmentModel.getAptDateTime());
        contentValues.put(DatabaseHelper.COL_APT_TAG, DatabaseHelper.COL_APT_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_APT_NAME,contentValues,DatabaseHelper.COL_APT_ID+"=?",new String[]{String.valueOf(appointmentModel.getAptID())});
        sqLiteDatabase.close();
        return true;
    }
}
