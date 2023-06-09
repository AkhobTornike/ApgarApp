package com.example.apgarapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateInputValidation {

    public static void showDateTimePicker(Context context, EditText dateTimeInput) {
        final Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int day = currentDate.get(Calendar.DAY_OF_MONTH);

        // Create a date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    Calendar selectedDateTime = Calendar.getInstance();
                    selectedDateTime.set(Calendar.YEAR, year1);
                    selectedDateTime.set(Calendar.MONTH, monthOfYear);
                    selectedDateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    // Show time picker dialog after selecting the date
                    showTimePicker(context, dateTimeInput, selectedDateTime);
                }, year, month, day);

        // Show the date picker dialog
        datePickerDialog.show();
    }

    private static void showTimePicker(Context context, EditText dateTimeInput, Calendar selectedDateTime) {
        int hour = selectedDateTime.get(Calendar.HOUR_OF_DAY);
        int minute = selectedDateTime.get(Calendar.MINUTE);

        // Create a time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                (view, hourOfDay, minute1) -> {
                    selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    selectedDateTime.set(Calendar.MINUTE, minute1);
                    selectedDateTime.set(Calendar.SECOND, 0);

                    // Format the selected date and time
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss", Locale.getDefault());
                    String selectedDateTimeString = sdf.format(selectedDateTime.getTime());

                    // Set the formatted date and time in the input field
                    dateTimeInput.setText(selectedDateTimeString);
                }, hour, minute, true);

        // Show the time picker dialog
        timePickerDialog.show();
    }
}
