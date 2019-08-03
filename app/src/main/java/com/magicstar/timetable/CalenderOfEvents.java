package com.magicstar.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CalenderOfEvents extends AppCompatActivity {
    private ImageView iv_display;
    private Button btn_right, btn_left;
    private int current_image_index;
    private int[] images = {R.drawable.ce};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayImage();
    }

    void DisplayImage(){
        iv_display = (ImageView)findViewById(R.id.iv_display);
    }
}
