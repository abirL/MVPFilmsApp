package com.abir.filmsapplication.ui.listFilms;

import android.util.Log;

import com.abir.filmsapplication.model.Film;
import com.abir.filmsapplication.rest.ApiClient;
import com.abir.filmsapplication.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmPresenter implements FilmsPresenterInterface{
    private FilmsListView filmsListView;
    private List<Film> films;

    public FilmPresenter(FilmsListView filmsListView) {
        this.filmsListView = filmsListView;
    }

    @Override
    public List<Film> getListFilms() {
        filmsListView.showProgress();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Film>> call = apiService.getFilms();
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>>call, Response<List<Film>> response) {
                films = response.body();
                filmsListView.setItems(films);
            }
            @Override
            public void onFailure(Call<List<Film>>call, Throwable t) {
            }
        });
        filmsListView.hideProgress();
        return films;
    }

    @Override
    public void onItemClicked(int position) {
        filmsListView.navigateToFilmDetails();
    }

}
