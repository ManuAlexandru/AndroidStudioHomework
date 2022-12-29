package com.example.classbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StudentUpdate extends AppCompatActivity {

    private Student selectedStudent;
    private SqlLiteManager sqlLiteManager;
private TextView name,age,classStudent,attendanceCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);

        initWidgets();
        checkForEditStudent();

    }

    private void checkForEditStudent() {
        Intent previousIntent=getIntent();

        int passedStudentId= previousIntent.getIntExtra(Student.StudentEditKey,-1);

        selectedStudent=Student.GetStudentById(passedStudentId);
        System.out.println("dsa "+selectedStudent);
        if(selectedStudent==null)
        {
            Toast.makeText(getApplicationContext(), "Sorry, we did not find any Student", Toast.LENGTH_LONG).show();
            finish();
        }
        name.setText(selectedStudent.getName());
        age.setText(selectedStudent.getAge());
        classStudent.setText(selectedStudent.getStudentClass());
        attendanceCount.setText("Attendance: 14/"+selectedStudent.getNrAttendance());
    }

    public void onClickIncrement(View view){
        int attendance=selectedStudent.getNrAttendance();
if(attendance<14){

    selectedStudent.setNrAttendance(++attendance);
    attendanceCount.setText("Attendance: 14/"+attendance);
    Toast.makeText(getApplicationContext(), "The Student attendance increased by 1", Toast.LENGTH_LONG).show();
}

else
    Toast.makeText(getApplicationContext(), "The Student already has the maximum attendance allowed", Toast.LENGTH_LONG).show();
    }

    public void onClickDecrement(View view){
        int attendance=selectedStudent.getNrAttendance();
        if(attendance>0){

            selectedStudent.setNrAttendance(--attendance);
            attendanceCount.setText("Attendance: 14/"+attendance);
            Toast.makeText(getApplicationContext(), "The Student attendance decreased by 1", Toast.LENGTH_LONG).show();
        }

        else
            Toast.makeText(getApplicationContext(), "The Student already has the minimum attendance allowed", Toast.LENGTH_LONG).show();
    }

    public void onClickUpdate(View view){
        if(inputValidators())
        {
            return;
        }
sqlLiteManager=SqlLiteManager.instanceOfDatabase(this);

selectedStudent.setName(name.getText().toString());
selectedStudent.setAge(age.getText().toString());
selectedStudent.setStudentClass(classStudent.getText().toString());

sqlLiteManager.UpdateStudent(selectedStudent);
finish();
    }
   public void onClickDelete(View view){
       sqlLiteManager=SqlLiteManager.instanceOfDatabase(this);

       sqlLiteManager.DeleteStudent(selectedStudent.getId());
       Student.RemoveStudent(selectedStudent.getId());

       Toast.makeText(getApplicationContext(), "Student was removed!", Toast.LENGTH_SHORT).show();
        finish();
   }

    private void initWidgets(){
        name=findViewById(R.id.inputEditName);
        age=findViewById(R.id.inputEditAge);
        classStudent=findViewById(R.id.inputEditClass);
        attendanceCount=findViewById(R.id.txtAttendance);
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