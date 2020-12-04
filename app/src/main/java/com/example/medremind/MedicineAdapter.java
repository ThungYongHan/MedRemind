package com.example.medremind;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
// for the medicines with intake time of today
public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineDataHolder>{
    private ArrayList<MedicineModel> medicineModels;
    private Context context;
    private MedDBHelper medDBHelper;
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
    private GraphDBHelper graphDBHelper;

    public MedicineAdapter(ArrayList<MedicineModel> medicineModels, Context context){
        this.medicineModels=medicineModels;
        this.context=context;
    }

    @NonNull
    @Override
    public MedicineAdapter.MedicineDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_daymedicine_layout,parent,false);
        return new MedicineDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.MedicineDataHolder holder, int position) {
        medDBHelper = new MedDBHelper(context);
        graphDBHelper = new GraphDBHelper(context);

        final MedicineModel medicineModel=medicineModels.get(position);
        Date currentTime = null, previousTime = null;
        String strTime = medicineModel.getMedTime();
        String strhour = strTime.substring(0,2);
        String strminute = strTime.substring(3,5);
        String totaltime = strhour + ":" +strminute;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            previousTime = dateFormat.parse(totaltime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String nowdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        String nowhour = nowdate.substring(11,13);
        String nowminute = nowdate.substring(14,16);
        String nowtotaltime = nowhour + ":" +nowminute;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            currentTime = format.parse(nowtotaltime);
            System.out.println(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // if current time is after medicine intake time
        if(currentTime.after(previousTime)){
            // set exclamation icon as visible
            holder.alert_taken.setVisibility(View.VISIBLE);
        }
        else{
            holder.alert_taken.setVisibility(View.INVISIBLE);
        }
        holder.medTitle.setText(medicineModel.getMedTitle());
        holder.medTime.setText(medicineModel.getMedTime());
        holder.medDosage.setText(medicineModel.getMedDosage());
        holder.make_taken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takenDialog(medicineModel.getMedID());
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicineModels.size();
    }

    public class MedicineDataHolder extends RecyclerView.ViewHolder{
        TextView medTitle, medTime, medDosage;
        ImageView make_taken, alert_taken;
        public MedicineDataHolder(@NonNull View itemView) {
            super(itemView);
            medTitle=(TextView)itemView.findViewById(R.id.medTitle);
            medTime=(TextView)itemView.findViewById(R.id.medTime);
            medDosage=(TextView)itemView.findViewById(R.id.medDosage);
            make_taken=(ImageView)itemView.findViewById(R.id.make_taken);
            alert_taken=(ImageView)itemView.findViewById(R.id.alert_taken);
        }
    }
    // medicine intake confirmation dialog
    private void takenDialog(final int medID){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Have you taken this medicine?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                switch (day) {
                    case Calendar.SUNDAY:
                        outOfRangeSun = graphDBHelper.fetchGraphOutOfRange(1);
                        // update out of range column for sunday graph
                        graphDBHelper.updateGraphSunOutOfRangeModel(new GraphModel(onTimeSun, outOfRangeSun, notTakenSun));
                        break;
                    case Calendar.MONDAY:
                        outOfRangeMon = graphDBHelper.fetchGraphOutOfRange(2);
                        graphDBHelper.updateGraphMonOutOfRangeModel(new GraphModel(onTimeMon, outOfRangeMon, notTakenMon));
                        break;
                    case Calendar.TUESDAY:
                        outOfRangeTue = graphDBHelper.fetchGraphOutOfRange(3);
                        graphDBHelper.updateGraphTueOutOfRangeModel(new GraphModel(onTimeTue, outOfRangeTue, notTakenTue));
                        break;
                    case Calendar.WEDNESDAY:
                        outOfRangeWed = graphDBHelper.fetchGraphOutOfRange(4);
                        graphDBHelper.updateGraphWedOutOfRangeModel(new GraphModel(onTimeWed, outOfRangeWed, notTakenWed));
                        break;
                    case Calendar.THURSDAY:
                        outOfRangeThu = graphDBHelper.fetchGraphOutOfRange(5);
                        graphDBHelper.updateGraphThuOutOfRangeModel(new GraphModel(onTimeThu, outOfRangeThu, notTakenThu));
                        break;
                    case Calendar.FRIDAY:
                        outOfRangeFri = graphDBHelper.fetchGraphOutOfRange(6);
                        graphDBHelper.updateGraphFriOutOfRangeModel(new GraphModel(onTimeFri, outOfRangeFri, notTakenFri));
                        break;
                    case Calendar.SATURDAY:
                        outOfRangeSat = graphDBHelper.fetchGraphOutOfRange(7);
                        graphDBHelper.updateGraphSatOutOfRangeModel(new GraphModel(onTimeSat, outOfRangeSat, notTakenSat));
                        break;
                }
                medDBHelper.makeTakenMed(medID);
                Toast.makeText(context, "Medicine has been set as taken", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity.class);
                // restart activity to reflect changes
                ((MainActivity)context).finish();
                // remove flashing animation
                ((MainActivity)context).overridePendingTransition(0,0);
                context.startActivity(intent);
                ((MainActivity)context).overridePendingTransition(0,0);

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
