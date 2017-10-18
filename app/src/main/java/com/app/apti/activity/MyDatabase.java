package com.app.apti.activity;

/**
 * Created by pankajjoshi on 18/10/17.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "questions.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ques="question";
    private static final String answer="answer";
    private static final String company="interview_of";
    private static final String table="interview";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<storedatabsevalue> getQuestions(){
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={MyDatabase.ques,MyDatabase.answer,MyDatabase.company};
//        String[] selectionArgs={categoryId+"",subjectId+"",yearId+""};
        Cursor cursor=db.query(MyDatabase.table, columns,null , null, null, null, null);
//        Cursor cursor=db.query(MyDatabase.TABLE_NAME, columns, null,null, null, null, null);
        ArrayList<storedatabsevalue> questionsArrayList=new ArrayList<>();

        while(cursor.moveToNext()){
            storedatabsevalue questions=new storedatabsevalue();
            questions.ques=cursor.getString(cursor.getColumnIndex(MyDatabase.ques));
            questions.answer=cursor.getString(cursor.getColumnIndex(MyDatabase.answer));
            questions.company=cursor.getString(cursor.getColumnIndex(MyDatabase.company));
            questionsArrayList.add(questions);
        }
        return questionsArrayList;
    }



}