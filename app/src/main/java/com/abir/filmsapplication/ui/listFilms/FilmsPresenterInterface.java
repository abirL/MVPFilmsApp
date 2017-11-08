package com.abir.filmsapplication.ui.listFilms;

import com.abir.filmsapplication.model.Film;

import java.util.List;

/**
 * Created by LMS on 01/11/2017.
 */

public interface FilmsPresenterInterface {

    List<Film> getListFilms();
    void onItemClicked(int position);

}
