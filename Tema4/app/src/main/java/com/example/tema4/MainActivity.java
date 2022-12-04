package com.example.tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText editText;
private Button btnAdd;
private Button btnDel;
private ListView listView;
private ArrayList<String> nameList;
private ArrayAdapter<String> adapter;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.inputName);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnDel=(Button) findViewById(R.id.btnDel);
        listView=(ListView) findViewById(R.id.lstNames);

        nameList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,nameList);
    listView.setAdapter(adapter);
    }
    public void onClickAdd(View v){
nameList.add(editText.getText().toString());
//System.out.println(nameList.size());
adapter.notifyDataSetChanged();
    }
   public void onClickDel(View v){
String name=editText.getText().toString();
int pozElem=nameList.indexOf(name);
if(pozElem!=-1)
{
    nameList.remove(pozElem);
    adapter.notifyDataSetChanged();
}
else
{
    toast=Toast. makeText(getApplicationContext(),"Nume introdus nu exista",Toast. LENGTH_SHORT);
    toast.show();

    //    System.out.println(nameList.size());
//    System.out.println("Element eliminat");
}
   }
}