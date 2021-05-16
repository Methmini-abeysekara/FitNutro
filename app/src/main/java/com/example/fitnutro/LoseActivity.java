package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        RecyclerView recyclerView = findViewById(R.id.W_L_recyclerView_gainList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyWorkoutData_Lose[] myMovieData = new MyWorkoutData_Lose[]{
                new MyWorkoutData_Lose("Sit-ups",R.drawable.situps),
                new MyWorkoutData_Lose("Mountain Climbers",R.drawable.mountain_climbers),
                new MyWorkoutData_Lose("Sprawls",R.drawable.sprawls),
                new MyWorkoutData_Lose("Waking Lungs",R.drawable.walking_lungs),
                new MyWorkoutData_Lose("Rowing Machine",R.drawable.rowing_machine),
        };

        MyWorkoutAdapter_Loss myWorkoutAdapterl = new MyWorkoutAdapter_Loss(myMovieData,LoseActivity.this);
        recyclerView.setAdapter(myWorkoutAdapterl);

    }
}