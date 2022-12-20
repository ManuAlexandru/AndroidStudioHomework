package com.example.tema3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ImageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        Intent intent = getIntent();
        String details = intent.getStringExtra("description");
        String displayMessage = details;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("key", displayMessage);
        ImageDetailsFragment blankFragment = new ImageDetailsFragment();
        blankFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainerView, blankFragment).commit();
    }

    public void onClickBack(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Going Back", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent1 = new Intent(ImageDetailsActivity.this, MainActivity.class);
        startActivity(intent1);
    }
}