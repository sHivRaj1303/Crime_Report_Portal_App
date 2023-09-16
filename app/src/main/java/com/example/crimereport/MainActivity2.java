package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
       NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

              switch (id){
                  case R.id.home_menu:

                      Toast.makeText(MainActivity2.this, "home page is  opne ", Toast.LENGTH_LONG).show();break;
                  case R.id.Add_crime_menu:
                      Intent intent = new Intent(MainActivity2.this, otpverificationVT.class);
                      startActivity(intent);



                      drawerLayout.closeDrawer(GravityCompat.START);
                      Toast.makeText(MainActivity2.this, "verify your mobile Number ", Toast.LENGTH_LONG).show();
                      break;

                  case R.id.help_menu:
                      Toast.makeText(MainActivity2.this, "I can't help you ", Toast.LENGTH_LONG).show();break;

                  case R.id.Logout_menu:
                      Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
                      startActivity(intent2);
                      drawerLayout.closeDrawer(GravityCompat.START);
                      Toast.makeText(MainActivity2.this, "Log out ", Toast.LENGTH_LONG).show();
                      break;
                      default:
                      return true;


                }
                return true;
            }
        });
    }
}