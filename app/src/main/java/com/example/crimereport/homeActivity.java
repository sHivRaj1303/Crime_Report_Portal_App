package com.example.crimereport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class homeActivity extends AppCompatActivity {

//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
    Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//      drawerLayout = findViewById(R.id.drawerlayout);
//      navigationView = findViewById( R.id.nav_view);
      toolbar = findViewById(R.id.toolbar);


      setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();




    }
}