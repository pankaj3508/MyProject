package com.app.apti.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    int pos=0;
    TextView title;
    LinearLayout editor;
    String topic;
    MyDatabase_question myDatabase_question;
    TextView quest,opt1,opt2,opt3,opt4;
    LinearLayout prev,next,share;
    LinearLayout one,two,three,four;
    LinearLayout color_one,color_two,color_three,color_four;
    private ArrayList<StoreQuestionData> questions;
   // private ArrayList<QuestionData> question_list=new ArrayList<QuestionData>();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.question,container,false);
        title=(TextView)v.findViewById(R.id.ques_topic);
        editor=(LinearLayout)v.findViewById(R.id.editor);
        prev=(LinearLayout)v.findViewById(R.id.move_prev);
        next=(LinearLayout) v.findViewById(R.id.move_next);
        share=(LinearLayout) v.findViewById(R.id.share);
        one=(LinearLayout)v.findViewById(R.id.layout_opt1);
        two=(LinearLayout)v.findViewById(R.id.layout_opt2);
        three=(LinearLayout)v.findViewById(R.id.layout_opt3);
        four=(LinearLayout)v.findViewById(R.id.layout_opt4);
        color_one=(LinearLayout)v.findViewById(R.id.color_option1);
        color_two=(LinearLayout)v.findViewById(R.id.color_option2);
        color_three=(LinearLayout)v.findViewById(R.id.color_option3);
        color_four=(LinearLayout)v.findViewById(R.id.color_option4);
        quest=(TextView)v.findViewById(R.id.ques);
        opt1=(TextView)v.findViewById(R.id.option1);
        opt2=(TextView)v.findViewById(R.id.option2);
        opt3=(TextView)v.findViewById(R.id.option3);
        opt4=(TextView)v.findViewById(R.id.option4);
        quest.setText(questions.get(pos).ques);
        opt1.setText(questions.get(pos).option1);
        opt2.setText(questions.get(pos).option2);
        opt3.setText(questions.get(pos).option3);
        opt4.setText(questions.get(pos).option4);
        title.setText(topic);
      //  Log.d("pankaj",question_list.toString());

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

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos!=0)
                    pos--;
                quest.setText(questions.get(pos).ques);
                opt1.setText(questions.get(pos).option1);
                opt2.setText(questions.get(pos).option2);
                opt3.setText(questions.get(pos).option3);
                opt4.setText(questions.get(pos).option4);
                color_one.setBackgroundResource(R.drawable.rectangle_solid);
                color_two.setBackgroundResource(R.drawable.rectangle_solid);
                color_three.setBackgroundResource(R.drawable.rectangle_solid);
                color_four.setBackgroundResource(R.drawable.rectangle_solid);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos!=questions.size()-1)
                    pos++;
                quest.setText(questions.get(pos).ques);
                opt1.setText(questions.get(pos).option1);
                opt2.setText(questions.get(pos).option2);
                opt3.setText(questions.get(pos).option3);
                opt4.setText(questions.get(pos).option4);
                color_one.setBackgroundResource(R.drawable.rectangle_solid);
                color_two.setBackgroundResource(R.drawable.rectangle_solid);
                color_three.setBackgroundResource(R.drawable.rectangle_solid);
                color_four.setBackgroundResource(R.drawable.rectangle_solid);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareBody = "Hey check out this question \n\n"+questions.get(pos).ques+"\n\n"+questions.get(pos).option1+
                        "\n\n"+questions.get(pos).option2+"\n\n"+questions.get(pos).option3+"\n\n"+questions.get(pos).option4;
                Intent sharing=new Intent(Intent.ACTION_SEND);
                sharing.setType("text/plain");
                sharing.putExtra(android.content.Intent.EXTRA_SUBJECT, "Prepare aptitude and for interviews");

                sharing.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                try {
                    startActivity(Intent.createChooser(sharing, "Share via"));
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(getActivity().getApplication(),"There is no email/message client in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(pos).answer.equalsIgnoreCase(questions.get(pos).option1))
                {
                    color_one.setBackgroundColor(Color.parseColor("#52919A"));
                }
                else
                {
                    color_one.setBackgroundColor(Color.parseColor("#FFD25239"));
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(pos).answer.equalsIgnoreCase(questions.get(pos).option2))
                {
                    color_two.setBackgroundColor(Color.parseColor("#52919A"));
                }
                else
                {
                    color_two.setBackgroundColor(Color.parseColor("#FFD25239"));
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(pos).answer.equalsIgnoreCase(questions.get(pos).option3))
                {
                    color_three.setBackgroundColor(Color.parseColor("#52919A"));
                }
                else
                {
                    color_three.setBackgroundColor(Color.parseColor("#FFD25239"));
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(pos).answer.equalsIgnoreCase(questions.get(pos).option4))
                {
                    color_four.setBackgroundColor(Color.parseColor("#52919A"));
                }
                else
                {
                    color_four.setBackgroundColor(Color.parseColor("#FFD25239"));
                }
            }
        });
        return v;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b=getArguments();
        topic=b.getString("topic");
        myDatabase_question=new MyDatabase_question(getActivity());
        questions=myDatabase_question.getQuestions(topic.toUpperCase());

      /*  XmlPullParserFactory xmlPullParserFactory;
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
        }*/
    }

    /*private ArrayList<QuestionData> parseXml(XmlPullParser xmlPullParser) throws
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

    }*/
}
