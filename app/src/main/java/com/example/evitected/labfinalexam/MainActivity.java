package com.example.evitected.labfinalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.evitected.labfinalexam.DatabaseClass.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnRegist, btnListMem;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        myDB = new DatabaseHelper(this, 2);
        bindWidget();
        setEvent();
    }

    private void setEvent() {
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        btnListMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, list_memberActivity.class);
                startActivity(i);
            }
        });
    }

    private void bindWidget() {
        btnRegist = (Button) findViewById(R.id.btnRegist);
        btnListMem = (Button) findViewById(R.id.btnListMem);
    }
}
