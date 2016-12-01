package com.example.evitected.labfinalexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evitected.labfinalexam.DatabaseClass.DatabaseHelper;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    private Spinner spTopic;
    private TextView etName, etMail, etPhone;
    private Button btnClear, btnRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDB = new DatabaseHelper(this, 2);
        bindWidget();
        setEvent();
    }
    private void setEvent() {
        btnRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please input your Name!!", Toast.LENGTH_SHORT).show();
                    etName.setError("");
                }else if(etMail.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please input your Email!!", Toast.LENGTH_SHORT).show();
                    etPhone.isFocused();
                }else if(etPhone.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please input your Phone Number!!", Toast.LENGTH_SHORT).show();
                    etMail.isFocused();
                }else if(spTopic.getSelectedItemPosition() == 0){
                    Toast.makeText(RegisterActivity.this, "Please Select Topic Interested", Toast.LENGTH_SHORT).show();
                }else{
                    boolean result = myDB.insertRegist(etName.getText().toString(),etMail.getText().toString(),etPhone.getText().toString(),spTopic.getSelectedItem().toString());
                    if(result){
                        Toast.makeText(RegisterActivity.this, "Register Successfully!!", Toast.LENGTH_SHORT).show();
                        clearText();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Register Unsuccessfully!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearText();
            }
        });
    }

    private void clearText() {
        etName.setText("");
        etMail.setText("");
        etPhone.setText("");
        spTopic.setSelection(0);
    }

    private void bindWidget() {
        etName = (TextView) findViewById(R.id.etName);
        etMail = (TextView) findViewById(R.id.etMail);
        etPhone = (TextView) findViewById(R.id.etPhone);
        spTopic = (Spinner) findViewById(R.id.spTopic);
        btnRegistered = (Button) findViewById(R.id.btnRegistered);
        btnClear = (Button) findViewById(R.id.btnClear);
    }
}
