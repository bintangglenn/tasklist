package com.bintangglenn.tasklist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bintangglenn.tasklist.data.TaskContract.TaskEntry;
import com.bintangglenn.tasklist.data.TaskDBHelper;

public class EditorActivity extends AppCompatActivity {
    private EditText editTextTask;
    private Spinner spinnerDay;
    private Button buttonSave;
    private int daySelection;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editTextTask = (EditText) findViewById(R.id.edit_text_task);
        spinnerDay = (Spinner) findViewById(R.id.spinner_day);
        buttonSave = (Button) findViewById(R.id.button_save_editor);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        setupSpinnerDay();
    }

    private void saveData() {
    }

    private void setupSpinnerDay() {
        ArrayAdapter daySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.day_options, android.R.layout.simple_spinner_item);
        daySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerDay.setAdapter(daySpinnerAdapter);

        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(!selection.isEmpty()) {
                    switch (selection) {
                        case "Monday":
                            daySelection = TaskEntry.DAY_MONDAY;
                            break;
                        case "Tuesday":
                            daySelection = TaskEntry.DAY_TUESDAY;
                            break;
                        case "Wednesday":
                            daySelection = TaskEntry.DAY_WEDNESDAY;
                            break;
                        case "Thursday":
                            daySelection = TaskEntry.DAY_THURSDAY;
                            break;
                        case "Friday":
                            daySelection = TaskEntry.DAY_FRIDAY;
                            break;
                        case "Saturday":
                            daySelection = TaskEntry.DAY_SATURDAY;
                            break;
                        default:
                            daySelection = TaskEntry.DAY_MONDAY;
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                daySelection = TaskEntry.DAY_MONDAY;
            }
        });
    }
}
