package com.magicstar.timetable;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.Calendar;

public class Disp_time3 extends Activity {
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_time1);
        Calendar calender = Calendar.getInstance();
        sharedPreferences = getSharedPreferences("MY_DAY", MODE_PRIVATE);
        int day = calender.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Sunday").apply();
                break;
            case Calendar.MONDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Monday").apply();
                break;
            case Calendar.TUESDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Tuesday").apply();
                break;
            case Calendar.WEDNESDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Wednesday").apply();
                break;
            case Calendar.THURSDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Thursday").apply();
                break;
            case Calendar.FRIDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Friday").apply();
                break;
            case Calendar.SATURDAY:
                startActivity(new Intent(Disp_time3.this, DayDetail3.class));
                sharedPreferences.edit().putString(SEL_DAY, "Saturday").apply();
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                startActivity(new Intent(this, MainActivity.class));
                //onBackPressed();
                this.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}