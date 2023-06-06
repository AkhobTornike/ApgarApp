package com.example.apgarapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNew extends AppCompatActivity {
    private EditText bornDateInput;
    private EditText idInput;
    private EditText nameInput;
    private Calendar selectedDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        // Initialize views
        bornDateInput = findViewById(R.id.bornDateInput);
        idInput = findViewById(R.id.babyID);
        nameInput = findViewById(R.id.babyName);

        // Set click listener for the date input (lambda)
        bornDateInput.setOnClickListener(v -> showDateTimePicker());

        // Create a calendar instance
        selectedDateTime = Calendar.getInstance();

        // Initialize the user information array
        // Array to store user information

        // Set text change listener for name input field
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Not used
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Validate the name input after each character om entered
                validateIdInput(s.toString());
            }
        });

        // Set text change listener for ID input field
        idInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Validate the ID input after the user finished entering
                validateIdInput(s.toString());
            }
        });

        // Create function for save btn jump to next page and sent Data
        Button createNewButton = findViewById(R.id.saveButton);
        createNewButton.setOnClickListener(v -> {
            Intent intent =new Intent(CreateNew.this, ApgarScore.class);

            // Retrieve the values from the input fields
            String name = nameInput.getText().toString();
            String id = idInput.getText().toString();
            String date = bornDateInput.getText().toString();

            // Pass the user information as extras in the intent
            intent.putExtra("name", name);
            intent.putExtra("id", id);
            intent.putExtra("date", date);

            startActivity(intent);

        });
    }

    private void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int day = currentDate.get(Calendar.DAY_OF_MONTH);

        // Create a date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    selectedDateTime.set(Calendar.YEAR, year1);
                    selectedDateTime.set(Calendar.MONTH, monthOfYear);
                    selectedDateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    // Show time picker dialog after selecting the date
                    showTimePicker();
                }, year, month, day);

        // Show the date picker dialog
        datePickerDialog.show();
    }

    private void showTimePicker() {
        int hour = selectedDateTime.get(Calendar.HOUR_OF_DAY);
        int minute = selectedDateTime.get(Calendar.MINUTE);

        // Create a time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    selectedDateTime.set(Calendar.MINUTE, minute1);
                    selectedDateTime.set(Calendar.SECOND, 0);

                    // Format the selected date and time
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss", Locale.getDefault());
                    String selectedDateTimeString = sdf.format(selectedDateTime.getTime());

                    // Set the formatted date and time in the input field
                    bornDateInput.setText(selectedDateTimeString);
                }, hour, minute, true);

        // Show the time picker dialog
        timePickerDialog.show();
    }

    private void validateIdInput(String id){
        if(id.length() != 11) {
            idInput.setError("ID should be exactly 9 digits");
        } else {
            idInput.setError(null);
        }
    }
}