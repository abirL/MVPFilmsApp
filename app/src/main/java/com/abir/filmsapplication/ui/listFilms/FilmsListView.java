package com.abir.filmsapplication.ui.listFilms;


import com.abir.filmsapplication.model.Film;

import java.util.List;

public interface FilmsListView {
    void setItems(List<Film> items);
    void navigateToFilmDetails();
    void setToolbarTitle();
    void showProgress();
    void hideProgress();
}
