package com.example.tp4am2019;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager adminFragments;
    FragmentTransaction transacFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminFragments=getFragmentManager();

        Fragment frgIngreso;
        frgIngreso=new Geo();
    }
}
