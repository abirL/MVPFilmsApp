package com.abir.filmsapplication.rest;

import android.widget.LinearLayout;

import com.abir.filmsapplication.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LMS on 17/10/2017.
 */

public interface ApiInterface {
    @GET("5927731b11000034066ccc7a")
    Call<List<Film>> getFilms();
}
