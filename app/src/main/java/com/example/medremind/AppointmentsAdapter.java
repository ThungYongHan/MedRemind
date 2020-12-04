package com.example.medremind;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.graphics.Color.BLUE;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentDataHolder>{
    private ArrayList<AppointmentModel> appoinmentModels;
    private Context context;
    private AptDBHelper aptDBHelper;
    public AppointmentsAdapter(ArrayList<AppointmentModel> appoinmentModels, Context context){
        this.appoinmentModels=appoinmentModels;
        this.context=context;
    }

    @NonNull
    @Override
    public AppointmentsAdapter.AppointmentDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_appointment_layout,parent,false);
        return new AppointmentDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapter.AppointmentDataHolder holder, int position) {
        aptDBHelper = new AptDBHelper(context);
        final AppointmentModel appointmentModel=appoinmentModels.get(position);
        Date currentTime = null, previousTime = null;
        String strTime = appointmentModel.getAptDateTime();
        // substring function to separate appointment datetime into separate hour, minute and second
        String strhour = strTime.substring(12,14);
        String strminute = strTime.substring(15,17);
        String strsecond = strTime.substring(18,20);
        // concatenate string
        String totaltime = strhour + ":" +strminute + ":" +strsecond;

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // parse appointment time into "HH:mm:ss" format
            previousTime = dateFormat.parse(totaltime);
        } catch (ParseException e) {
            // to more accurately diagnose exceptions with the exact line and method that raised the exception
            e.printStackTrace();
        }
        String nowdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        String nowday = nowdate.substring(0,2);
        String nowmonth = nowdate.substring(3,5);
        String nowyear = nowdate.substring(6,10);
        String nowhour = nowdate.substring(11,13);
        String nowminute = nowdate.substring(14,16);
        String nowsecond = nowdate.substring(17,19);
        String nowtotaltime = nowhour + ":" +nowminute + ":" +nowsecond;

        String subnowday = nowday.substring(0,1);
        String subnowmonth = nowdate.substring(3,4);

        // if day is 09, then retrieve 9
        if(subnowday.equals("0") ){
            nowday = nowdate.substring(1,2);
        }
        if(subnowmonth.equals("0")){
            nowmonth = nowdate.substring(1,2);
        }

        int numnowday = Integer.parseInt(nowday);
        int numnowmonth = Integer.parseInt(nowmonth);
        int numnowyear = Integer.parseInt(nowyear);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            currentTime = format.parse(nowtotaltime);
            System.out.println(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date d=new Date(numnowyear,numnowmonth,numnowday);
        String neededdate = appointmentModel.getAptDateTime();
        String subyear = neededdate.substring(0,4);
        String submonth = neededdate.substring(5,7);
        String subdate = neededdate.substring(8,10);

        int numyear = Integer.parseInt(subyear);
        int nummonth = Integer.parseInt(submonth);
        int numday = Integer.parseInt(subdate);
        Date d1=new Date(numyear,nummonth,numday);
        // compare current date to appointment date
        int comparison=d.compareTo(d1);
        // if current date is before appointment date
        if(comparison == -1){
            // set text color with specified color hex
            holder.aptTitle.setTextColor(Color.parseColor("#33a532"));
        }
        // if current date is after appointment date
        else if(comparison == 1){
            holder.aptTitle.setTextColor(Color.parseColor("#F32013"));
            // put strike-through decoration through text
            holder.aptTitle.setPaintFlags(holder.aptDateTime.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }
        // if current date is the same as appointment date and if current time is after appointment time
        else if(comparison == 0  && currentTime.after(previousTime)){
            holder.aptTitle.setTextColor(Color.parseColor("#F32013"));
            holder.aptTitle.setPaintFlags(holder.aptDateTime.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }
        // if current date is the same as appointment date
        else if(comparison == 0){
            holder.aptTitle.setTextColor(Color.parseColor("#ff6700"));
        }

        holder.aptTitle.setText(appointmentModel.getAptTitle());
        holder.aptDateTime.setText(appointmentModel.getAptDateTime());
        holder.make_delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // delete this appointment dialog
                deleteDialog(appointmentModel.getAptID());
            }
        });
        holder.ivEditApt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edit this appointment dialog
                showAptEdit(appointmentModel.getAptID());
            }
        }); }

    @Override
    public int getItemCount() {
        return appoinmentModels.size();
    }

    public class AppointmentDataHolder extends RecyclerView.ViewHolder{
        TextView aptTitle, aptDateTime;
        ImageView make_delete, ivEditApt;
        public AppointmentDataHolder(@NonNull View itemView) {
            super(itemView);
            aptTitle=(TextView)itemView.findViewById(R.id.aptTitle);
            aptDateTime=(TextView)itemView.findViewById(R.id.aptDateTime);
            make_delete=(ImageView)itemView.findViewById(R.id.make_delete);
            ivEditApt = (ImageView)itemView.findViewById(R.id.ivEditApt);
        }
    }

    private void deleteDialog(final int aptID){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure that you want to delete this appointment?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aptDBHelper.removeApt(aptID);
                Toast.makeText(context, "Appointment has been deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Appointments.class);
                // restart activity to reflect changes
                ((Appointments)context).finish();
                // remove flashing animation
                ((Appointments)context).overridePendingTransition(0,0);
                context.startActivity(intent);
                ((Appointments)context).overridePendingTransition(0,0);
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

    // dialog to edit appointment details
    private void showAptEdit(final int aptID){
        aptDBHelper=new AptDBHelper(context);
        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view=layoutInflater.inflate(R.layout.edit_apt_dialog,null);
        builder.setView(view);
        final TextInputEditText aptTitle=(TextInputEditText)view.findViewById(R.id.apt_title);
        final TextInputEditText aptDateTime=(TextInputEditText)view.findViewById(R.id.apt_datetime);

        aptTitle.setText(aptDBHelper.fetchAptTitle(aptID));
        aptDateTime.setText(aptDBHelper.fetchAptDateTime(aptID));

        TextView cancel=(TextView)view.findViewById(R.id.cancel);
        TextView editApt=(TextView)view.findViewById(R.id.edit_apt_detail);
        editApt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String getAptTitle=aptTitle.getText().toString();
                String getAptDateTime=aptDateTime.getText().toString();

                boolean isTitleEmpty=aptTitle.getText().toString().isEmpty();
                boolean isDateTimeEmpty=aptDateTime.getText().toString().isEmpty();
                if(isTitleEmpty){
                    aptTitle.setError("Appointment title required !");
                }else if(isDateTimeEmpty){
                    aptDateTime.setError("Appointment date and time required !");
                }
                else if(aptDBHelper.updateApt(
                        new AppointmentModel(aptID,getAptTitle,getAptDateTime)
                )){
                    Toast.makeText(context, "Appointment details have been updated!", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context,Appointments.class));
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,Appointments.class));
            }
        });
        builder.create().show();
    }
}
