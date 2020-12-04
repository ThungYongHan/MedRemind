package com.example.medremind;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
// for the entire medicines list
public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.MedicineDataHolder>{
    private ArrayList<MedicineModel> medicineModels;
    private Context context;
    private MedDBHelper medDBHelper;
    public MedicineListAdapter(ArrayList<MedicineModel> medicineModels, Context context){
        this.medicineModels=medicineModels;
        this.context=context;
    }

    @NonNull
    @Override
    public MedicineListAdapter.MedicineDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_medicine_layout,parent,false);
        return new MedicineDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineListAdapter.MedicineDataHolder holder, int position) {
        medDBHelper = new MedDBHelper(context);
        final MedicineModel medicineModel=medicineModels.get(position);
        holder.medTitle.setText(medicineModel.getMedTitle());
        holder.medTime.setText(medicineModel.getMedTime());
        holder.medDosage.setText(medicineModel.getMedDosage());
        holder.medSun.setText(medicineModel.getMedSun());
        holder.medMon.setText(medicineModel.getMedMon());
        holder.medTue.setText(medicineModel.getMedTue());
        holder.medWed.setText(medicineModel.getMedWed());
        holder.medThu.setText(medicineModel.getMedThu());
        holder.medFri.setText(medicineModel.getMedFri());
        holder.medSat.setText(medicineModel.getMedSat());
        holder.deleteMed.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                deleteDialog(medicineModel.getMedID());
            }
        });
        holder.editMed.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                editDialog(medicineModel.getMedID());
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicineModels.size();
    }

    public class MedicineDataHolder extends RecyclerView.ViewHolder{
        TextView medTitle, medTime, medDosage, medSun, medMon, medTue, medWed, medThu, medFri, medSat;
        ImageView deleteMed, editMed;

        public MedicineDataHolder(@NonNull View itemView) {
            super(itemView);
            medTitle=(TextView)itemView.findViewById(R.id.medTitle);
            medTime=(TextView)itemView.findViewById(R.id.medTime);
            medDosage=(TextView)itemView.findViewById(R.id.medDosage);
            medSun=(TextView)itemView.findViewById(R.id.medSun);
            medMon=(TextView)itemView.findViewById(R.id.medMon);
            medTue=(TextView)itemView.findViewById(R.id.medTue);
            medWed=(TextView)itemView.findViewById(R.id.medWed);
            medThu=(TextView)itemView.findViewById(R.id.medThu);
            medFri=(TextView)itemView.findViewById(R.id.medFri);
            medSat=(TextView)itemView.findViewById(R.id.medSat);
            deleteMed=(ImageView)itemView.findViewById(R.id.deleteMed);
            editMed=(ImageView)itemView.findViewById(R.id.editMed);
        }
    }

    private void deleteDialog(final int medID){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this medicine ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                medDBHelper.removeMed(medID);
                Toast.makeText(context, "Medicine has been deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Medicine.class);
                // restart activity to reflect changes
                ((Medicine)context).finish();
                // remove flashing animation
                ((Medicine)context).overridePendingTransition(0,0);
                context.startActivity(intent);
                ((Medicine)context).overridePendingTransition(0,0);
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

    private void editDialog(final int medID){
        medDBHelper=new MedDBHelper(context);
        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view=layoutInflater.inflate(R.layout.edit_med_dialog,null);
        builder.setView(view);
        final TextInputEditText medTitle=(TextInputEditText)view.findViewById(R.id.med_title);
        final TextInputEditText medTime=(TextInputEditText)view.findViewById(R.id.med_time);
        final TextInputEditText medDosage=(TextInputEditText)view.findViewById(R.id.med_dosage);
        final TextInputEditText medSun=(TextInputEditText)view.findViewById(R.id.med_Sun);
        final TextInputEditText medMon=(TextInputEditText)view.findViewById(R.id.med_Mon);
        final TextInputEditText medTue=(TextInputEditText)view.findViewById(R.id.med_Tue);
        final TextInputEditText medWed=(TextInputEditText)view.findViewById(R.id.med_Wed);
        final TextInputEditText medThu=(TextInputEditText)view.findViewById(R.id.med_Thu);
        final TextInputEditText medFri=(TextInputEditText)view.findViewById(R.id.med_Fri);
        final TextInputEditText medSat=(TextInputEditText)view.findViewById(R.id.med_Sat);

        medTitle.setText(medDBHelper.fetchMedTitle(medID));
        medTime.setText(medDBHelper.fetchMedTime(medID));
        medDosage.setText(medDBHelper.fetchMedDosage(medID));
        medSun.setText(medDBHelper.fetchMedListSun(medID));
        medMon.setText(medDBHelper.fetchMedListMon(medID));
        medTue.setText(medDBHelper.fetchMedListTue(medID));
        medWed.setText(medDBHelper.fetchMedListWed(medID));
        medThu.setText(medDBHelper.fetchMedListThu(medID));
        medFri.setText(medDBHelper.fetchMedListFri(medID));
        medSat.setText(medDBHelper.fetchMedListSat(medID));

        TextView cancel=(TextView)view.findViewById(R.id.cancel);
        TextView editMed=(TextView)view.findViewById(R.id.edit_med_detail);
        editMed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String getMedTitle=medTitle.getText().toString();
                String getMedTime=medTime.getText().toString();
                String getMedDosage=medDosage.getText().toString();
                String getMedSun=medSun.getText().toString();
                String getMedMon=medMon.getText().toString();
                String getMedTue=medTue.getText().toString();
                String getMedWed=medWed.getText().toString();
                String getMedThu=medThu.getText().toString();
                String getMedFri=medFri.getText().toString();
                String getMedSat=medSat.getText().toString();

                boolean isTitleEmpty=medTitle.getText().toString().isEmpty();
                boolean isTimeEmpty=medTime.getText().toString().isEmpty();
                boolean isDosageEmpty=medDosage.getText().toString().isEmpty();
                boolean isSunEmpty=medSun.getText().toString().isEmpty();
                boolean isMonEmpty=medMon.getText().toString().isEmpty();
                boolean isTueEmpty=medTue.getText().toString().isEmpty();
                boolean isWedEmpty=medWed.getText().toString().isEmpty();
                boolean isThuEmpty=medThu.getText().toString().isEmpty();
                boolean isFriEmpty=medFri.getText().toString().isEmpty();
                boolean isSatEmpty=medSat.getText().toString().isEmpty();
                // input error handling for editing medicine details
                if(isTitleEmpty){
                    medTitle.setError("Medicine title required !");
                }
                else if(isTimeEmpty){
                    medTime.setError("Medicine intake time required !");
                }
                else if(isDosageEmpty){
                    medDosage.setError("Medicine dosage required !");
                }
                else if(!medSun.getText().toString().equals("sun") && !medSun.getText().toString().equals("0") ){
                    medSun.setError("Medicine Sunday status must be either sun or 0 !");
                }
                else if(isSunEmpty){
                    medSun.setError("Medicine Sunday status required !");
                }
                else if(!medMon.getText().toString().equals("mon") && !medMon.getText().toString().equals("0") ){
                    medMon.setError("Medicine Monday status must be either mon or 0 !");
                }
                else if(isMonEmpty){
                    medMon.setError("Medicine Monday status required !");
                }
                else if(!medTue.getText().toString().equals("tue") && !medTue.getText().toString().equals("0") ){
                    medTue.setError("Medicine Tuesday status must be either tue or 0 !");
                }
                else if(isTueEmpty){
                    medTue.setError("Medicine Tuesday status required !");
                }
                else if(!medWed.getText().toString().equals("wed") && !medWed.getText().toString().equals("0") ){
                    medWed.setError("Medicine Wednesday status must be either wed or 0 !");
                }
                else if(isWedEmpty){
                    medWed.setError("Medicine Wednesday status required !");
                }
                else if(!medThu.getText().toString().equals("thu") && !medThu.getText().toString().equals("0") ){
                    medThu.setError("Medicine Thursday status must be either thu or 0 !");
                }
                else if(isThuEmpty){
                    medThu.setError("Medicine Thursday status required !");
                }
                else if(!medFri.getText().toString().equals("fri") && !medFri.getText().toString().equals("0") ){
                    medFri.setError("Medicine Friday status must be either fri or 0 !");
                }
                else if(isFriEmpty){
                    medFri.setError("Medicine Friday status required !");
                }
                else if(!medSat.getText().toString().equals("sat") && !medSat.getText().toString().equals("0") ){
                    medSat.setError("Medicine Saturday status must be either sat or 0 !");
                }
                else if(isSatEmpty){
                    medSat.setError("Medicine Saturday status required !");
                }
                else if(medDBHelper.updateMed(
                        new MedicineModel(medID,getMedTitle,getMedSun,getMedMon,getMedTue,getMedWed,getMedThu,getMedFri,getMedSat,getMedTime,getMedDosage)
                )){
                    Toast.makeText(context, "Medicine details have been updated!", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context,Medicine.class));
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,Medicine.class));
            }
        });
        builder.create().show();
    }
}
