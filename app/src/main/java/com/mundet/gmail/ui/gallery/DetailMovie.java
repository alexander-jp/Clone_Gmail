package com.mundet.gmail.ui.gallery;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mundet.gmail.R;
import com.mundet.gmail.model.BaseUrl;
import com.mundet.gmail.model.Results;

import java.util.ArrayList;
import java.util.List;

public class DetailMovie extends AppCompatActivity {
    Results resultado;
    TextView txtNameMovie, txtVoteMovie, txtDateMovie, txtOverviewMovie;
    ImageView imageView, imgMovie;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        txtNameMovie = findViewById(R.id.txtNameMovie);
        txtVoteMovie = findViewById(R.id.txtVoteMovie);
        txtDateMovie = findViewById(R.id.txtDateMovie);
        txtOverviewMovie = findViewById(R.id.txtOverviewMovie);
        imageView = findViewById(R.id.imgAvatarMovie);
        imgMovie = findViewById(R.id.imgMovie);
        coordinatorLayout = findViewById(R.id.coordinatorDetailMovie);
        setDataViews();
    }

    private void setDataViews() {
        resultado = getIntent().getParcelableExtra("Movie");
        txtNameMovie.setText(resultado.getTitle());
        txtVoteMovie.setText(resultado.getVote_average());
        txtDateMovie.setText(resultado.getRelease_date());
        txtOverviewMovie.setText(resultado.getOverview());

        Glide.with(this).load(BaseUrl.URL_IMG_200 + resultado.getPoster_path()).override(1, 1).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                coordinatorLayout.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });

        Glide.with(this).load(BaseUrl.URL_IMG + resultado.getPoster_path()).into(imageView);
        Glide.with(this).load(BaseUrl.URL_IMG + resultado.getPoster_path()).into(imgMovie);
    }
}
