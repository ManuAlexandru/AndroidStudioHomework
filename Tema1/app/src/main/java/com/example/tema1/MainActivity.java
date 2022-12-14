package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView firstName,lastName,email;
EditText editFirstName,editLastName,editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName=findViewById(R.id.txt1);
        lastName=findViewById(R.id.txt2);
        email=findViewById(R.id.txt3);
        editFirstName=findViewById(R.id.txtFirstName);
        editLastName=findViewById(R.id.txtLastName);
        editEmail=findViewById(R.id.txtEmail);
    }
  public void onClickReg(View view){
firstName.setText("First Name: "+editFirstName.getText().toString());
      lastName.setText("First Name: "+editLastName.getText().toString());
      email.setText("First Name: "+editEmail.getText().toString());
  }
}