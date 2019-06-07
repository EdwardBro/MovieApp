package com.example.movieappedwardbro.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("vote_average")
    private double rating;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    private String posterImage;

    @SerializedName("backdrop_path")
    private String backdropImage;

    @SerializedName("adult")
    private Boolean adult;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids;

    @SerializedName("id")
    private int id;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("popularity")
    private Number popularity;

    @SerializedName("video")
    private Boolean video;

    @SerializedName("vote_count")
    private Integer vote_count;

    public Movie(String title, String overview, double rating, String releaseDate, String posterImage, String backdropImage, Boolean adult, List<Integer> genre_ids, int id, String original_title, String original_language, Number popularity, Boolean video, Integer vote_count) {
        this.title = title;
        this.overview = overview;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.posterImage = posterImage;
        this.backdropImage = backdropImage;
        this.adult = adult;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.popularity = popularity;
        this.video = video;
        this.vote_count = vote_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getBackdropImage() {
        return backdropImage;
    }

    public void setBackdropImage(String backdropImage) {
        this.backdropImage = backdropImage;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public Number getPopularity() {
        return popularity;
    }

    public void setPopularity(Number popularity) {
        this.popularity = popularity;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }
}
