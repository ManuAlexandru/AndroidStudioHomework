package com.example.classbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView studentListView;
   private StudentAdapter studentAdapter;
    @Override
    protected void onResume() {
        super.onResume();
        loadFromDatabase();
        setStudentAdapter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        loadFromDatabase();
        setStudentAdapter();
        setOnClikListener();

    }
    private void initWidgets()
    {

        studentListView=findViewById(R.id.studentList);
    }

    private void setOnClikListener() {
        studentListView=findViewById(R.id.studentList);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student=(Student) studentListView.getItemAtPosition(position);
                Intent intent=new Intent(getApplicationContext(),StudentUpdate.class);
                Toast.makeText(getApplicationContext(), "Item clicked at position " + student.getId(), Toast.LENGTH_SHORT).show();
intent.putExtra(Student.StudentEditKey,student.getId());
startActivity(intent);
            }
        });
    }

    private void loadFromDatabase() {
        SqlLiteManager sqlLiteManager=SqlLiteManager.instanceOfDatabase(this);
        sqlLiteManager.populateStudentListArray();
    }

    private void setStudentAdapter()
    {
        studentAdapter=new StudentAdapter(getApplicationContext(),Student.studentArrayList);
        studentListView.setAdapter(studentAdapter);
    }



    public void onClickAdd(View view){
        Intent newStudentIntent=new Intent(this,StudentDetailsActivity.class);
        startActivity(newStudentIntent);
    }


}