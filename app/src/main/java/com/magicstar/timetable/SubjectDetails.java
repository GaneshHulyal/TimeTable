package com.magicstar.timetable;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        setupUIViews();
        initToolbar();
        setupUIViews();
        setupListView();
    }
    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubjectDetails);
        listView = (ListView)findViewById(R.id.lvSubjectDetails);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        String subject_selected=SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF,null);
        String[] syllabus= new String[]{};
        String[] titles=getResources().getStringArray(R.array.title);
        if(subject_selected.equalsIgnoreCase("VCLA")){
            syllabus=getResources().getStringArray(R.array.VCLA);
        }else if(subject_selected.equalsIgnoreCase("AS")){
            syllabus=getResources().getStringArray(R.array.AS);
        }else if(subject_selected.equalsIgnoreCase("MC")){
            syllabus=getResources().getStringArray(R.array.MC);
        }else if(subject_selected.equalsIgnoreCase("OOPS")){
            syllabus=getResources().getStringArray(R.array.OOPS);
        }else if(subject_selected.equalsIgnoreCase("DBMS")){
            syllabus=getResources().getStringArray(R.array.DBMS);
        }else if(subject_selected.equalsIgnoreCase("OS")){
            syllabus=getResources().getStringArray(R.array.OS);
        }else if(subject_selected.equalsIgnoreCase("DBMSLAB")){
            syllabus=getResources().getStringArray(R.array.DBMSLAB);
        }else if(subject_selected.equalsIgnoreCase("CPPLAB")){
            syllabus=getResources().getStringArray(R.array.CPPLAB);
        }

            SubjectDetailsAdapter subjectDetailsAdapter= new SubjectDetailsAdapter(this,titles,syllabus);
            listView.setAdapter(subjectDetailsAdapter);

    }
    public class SubjectDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, syllabus;
        private String[] titleArray;
        private String[] syllabusArray;

        public SubjectDetailsAdapter(Context context, String[] title, String[] syllabus){
            mContext = context;
            titleArray = title;
            syllabusArray = syllabus;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.subject_details_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus = (TextView)convertView.findViewById(R.id.tvSyllabus);

            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);
            return convertView;

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
