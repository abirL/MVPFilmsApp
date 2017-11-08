package com.abir.filmsapplication.ui.listFilms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.abir.filmsapplication.R;
import com.abir.filmsapplication.adapter.FilmAdapter;
import com.abir.filmsapplication.model.Film;
import com.abir.filmsapplication.ui.detailsFilm.FilmDetails;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmsList extends AppCompatActivity implements FilmsListView {

    @BindView(R.id.recycler_view_films)
    RecyclerView recyclerViewFilms;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.test)
    TextView test;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    private FilmAdapter filmAdapter;
    private FilmsPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setToolbarTitle();
        setSupportActionBar(toolbar);
        presenter = new FilmPresenter(this);
        presenter.getListFilms();

    }
    @Override protected void onResume() {
        super.onResume();
    }
    @Override protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_title_sort) {
            Collections.sort(presenter.getListFilms(), new Comparator<Film>() {
                @Override
                public int compare(Film lhs, Film rhs) {
                    return lhs.getTitle().compareTo(rhs.getTitle());
                }
            });
            filmAdapter.notifyDataSetChanged();
            return true;
        }
        if (id == R.id.action_year_sort) {
            Collections.sort(presenter.getListFilms(), new Comparator<Film>() {
                @Override
                public int compare(Film lhs, Film rhs) {
                    return lhs.getYear().compareTo(rhs.getYear());
                }
            });
            filmAdapter.notifyDataSetChanged();
            return true;
        }
        if (id == R.id.action_clear_sorting) {
            filmAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setItems(final List<Film> items) {
        filmAdapter = new FilmAdapter(FilmsList.this,items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFilms.setLayoutManager(mLayoutManager);
        recyclerViewFilms.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFilms.setAdapter(filmAdapter);
    }

    @Override
    public void navigateToFilmDetails() {
        Intent intent = new Intent(FilmsList.this, FilmDetails.class);
        startActivity(intent);
    }

    @Override
    public void setToolbarTitle() {
        getSupportActionBar().setTitle(getString(R.string.title_page_one));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewFilms.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerViewFilms.setVisibility(View.VISIBLE);
    }
}
