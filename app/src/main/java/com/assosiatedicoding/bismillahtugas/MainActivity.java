package com.assosiatedicoding.bismillahtugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button umum, admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        umum = (Button) findViewById(R.id.btn_umum);
        admin = (Button) findViewById(R.id.btn_Admin);
        umum.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Admin:
                Intent moveintent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(moveintent);
                break;
        }
        switch (v.getId()){
            case R.id.btn_umum:
                Intent moveintent = new Intent(MainActivity.this,ImageActivity1.class);
                startActivity(moveintent);
                break;
        }
    }
}

