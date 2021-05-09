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

public class MyWorkoutAdapter extends RecyclerView.Adapter<MyWorkoutAdapter.ViewHolder> {
    MyWorkoutData[] myWorkoutData;
    Context context;

    public MyWorkoutAdapter(MyWorkoutData[] myWorkoutData,GainActivity activity) {
        this.myWorkoutData = myWorkoutData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gain_workout_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyWorkoutData myWorkoutDataList = myWorkoutData[position];
        holder.textViewName.setText(myWorkoutDataList.getWorkoutName());
        holder.workoutImage.setImageResource(myWorkoutDataList.getWorkoutImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,myWorkoutDataList.getWorkoutName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myWorkoutData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView workoutImage;
        TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutImage = itemView.findViewById(R.id.W_imageview);
            textViewName = itemView.findViewById(R.id.W_workoutName);
        }
    }

}

