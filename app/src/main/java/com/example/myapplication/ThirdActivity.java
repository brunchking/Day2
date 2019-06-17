package com.example.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ThirdActivity extends AppCompatActivity {
    private String fname = "note.txt";
    byte DATA[] = new byte[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView txt1 = findViewById(R.id.txt1);
        TextView txt2 = findViewById(R.id.txt2);
        TextView txt3 = findViewById(R.id.txt3);
        TextView txt4 = findViewById(R.id.txt4);
        TextView txt5 = findViewById(R.id.txt5);
        TextView txt6 = findViewById(R.id.txt6);

        Bundle bundle = this.getIntent().getExtras();
        String str = "";
        if (bundle != null) {
            DATA = bundle.getByteArray("DATA");
        }

        int count = 0;
        int count2 = 0;
        if (bundle != null) {
            count = bundle.getInt("COUNT");
            count2 = bundle.getInt("COUNT2");
            str = bundle.getString("MODULE");
        }
        if (count + count2 > 15 &&  count == 6) {
            txt1.setText("已修畢 " + str);
            txt2.setText("必備" + count + "學分");
            txt3.setText("選備" + count2 + "學分");
        }
        else {
            txt1.setText("未修畢 " + '(' + str + ')');
            txt2.setText("必備" + (count) + "學分");
            txt3.setText("未通過" + (6 - count) + "學分");
            txt4.setText("選備" + count2 + "學分");
            txt5.setText("未通過" + (10 - count2) + "學分");
            txt6.setText("不足" + (15 - (count + count2)) + "學分");
        }
    }

}
