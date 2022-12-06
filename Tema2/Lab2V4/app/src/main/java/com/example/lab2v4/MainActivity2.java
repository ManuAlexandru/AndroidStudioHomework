package com.example.lab2v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
public int Nr1,Nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String recData=getIntent().getStringExtra("string_key");
        String recData1=getIntent().getStringExtra("string_key1");
        Nr1=Integer.parseInt(recData1);
        Nr2=Integer.parseInt(recData);
        TextView txtViewReceivedData=findViewById(R.id.txtRec);
        txtViewReceivedData.setText("The numbers are: "+Nr1+", "+Nr2);

    }
    public void onClickSubstract(View view){

Intent resultIntent=new Intent();
int result=Nr1-Nr2;

resultIntent.putExtra("result",result);


        Context context=getApplicationContext();
        CharSequence text="Going to A1";
        int duration = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();
setResult(RESULT_OK,resultIntent);
finish();
    }
    public void onClickAdd(View view){
        Intent resultIntent=new Intent();
        int result=Nr1+Nr2;

        resultIntent.putExtra("result",result);

        Context context=getApplicationContext();
        CharSequence text="Going to A1";
        int duration = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();
        setResult(RESULT_OK,resultIntent);
        finish();

    }
}