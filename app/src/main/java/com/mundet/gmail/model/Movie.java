package com.mundet.gmail.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Movie {

    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("sort_by")
    String sort_by;
    @SerializedName("results")
    List<Results> results;


/*    @SerializedName("iso_639_1")
    String iso_639_1;
    @SerializedName("id")
    int id;
    @SerializedName("iso_3166_1")
    String iso_3166_1;
    @SerializedName("total_results")
    int total_results;
    @SerializedName("object_ids")
    MovieIds movieIds;
    @SerializedName("revenue")
    double revenue;
    @SerializedName("total_pages")
    int total_pages;
    @SerializedName("name")
    String name;
    @SerializedName("public")
    boolean publico;
    @SerializedName("comments")
    comments comments;
    @SerializedName("sort_by")
    String sort_by;
    @SerializedName("description")
    String description;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("Results")
    List<Results> Results;
    @SerializedName("average_rating")
    double average_rating;
    @SerializedName("runtime")
    int runtime;
    @SerializedName("created_by")
    created_by created_by;
    @SerializedName("poster_path")
    String poster_path;*/
}
