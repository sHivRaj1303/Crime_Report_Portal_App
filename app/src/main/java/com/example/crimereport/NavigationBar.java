package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.crimereport.databinding.ActivityMainBinding;

public class NavigationBar extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}