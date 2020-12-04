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

public class Appointments extends AppCompatActivity {
    private RecyclerView appointments;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<AppointmentModel> AppointmentModels;
    private AppointmentsAdapter appointmentsAdapter;
    private LinearLayout linearLayout;
    private AptDBHelper aptDBHelper;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadAppointments();
    }
    // display all appointments in recyclerview
    private void loadAppointments(){
        setTitle("Appointments");
        appointments=(RecyclerView)findViewById(R.id.appointments_view);
        aptDBHelper=new AptDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_appointments_section);
        if(aptDBHelper.countAppointments()==0){
            linearLayout.setVisibility(View.VISIBLE);
            appointments.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            appointments.setVisibility(View.VISIBLE);
            AppointmentModels=new ArrayList<>();
            AppointmentModels=aptDBHelper.fetchAllAppointments();
            appointmentsAdapter=new AppointmentsAdapter(AppointmentModels,this);
        }
            linearLayoutManager=new LinearLayoutManager(this);
            appointments.setAdapter(appointmentsAdapter);
            appointments.setLayoutManager(linearLayoutManager);
    }
    // display appointments due today in recyclerview
    private void loadTodayAppointments(){
        setTitle("Appointments For Today");
        appointments=(RecyclerView)findViewById(R.id.appointments_view);
        aptDBHelper=new AptDBHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.no_appointments_section);
        if(aptDBHelper.countAppointments()==0){
            linearLayout.setVisibility(View.VISIBLE);
            appointments.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.GONE);
            appointments.setVisibility(View.VISIBLE);
            AppointmentModels=new ArrayList<>();
            AppointmentModels=aptDBHelper.fetchTodayAppointments();
            appointmentsAdapter=new AppointmentsAdapter(AppointmentModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        appointments.setAdapter(appointmentsAdapter);
        appointments.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appointments_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view_today_appointments:
                loadTodayAppointments();
                return true;
            case R.id.view_all_appointments:
                loadAppointments();
                return true;
            case R.id.delete_all_appointments:
                deleteAptDialog();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    // appointment list deletion confirmation dialog box
    private void deleteAptDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Appointment List Deletion Confirmation");
        builder.setMessage("Do you want to delete all appointments in the appointment list?");
        builder.setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(aptDBHelper.removeAllApt()){
                    startActivity(new Intent(Appointments.this,Appointments.class));
                    Toast.makeText(Appointments.this, "All appointments in the appointments list have been deleted", Toast.LENGTH_SHORT).show();
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
    public void onBackPressed() {
        startActivity(new Intent(Appointments.this,MainActivity.class));
    }
}