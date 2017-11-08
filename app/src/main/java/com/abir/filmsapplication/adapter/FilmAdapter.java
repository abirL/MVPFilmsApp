package com.abir.filmsapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.abir.filmsapplication.R;
import com.abir.filmsapplication.model.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LMS on 20/06/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    private List<Film> filmList=new ArrayList<>();
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_film)
        ImageView imageFilm;

        @BindView(R.id.title_film)
        TextView titleFilm;

        @BindView(R.id.year_film)
        TextView dateFilm;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.setDebug(true);
            ButterKnife.bind(this, view);
        }
    }

    public FilmAdapter(Context context, List<Film> filmList) {

        this.filmList = filmList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_films, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Film film = filmList.get(position);
        holder.dateFilm.setText(film.getYear());
        holder.titleFilm.setText(film.getTitle());

        Picasso.with(context).load(""+film.getImages().get(0))
                .fit().centerCrop()
                .into(holder.imageFilm);


    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
