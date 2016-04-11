package com.example.arvindhsv.datetestingapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ListActivity {
    private Calendar cal = Calendar.getInstance();
    private Map<Integer, Integer> maxMonthDay = new HashMap<>();
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private int year;
    private int month;
    private int date;
    String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createMaxMonthMap();
        setContentView(R.layout.content_main);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
    }

    private void createMaxMonthMap() {
        maxMonthDay.put(1, 31);
        maxMonthDay.put(2, 29);
        maxMonthDay.put(3, 31);
        maxMonthDay.put(4, 30);
        maxMonthDay.put(5, 31);
        maxMonthDay.put(6, 30);
        maxMonthDay.put(7, 31);
        maxMonthDay.put(8, 30);
        maxMonthDay.put(9, 31);
        maxMonthDay.put(10, 30);
        maxMonthDay.put(11, 31);
        maxMonthDay.put(12, 31);
    }

    public void validate(View view) {
        try {
            date = Integer.parseInt(((EditText) findViewById(R.id.dateText)).getText().toString());
            month = Integer.parseInt(((EditText) findViewById(R.id.monthText)).getText().toString());
            year = Integer.parseInt(((EditText) findViewById(R.id.yearText)).getText().toString());
            validateDate(date, month, year);
        }
        catch (NumberFormatException ex){
            toastForShortLength("Field Value Empty");
        }
        catch (Exception e) {
            toastForShortLength("Exception");
        }
        addInputValueToList(date, month, year);
        date = month = year = 0;
        toastMessage = "";
    }

    private void addInputValueToList(int date, int month, int year) {
        listItems.add(date + "/" + month + "/" + year + " - " + toastMessage);
        adapter.notifyDataSetChanged();
    }

    public void clear(View view) {
        EditText date = (EditText) findViewById(R.id.dateText);
        EditText month = (EditText) findViewById(R.id.monthText);
        EditText year = (EditText) findViewById(R.id.yearText);
        date.setText("");
        month.setText("");
        year.setText("");
    }

    private void validateDate(int date, int month, int year) {
        if (checkForDateBeingValidForMonth(date, month) && checkForValidYearAndMonth(year, month)) {
            toastForShortLength("Valid Date");
        } else {
            toastForShortLength("Invalid Date");
        }
    }

    private void toastForShortLength(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toastMessage = text;
        toast.show();
    }

    private boolean checkForValidYearAndMonth(int year, int month) {
        return (year < cal.get(Calendar.YEAR) || (year == cal.get(Calendar.YEAR) && month <= cal.get(Calendar.MONTH) + 1));
    }

    private boolean checkForDateBeingValidForMonth(int date, int month) {
        return date > 0 && date <= maxMonthDay.get(month);
    }
}