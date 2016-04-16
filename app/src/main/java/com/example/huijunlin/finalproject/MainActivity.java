package com.example.huijunlin.finalproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements FragmentNewsMain.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, FragmentNewsMain.newInstance())
                .commit();

    }


    @Override
    public void onListItemSelected(int position, HashMap<String, String> movie) {

    }
}
