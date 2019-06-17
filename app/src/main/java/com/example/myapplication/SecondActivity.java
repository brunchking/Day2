package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {
    String[] arr = {"AI", "IT", "ERP", "Media"};
    String[][] must = {
            {"演算法概論", "社群運算與巨量資料導論", "軟體工程概論", "高等資料庫", "高等資訊網路", "雲端計算概論", "行動裝置程式設計", "網路安全與管理", "數位電視技術", "IPTV實務與應用", "電子電路導論與物聯網實務"},
            {"數位創新產業應用", "資料採礦與商業智慧", "APP手機應用開發", "數位行銷", "網路行銷", "顧客關係管理", "巨量資料分析(一)", "電子商務實作", "雲端計算概論", "人機介面", "互動科技應用與設計"},
            {"企業資源規劃", "供應鏈管理", "資料採礦與商業智慧", "成本會計", "巨量資料分析(二)", "雲端計算概論", "模糊邏輯實務與應用", "類神經網路實務與應用", "網路安全與管理", "高等資料庫", "人機介面"},
            {"多媒體製作(一)", "數位影像設計", "虛擬實境", "多媒體製作(二)", "數位視訊剪輯", "數位電視技術", "實務與應用", "多媒體音樂實作", "3D 模型動畫", "3D 動畫", "電腦視覺"}
    };
    String[][] notMust = { {"高等資料庫", "高等資訊網路", "雲端計算概論", "行動裝置程式設計", "網路安全與管理", "數位電視技術", "IPTV實務與應用", "電子電路導論與物聯網實務"},
            {"數位行銷", "網路行銷", "顧客關係管理", "巨量資料分析(一)", "電子商務實作", "雲端計算概論", "人機介面", "互動科技應用與設計"},
            {"成本會計", "巨量資料分析(二)", "雲端計算概論", "模糊邏輯實務與應用", "類神經網路實務與應用", "網路安全與管理", "高等資料庫", "人機介面"},
            {"多媒體製作(二)", "數位視訊剪輯", "數位電視技術", "實務與應用", "多媒體音樂實作", "3D 模型動畫", "3D 動畫", "電腦視覺"}
    };
    String fname = "BRUNCH.txt";

    byte[] array2 = new byte[12];
    private int[] chkIDs = {R.id.btnA, R.id.btnB, R.id.btnC, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,  R.id.btn8};
    int count = 0, count2 = 0;
    boolean init = false;

    @Override
    //onCreate
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tvResult = findViewById(R.id.tvResult);
        CheckBox btnA = findViewById(R.id.btnA);
        CheckBox btnB = findViewById(R.id.btnB);
        CheckBox btnC = findViewById(R.id.btnC);
        CheckBox btn1 = findViewById(R.id.btn1);
        CheckBox btn2 = findViewById(R.id.btn2);
        CheckBox btn3 = findViewById(R.id.btn3);
        CheckBox btn4 = findViewById(R.id.btn4);
        CheckBox btn5 = findViewById(R.id.btn5);
        CheckBox btn6 = findViewById(R.id.btn6);
        CheckBox btn7 = findViewById(R.id.btn7);
        CheckBox btn8 = findViewById(R.id.btn8);
        CheckBox[] course = {btnA, btnB, btnC, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        int i = 0, j = 0, module = 0;
        String str = "";

        //BUNDLE
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            str = bundle.getString("PACKAGE");
            module = bundle.getInt("MODULE");
        }
        for (i = 0; i < 11; i++) {
            course[i].setText(must[module][i]);
        }


        ///READ

            try {
                FileInputStream in = openFileInput(fname);
                byte[] data = new byte[128];
                in.read(data);
                in.close();
                for (i = 0; i < 12; i++) {
                    array2[i] = data[i];
                }
                Log.i("BRUNCH", Integer.toString((int)array2[11]));
                Log.i("BRUNCH", Integer.toString(module));
                if (array2[11] == module) {
                    for (i = 0; i < 11; i++) {
                        if (array2[i] == 1)
                            course[i].setChecked(true);
                    }
                }
                tvResult.setText(new String("Load \"" + fname + "\" success."));
            } catch (IOException ex) {
                tvResult.setText(new String("Load  \"" + fname + "\"  fail."));
                for (i = 0; i < 11; i++) {
                    course[i].setChecked(false);
                }
            }


    }
    ///////////////////////////////////////////////
    //btnSEND
    public void button_Click2(View view) {
        CheckBox btnA = findViewById(R.id.btnA);
        CheckBox btnB = findViewById(R.id.btnB);
        CheckBox btnC = findViewById(R.id.btnC);
        CheckBox btn1 = findViewById(R.id.btn1);
        CheckBox btn2 = findViewById(R.id.btn2);
        CheckBox btn3 = findViewById(R.id.btn3);
        CheckBox btn4 = findViewById(R.id.btn4);
        CheckBox btn5 = findViewById(R.id.btn5);
        CheckBox btn6 = findViewById(R.id.btn6);
        CheckBox btn7 = findViewById(R.id.btn7);
        CheckBox btn8 = findViewById(R.id.btn8);
        CheckBox[] course = {btnA, btnB, btnC, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        int i, module = 0;

        ///INTENT BUNDLE
        Intent intent = new Intent(this, ThirdActivity.class);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            module = bundle.getInt("MODULE");
        }


        ///SAVE
        for (i = 0; i < 11; i++) {
            array2[i] = 0;
        }
        for (i = 0; i < 11; i++) {
            if (course[i].isChecked()) {
                array2[i] = 1;
            }
        }
        array2[11] = (byte)module;
        Log.i("BRUNCH", Integer.toString((int)array2[11]));
        Log.i("BRUNCH", Integer.toString(module));
        ///SAVE IN TXT
        try {
            FileOutputStream out = openFileOutput(fname, MODE_APPEND);
            out.write(array2);
            out.close();
            Toast.makeText(this, "Save \"" + fname + "\" success." , Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }


        ///SEND TO NEXT PAGE
        for (i = 0; i < 3; i++) {
            if (course[i].isChecked()) {
                count += 2;
            }
        }
        for (i = 3; i < 11; i++) {
            if (course[i].isChecked()) {
                count2 += 2;
            }
        }


        bundle.putString("MODULE", arr[module]);
        bundle.putInt("COUNT", count);
        bundle.putInt("COUNT2", count2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}

