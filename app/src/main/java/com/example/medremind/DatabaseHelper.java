package com.example.medremind;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="finalmedremind";

    public static final String TABLE_APT_NAME="appointments";
    public static final String COL_APT_ID="apt_id";
    public static final String COL_APT_TITLE="apt_title";
    public static final String COL_APT_DATETIME="apt_datetime";
    public static final String COL_APT_TAG="apt_tag";
    public static final String COL_APT_STATUS="apt";

    public static final String TABLE_WATER_NAME="water";
    public static final String COL_WATER_ID="water_id";
    public static final String COL_WATER_INTAKE="water_intake";
    public static final String COL_WATER_TAG="water_tag";
    public static final String COL_WATER_STATUS="wat";

    public static final String TABLE_GRAPH_NAME="graph";
    public static final String COL_GRAPH_ID="graph_id";
    public static final String COL_GRAPH_ONTIME="graph_ontime";
    public static final String COL_GRAPH_OUTOFRANGE="graph_outofrange";
    public static final String COL_GRAPH_NOTTAKEN="graph_nottaken";
    public static final String COL_GRAPH_TAG="graph_tag";
    public static final String COL_GRAPH_STATUS="gph";

    public static final String TABLE_MED_NAME="medicine";
    public static final String COL_MED_ID="med_id";
    public static final String COL_MED_TITLE="med_title";
    public static final String COL_MED_TIME="med_time";
    public static final String COL_MED_DOSAGE="med_dosage";
    public static final String COL_MED_SUN="med_sun";
    public static final String COL_MED_MON="med_mon";
    public static final String COL_MED_TUE="med_tue";
    public static final String COL_MED_WED="med_wed";
    public static final String COL_MED_THU="med_thu";
    public static final String COL_MED_FRI="med_fri";
    public static final String COL_MED_SAT="med_sat";
    public static final String COL_MED_TAG="med_tag";
    public static final String COL_MED_STATUS="med";
    public static final String COL_MED_STATUS_SUN="sun";
    public static final String COL_MED_STATUS_MON="mon";
    public static final String COL_MED_STATUS_TUE="tue";
    public static final String COL_MED_STATUS_WED="wed";
    public static final String COL_MED_STATUS_THU="thu";
    public static final String COL_MED_STATUS_FRI="fri";
    public static final String COL_MED_STATUS_SAT="sat";
    public static final String COL_MED_TAKEN="med_taken";
    public static final String COL_MED_STATUS_NOTTAKEN="not";
    public static final String COL_MED_STATUS_TAKEN="taken";

    private static final String CREATE_APT_TABLE="CREATE TABLE IF NOT EXISTS " + TABLE_APT_NAME+"("+
            COL_APT_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            COL_APT_TITLE+" TEXT NOT NULL UNIQUE,"+COL_APT_DATETIME+" TEXT NOT NULL,"+
            COL_APT_TAG+" TEXT NOT NULL"+")";

    private static final String CREATE_MED_TABLE="CREATE TABLE IF NOT EXISTS " + TABLE_MED_NAME+"("+
            COL_MED_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            COL_MED_TITLE+" TEXT NOT NULL,"+ COL_MED_SUN+" TEXT NOT NULL,"+
            COL_MED_MON+" TEXT NOT NULL,"+ COL_MED_TUE+" TEXT NOT NULL,"+
            COL_MED_WED+" TEXT NOT NULL,"+ COL_MED_THU+" TEXT NOT NULL,"+
            COL_MED_FRI+" TEXT NOT NULL,"+ COL_MED_SAT+" TEXT NOT NULL,"+
            COL_MED_TIME+" TEXT NOT NULL,"+ COL_MED_DOSAGE+" TEXT NOT NULL,"+ COL_MED_TAKEN+" TEXT NOT NULL,"+
            COL_MED_TAG+" TEXT NOT NULL"+")";

    private static final String CREATE_WATER_TABLE="CREATE TABLE IF NOT EXISTS " + TABLE_WATER_NAME+"("+
            COL_WATER_ID+" INTEGER NOT NULL PRIMARY KEY,"+
            COL_WATER_INTAKE+" TEXT NOT NULL,"+ COL_WATER_TAG+" TEXT NOT NULL"+")";

    private static final String CREATE_GRAPH_TABLE="CREATE TABLE IF NOT EXISTS " + TABLE_GRAPH_NAME+"("+
            COL_GRAPH_ID+" INTEGER NOT NULL PRIMARY KEY,"+
            COL_GRAPH_ONTIME+" TEXT NOT NULL,"+
            COL_GRAPH_OUTOFRANGE+" TEXT NOT NULL,"+
            COL_GRAPH_NOTTAKEN+" TEXT NOT NULL,"+ COL_GRAPH_TAG+" TEXT NOT NULL"+")";

    private static final String DROP_APT_TABLE="DROP TABLE IF EXISTS " + TABLE_APT_NAME;

    private static final String DROP_MED_TABLE="DROP TABLE IF EXISTS " + TABLE_MED_NAME;

    private static final String DROP_WATER_TABLE="DROP TABLE IF EXISTS " + TABLE_WATER_NAME;

    private static final String DROP_GRAPH_TABLE="DROP TABLE IF EXISTS " + TABLE_GRAPH_NAME;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_APT_TABLE);
        sqLiteDatabase.execSQL(CREATE_MED_TABLE);
        sqLiteDatabase.execSQL(CREATE_WATER_TABLE);
        sqLiteDatabase.execSQL(CREATE_GRAPH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_APT_TABLE);
        sqLiteDatabase.execSQL(DROP_MED_TABLE);
        sqLiteDatabase.execSQL(DROP_WATER_TABLE);
        sqLiteDatabase.execSQL(DROP_GRAPH_TABLE);
        onCreate(sqLiteDatabase);
    }
}
