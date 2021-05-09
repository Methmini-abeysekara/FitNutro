package com.example.fitnutro;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateTask extends AppCompatActivity {

    EditText title_input, description_input, sets_input,reps_input;
    Button update_button,delete_button;

    String id, title, description, sets, reps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        title_input = findViewById(R.id.W_title_input);
        description_input = findViewById(R.id.W_description_input);
        sets_input = findViewById(R.id.W_sets_input);
        reps_input = findViewById(R.id.W_reps_input);
        update_button = findViewById(R.id.W_add_button2);
        delete_button = findViewById(R.id.W_delete_button);

        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHandler myDB = new DatabaseHandler(UpdateTask.this);
                title = title_input.getText().toString().trim();
                description = description_input.getText().toString().trim();
                sets = sets_input.getText().toString().trim();
                reps = reps_input.getText().toString().trim();
                myDB.updateData(id,title,description,sets,reps);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialogMsg();

            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("description") && getIntent().hasExtra("sets") && getIntent().hasExtra("reps")){
            //Getting Data from Intent

            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            description = getIntent().getStringExtra("description");
            sets = getIntent().getStringExtra("sets");
            reps = getIntent().getStringExtra("reps");

            //Setting Intent Data
            title_input.setText(title);
            description_input.setText(description);
            sets_input.setText(sets);
            reps_input.setText(reps);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialogMsg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Do you want to delete this record ? " );
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHandler myDB = new DatabaseHandler(UpdateTask.this);
                myDB.deleteRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }



}