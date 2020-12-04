package com.example.medremind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class NewAppointments extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener  {
    TextView textView;
    Button button;
    String time;
    EditText etAptTitle;
    String aptTitle;
    private AptDBHelper aptDBHelper;
    String strHour="";
    String strMin="";
    String strMonth="";
    String strDay="";
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("New Appointment");
        aptDBHelper = new AptDBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newappointments);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnPick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aptTitle = etAptTitle.getText().toString();
                if (aptTitle.equalsIgnoreCase("")){
                    etAptTitle.setError("Please enter appointment title!");
                }
                else {
                    Calendar calendar = Calendar.getInstance();
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    day = calendar.get(Calendar.DAY_OF_MONTH);
                    // populate DatePickerDialog with data of current year, month and day
                    DatePickerDialog datePickerDialog = new DatePickerDialog(NewAppointments.this, NewAppointments.this, year, month, day);
                    datePickerDialog.show();
                }
            }
        });
        etAptTitle = findViewById(R.id.etAptTitle);
        aptTitle = etAptTitle.getText().toString();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = dayOfMonth;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(NewAppointments.this, NewAppointments.this, hour, minute, true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        int testMonth;
        testMonth = myMonth + 1;
        if (myMonth<10){
            strMonth = "0"+Integer.toString(testMonth);
        }
        else{
            strMonth = Integer.toString(testMonth);
        }
        if (myday<10){
            strDay = "0"+Integer.toString(myday);
        }
        else{
            strDay = Integer.toString(myday);
        }
        if (myHour<10){
            strHour = "0"+Integer.toString(myHour);
        }
        else{
            strHour = Integer.toString(myHour);
        }
        if (minute<10){
            strMin = "0"+Integer.toString(minute);
        }
        else{
            strMin = Integer.toString(minute);
        }
        myMinute = minute;
       // yyyy-MM-dd, hh:mm:ss
        time = myYear + "-" +
                "" + (strMonth) + "-" +
                "" + strDay +
                ", " + strHour + ":" +
                strMin + ":" +
                "00";
        aptTitle = etAptTitle.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Appointment Details\n" + aptTitle + " : " + time);
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aptTitle = etAptTitle.getText().toString();
                aptDBHelper.addNewAppointment(new AppointmentModel(aptTitle, time));
                Intent i = new Intent(getApplicationContext(), Appointments.class);
                startActivity(i);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewAppointments.this,MainActivity.class));
    }
}