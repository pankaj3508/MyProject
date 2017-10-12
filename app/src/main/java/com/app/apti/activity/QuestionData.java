package com.app.apti.activity;

/**
 * Created by pankajjoshi on 12/10/17.
 */

public class QuestionData {
    private String ques;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String ans;
    private String exp;

    public void setQues(String s)
    {
        this.ques=s;
    }
    public void setOpt1(String s)
    {
        this.opt1=s;
    }
    public void setOpt2(String s)
    {
        this.opt2=s;
    }
    public void setOpt3(String s)
    {this.opt3=s;

    }
    public void setOpt4(String s)
    {
        this.opt4=s;
    }
    public void setAns(String s)
    {
        this.ans=s;
    }
    public void setExp(String s)
    {
        this.exp=s;
    }

    public String getQues() {
        return ques;
    }

    public String getOpt1()
    {
        return opt1;
    }
    public String getOpt2()
    {
        return opt2;
    }
    public String getOpt3()
    {
        return opt3;
    }
    public String getOpt4()
    {
        return opt4;
    }
    public String getAns()
    {
        return ans;
    }
    public String getExp()
    {
        return exp;
    }

}
