package com.example.medremind;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class NewMedicine extends AppCompatActivity {
    private TextView tvTime;
    private EditText etMedName, etDose;
    String medTitle, medDose, medTime;
    String sun = "0";
    String mon = "0";
    String tue = "0";
    String wed = "0";
    String thu = "0";
    String fri = "0";
    String sat = "0";
    String strHour="";
    String strMin="";
    CheckBox cbSun, cbMon, cbTue, cbWed, cbThu, cbFri, cbSat;
    private Button btAddMed;
    private MedDBHelper medDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        medDBHelper = new MedDBHelper(this);
        cbSun = (CheckBox) findViewById(R.id.cbSun);
        cbMon = (CheckBox) findViewById(R.id.cbMon);
        cbTue = (CheckBox) findViewById(R.id.cbTue);
        cbWed = (CheckBox) findViewById(R.id.cbWed);
        cbThu = (CheckBox) findViewById(R.id.cbThu);
        cbFri = (CheckBox) findViewById(R.id.cbFri);
        cbSat = (CheckBox) findViewById(R.id.cbSat);
        btAddMed = (Button) findViewById(R.id.btAddMed);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmedicine);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // set title for activity
        setTitle("New Medicine");
    }
    // select medicine intake time
    public void medicineTimeSelect(View view){
        tvTime = (TextView) findViewById(R.id.tvTime);
        Calendar mCurrentTime = Calendar.getInstance();
        int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mCurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(NewMedicine.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timepicker, int selectedHour, int selectedMinute) {
                if (selectedHour<10){
                     strHour = "0"+Integer.toString(selectedHour);
                }
                else{
                    strHour = Integer.toString(selectedHour);
                }
                if (selectedMinute<10){
                    strMin = "0"+Integer.toString(selectedMinute);
                }
                else{
                    strMin = Integer.toString(selectedMinute);
                }
                tvTime.setText(strHour + ":" + strMin);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    // check box for intake day
    public void onCheckBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.cbSun:
                if (checked){
                    sun = "sun";
                }
                else{
                    sun = "0";
                }
                break;
            case R.id.cbMon:
                if (checked){
                    mon = "mon";
                }
                else{
                    mon = "0";
                }
                break;
            case R.id.cbTue:
                if (checked){
                    tue = "tue";
                }
                else{
                    tue = "0";
                }
                break;
            case R.id.cbWed:
                if (checked){
                    wed = "wed";
                }
                else{
                    wed = "0";
                }
                break;
            case R.id.cbThu:
                if (checked){
                    thu = "thu";
                }
                else{
                    thu = "0";
                }
                break;
            case R.id.cbFri:
                if (checked){
                    fri = "fri";
                }
                else{
                    fri = "0";
                }
                break;
            case R.id.cbSat:
                if (checked){
                    sat = "sat";
                }
                else{
                    sat = "0";
                }
                break;
        }
    }

    public void checkMedicineDetails(View view) {
        etMedName = findViewById(R.id.etMedName);
        medTitle = etMedName.getText().toString();
        tvTime = findViewById(R.id.tvTime);
        medTime = tvTime.getText().toString();
        etDose = findViewById(R.id.etDose);
        medDose = etDose.getText().toString();
        // if medicine title input is empty
        if (medTitle.equalsIgnoreCase("")) {
            // set error message
            etMedName.setError("Please enter medicine name!");
        }
        // if medicine intake time is still the default "Intake Time"
        else if (medTime.equalsIgnoreCase("Intake Time")) {
            tvTime.setError("Please choose medicine intake time!");
        }
        else if (medDose.equalsIgnoreCase("")) {
            etDose.setError("Please enter medicine dosage!");
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add New Medicine Details\n" + medTitle + "/" + medTime + "/" + medDose);
            builder.setMessage("Are you sure?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    medTitle = etMedName.getText().toString();
                    medDose = etDose.getText().toString();
                    medDBHelper.addNewMedicine(new MedicineModel(medTitle, sun, mon, tue, wed, thu, fri, sat, medTime, medDose));
                    Intent i = new Intent(getApplicationContext(), NewMedicine.class);
                    startActivity(i);
                    Toast.makeText(NewMedicine.this, "Medicine has been added", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNeutralButton("Yes And Add More Intake Times", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    medTitle = etMedName.getText().toString();
                    medDose = etDose.getText().toString();
                    medDBHelper.addNewMedicine(new MedicineModel(medTitle, sun, mon, tue, wed, thu, fri, sat, medTime, medDose));
                    Toast.makeText(NewMedicine.this, "Medicine has been added", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewMedicine.this,MainActivity.class));
    }
}