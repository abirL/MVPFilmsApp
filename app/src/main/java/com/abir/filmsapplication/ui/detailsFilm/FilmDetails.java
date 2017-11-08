package com.abir.filmsapplication.ui.detailsFilm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.abir.filmsapplication.R;
import com.abir.filmsapplication.Session;
import com.daimajia.slider.library.SliderLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmDetails extends AppCompatActivity {

    private Session session;

    @BindView(R.id.text_intro)
    TextView textIntro;

    @BindView(R.id.text_text)
    TextView text;

    @BindView(R.id.slider)
    SliderLayout slider;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        session = new Session(this);

        //set toolbar title
        getSupportActionBar().setTitle(session.getTitle()+" ("+session.getYear()+")");

        //set content texts
        textIntro.setText(session.getIntro());
        text.setText(session.getText());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
