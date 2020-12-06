package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Initialize Variable
    EditText editText;
    Button btSubmmit;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Assign Variable
        editText = findViewById(R.id.edit_text);
        btSubmmit = findViewById(R.id.bn_submmit);
        spinner = findViewById(R.id.spinner);
        // Initialized array list
        ArrayList<String> arrayList = new ArrayList<>();
        // use for loop
        for (int i=0;i<7;i++){
            if (i==0){
                // when value is equal to 0
                // Add none value in array list
                arrayList.add("none");
            }else{
                // when value is not equal to 0
                //add values in array list
                arrayList.add("item"+1);
            }
        }
        // set spinner adapter
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrayList));
        btSubmmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString().trim();
                spinner.setSelection(getIndex(spinner,s));
            }
        });


    }

    private int getIndex(Spinner spinner, String s) {
        // Use for loop
        for(int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(s)){
                // when value match
                // return value position
                return i;
            }
        }
        // when no value match
        //Return 0
        return 0;
    }
}