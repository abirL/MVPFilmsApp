package com.abir.filmsapplication;

import android.content.Context;
import android.content.SharedPreferences;


public class Session {
    private SharedPreferences prefs;
    SharedPreferences.Editor editor ;
    public Session(Context cntx) {
        editor = cntx.getSharedPreferences("film", 0).edit();
        prefs = cntx.getSharedPreferences("film", 0);
    }


    public void setText(String text) {

        editor.putString("text", text);
        editor.commit();
    }

    public String getText() {
        String text = prefs.getString("text","");
        return text;
    }

    public void setIntro(String intro) {

        editor.putString("intro", intro);
        editor.commit();
    }

    public String getIntro() {
        String intro = prefs.getString("intro","");
        return intro;
    }

    public void setYear(String year) {

        editor.putString("year", year);
        editor.commit();
    }

    public String getYear() {
        String year = prefs.getString("year","");
        return year;
    }
    public void setTitle(String title) {

        editor.putString("title", title);
        editor.commit();
    }

    public String getTitle() {
        String title = prefs.getString("title","");
        return title;
    }

}
