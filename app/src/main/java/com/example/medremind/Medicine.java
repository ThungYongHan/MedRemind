package com.example.medremind;

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

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Medicine extends AppCompatActivity {
    private RecyclerView medicine;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<MedicineModel> MedicineModels;
    private MedicineListAdapter medicineListAdapter;
    private LinearLayout linearLayout;
    private MedDBHelper medDBHelper;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Medicines");
        loadMedicine();
    }
    // load all medicines
    private void loadMedicine(){
        setTitle("Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchAllMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load sunday medicines
    private void loadSunMedicine(){
        setTitle("Sunday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchSunMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load monday medicines
    private void loadMonMedicine(){
        setTitle("Monday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchMonMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load tuesday medicines
    private void loadTueMedicine(){
        setTitle("Tuesday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchTueMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load wednesday medicines
    private void loadWedMedicine(){
        setTitle("Wednesday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchWedMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load thursday medicines
    private void loadThuMedicine(){
        setTitle("Thursday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchThuMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load friday medicines
    private void loadFriMedicine(){
        setTitle("Friday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchFriMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }
    // load saturday medicines
    private void loadSatMedicine(){
        setTitle("Saturday's Medicines");
        medicine=(RecyclerView)findViewById(R.id.medicine_view);
        medDBHelper=new MedDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_medicine_section);
        if(medDBHelper.countMedicine()==0){
            linearLayout.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            medicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            MedicineModels=medDBHelper.fetchSatMedicine();
            medicineListAdapter=new MedicineListAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        medicine.setAdapter(medicineListAdapter);
        medicine.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.medicine_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_medicines:
                deleteAllMedDialog();
                return true;
            case R.id.view_sun_med:
                loadSunMedicine();
                return true;
            case R.id.view_mon_med:
                loadMonMedicine();
                return true;
            case R.id.view_tue_med:
                loadTueMedicine();
                return true;
            case R.id.view_wed_med:
                loadWedMedicine();
                return true;
            case R.id.view_thu_med:
                loadThuMedicine();
                return true;
            case R.id.view_fri_med:
                loadFriMedicine();
                return true;
            case R.id.view_sat_med:
                loadSatMedicine();
                return true;
            case R.id.view_all_med:
                loadMedicine();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // confirmation dialog for medicine list deletion
    private void deleteAllMedDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Medicine List Deletion Confirmation");
        builder.setMessage("Do you want to delete all medicines in the medicine list?");
        builder.setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(medDBHelper.removeAllMed()){
                    startActivity(new Intent(Medicine.this,Medicine.class));
                    Toast.makeText(Medicine.this, "All medicines have been deleted", Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    @Override
    // called when back button is pressed
    public void onBackPressed() {
        startActivity(new Intent(Medicine.this,MainActivity.class));
    }
}