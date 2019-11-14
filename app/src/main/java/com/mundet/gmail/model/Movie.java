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
}
