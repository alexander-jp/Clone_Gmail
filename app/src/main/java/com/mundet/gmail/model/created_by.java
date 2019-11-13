package com.mundet.gmail.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class created_by {
    @SerializedName("gravatar_hash")
    String gravatar;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;
    @SerializedName("id")
    String id;

}

