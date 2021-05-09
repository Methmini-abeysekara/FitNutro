package com.example.fitnutro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomView extends RecyclerView.Adapter<CustomView.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList workout_id, workout_title, workout_description, workout_sets, workout_reps;

    CustomView(Activity activity, Context context,ArrayList workout_id, ArrayList workout_title,ArrayList workout_description, ArrayList workout_sets,ArrayList workout_reps){
        this.activity = activity;
        this.context = context;
        this.workout_id = workout_id;
        this.workout_title =workout_title;
        this.workout_description = workout_description;
        this.workout_sets = workout_sets;
        this.workout_reps =workout_reps;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_id.setText(String.valueOf(workout_id.get(position)));
        holder.txt_title.setText(String.valueOf(workout_title.get(position)));
        holder.txt_description.setText(String.valueOf(workout_description.get(position)));
        holder.txt_sets.setText(String.valueOf(workout_sets.get(position)));
        holder.txt_reps.setText(String.valueOf(workout_reps.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateTask.class);
                intent.putExtra("id", String.valueOf(workout_id.get(position)));
                intent.putExtra("title", String.valueOf(workout_title.get(position)));
                intent.putExtra("description", String.valueOf(workout_description.get(position)));
                intent.putExtra("sets", String.valueOf(workout_sets.get(position)));
                intent.putExtra("reps", String.valueOf(workout_reps.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return workout_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id, txt_title,txt_description, txt_sets,  txt_reps;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.W_txt_id);
            txt_title = itemView.findViewById(R.id.W_txt_title);
            txt_description = itemView.findViewById(R.id.W_txt_description);
            txt_sets = itemView.findViewById(R.id.W_txt_sets);
            txt_reps = itemView.findViewById(R.id.W_txt_reps);
            mainLayout = itemView.findViewById(R.id.W_mainLayout);

        }
    }
}
