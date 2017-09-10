package com.example.mrityunjay.androidassignment114;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Employee employee;
    Button button;
    EditText edit1;
    EditText edit2;
    EditText edit3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        button = (Button) findViewById(R.id.btn);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
    }

    DatabaseHandler databaseHandler = new DatabaseHandler(this);


    public void addData() {
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          databaseHandler.insertRecord(new Employee(edit1.getText().toString(), edit2.getText().toString()));
                                          Employee employee = databaseHandler.retrievr();
                                          textView2.setText(employee.getName());
                                          textView3.setText(employee.getLast_Name());

                                      }
                                  }

        );
    }
}


