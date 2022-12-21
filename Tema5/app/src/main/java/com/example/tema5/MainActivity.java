package com.example.tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int generatedNumber=0;
    int myNumber, hisNumber = -1;
    private static final Handler mainHandler = new Handler();
    private volatile boolean stopThread = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickStart(View view) {
        stopThread = false;
        Fire fire = new Fire();
        new Thread(fire).start();
    }
    public void onClickCompara(View view) {
        compareMyNumber(generatedNumber);
    }
    public void compareMyNumber(int generatedNumber) {
        TextView inputNumber = findViewById(R.id.editTxt);
        if (inputNumber.getText().length() <= 0) {
            inputNumber.setText("0");
        }
        myNumber = Integer.parseInt(inputNumber.getText().toString());

        TextView winner = findViewById(R.id.txtWin);
        if (myNumber == generatedNumber) {
            winner.setText("You won");
            stopThread = true;
        } else {
            winner.setText(myNumber+" nu e cel castigator");
        }
    }
    public void compareHisNumber(int hisNumber, int generatedNumber) {
        TextView winner = findViewById(R.id.txtWin);
        if (hisNumber == generatedNumber) {
            winner.setText("Robot won");
            stopThread = true;
        } else {
            winner.setText(hisNumber+" nu e cel castigator");
        }
    }


    class Fire implements Runnable {

        Fire() {
        }

        @Override
        public void run() {
            generatedNumber = generateRandomNumber();

            while (!stopThread) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        hisNumber = generateRandomNumber();
                        TextView textView = findViewById(R.id.txtRobot);
                        textView.setText("Robot Choosed: " + hisNumber);

                        compareHisNumber(hisNumber, generatedNumber);
                    }
                });
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(21);
    }
}