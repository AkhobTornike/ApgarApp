package com.example.apgarapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class CheckBabyInfo extends AppCompatActivity {

    private EditText nameInput;
    private EditText idInput;
    private EditText bornDateInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_baby_info);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        bornDateInput = findViewById(R.id.bornDateInput);

        String name = UserInfoManager.getInstance().getName();
        String id = UserInfoManager.getInstance().getId();
        String date = UserInfoManager.getInstance().getDate();

        bornDateInput.setOnClickListener(v -> DateInputValidation.showDateTimePicker(CheckBabyInfo.this, bornDateInput));


        Button SaveButton = findViewById(R.id.SaveButton);
        SaveButton.setOnClickListener(v -> {
            String name1 = nameInput.getText().toString().trim();
            String id1 = idInput.getText().toString().trim();
            String date1 = bornDateInput.getText().toString().trim();

            if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(id1) || TextUtils.isEmpty(date1)) {
                Toast.makeText(CheckBabyInfo.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (id1.length() != 11) {
                Toast.makeText(CheckBabyInfo.this, "ID should be exactly 11 digits", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CheckBabyInfo.this, Result.class);
                UserInfoManager.getInstance().saveUserInfo(name1, id1, date1);
                startActivity(intent);
            }
        });

        if (!TextUtils.isEmpty(name)) {
            nameInput.setText(name);
            nameInput.setTextColor(Color.BLACK);
            nameInput.setTextSize(20);
            nameInput.setEnabled(false);
        } else {
            nameInput.setHint("Enter Name");
        }

        if (!TextUtils.isEmpty(id)) {
            idInput.setText(id);
            idInput.setTextColor(Color.BLACK);
            idInput.setTextSize(20);
            if (isIDValid(id)) {
                idInput.setEnabled(false);
            } else {
                idInput.setHint("Invalid ID");
            }
        } else {
            idInput.setHint("Enter ID");
        }

        if (!TextUtils.isEmpty(date)) {
            bornDateInput.setText(date);
            bornDateInput.setTextColor(Color.BLACK);
            bornDateInput.setTextSize(20);
            bornDateInput.setEnabled(false);
        } else {
            bornDateInput.setHint("Select Date");
        }
    }

    private boolean isIDValid(String id) {
        if (id.length() != 11) {
            return false;
        }

        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
