package com.example.medremind;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.stetho.Stetho;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView daymedicine;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<MedicineModel> MedicineModels;
    private MedicineAdapter medicineAdapter;
    private LinearLayout linearLayout;
    private MediaPlayer mMediaPlayer, testMediaPlayer;
    private MedDBHelper medDBHelper;
    private WaterDBHelper waterDBHelper;
    private GraphDBHelper graphDBHelper;
    private AptDBHelper aptDBHelper;
    private ImageButton mAddWater;
    int idtest;
    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond, tvTest;
    Context mContext = this;
    private Handler handler;
    private Runnable runnable;
    private String getAptTitleString;
    private String intakeNum;
    private String onTimeSun;
    private String outOfRangeSun;
    private String notTakenSun;
    private String onTimeMon;
    private String outOfRangeMon;
    private String notTakenMon;
    private String onTimeTue;
    private String outOfRangeTue;
    private String notTakenTue;
    private String onTimeWed;
    private String outOfRangeWed;
    private String notTakenWed;
    private String onTimeThu;
    private String outOfRangeThu;
    private String notTakenThu;
    private String onTimeFri;
    private String outOfRangeFri;
    private String notTakenFri;
    private String onTimeSat;
    private String outOfRangeSat;
    private String notTakenSat;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // start MyService
        startService(new Intent(getApplicationContext(),MyService.class));
        super.onCreate(savedInstanceState);
        // set navigation menu
        setContentView(R.layout.slide_main);
        // load medicines that are still not taken for that day
        loadDayMedicine();

        handler = new Handler();
        runnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                // get current time
                Calendar calendar = Calendar.getInstance(Locale.getDefault());
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                //  if current time is 00:00:00
                if (hour==0){
                    if (minute==0){
                        if (second==0){
                            // reset taken medicine and water intake
                            medDBHelper.removeTakenSun("sun");
                            medDBHelper.removeTakenMon("mon");
                            medDBHelper.removeTakenTue("tue");
                            medDBHelper.removeTakenWed("wed");
                            medDBHelper.removeTakenThu("thu");
                            medDBHelper.removeTakenFri("fri");
                            medDBHelper.removeTakenSat("sat");
                            waterDBHelper.removeWaterIntake(1);
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                            // restart MainActivity
                            MainActivity.this.startActivity(intent);
                        }
                    }
                }
                Calendar takencalendar = Calendar.getInstance();
                // get day of the week of current day
                int day = takencalendar.get(Calendar.DAY_OF_WEEK);
                switch (day) {
                    // if current day is sunday
                    case Calendar.SUNDAY:
                        //  if current time is 00:00:00
                        if (hour==0){
                            if (minute==0){
                                if (second==0){
                                    // reset weekly medicine graph statistics
                                    graphDBHelper.removeGraphIntake(1);
                                    graphDBHelper.removeGraphIntake(2);
                                    graphDBHelper.removeGraphIntake(3);
                                    graphDBHelper.removeGraphIntake(4);
                                    graphDBHelper.removeGraphIntake(5);
                                    graphDBHelper.removeGraphIntake(6);
                                    graphDBHelper.removeGraphIntake(7);
                                }
                            }
                        }
                        // if current time is 23:59:59
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenSun = graphDBHelper.fetchGraphNotTaken(1);
                                    // update not taken medicine statistics for sunday
                                    graphDBHelper.updateGraphSunNotTakenModel(new GraphModel(onTimeSun, outOfRangeSun, notTakenSun));
                                }
                            }
                        }
                        break;
                    case Calendar.MONDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenMon = graphDBHelper.fetchGraphNotTaken(2);
                                    // update not taken medicine statistics for monday
                                    graphDBHelper.updateGraphMonNotTakenModel(new GraphModel(onTimeMon, outOfRangeMon, notTakenMon));
                                }
                            }
                        }
                        break;
                    case Calendar.TUESDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenTue = graphDBHelper.fetchGraphNotTaken(3);
                                    // update not taken medicine statistics for tuesday
                                    graphDBHelper.updateGraphTueNotTakenModel(new GraphModel(onTimeTue, outOfRangeTue, notTakenTue));
                                }
                            }
                        }
                        break;
                    case Calendar.WEDNESDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenWed = graphDBHelper.fetchGraphNotTaken(4);
                                    // update not taken medicine statistics for wednesday
                                    graphDBHelper.updateGraphWedNotTakenModel(new GraphModel(onTimeWed, outOfRangeWed, notTakenWed));
                                }
                            }
                        }
                        break;
                    case Calendar.THURSDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenThu = graphDBHelper.fetchGraphNotTaken(5);
                                    // update not taken medicine statistics for thursday
                                    graphDBHelper.updateGraphThuNotTakenModel(new GraphModel(onTimeThu, outOfRangeThu, notTakenThu));
                                }
                            }
                        }
                        break;
                    case Calendar.FRIDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenFri = graphDBHelper.fetchGraphNotTaken(6);
                                    // update not taken medicine statistics for friday
                                    graphDBHelper.updateGraphFriNotTakenModel(new GraphModel(onTimeFri, outOfRangeFri, notTakenFri));
                                }
                            }
                        }
                        break;
                    case Calendar.SATURDAY:
                        if (hour==23){
                            if (minute==59){
                                if (second==59){
                                    notTakenSat = graphDBHelper.fetchGraphNotTaken(7);
                                    // update not taken medicine statistics for saturday
                                    graphDBHelper.updateGraphSatNotTakenModel(new GraphModel(onTimeSat, outOfRangeSat, notTakenSat));
                                }
                            }
                        }
                        break;
                }

                // run these codes every second
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1 * 1000);

        waterDBHelper = new WaterDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);

        aptDBHelper = new AptDBHelper(mContext);
        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvTest = (TextView) findViewById(R.id.textView4);
        // if no columns in the water table is found
        if (waterDBHelper.countWater()==0){
            waterDBHelper.setWaterModel(new WaterModel("0"));
        }
        // if no columns in the graph table is found
        if (graphDBHelper.countGraph()==0){
            graphDBHelper.setGraphSunModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphMonModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphTueModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphWedModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphThuModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphFriModel(new GraphModel("0", "0", "0"));
            graphDBHelper.setGraphSatModel(new GraphModel("0", "0", "0"));
        }

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        showDrawerLayout();
        navigationMenuInit();

        // appointment title spinner
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>appointmentModelArrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,aptDBHelper.fetchAptStrings());
        appointmentModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(appointmentModelArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getAptTitleString=adapterView.getItemAtPosition(i).toString();
                idtest = aptDBHelper.fetchAptID(getAptTitleString);
                countDownStart();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // fetch water of id 1 (the only water id)
        intakeNum = waterDBHelper.fetchWaterIntake(1);
        mAddWater = (ImageButton) findViewById(R.id.wateraddBtn);
        final TextView text = (TextView)findViewById(R.id.textView2);
        // final String intakeNum = waterDBHelper.fetchWaterIntake(1);
        text.setText("Water Intake of The Day: " + intakeNum);
        mAddWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterDBHelper.updateWaterModel(new WaterModel(intakeNum));
                intakeNum = waterDBHelper.fetchWaterIntake(1);
                text.setText("Water Intake of The Day: " + intakeNum);
            }
        });
    }
    // countdown timer function that runs every second and displays the difference between current datetime
    // and datetime of the appointment selected in appointment spinner
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");
                    // parse selected appointment in spinner's datetime to dateFormat format
                    Date futureDate = dateFormat.parse(aptDBHelper.fetchAptDateTime(idtest));
                    // get current datetime
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        // get time difference of selected appointment datetime and current datetime
                        long diff = futureDate.getTime() - currentDate.getTime();
                        // calculation for countdown timer
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff = diff - days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff = diff - hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff = diff - minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        // set text after formatting into 2-char string
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText("" + String.format("%02d", minutes));
                        txtTimerSecond.setText("" + String.format("%02d", seconds));
                    }
                    // if the current datetime is after selected appointment's datetime
                    else {
                        txtTimerDay.setText("00");
                        txtTimerHour.setText("00");
                        txtTimerMinute.setText("00");
                        txtTimerSecond.setText("00");
                    }
                } catch (Exception e) {
                    // to more accurately diagnose exceptions with the exact line and method that raised the exception
                    e.printStackTrace(); }}};
        // run the code every second
        handler.postDelayed(runnable, 1 * 1000);
    }

    private void navigationMenuInit(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // construct navigation drawer
    private void showDrawerLayout(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,(Toolbar) findViewById(R.id.toolbar) , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        // sync drawer icon
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        // if user selects navigation menu item
        if (id == R.id.new_appointments) {
            // start NewAppointments activity
            startActivity(new Intent(this,NewAppointments.class));
        }
        else if (id == R.id.appointments_list) {
            startActivity(new Intent(this,Appointments.class));
        }
        else if (id == R.id.new_medicine) {
            startActivity(new Intent(this,NewMedicine.class));
        }
        else if (id == R.id.medicines_list) {
            startActivity(new Intent(this,Medicine.class));
        }
        else if (id == R.id.taken_medicines_list) {
            startActivity(new Intent(this,TakenDayMedicine.class));
        }
        else if (id == R.id.graph_function) {
            startActivity(new Intent(this,Graphing.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // close drawer and it moves to the left
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // load non-taken medicines for the day
    private void loadDayMedicine(){
        daymedicine=(RecyclerView)findViewById(R.id.daymedicines_view);
        medDBHelper=new MedDBHelper(this);
        if(medDBHelper.countMedicine()==0){
            daymedicine.setVisibility(View.GONE);
        }
        else{
            daymedicine.setVisibility(View.VISIBLE);
            MedicineModels=new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.SUNDAY:
                    MedicineModels=medDBHelper.fetchMedSun();
                    handler = new Handler();
                    runnable = new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            sundayTest();
                            // run these codes every 20 seconds
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);
                    // get current time
                    String sundayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                    // if no non-taken medicine is found with the same intake time as current time
                    if (!medDBHelper.fetchMedTimeSun(sundayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeSun(sundayTime);
                        int MedSunTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedSunTitleID);

                        String strGetMedSunTimeID =  medDBHelper.fetchMedTimeSun(sundayTime);
                        final int MedSunTimeID = Integer.parseInt(strGetMedSunTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedSunTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        // set the MediaPlayer to loop
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeSun = graphDBHelper.fetchGraphOnTime(1);
                                // update intake on time statistics for sunday if user clicks yes
                                graphDBHelper.updateGraphSunOnTimeModel(new GraphModel(onTimeSun, outOfRangeSun, notTakenSun));

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                // stop vibration
                                v.cancel();
                                medDBHelper.makeTakenMed(MedSunTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                MainActivity.this.finish();
                                // remove flashing animation
                                MainActivity.this.overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                MainActivity.this.overridePendingTransition(0,0);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                // dismiss and remove dialog from screen
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;

                case Calendar.MONDAY:
                    MedicineModels=medDBHelper.fetchMedMon();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            mondayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);

                    // get current time (might have to remove final)
                    String mondayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    if (!medDBHelper.fetchMedTimeMon(mondayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeMon(mondayTime);
                        int MedMonTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedMonTitleID);

                        String strGetMedMonTimeID =  medDBHelper.fetchMedTimeMon(mondayTime);
                        final int MedMonTimeID = Integer.parseInt(strGetMedMonTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedMonTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();

                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeMon = graphDBHelper.fetchGraphOnTime(2);
                                graphDBHelper.updateGraphMonOnTimeModel(new GraphModel(onTimeMon, outOfRangeMon, notTakenMon));

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();

                                v.cancel();
                                medDBHelper.makeTakenMed(MedMonTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                ((MainActivity)MainActivity.this).finish();
                                // remove flashing animation
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;

                case Calendar.TUESDAY:
                    MedicineModels=medDBHelper.fetchMedTue();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            tuesdayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);

                    // get current time
                    String tuesdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    if (!medDBHelper.fetchMedTimeTue(tuesdayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeTue(tuesdayTime);
                        int MedTueTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedTueTitleID);

                        String strGetMedTueTimeID =  medDBHelper.fetchMedTimeTue(tuesdayTime);
                        final int MedTueTimeID = Integer.parseInt(strGetMedTueTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedTueTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeTue = graphDBHelper.fetchGraphOnTime(3);
                                graphDBHelper.updateGraphTueOnTimeModel(new GraphModel(onTimeTue, outOfRangeTue, notTakenTue));

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();

                                v.cancel();
                                medDBHelper.makeTakenMed(MedTueTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                ((MainActivity)MainActivity.this).finish();
                                // remove flashing animation
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;

                case Calendar.WEDNESDAY:
                    MedicineModels=medDBHelper.fetchMedWed();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            wednesdayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);
                        // get current time
                        String wednesdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                        if (!medDBHelper.fetchMedTimeWed(wednesdayTime).equals("")){
                            String strCurrentMedTitle =  medDBHelper.fetchMedTimeWed(wednesdayTime);
                            int MedWedTitleID = Integer.parseInt(strCurrentMedTitle);
                            String currentMedTitle = medDBHelper.fetchMedTitle(MedWedTitleID);

                            String strGetMedWedTimeID =  medDBHelper.fetchMedTimeWed(wednesdayTime);
                            final int MedWedTimeID = Integer.parseInt(strGetMedWedTimeID);
                            String currentMedTime = medDBHelper.fetchMedTime(MedWedTimeID);

                            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            long[] pattern = {0, 100, 1000};
                            v.vibrate(pattern, 0);

                            mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                            mMediaPlayer.setLooping(true);
                            mMediaPlayer.start();
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("Medicine Alert");
                            builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    onTimeWed = graphDBHelper.fetchGraphOnTime(4);
                                    graphDBHelper.updateGraphWedOnTimeModel(new GraphModel(onTimeWed, outOfRangeWed, notTakenWed));

                                    mMediaPlayer.stop();
                                    mMediaPlayer.reset();
                                    // release to save system resources
                                    mMediaPlayer.release();

                                    v.cancel();
                                    medDBHelper.makeTakenMed(MedWedTimeID);
                                    Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                    // restart activity to reflect changes
                                    ((MainActivity)MainActivity.this).finish();
                                    // remove flashing animation
                                    ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                    MainActivity.this.startActivity(intent);
                                    ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mMediaPlayer.stop();
                                    mMediaPlayer.reset();
                                    mMediaPlayer.release();
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    break;

                case Calendar.THURSDAY:
                    MedicineModels=medDBHelper.fetchMedThu();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            thursdayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);
                    // get current time
                    String thursdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    if (!medDBHelper.fetchMedTimeThu(thursdayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeThu(thursdayTime);
                        int MedThuTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedThuTitleID);

                        String strGetMedThuTimeID =  medDBHelper.fetchMedTimeThu(thursdayTime);
                        final int MedThuTimeID = Integer.parseInt(strGetMedThuTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedThuTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeThu = graphDBHelper.fetchGraphOnTime(5);
                                graphDBHelper.updateGraphThuOnTimeModel(new GraphModel(onTimeThu, outOfRangeThu, notTakenThu));
/*                                graphDBHelper.updateOnTimeModel(new GraphModel(intakeNum));
                                intakeNum = waterDBHelper.fetchWaterIntake(1);*/

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                v.cancel();
                                medDBHelper.makeTakenMed(MedThuTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                ((MainActivity)MainActivity.this).finish();
                                // remove flashing animation
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;

                case Calendar.FRIDAY:
                    MedicineModels=medDBHelper.fetchMedFri();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            fridayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);
                    // get current time
                    String fridayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    if (!medDBHelper.fetchMedTimeFri(fridayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeFri(fridayTime);
                        int MedFriTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedFriTitleID);

                        String strGetMedFriTimeID =  medDBHelper.fetchMedTimeFri(fridayTime);
                        final int MedFriTimeID = Integer.parseInt(strGetMedFriTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedFriTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeFri = graphDBHelper.fetchGraphOnTime(6);
                                graphDBHelper.updateGraphFriOnTimeModel(new GraphModel(onTimeFri, outOfRangeFri, notTakenFri));

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();

                                v.cancel();
                                medDBHelper.makeTakenMed(MedFriTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                ((MainActivity)MainActivity.this).finish();
                                // remove flashing animation
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;

                case Calendar.SATURDAY:
                    MedicineModels=medDBHelper.fetchMedSat();
                    handler = new Handler();
                    runnable = new Runnable() {

                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void run() {
                            saturdayTest();
                            handler.postDelayed(this, 20000);
                        }
                    };
                    handler.postDelayed(runnable, 1 * 20000);
                    // get current time
                    String saturdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    if (!medDBHelper.fetchMedTimeSat(saturdayTime).equals("")){
                        String strCurrentMedTitle =  medDBHelper.fetchMedTimeSat(saturdayTime);
                        int MedSatTitleID = Integer.parseInt(strCurrentMedTitle);
                        String currentMedTitle = medDBHelper.fetchMedTitle(MedSatTitleID);

                        String strGetMedSatTimeID =  medDBHelper.fetchMedTimeSat(saturdayTime);
                        final int MedSatTimeID = Integer.parseInt(strGetMedSatTimeID);
                        String currentMedTime = medDBHelper.fetchMedTime(MedSatTimeID);

                        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        v.vibrate(pattern, 0);

                        mMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
                        mMediaPlayer.setLooping(true);
                        mMediaPlayer.start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Medicine Alert");
                        builder.setMessage("Please take your medicine: " + currentMedTitle + " - " + currentMedTime);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                onTimeSat = graphDBHelper.fetchGraphOnTime(7);
                                graphDBHelper.updateGraphSatOnTimeModel(new GraphModel(onTimeSat, outOfRangeSat, notTakenSat));

                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();

                                v.cancel();
                                medDBHelper.makeTakenMed(MedSatTimeID);
                                Toast.makeText(MainActivity.this, "Medicine has been taken", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                // restart activity to reflect changes
                                ((MainActivity)MainActivity.this).finish();
                                // remove flashing animation
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);
                                MainActivity.this.startActivity(intent);
                                ((MainActivity)MainActivity.this).overridePendingTransition(0,0);

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mMediaPlayer.stop();
                                mMediaPlayer.reset();
                                mMediaPlayer.release();
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;
            }
            medicineAdapter=new MedicineAdapter(MedicineModels,this);
        }
        linearLayoutManager=new LinearLayoutManager(this);
        daymedicine.setAdapter(medicineAdapter);
        daymedicine.setLayoutManager(linearLayoutManager);
    }
    // options menu for MainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainactivity_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_all_taken:
                removeTakenDialog();
                return true;
            case R.id.remove_water_intake:
                removeWaterIntakeDialog();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // entire taken medicine list reset confirmation dialog
    private void removeTakenDialog(){
        androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Taken Medicine List Reset Confirmation");
        builder.setMessage("Do you want to reset the taken medicine list?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(medDBHelper.removeTakenSun("sun") && medDBHelper.removeTakenMon("mon") && medDBHelper.removeTakenTue("tue") && medDBHelper.removeTakenWed("wed") && medDBHelper.removeTakenThu("thu") && medDBHelper.removeTakenFri("fri")  && medDBHelper.removeTakenSat("sat") ){
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                    Toast.makeText(MainActivity.this, "The taken medicine list has been reset", Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    // reset water intake for the day confirmation dialog
    private void removeWaterIntakeDialog(){
        androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Water Intake Reset Confirmation");
        builder.setMessage("Do you want to reset the water intake?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(waterDBHelper.removeWaterIntake(1)){
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                    Toast.makeText(MainActivity.this, "The water intake has been reset", Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void sundayTest() {
        String sundayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeSun(sundayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();

        } else {
            show_Notification();
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 1000};
            v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000); //set your time in milliseconds
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void mondayTest() {
        String mondayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeMon(mondayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();
        } else {
             show_Notification();
             final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
             long[] pattern = {0, 100, 1000};
             v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000);
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void tuesdayTest() {
        String tuesdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeTue(tuesdayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();
        } else {
            show_Notification();
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 1000};
            v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000);
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void wednesdayTest() {
        String wednesdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeWed(wednesdayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();

        } else {
            show_Notification();
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 1000};
            v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000);
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void thursdayTest() {
        String thursdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeThu(thursdayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();

        } else {
            show_Notification();
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 1000};
            v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000);
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void fridayTest() {
        String fridayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);

        if (medDBHelper.fetchMedTimeFri(fridayTime).equals("")) {
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();

        } else {
            show_Notification();
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 1000};
            v.vibrate(pattern, -1);
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            if (!isScreenOn) {
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                wl.acquire(3000);
            }
            testMediaPlayer.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    // called every 20 seconds by handler and runnable in loadDayMedicines()
    private void saturdayTest() {
        // get current time in "HH:mm" format
        String saturdayTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        // create MediaPlayer with alarm sound file as parameter
        testMediaPlayer = MediaPlayer.create(this, R.raw.cuco_sound);
        // if no medicine with same intake time as current time is found
        if (medDBHelper.fetchMedTimeSat(saturdayTime).equals("")) {
            // stops testMediaPlayer if playback has been started
            testMediaPlayer.stop();
            testMediaPlayer.reset();
            testMediaPlayer.release();
        } else {
            show_Notification();
            // get a Vibrator instance
            final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // vibration pattern
            long[] pattern = {0, 100, 1000};
            // vibrate once
            v.vibrate(pattern, -1);
            // get PowerManager instance
            PowerManager pm = (PowerManager) MainActivity.this.getSystemService(Context.POWER_SERVICE);
            boolean isScreenOn = Build.VERSION.SDK_INT >= 20 ? pm.isInteractive() : pm.isScreenOn();
            // if screen is not interactive
            if (!isScreenOn) {
                // wakelock to light up the screen when notification is received
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "myApp:notificationLock");
                // acquires wakelock and releases after 3 seconds
                wl.acquire(3000);
            }
            // starts testMediaPlayer playback
            testMediaPlayer.start();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    // show notification function that is called by dayTest() when there is non-taken medicine with same intake time as current time
    public void show_Notification(){
        // intent to start MainActivity when notification is tapped
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        String CHANNEL_ID="MYCHANNEL";
        // construct notification channel with unique channel id, name and importance level
        NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,"name",NotificationManager.IMPORTANCE_HIGH);
        // set PendingIntent with requestCode, which intent to launch and what flags to set
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        // constructs new builder and constructed notification will be posted on this NotificationChannel
        Notification notification=new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentText("Medicine intake reminder")
                .setContentTitle("MedRemind")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.pushv2)
                .setAutoCancel(true)
                // build notification with above options
                .build();
        // retrieve a NotificationManager instance
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // create a notification channel that notifications can be posted to
        notificationManager.createNotificationChannel(notificationChannel);
        // post notification with id as 1
        notificationManager.notify(1,notification);
    }
}


