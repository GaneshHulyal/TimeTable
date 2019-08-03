package com.magicstar.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.magicstar.timetable.utils.LetterImageView;

public class DayDetail2 extends AppCompatActivity {

    private ListView listView;
    private android.support.v7.widget.Toolbar toolbar;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail2);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.lvDayDetail);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.ToolbarDayDetail2);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Disp_time2.sharedPreferences.getString(Disp_time2.SEL_DAY, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        Monday = getResources().getStringArray(R.array.Monday2);
        Tuesday = getResources().getStringArray(R.array.Tuesday2);
        Wednesday = getResources().getStringArray(R.array.Wednesday2);
        Thursday = getResources().getStringArray(R.array.Thursday2);
        Friday = getResources().getStringArray(R.array.Friday2);
        Saturday = getResources().getStringArray(R.array.Saturday2);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);
        Time6 = getResources().getStringArray(R.array.time6);

        String selected_day = Disp_time2.sharedPreferences.getString(Disp_time2.SEL_DAY, null);

        if(selected_day.equalsIgnoreCase("Monday")){
            PreferredDay = Monday;
            PreferredTime = Time1;
        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            PreferredDay = Tuesday;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Wednesday")){
            PreferredDay = Wednesday;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Thursday")){
            PreferredDay = Thursday;
            PreferredTime = Time4;
        }else if(selected_day.equalsIgnoreCase("Friday")){
            PreferredDay = Friday;
            PreferredTime = Time5;
        }else{
            PreferredDay = Saturday;
            PreferredTime = Time6;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail2.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }

            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                startActivity(new Intent(this, MainActivity.class));
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
