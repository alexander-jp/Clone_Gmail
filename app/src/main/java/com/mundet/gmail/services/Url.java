package com.mundet.gmail.services;

import com.mundet.gmail.model.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Url {

    @GET("/4/list/{list_id}?api_key=db4da979de34e8168cfe2523c14eacbe&language=en-US")
    Observable<Movie> getDataLugares(@Path("list_id") int list_id);
}
