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

import java.util.ArrayList;

public class TakenMedicineAdapter extends RecyclerView.Adapter<TakenMedicineAdapter.MedicineDataHolder>{
    private ArrayList<MedicineModel> medicineModels;
    private Context context;
    private MedDBHelper medDBHelper;
    public TakenMedicineAdapter(ArrayList<MedicineModel> medicineModels, Context context){
        this.medicineModels=medicineModels;
        this.context=context;
    }

    @NonNull
    @Override
    public TakenMedicineAdapter.MedicineDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_takenmedicine_layout,parent,false);
        return new MedicineDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TakenMedicineAdapter.MedicineDataHolder holder, int position) {
        medDBHelper = new MedDBHelper(context);
        final MedicineModel medicineModel=medicineModels.get(position);
        //holder.medTitle.setTextColor(Color.parseColor("#008450"));
        holder.medTitle.setText(medicineModel.getMedTitle());
        //holder.medTime.setTextColor(Color.parseColor("#EFB700"));
        holder.medTime.setText(medicineModel.getMedTime());
        //holder.medDosage.setTextColor(Color.parseColor("#B81D13"));
        holder.medDosage.setText(medicineModel.getMedDosage());

    }

    @Override
    public int getItemCount() {
        return medicineModels.size();
    }

    public class MedicineDataHolder extends RecyclerView.ViewHolder{
        TextView medTitle, medTime, medDosage;
        public MedicineDataHolder(@NonNull View itemView) {
            super(itemView);
            medTitle=(TextView)itemView.findViewById(R.id.medTitle);
            medTime=(TextView)itemView.findViewById(R.id.medTime);
            medDosage=(TextView)itemView.findViewById(R.id.medDosage);
        }
    }

}