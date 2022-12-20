package com.example.tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.tema3.R.drawable.poza1;
import static com.example.tema3.R.drawable.poza2;
import static com.example.tema3.R.drawable.poza3;

public class MainActivity extends AppCompatActivity {
    static int count = 1;
    ImageView imageView;
    String description = "O poza cu Floarea Soarelui";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        imageView.setImageResource(0);
        imageView.setBackgroundResource(poza1);
    }

    public void onClickDet(View view) {
        Intent intent = new Intent(this, ImageDetailsActivity.class);

        intent.putExtra("description",description);
        Toast toast = Toast.makeText(getApplicationContext(), "Going to Details", Toast.LENGTH_SHORT);
        toast.show();
        startActivity(intent);
    }

    public void onClickPrev(View view) {
        SetImage(-1);
    }

    public void onClickNext(View view) {

        SetImage(1);


    }

    private void SetImage(int index) {
        imageView = findViewById(R.id.img);

        count = count + index;
        if (count == 1) {
            imageView.setBackgroundResource(poza1);
            description="O poza cu Floarea Soarelui";
        }
        if (count == 2) {

            imageView.setBackgroundResource(poza2);
            description="O poza cu un barbat si caine";
        }
        if (count == 3) {
            imageView.setBackgroundResource(poza3);
            description="O poza cu o carte";
        }
        if (count > 3) {
            count = 1;
            imageView.setBackgroundResource(poza1);
            description="O poza cu Floarea Soarelui";
        }
        if (count < 1) {
            count = 3;
            imageView.setBackgroundResource(poza3);
            description="O poza cu o carte";
        }
    }
}
