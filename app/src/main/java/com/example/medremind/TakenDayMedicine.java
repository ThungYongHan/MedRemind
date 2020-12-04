package com.example.medremind;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;

public class TakenDayMedicine extends AppCompatActivity {
    private RecyclerView medicine;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<MedicineModel> MedicineModels;
    private TakenMedicineAdapter takenmedicineListAdapter;
    private LinearLayout linearLayout;
    private MedDBHelper medDBHelper;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken_day_medicine);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Today's Taken Medicines");
        loadTakenMedicine();
    }

    private void loadTakenMedicine(){
        medicine=(RecyclerView)findViewById(R.id.taken_medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_takenmedicine_section);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
        case Calendar.SUNDAY:
        if(medDBHelper.countTakenMedSun()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchSunTakenMedicine();
            takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
        }
        break;
        case Calendar.MONDAY:
            if(medDBHelper.countTakenMedMon()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchMonTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        case Calendar.TUESDAY:
            if(medDBHelper.countTakenMedTue()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchTueTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        case Calendar.WEDNESDAY:
            if(medDBHelper.countTakenMedWed()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchWedTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        case Calendar.THURSDAY:
            if(medDBHelper.countTakenMedThu()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchThuTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        case Calendar.FRIDAY:
            if(medDBHelper.countTakenMedFri()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchFriTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        case Calendar.SATURDAY:
            if(medDBHelper.countTakenMedSat()==0){
                linearLayout.setVisibility(View.VISIBLE);
                medicine.setVisibility(View.GONE);
            }
            else{
                linearLayout.setVisibility(View.GONE);
                medicine.setVisibility(View.VISIBLE);
                MedicineModels=new ArrayList<>();
                MedicineModels=medDBHelper.fetchSatTakenMedicine();
                takenmedicineListAdapter=new TakenMedicineAdapter(MedicineModels,this);
            }
            break;
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(takenmedicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TakenDayMedicine.this,MainActivity.class));
    }

}