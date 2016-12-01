package com.example.evitected.labfinalexam;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.evitected.labfinalexam.DatabaseClass.DatabaseHelper;

public class list_memberActivity extends AppCompatActivity {

    private Spinner spFormat;
    private ListView lvDisplay;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_member);
        myDB = new DatabaseHelper(this, 2);
        bindWidget();
        setEvent();
    }

    private void setEvent() {
        spFormat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                }
                else if(i == 1){
                    createListMemByName();
                }else if(i == 2){
                    createListMemByID();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createListMemByID() {
        Cursor result = myDB.getListMemByID();
        int row = result.getCount();
        if(row > 0){
            String[] from = new String[] {"name", "type"};
            int[] to = new int[] {R.id.tvNameList, R.id.tvTypeList};
            SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(
                    this,
                    R.layout.activity_list_member__layout,
                    result,
                    from,
                    to,
                    0
            );
            lvDisplay.setAdapter(myAdapter);
        }
    }

    private void createListMemByName() {
        Cursor result = myDB.getListMemByName();
        int row = result.getCount();
        if(row > 0){
            String[] from = new String[] {"name", "type"};
            int[] to = new int[] {R.id.tvNameList, R.id.tvTypeList};
            SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(
                    this,
                    R.layout.activity_list_member__layout,
                    result,
                    from,
                    to,
                    0
            );
            lvDisplay.setAdapter(myAdapter);
        }
    }

    private void bindWidget() {
        spFormat = (Spinner) findViewById(R.id.spFormat);
        lvDisplay = (ListView) findViewById(R.id.lvDisplay);
    }
}
