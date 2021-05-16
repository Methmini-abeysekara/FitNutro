package com.example.fitnutro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyWorkoutAdapter_Loss extends RecyclerView.Adapter<MyWorkoutAdapter_Loss.ViewHolder> {
    MyWorkoutData_Lose[] myWorkoutDatal;
    Context contextl;

    public MyWorkoutAdapter_Loss(MyWorkoutData_Lose[] myWorkoutDatal,LoseActivity activity) {
        this.myWorkoutDatal = myWorkoutDatal;
        this.contextl = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.loss_workout_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyWorkoutData_Lose myWorkoutDataList = myWorkoutDatal[position];
        holder.textViewNamel.setText(myWorkoutDataList.getWorkoutNamel());
        holder.workoutImagel.setImageResource(myWorkoutDataList.getWorkoutImagel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contextl,myWorkoutDataList.getWorkoutNamel(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myWorkoutDatal.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView workoutImagel;
        TextView textViewNamel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutImagel = itemView.findViewById(R.id.W_L_imageview);
            textViewNamel = itemView.findViewById(R.id.W_L_workoutName);
        }
    }

}