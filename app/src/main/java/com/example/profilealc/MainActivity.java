package com.example.profilealc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showALCPage(View view){
        Intent intent=new Intent(this,  ALCActivity.class);
        startActivity(intent);
    }
    public void showProfilePage(View view){
        Intent intent=new Intent(this,  ProfileActivity.class);
        startActivity(intent);
    }
}
