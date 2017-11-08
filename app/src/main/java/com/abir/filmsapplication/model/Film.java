package com.abir.filmsapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LMS on 28/06/2017.
 */

public class Film {
    @SerializedName("title")
    private String title;

    @SerializedName("intro")
    private String intro;

    @SerializedName("year")
    private String year;

    @SerializedName("text")
    private String text;

    @SerializedName("images")
    private List<String> images;

    public Film() {
    }

    public Film(String title, String intro, String year, String text, List<String> images) {
        this.title = title;
        this.intro = intro;
        this.year = year;
        this.text = text;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
