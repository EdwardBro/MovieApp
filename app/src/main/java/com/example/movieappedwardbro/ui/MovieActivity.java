package com.example.movieappedwardbro.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.movieappedwardbro.R;

public class MovieActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageView posterImage;
    private TextView title;
    private TextView releaseDate;
    private TextView rating;
    private TextView overview;
    private Button buttonBack;
    private String baseImageURL = "https://image.tmdb.org/t/p/w500";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_cell);

        initViews();
    }

    private void initViews() {
        backgroundImage = findViewById(R.id.backgroundImage);
        posterImage = findViewById(R.id.posterImage);
        title = findViewById(R.id.title);
        releaseDate = findViewById(R.id.release);
        rating = findViewById(R.id.rating);
        overview = findViewById(R.id.overview);
        buttonBack = findViewById(R.id.backButton);

        Glide.with(this)
                .load(baseImageURL + getIntent().getStringExtra("backdropImage"))
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(backgroundImage);
        Glide.with(this)
                .load(baseImageURL + getIntent().getStringExtra("posterImage"))
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(posterImage);
        title.setText(getIntent().getStringExtra("title"));
        releaseDate.setText(getIntent().getStringExtra("releaseDate"));
        rating.setText(Double.toString(getIntent().getDoubleExtra("rating", 0.0)));
        overview.setText(getIntent().getStringExtra("overview"));
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
