package com.example.classbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetailsActivity extends AppCompatActivity {

    private EditText name,age,classStudent,presenceEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        initWidgets();
    }

    private void initWidgets() {
        name=findViewById(R.id.inputName);
        age=findViewById(R.id.inputAge);
        classStudent=findViewById(R.id.inputClass);

    }

    public void onClickSave(View view){
        SqlLiteManager sqlLiteManager=SqlLiteManager.instanceOfDatabase(this);

        if(inputValidators())
        {
            return;
        }

String resultName=String.valueOf(name.getText());
String resultAge=String.valueOf(age.getText());
String resultClasStudent=String.valueOf(classStudent.getText());

int id=Student.studentArrayList.size();
Student student=new Student(id,resultName,resultAge,resultClasStudent,0);
Student.studentArrayList.add(student);
sqlLiteManager.addStudentToDb(student);
finish();
    }
    private Boolean inputValidators(){
        if(name.getText().length()==0){
            Toast.makeText(getApplicationContext(), "Name field can not be empty!", Toast.LENGTH_SHORT).show();
            return true;
        }


        if(age.getText().length()==0)
        {
            Toast.makeText(getApplicationContext(), "Age field can not be empty!", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(classStudent.getText().length()==0)
        {
            Toast.makeText(getApplicationContext(), "Class field can not be empty!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}