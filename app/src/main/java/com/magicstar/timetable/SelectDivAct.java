package com.magicstar.timetable;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;


public class SelectDivAct extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    public static boolean activity = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_div);

       // TextView t1=(TextView) findViewById(R.id.Main);
        //t1.setText("Select Your Division");
        initToolbar();

        Button btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner sp=(Spinner) findViewById(R.id.spinner);
                String div=sp.getSelectedItem().toString();
                if(div.equalsIgnoreCase("A Division"))
                {
                    startActivity(new Intent(SelectDivAct.this,Disp_time.class));
                }
                else if(div.equalsIgnoreCase("B Division"))
                {
                    startActivity(new Intent(SelectDivAct.this,Disp_time1.class));
                }
                else if(div.equalsIgnoreCase("C Division"))
                {
                    startActivity(new Intent(SelectDivAct.this,Disp_time2.class));
                }
                else if(div.equalsIgnoreCase("D Division")){
                    startActivity(new Intent(SelectDivAct.this,Disp_time3.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Selection",Toast.LENGTH_SHORT).show();
                }
        }
    });

}
    private void initToolbar(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.ToolbarDayDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Your Division");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                //onBackPressed();
                startActivity(new Intent(this, MainActivity.class));
                this.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}