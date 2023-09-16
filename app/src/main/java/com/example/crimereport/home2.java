package com.example.crimereport;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class home2 extends AppCompatActivity {

    private NavigationView nav;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        nav= (NavigationView) findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar1,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch ( item.getItemId()){


                    case R.id.home_menu:
                        Toast.makeText(home2.this, "home panale open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Add_crime_menu:
                        Toast.makeText(home2.this, "open add crime menu", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.search_menu:
                        Toast.makeText(home2.this, "open add crime menu", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;



                }




                return true;
            }
        });



    }
}