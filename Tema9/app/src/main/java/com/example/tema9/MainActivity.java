package com.example.tema9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView name, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.inputFilterByName);
        result=findViewById(R.id.txtResult);
    }

    public void onClickMove(View view){
        Intent switchActivityIntent = new Intent(this, AddToDataBase.class);
        startActivity(switchActivityIntent);
    }
    public void onClickFilter(View view){
        System.out.println("Intra in metoda");
        SqlLiteManager sqlLiteManager=new SqlLiteManager(this);
        System.out.println("Intra in metoda1");
User user=sqlLiteManager.getUser(name.getText().toString());
if(user==null)
    result.setText("Studentul cu acest nume nu exista");
else {
    result.setText("Name: " + user.getName() + "\n" +
            "Age: " + user.getAge() + "\n" +
            "Class: " + user.getUserClass() + "\n");
    System.out.println("Intra in metoda2");
}
    }
}