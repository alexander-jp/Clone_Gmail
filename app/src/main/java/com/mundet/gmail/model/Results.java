package com.mundet.gmail.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Results {

    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("vote_count")
    int vote_count;
    @SerializedName("video")
    boolean video;
    @SerializedName("media_type")
    String media_type;
    @SerializedName("id")
    int id;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("original_language")
    String original_language;
    @SerializedName("original_title")
    String original_title;
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    String vote_average;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String release_date;

    public Results(){}

    public Results(String poster_path, double popularity, int vote_count, boolean video, String media_type, int id, boolean adult, String backdrop_path, String original_language, String original_title, String title, String vote_average, String overview, String release_date) {
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.media_type = media_type;
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
    }

    /*  @SerializedName("poster_path")
    String poster_path;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("vote_count")
    int vote_count;
    @SerializedName("video")
    boolean video;
    @SerializedName("media_type")
    String media_type;
    @SerializedName("id")
    int id;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("original_language")
    String original_language;
    @SerializedName("original_title")
    String original_title;
    @SerializedName("genre_ids")
    String genre_ids;
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    String vote_average;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String release_date;*/



}
