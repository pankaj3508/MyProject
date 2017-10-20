package com.app.apti.activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by pankajjoshi on 20/10/17.
 */

public class MyDatabase_question extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "aptitudedb.db";
    private static final int DATABASE_VERSION = 3;
    private static final String ques = "ques";
    private static final String option1 = "option1";
    private static final String option2 = "option2";
    private static final String option3 = "option3";
    private static final String option4 = "option4";
    private static final String answer = "answer";
    private static final String explanation = "explanation";
    //private static final String topic="topic";
    private static final String table = "interview";

    public MyDatabase_question(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<StoreQuestionData> getQuestions(String topic) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT ques, option1, option2, option3, option4, answer, explanation from ques" +
                        " WHERE topic='"+topic+"'";
//        String[] selectionArgs={categoryId+"",subjectId+"",yearId+""};
        Cursor cursor = db.rawQuery(query, null);
//        Cursor cursor=db.query(MyDatabase.TABLE_NAME, columns, null,null, null, null, null);
        ArrayList<StoreQuestionData> questionsArrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            StoreQuestionData questions = new StoreQuestionData();
            questions.ques = cursor.getString(cursor.getColumnIndex(MyDatabase_question.ques));
            questions.option1 = cursor.getString(cursor.getColumnIndex(MyDatabase_question.option1));
            questions.option2 = cursor.getString(cursor.getColumnIndex(MyDatabase_question.option2));
            questions.option3 = cursor.getString(cursor.getColumnIndex(MyDatabase_question.option3));
            questions.option4 = cursor.getString(cursor.getColumnIndex(MyDatabase_question.option4));
            questions.answer = cursor.getString(cursor.getColumnIndex(MyDatabase_question.answer));
            questions.explanation = cursor.getString(cursor.getColumnIndex(MyDatabase_question.explanation));

            questionsArrayList.add(questions);
        }
        return questionsArrayList;
    }
}
