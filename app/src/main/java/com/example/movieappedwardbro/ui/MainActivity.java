package com.example.movieappedwardbro.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieappedwardbro.R;
import com.example.movieappedwardbro.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieListAdapter movieListAdapter;
    private RecyclerView rvMovies;
    private List<Movie> movieList = new ArrayList<>();
    private ImageView posterImage;
    private Button btnMovies;
    private EditText yearEdit;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText targetEditText = (EditText)findViewById(R.id.yearText);
        targetEditText.setOnEditorActionListener(new DoneOnEditorActionListener());

        initViews();
        initObservers();
        initRecyclerView();
    }

    private void initRecyclerView() {
        movieListAdapter = new MovieListAdapter(this, movieList);
        rvMovies = findViewById(R.id.movieList);
        rvMovies.setAdapter(movieListAdapter);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rvMovies.setLayoutManager(gridLayoutManager);
        rvMovies.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() { // Add Global Layout Listener to calculate the span count.
                    @Override
                    public void onGlobalLayout() {
                        rvMovies.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        gridLayoutManager.setSpanCount(calculateSpanCount());
                        gridLayoutManager.requestLayout();
                    }
                });
        viewModel.getMovies();
    }

    /**
     * Calculate the number of spans for the recycler view based on the recycler view width.
     *
     * @return int number of spans.
     */

    private int calculateSpanCount() {
        int viewWidth = rvMovies.getMeasuredWidth();
        float cardViewWidth = getResources().getDimension(R.dimen.poster_width);
        float cardViewMargin = getResources().getDimension(R.dimen.margin_medium);
        int spanCount = (int) Math.floor(viewWidth / (cardViewWidth + cardViewMargin));
        return spanCount >= 1 ? spanCount : 1;
    }

    private void initViews() {
        posterImage = findViewById(R.id.posterImage);
        btnMovies = findViewById(R.id.submitButton);
        yearEdit = findViewById(R.id.yearText);
        btnMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getMovieYear(yearEdit.getText().toString());
            }
        });
    }

    private void initObservers() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showToast(s);
            }
        });
        viewModel.getMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movieList = movies;
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (movieListAdapter == null) {
            movieListAdapter = new MovieListAdapter(this, movieList);
            rvMovies.setAdapter(movieListAdapter);
        } else {
            movieListAdapter.swapList(movieList);
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG)
                .show();
    }

}

class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            return true;
        }
        return false;
    }
}


































































// API key - c6eba2d84478124f61928ecad8e7aacd