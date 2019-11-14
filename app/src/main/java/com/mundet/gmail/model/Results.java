package com.mundet.gmail.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Results implements Parcelable {
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

    protected Results(Parcel in) {
        poster_path = in.readString();
        popularity = in.readDouble();
        vote_count = in.readInt();
        video = in.readByte() != 0;
        media_type = in.readString();
        id = in.readInt();
        adult = in.readByte() != 0;
        backdrop_path = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        title = in.readString();
        vote_average = in.readString();
        overview = in.readString();
        release_date = in.readString();
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeDouble(popularity);
        dest.writeInt(vote_count);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeString(media_type);
        dest.writeInt(id);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(backdrop_path);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(title);
        dest.writeString(vote_average);
        dest.writeString(overview);
        dest.writeString(release_date);
    }
}
