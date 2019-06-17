package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgMajor;
    int myMajor = -1;
    TextView tvResult;
    public void showmsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    String myfile="BRUNCH.txt";
    int module = 0;
    String[] arr = {"AI", "IT", "ERP", "Media"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        rgMajor = findViewById(R.id.rgMajor);
        rgMajor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                myMajor = checkedId;
            }
        });

        try{
            FileInputStream in = openFileInput(myfile);
            byte[] data = new byte[128];
            in.read(data);
            in.close();
            String str = new String(data);
            Log.i("BRUNCH", "myMajor " + str);
            Scanner scn = new Scanner(str);
            myMajor = scn.nextInt();
            Log.i("BRUNCH", "myMajor " + Integer.toString(myMajor));
            rgMajor.check(myMajor);
            tvResult.setText(new String("Load \""+myfile+"\" success:"));
        }catch (IOException e){
            myMajor = -1;
            tvResult.setText(new String("Load \""+myfile+"\" fail"));
        }
    }
    ///SAVE
    public void btnSave_Cl(View view) {
        try {
            FileOutputStream out = openFileOutput(myfile, MODE_PRIVATE);
            String str = Integer.toString(myMajor);
            str += "\n";
            out.write(str.getBytes());
            Log.i("BRUNCH", new String(str.getBytes()));
            out.close();
            showmsg(new String("Save into \"" + myfile + "\" Succ:" + str));
        } catch (IOException e) {
            e.printStackTrace();
            showmsg(new String("Fail"));
        }
    }
    ///SEND
    public void btn_Click(View view) {
        String str ="";
        RadioButton AI = findViewById(R.id.AI);
        RadioButton IT = findViewById(R.id.IT);
        RadioButton ERP = findViewById(R.id.ERP);
        RadioButton Media = findViewById(R.id.Media);
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle= new Bundle();
        if (AI.isChecked()) {
            str = arr[0];
            module = 0;
        }
        if (IT.isChecked()) {
            str = arr[1];
            module = 1;
        }
        if (ERP.isChecked()) {
            str = arr[2];
            module = 2;
        }
        if (Media.isChecked()) {
            str = arr[3];
            module = 3;
        }
        bundle.putString("PACKAGE", str);
        bundle.putInt("MODULE", module);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void btnDebug_Click(View view) {
        TextView txtContent = findViewById(R.id.txtContent);
        try {
            FileInputStream in = openFileInput(myfile);
            byte[] data = new byte[128];
            in.read(data);
            in.close();
            String str = new String(data);
            txtContent.setText(str);
        }
        catch(IOException ex) {

        }
    }
}
