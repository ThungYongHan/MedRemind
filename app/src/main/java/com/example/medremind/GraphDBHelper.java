package com.example.medremind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class GraphDBHelper {
    private Context context;
    private DatabaseHelper databasehelper;
    private SQLiteDatabase database;
    private MedDBHelper medDBHelper;

    public GraphDBHelper(Context context){
        this.context = context;
        databasehelper = new DatabaseHelper(context);
    }
    // set sunday graph column
    public boolean setGraphSunModel(GraphModel graphModel){
        String graphSun = "1";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphSun);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean setGraphMonModel(GraphModel graphModel){
        String graphMon = "2";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphMon);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean setGraphTueModel(GraphModel graphModel){
        String graphTue = "3";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphTue);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean setGraphWedModel(GraphModel graphModel){
        String graphWed = "4";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphWed);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }
    public boolean setGraphThuModel(GraphModel graphModel){
        String graphThu = "5";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphThu);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean setGraphFriModel(GraphModel graphModel){
        String graphFri = "6";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphFri);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean setGraphSatModel(GraphModel graphModel){
        String graphSat = "7";

        String ontime = "0";
        String outofrange = "0";
        String nottaken = "0";
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ID,graphSat);
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,ontime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,outofrange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,nottaken);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_GRAPH_NAME,null,contentValues);
        sqLiteDatabase.close();
        return true;
    }

    // update sunday taken on time column
    public boolean updateGraphSunOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"1"});
        sqLiteDatabase.close();
        return true;
    }
    // update sunday taken out of range column
    public boolean updateGraphSunOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"1"});
        sqLiteDatabase.close();
        return true;
    }
    // update sunday not taken column
    public boolean updateGraphSunNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allSunMed = medDBHelper.countMedSun();
        int allTakenSunMed = medDBHelper.countTakenMedSun();
        int differenceSunMed = allSunMed - allTakenSunMed;
        int tempLate = differenceSunMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"1"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphMonOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"2"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphMonOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"2"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphMonNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allMonMed = medDBHelper.countMedMon();
        int allTakenMonMed = medDBHelper.countTakenMedMon();
        int differenceMonMed = allMonMed - allTakenMonMed;
        int tempLate = differenceMonMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"2"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphTueOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"3"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphTueOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"3"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphTueNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allTueMed = medDBHelper.countMedTue();
        int allTakenTueMed = medDBHelper.countTakenMedTue();
        int differenceTueMed = allTueMed - allTakenTueMed;
        int tempLate = differenceTueMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"3"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphWedOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"4"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphWedOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"4"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphWedNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allWedMed = medDBHelper.countMedWed();
        int allTakenWedMed = medDBHelper.countTakenMedWed();
        int differenceWedMed = allWedMed - allTakenWedMed;
        int tempLate = differenceWedMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"4"});
        sqLiteDatabase.close();
        return true;
    }


    public boolean updateGraphThuOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"5"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphThuOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"5"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphThuNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allThuMed = medDBHelper.countMedThu();
        int allTakenThuMed = medDBHelper.countTakenMedThu();
        int differenceThuMed = allThuMed - allTakenThuMed;
        int tempLate = differenceThuMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"5"});
        sqLiteDatabase.close();
        return true;
    }


    public boolean updateGraphFriOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"6"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphFriOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"6"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphFriNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        medDBHelper=new MedDBHelper(context);
        int allFriMed = medDBHelper.countMedFri();
        int allTakenFriMed = medDBHelper.countTakenMedFri();
        int differenceFriMed = allFriMed - allTakenFriMed;
        int tempLate = differenceFriMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"6"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphSatOnTimeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOnTime = Integer.parseInt(graphModel.getGraphOnTime()) + 1;

        String stringOnTime= String.valueOf(tempOnTime);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,stringOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"7"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphSatOutOfRangeModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        int tempOutOfRange = Integer.parseInt(graphModel.getGraphOutOfRange()) + 1;

        String stringOutOfRange = String.valueOf(tempOutOfRange);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,stringOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"7"});
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateGraphSatNotTakenModel(GraphModel graphModel){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
       medDBHelper=new MedDBHelper(context);
        int allSatMed = medDBHelper.countMedSat();
        int allTakenSatMed = medDBHelper.countTakenMedSat();
        int differenceSatMed = allSatMed - allTakenSatMed;
        int tempLate = differenceSatMed;
        String stringLate = String.valueOf(tempLate);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,stringLate);
        contentValues.put(DatabaseHelper.COL_GRAPH_TAG, DatabaseHelper.COL_GRAPH_STATUS);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",new String[]{"7"});
        sqLiteDatabase.close();
        return true;
    }

    public String fetchGraphOnTime(int graphID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        String temp = String.valueOf(graphID);

        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{temp});
        String intake="";
        if(cursor.moveToFirst()){
            intake=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return intake;
    }

    public String fetchGraphOutOfRange(int graphID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        String temp = String.valueOf(graphID);
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{temp});
        String intake="";
        if(cursor.moveToFirst()){
            intake=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return intake;
    }

    public String fetchGraphNotTaken(int graphID){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        String temp = String.valueOf(graphID);

        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{temp});
        String intake="";
        if(cursor.moveToFirst()){
            intake=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return intake;
    }

    // count number of graph rows
    public int countGraph(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String count="SELECT " + DatabaseHelper.COL_GRAPH_ID + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_TAG+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(count, new String[]{DatabaseHelper.COL_GRAPH_STATUS});
        return cursor.getCount();
    }
    // reset the graph statistics to 0 0 0
    public boolean removeGraphIntake(int graphID){
        String removeSunOnTime = "0";
        String removeSunOutOfRange = "0";
        String removeSunNotTaken = "0";
        String tempID = String.valueOf(graphID);
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_GRAPH_ONTIME,removeSunOnTime);
        contentValues.put(DatabaseHelper.COL_GRAPH_OUTOFRANGE,removeSunOutOfRange);
        contentValues.put(DatabaseHelper.COL_GRAPH_NOTTAKEN,removeSunNotTaken);
        sqLiteDatabase.update(DatabaseHelper.TABLE_GRAPH_NAME,contentValues,DatabaseHelper.COL_GRAPH_ID+"=?",
                new String[]{tempID});
        sqLiteDatabase.close();
        return true;
    }
    // count taken on time for sunday graph
    public String countTakeOnGraphSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"1"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    public String countTakeOnGraphMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"2"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOnGraphTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"3"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOnGraphWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"4"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOnGraphThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"5"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOnGraphFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"6"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOnGraphSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_ONTIME + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"7"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_ONTIME));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    // count taken not on time for sunday graph
    public String countTakeOutGraphSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"1"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOutGraphMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"2"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOutGraphTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"3"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOutGraphWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"4"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOutGraphThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"5"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeOutGraphFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"6"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    public String countTakeOutGraphSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_OUTOFRANGE + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"7"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_OUTOFRANGE));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    // count not taken for sunday graph
    public String countTakeNotGraphSun(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"1"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeNotGraphMon(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"2"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    public String countTakeNotGraphTue(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"3"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    public String countTakeNotGraphWed(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"4"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
    public String countTakeNotGraphThu(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"5"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeNotGraphFri(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"6"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }

    public String countTakeNotGraphSat(){
        SQLiteDatabase sqLiteDatabase=this.databasehelper.getReadableDatabase();
        String query="SELECT " + DatabaseHelper.COL_GRAPH_NOTTAKEN + " FROM " + DatabaseHelper.TABLE_GRAPH_NAME + " WHERE " + DatabaseHelper.COL_GRAPH_ID+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(query,new String[]{"7"});
        String title="";
        if(cursor.moveToFirst()){
            title=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRAPH_NOTTAKEN));
        }
        cursor.close();
        sqLiteDatabase.close();
        return title;
    }
}