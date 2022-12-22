package com.example.tema8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String jsonURL = "https://www.floatrates.com/daily/ron.json";
    TextView resFromApi, input;
    String suma;
    private Spinner spinner;
    private static final String[] paths = {"USD", "EUR", "MUR","ZMW"};
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void onClickConvert(View view) {
        spinner = (Spinner) findViewById(R.id.spinner);
        Object selectedItem = spinner.getSelectedItem();


        input = findViewById(R.id.editTextTextPersonName);
        String operator1 = input.getText().toString();
        if (operator1.equals("")) {
            Toast.makeText(MainActivity.this, "Plese write a sum", Toast.LENGTH_LONG).show();
        } else {
            Result(view, selectedItem.toString().toLowerCase(), operator1);

        }


    }
    public void Result(View view, String tip, String operator1) {
        resFromApi = findViewById(R.id.txtResponse);
        input = findViewById(R.id.editTextTextPersonName);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Log.i(TAG, "onClickGetData: " + jsonURL);

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: "+e.toString());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject obj = null;
                input = findViewById(R.id.editTextTextPersonName);
                try {
                    obj = new JSONObject(recData);
                    JSONObject b = obj.getJSONObject(tip);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                spinner = (Spinner) findViewById(R.id.spinner);
                                String operator = b.getString("rate").toString();
                                String response = String.valueOf((Double.parseDouble(operator1) * Double.parseDouble(operator)));
                                resFromApi.setText("Value in "+spinner.getSelectedItem().toString()+": "+response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                objToTrim = recData;
            }
        });

    }
}