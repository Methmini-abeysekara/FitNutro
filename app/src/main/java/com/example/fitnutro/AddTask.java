package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTask extends AppCompatActivity {

    EditText title_input, description_input, sets_input, reps_input;
    Button add_button2;

    //VALIDATE WORKOUT DESCRIPTION
    public boolean validateDescription() {
        String description = description_input.getText().toString();
        if (description.isEmpty())
        {
            description_input.setError("field can't be empty");
            return false;
        }
        else
        {
            description_input.setError(null);
            return true;
        }
    }

    //VALIDATE SETS
    public boolean validateSets(){
        String sets = sets_input.getText().toString();
        if(sets.isEmpty())
        {
            sets_input.setError("field can't be empty");
            return false;
        }
        else
        {
            sets_input.setError(null);
            return true;
        }
    }

    //VALIDATE REPS
    public boolean validateReps(){
        String reps = reps_input.getText().toString();
        if(reps.isEmpty())
        {
            reps_input.setError("field can't be empty");
            return false;
        }
        else
        {
            reps_input.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        title_input = findViewById(R.id.W_title_input);
        description_input = findViewById(R.id.W_description_input);
        sets_input = findViewById(R.id.W_sets_input);
        reps_input = findViewById(R.id.W_reps_input);
        add_button2 = findViewById(R.id.W_add_button2);

        add_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateDescription()){
                    return;
                }
                if(!validateSets()){
                    return;
                }
                if(!validateReps()){
                    return;
                }

                DatabaseHandler myDB = new DatabaseHandler(AddTask.this);
                myDB.addTask(title_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        Integer.valueOf(sets_input.getText().toString().trim()),
                        Integer.valueOf(reps_input.getText().toString().trim() ) );
            }
        });
    }

}