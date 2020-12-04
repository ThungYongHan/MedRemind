package com.example.medremind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MedDBHelper {
    private Context context;
    private DatabaseHelper databasehelper;
    private SQLiteDatabase database;
    public MedDBHelper(Context context){
        this.context = context;
        databasehelper = new DatabaseHelper(context);
    }

    public boolean addNewMedicine(MedicineModel medicineModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TITLE,medicineModel.getMedTitle());
        contentValues.put(DatabaseHelper.COL_MED_SUN,medicineModel.getMedSun());
        contentValues.put(DatabaseHelper.COL_MED_MON,medicineModel.getMedMon());
        contentValues.put(DatabaseHelper.COL_MED_TUE,medicineModel.getMedTue());
        contentValues.put(DatabaseHelper.COL_MED_WED,medicineModel.getMedWed());
        contentValues.put(DatabaseHelper.COL_MED_THU,medicineModel.getMedThu());
        contentValues.put(DatabaseHelper.COL_MED_FRI,medicineModel.getMedFri());
        contentValues.put(DatabaseHelper.COL_MED_SAT,medicineModel.getMedSat());
        contentValues.put(DatabaseHelper.COL_MED_TIME,medicineModel.getMedTime());
        contentValues.put(DatabaseHelper.COL_MED_DOSAGE,medicineModel.getMedDosage());
        contentValues.put(DatabaseHelper.COL_MED_TAG, DatabaseHelper.COL_MED_STATUS);
        contentValues.put(DatabaseHelper.COL_MED_TAKEN, DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_MED_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public ArrayList<MedicineModel> fetchAllMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchSunMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_SUN+"=\"sun\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMonMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_MON+"=\"mon\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchTueMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TUE+"=\"tue\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchWedMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_WED+"=\"wed\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchThuMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_THU+"=\"thu\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchFriMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_FRI+"=\"fri\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchSatMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_SAT+"=\"sat\" AND " + DatabaseHelper.COL_MED_TAG+"=? ORDER BY " + DatabaseHelper.COL_MED_TITLE + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedSun(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN)));
            medicineModel.setMedMon(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON)));
            medicineModel.setMedTue(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE)));
            medicineModel.setMedWed(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED)));
            medicineModel.setMedThu(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU)));
            medicineModel.setMedFri(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI)));
            medicineModel.setMedSat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public boolean makeTakenMed(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_TAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_ID+"=?",
                new String[]{String.valueOf(medID)});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenSun(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_SUN+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenMon(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_MON+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenTue(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_TUE+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenWed(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_WED+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenThu(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_THU+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenFri(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_FRI+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeTakenSat(String currentDay){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TAKEN,DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_SAT+"=?",
                new String[]{currentDay});
        sqLiteDatabase.close();
        return true;
    }

    public ArrayList<MedicineModel> fetchSunTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_SUN+"=\"sun\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMonTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_MON+"=\"mon\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchTueTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_TUE+"=\"tue\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchWedTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_WED+"=\"wed\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchThuTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_THU+"=\"thu\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchFriTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_FRI+"=\"fri\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchSatTakenMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_SAT+"=\"sat\""  ;
        Cursor cursor=sqLiteDatabase.rawQuery(query, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        while(cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }


    public int countMedicine(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAG+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS});
        return cursor.getCount();
    }

    public int countTakenMedSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_SUN+"=\"sun\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_MON+"=\"mon\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_TUE+"=\"tue\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_WED+"=\"wed\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_THU+"=\"thu\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_FRI+"=\"fri\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public int countTakenMedSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=?" + " AND " + DatabaseHelper.COL_MED_SAT+"=\"sat\"";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TAKEN});
        return cursor.getCount();
    }

    public String fetchMedTitle(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_TITLE + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedTime(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_TIME + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedDosage(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_DOSAGE + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListSun(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_SUN + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SUN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListMon(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_MON + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_MON));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListTue(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_TUE + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TUE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListWed(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_WED + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_WED));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListThu(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_THU + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_THU));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListFri(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_FRI + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_FRI));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String fetchMedListSat(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_SAT + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(medID)});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_SAT));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }


    public String fetchMedTimeSun(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_SUN+"=\"sun\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public String fetchMedTimeMon(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_MON+"=\"mon\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public String fetchMedTimeTue(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_TUE+"=\"tue\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }


    public String fetchMedTimeWed(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_WED+"=\"wed\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";

        //  String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_WED+"=\"wed\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public String fetchMedTimeThu(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_THU+"=\"thu\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public String fetchMedTimeFri(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_FRI+"=\"fri\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public String fetchMedTimeSat(String currentTime){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TIME+"=?"  + " AND " + DatabaseHelper.COL_MED_SAT+"=\"sat\""  + " AND " + DatabaseHelper.COL_MED_TAKEN+"=\"not\"";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{currentTime});
        String time="";
        if(cursor.moveToFirst()){
            time=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID));
        }
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }

    public int countMedSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_SUN+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_SUN});
        return cursor.getCount();
    }

    public int countMedMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_MON+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_MON});
        return cursor.getCount();
    }

    public int countMedTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TUE+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_TUE});
        return cursor.getCount();
    }

    public int countMedWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_WED+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_WED});
        return cursor.getCount();
    }

    public int countMedThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_THU+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_THU});
        return cursor.getCount();
    }

    public int countMedFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_FRI+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_FRI});
        return cursor.getCount();
    }

    public int countMedSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_MED_ID + " FROM " + DatabaseHelper.TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_SAT+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_MED_STATUS_SAT});
        return cursor.getCount();
    }

    public ArrayList<MedicineModel> fetchMedSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_SUN+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";

        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_SUN});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }


    public ArrayList<MedicineModel> fetchMedMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_MON+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_MON});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMedTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_TUE+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_TUE});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMedWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_WED+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_WED});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMedThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_THU+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_THU});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMedFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_FRI+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_FRI});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public ArrayList<MedicineModel> fetchMedSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        ArrayList<MedicineModel> medicineModels=new ArrayList<>();
        String query="SELECT * FROM " + DatabaseHelper. TABLE_MED_NAME + " WHERE " + DatabaseHelper.COL_MED_TAKEN+"=\"not\" AND " + DatabaseHelper.COL_MED_SAT+"=? ORDER BY " + DatabaseHelper.COL_MED_TIME + " ASC";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{DatabaseHelper.COL_MED_STATUS_SAT});
        while (cursor.moveToNext()){
            MedicineModel medicineModel=new MedicineModel();
            medicineModel.setMedID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MED_ID)));
            medicineModel.setMedTitle(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TITLE)));
            medicineModel.setMedTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_TIME)));
            medicineModel.setMedDosage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MED_DOSAGE)));
            medicineModels.add(medicineModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return medicineModels;
    }

    public boolean removeMed(int medID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        sqLiteDatabase.delete(DatabaseHelper.TABLE_MED_NAME, DatabaseHelper.COL_MED_ID+"=?",new String[]{String.valueOf(medID)});
        sqLiteDatabase.close();
        return true;
    }

    public boolean removeAllMed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        sqLiteDatabase.delete(DatabaseHelper.TABLE_MED_NAME,DatabaseHelper.COL_MED_TAG+"=?",new String[]{DatabaseHelper.COL_MED_STATUS});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateMed(MedicineModel medicineModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_MED_TITLE,medicineModel.getMedTitle());
        contentValues.put(DatabaseHelper.COL_MED_TIME,medicineModel.getMedTime());
        contentValues.put(DatabaseHelper.COL_MED_DOSAGE,medicineModel.getMedDosage());
        contentValues.put(DatabaseHelper.COL_MED_SUN,medicineModel.getMedSun());
        contentValues.put(DatabaseHelper.COL_MED_MON,medicineModel.getMedMon());
        contentValues.put(DatabaseHelper.COL_MED_TUE,medicineModel.getMedTue());
        contentValues.put(DatabaseHelper.COL_MED_WED,medicineModel.getMedWed());
        contentValues.put(DatabaseHelper.COL_MED_THU,medicineModel.getMedThu());
        contentValues.put(DatabaseHelper.COL_MED_FRI,medicineModel.getMedFri());
        contentValues.put(DatabaseHelper.COL_MED_SAT,medicineModel.getMedSat());
        contentValues.put(DatabaseHelper.COL_MED_TAKEN, DatabaseHelper.COL_MED_STATUS_NOTTAKEN);
        contentValues.put(DatabaseHelper.COL_MED_TAG, DatabaseHelper.COL_MED_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_MED_NAME,contentValues,DatabaseHelper.COL_MED_ID+"=?",new String[]{String.valueOf(medicineModel.getMedID())});
        sqLiteDatabase.close();
        return true;
    }


}
