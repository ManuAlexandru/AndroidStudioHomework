package com.example.classbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SqlLiteManager extends SQLiteOpenHelper {

    private static SqlLiteManager sqlLiteManager;
    private static final String DATABASE_Name="ClassBook";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME_STUDENT="Student";
    private static final String COUNTER="Counter";

    private static final String id_Student="id";
    private static final String name_Student="name";
    private static final String age_Student="age";
    private static final String nrAttendance_Student="nrAttendance";
    private static final String class_Student="StudentClass";

    public SqlLiteManager( Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    public static SqlLiteManager instanceOfDatabase(Context context){
        if(sqlLiteManager==null)
            sqlLiteManager=new SqlLiteManager(context);
        return sqlLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql;
        sql=new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME_STUDENT)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(id_Student)
                .append(" INT, ")
                .append(name_Student)
                .append(" TEXT, ")
                .append(age_Student)
                .append(" TEXT, ")
                .append(nrAttendance_Student)
                .append(" INT, ")
                .append(class_Student)
                .append(" TEXT)");
        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void populateStudentListArray(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Student.studentArrayList=new ArrayList<>();
            try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME_STUDENT, null)) {
                if(result.getCount()!=0){
                    while(result.moveToNext()){
                        int id=result.getInt(1);
                        String name=result.getString(2);
                        String age=result.getString(3);
                        int attendance=result.getInt(4);
                        String classStudent=result.getString(5);


                        Student student=new Student(id,name,age,classStudent,attendance);
                        Student.studentArrayList.add(student);
                    }
                }
            }catch(Exception ex){System.out.println(ex.toString());}
    }

    public void UpdateStudent(Student student){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(id_Student,student.getId());
        contentValues.put(name_Student,student.getName());
        contentValues.put(age_Student,student.getAge());
        System.out.println(student.getStudentClass());
        contentValues.put(class_Student, student.getStudentClass());
        contentValues.put(nrAttendance_Student, student.getNrAttendance());
        sqLiteDatabase.update(TABLE_NAME_STUDENT,contentValues,id_Student+"=?",new String[]{String.valueOf(student.getId())});
    }
    public void DeleteStudent(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TABLE_NAME_STUDENT,id_Student + "=?", new String[]{String.valueOf(id)});
    }

        public void addStudentToDb(Student student){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(id_Student,student.getId());
        contentValues.put(name_Student,student.getName());
        contentValues.put(age_Student,student.getAge());
        contentValues.put(class_Student, student.getStudentClass());
        contentValues.put(nrAttendance_Student, 0);
        sqLiteDatabase.insert(TABLE_NAME_STUDENT,null,contentValues);
    }
}
