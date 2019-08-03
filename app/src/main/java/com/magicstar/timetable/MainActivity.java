package com.magicstar.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private ListView listView;
    ViewPager viewPager;
    private FirebaseAuth mAuth;
    private ActionBarDrawerToggle aToggle;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    SliderLayout sliderLayout;


    int images[] = {R.drawable.imad, R.drawable.imab, R.drawable.imgc, R.drawable.imga};
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent i=new Intent(MainActivity.this,Disp_time.class);
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(3);
        //startActivity(i);
        setupUIViews();
        initToolbar();
        setSliderViews();
        setupListView();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.userNameText);
        navUsername.setText(user.getDisplayName());
        TextView navUserMail = (TextView) headerView.findViewById(R.id.userMainId);
        navUserMail.setText(user.getEmail());

        dl = (DrawerLayout)findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl,R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.vp:
                        Toast.makeText(MainActivity.this, "Visit Contineo",Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(getApplicationContext(), contineo.class);
                        startActivity(i);
                        break;
                    case R.id.std:
                        Toast.makeText(MainActivity.this, "Visit parent Contineo",Toast.LENGTH_SHORT).show();
                        Intent j= new Intent(getApplicationContext(), ParentContineo.class);

                        startActivity(j);
                        break;
                    case R.id.qp:
                        Toast.makeText(MainActivity.this, "Download Lesson Plan",Toast.LENGTH_SHORT).show();
                        Intent k= new Intent(getApplicationContext(), contineo.class);
                        startActivity(k);
                        break;
                    case R.id.sy:
                        Toast.makeText(MainActivity.this, "Calender of Events",Toast.LENGTH_SHORT).show();
                        Intent l= new Intent(getApplicationContext(), CalenderOfEvents.class);
                        startActivity(l);
                        break;
                    case R.id.Ask:
                        Toast.makeText(MainActivity.this, "Opening Chat Room...",Toast.LENGTH_SHORT).show();
                        Intent m= new Intent(getApplicationContext(), ChatRoom.class);
                        startActivity(m);
                        break;
                    case R.id.Result:
                        Toast.makeText(MainActivity.this, "Results",Toast.LENGTH_SHORT).show();
                        Intent n= new Intent(getApplicationContext(), Results.class);
                        startActivity(n);
                        break;
                    case R.id.Logout:
                        Toast.makeText(MainActivity.this, "Loging out...",Toast.LENGTH_SHORT).show();
                        mAuth.getInstance().signOut();
                        Intent o=new Intent(getApplicationContext(),SplashScreen.class);
                        startActivity(o);

                }return true;




            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.chat_room:
                                startActivity(new Intent(MainActivity.this,ChatRoom.class));
                                break;
                            case R.id.contineo:
                                startActivity(new Intent(MainActivity.this,ParentContineo.class));
                                break;
                            case R.id.lesson:
                                startActivity(new Intent(MainActivity.this,SubjectActivity.class));
                                break;
                            case R.id.share:
                                startActivity(new Intent(MainActivity.this,Resources.class));
                                break;
                        }
                        return false;
                    }
                });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        //listView = (ListView)findViewById(R.id.lvMain);
    }


    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Buddy");
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        aToggle =new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(aToggle);
        aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);}

       // SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        //listView.setAdapter(simpleAdapter);

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, Disp_time.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(MainActivity.this, SubjectActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(MainActivity.this, SelectDivAct.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        break;
                    }
                }
            }
        });
    }*/



    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "See you soon... Bye.", Toast.LENGTH_SHORT).show();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
    private void setSliderViews() {

        for (int i = 0; i <= 2; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:                   //these are the images that are actually displaying there we need to give different address later
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/timetable-918a8.appspot.com/o/Quotefancy-1214-3840x2160.jpg?alt=media&token=457d6458-9c6e-4002-a877-8d30c3c1fc0c");
                    break;
                case 1:
                    sliderView.setImageUrl("https://1zl13gzmcsu3l9yq032yyf51-wpengine.netdna-ssl.com/wp-content/uploads/2016/07/jobs-1-800x420-1.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("http://obamapacman.com/wp-content/uploads/2012/01/Life-vs-death-Steve-Jobs-quote.jpg");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("");
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}