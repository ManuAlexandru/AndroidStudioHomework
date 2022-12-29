package com.example.classbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, List<Student> students){
        super(context,0,students);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student=getItem(position);
        if(convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.student_list,parent,false);

        TextView name=convertView.findViewById(R.id.nameCell);
        TextView classStudent=convertView.findViewById(R.id.classCell);
        TextView age=convertView.findViewById(R.id.ageCell);
        TextView presence=convertView.findViewById(R.id.attendanceCell);

        name.setText(student.getName());
        classStudent.setText(student.getStudentClass());
        age.setText(student.getAge());
        presence.setText(String.valueOf(student.getNrAttendance()));

        return convertView;
    }
}
