package com.example.tema9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlLiteManager extends SQLiteOpenHelper {

    private static SqlLiteManager sqlLiteManager;
    private static final String DATABASE_Name="NoteDB";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="USER";
    private static final String COUNTER="Counter";

    private static final String id_field="id";
    private static final String name_field="name";
    private static final String age_field="age";
    private static final String class_field="class";

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
        .append(TABLE_NAME)
        .append("(")
        .append(COUNTER)
        .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
        .append(id_field)
        .append(" INT, ")
        .append(name_field)
        .append(" TEXT, ")
        .append(age_field)
        .append(" TEXT, ")
        .append(class_field)
        .append(" TEXT)");
        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addUserToDB(User user){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(id_field,user.getId());
        contentValues.put(name_field,user.getName());
        contentValues.put(age_field,user.getAge());
        contentValues.put(class_field, user.getUserClass());
sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }
    public User  getUser(String Name) {
        System.out.println("Intra in metoda2");
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        System.out.println("Intra in metoda3");
        //Cursor result=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME +" where "+name_field+"="+Name,null);
        try {
            Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME+" where "+name_field+"=?", new String[]{Name});
            result.moveToFirst();


                return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    }

