package com.app.apti.activity;

/**
 * Created by pankajjoshi on 6/10/17.
 */

public class DrawerItem {
    String name;
    int imgid;

    public DrawerItem(String name,int imgid)
    {
        this.name=name;
        this.imgid=imgid;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setImgid(int imgid)
    {
        this.imgid=imgid;
    }
    public int getImgid()
    {
        return imgid;
    }
}
