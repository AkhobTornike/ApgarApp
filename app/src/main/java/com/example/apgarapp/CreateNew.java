package com.example.apgarapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNew extends AppCompatActivity {
    private EditText bornDateInput;
    private EditText idInput;
    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        // Initialize views
        bornDateInput = findViewById(R.id.bornDateInput);
        idInput = findViewById(R.id.babyID);
        nameInput = findViewById(R.id.babyName);

        // Set click listener for the date input
        bornDateInput.setOnClickListener(v -> DateInputValidation.showDateTimePicker(CreateNew.this, bornDateInput));

        // Set text change listener for name input field
        nameInput.addTextChangedListener(new TextWatcher() {
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
                // Not used
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

        // Create function for save button to jump to the next page and send data
        Button createNewButton = findViewById(R.id.saveButton);
        createNewButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateNew.this, ApgarScore.class);

            // Retrieve the values from the input fields
            String name = nameInput.getText().toString();
            String id = idInput.getText().toString();
            String date = bornDateInput.getText().toString();

            UserInfoManager.getInstance().saveUserInfo(name, id, date);

            if (date.isEmpty()) {
                Toast.makeText(CreateNew.this, "Please fill Date field", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(intent);
            }
        });
    }

    private void validateIdInput(String id) {
        if (id.length() != 11) {
            idInput.setError("ID should be exactly 11 digits");
        } else {
            idInput.setError(null);
        }
    }
}