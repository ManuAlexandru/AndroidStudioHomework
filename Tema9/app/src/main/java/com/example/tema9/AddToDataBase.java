package com.example.tema9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddToDataBase extends AppCompatActivity {
TextView name,age,userClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_data_base);
        name=findViewById(R.id.inputName);
        age=findViewById(R.id.inputAge);
        userClass=findViewById(R.id.inputClass);
    }

    public void onClickBack(View view){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
    public void onClickAdd(View view){
        SqlLiteManager sqlLiteManager=new SqlLiteManager(this);

        User user=new User(0,name.getText().toString(),age.getText().toString(),userClass.getText().toString());

        sqlLiteManager.addUserToDB(user);
    }
}