package com.example.lab2v4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void moveToA2(View view) {
        Intent intent1 = new Intent(this, MainActivity2.class);
        EditText nr1 = findViewById(R.id.sendName);
        EditText nr2 = findViewById(R.id.sendName2);


        if (ValidateNumbers(nr1, nr2) == true) {
            intent1.putExtra("string_key", nr1.getText().toString());
            intent1.putExtra("string_key1", nr2.getText().toString());
            startActivityForResult(intent1,1);
            CreateToast("Going to A2");
        } else
            CreateToast("Please introduce the numbers");


    }

    public boolean ValidateNumbers(EditText nr1, EditText nr2) {
        if (nr1 == null || nr2 == null)
            return false;
        return true;


    }


    public void CreateToast(CharSequence message) {
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode,resultCode,data);
if(requestCode==1) {
    int result = 0;
    if (resultCode == RESULT_OK) {
        result = data.getIntExtra("result", 0);
        TextView txtViewReceivedData = findViewById(R.id.result);
        txtViewReceivedData.setText("Result: " + result);
    }
}

    }
}