package com.app.apti.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apti.R;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by pankajjoshi on 12/10/17.
 */

public class Question extends Fragment {

    TextView title;
    LinearLayout editor;
    private ArrayList<QuestionData> question_list=new ArrayList<QuestionData>();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.question,container,false);
        title=(TextView)v.findViewById(R.id.ques_topic);
        editor=(LinearLayout)v.findViewById(R.id.editor);
        Bundle b=getArguments();
        title.setText(b.getString("topic"));
        Log.d("pankaj",question_list.toString());

        editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new Editor();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XmlPullParserFactory xmlPullParserFactory;
        try {
            xmlPullParserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser=xmlPullParserFactory.newPullParser();
            InputStream inputStream = getActivity().getApplicationContext().getAssets().open("age.xml");
            xmlPullParser.setFeature(xmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            xmlPullParser.setInput(inputStream,null);
            question_list=parseXml(xmlPullParser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<QuestionData> parseXml(XmlPullParser xmlPullParser) throws
            XmlPullParserException,IOException
    {
        ArrayList<QuestionData> quest=null;
        int eventType=xmlPullParser.getEventType();
        QuestionData questiondata=null;
        while(eventType!=XmlPullParser.END_DOCUMENT)
        {
            String name;
            switch(eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                    quest=new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    name=xmlPullParser.getName();
                    if(name.equals("question"))
                    {
                        questiondata=new QuestionData();

                    }else if(questiondata!=null)
                    {
                        if(name.equals("que")){
                            questiondata.setQues(xmlPullParser.nextText());
                        }else if(name.equals("option1")){
                            questiondata.setOpt1(xmlPullParser.nextText());
                        }else if(name.equals("option2")){
                            questiondata.setOpt2(xmlPullParser.nextText());
                        }else if(name.equals("option3")){
                            questiondata.setOpt3(xmlPullParser.nextText());
                        }else if(name.equals("option4")){
                            questiondata.setOpt4(xmlPullParser.nextText());
                        }else if(name.equals("answer")){
                            questiondata.setAns(xmlPullParser.nextText());
                        }else if(name.equals("explanation")){
                            questiondata.setExp(xmlPullParser.nextText());
                        }

                    }
                    break;
                case XmlPullParser.END_TAG:
                    name=xmlPullParser.getName();
                    if(name.equalsIgnoreCase("question") && questiondata!=null)
                    {
                        quest.add(questiondata);
                    }
                    break;
            }
            eventType=xmlPullParser.next();
        }
        return quest;

    }
}
