package com.example.tema6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onStart(View view) {
        TextView perioada = findViewById(R.id.editP);
        TextView volum = findViewById(R.id.editV);
        TextView durata = findViewById(R.id.editD);
        String P = perioada.getText().toString();
        String V = volum.getText().toString();
        String D = durata.getText().toString();

        Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
        serviceIntent.putExtra("duration", P);
        serviceIntent.putExtra("volume", V);
        serviceIntent.putExtra("durationNoise",D);
        this.startService(serviceIntent);


    }

    public void onStop(View view) {
        Intent intent_2 = new Intent(getApplicationContext(), MyService.class);
        stopService(intent_2);
    }
}