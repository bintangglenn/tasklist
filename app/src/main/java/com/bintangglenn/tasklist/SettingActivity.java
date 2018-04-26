package com.bintangglenn.tasklist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    TextView textViewPref;
    EditText editTextPref;
    Button buttonSavePref;
    Button buttonClearPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textViewPref = (TextView) findViewById(R.id.text_view_shared_pref);
        editTextPref = (EditText) findViewById(R.id.edit_text_pref);
        buttonSavePref = (Button) findViewById(R.id.button_save_pref);
        buttonClearPref = (Button) findViewById(R.id.button_clear_pref);

        buttonSavePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSharedPref();
            }
        });
        
        buttonClearPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearSharedPref();
            }
        });

    }

    private void clearSharedPref() {
        Toast.makeText(this, "SharedPreferences cleared", Toast.LENGTH_SHORT).show();
    }

    private void saveSharedPref() {

    }

}
