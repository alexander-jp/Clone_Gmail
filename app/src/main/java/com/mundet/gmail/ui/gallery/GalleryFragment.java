package com.mundet.gmail.ui.gallery;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mundet.gmail.R;
import com.mundet.gmail.model.Movie;
import com.mundet.gmail.model.Results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView lista;
    ProgressBar progressBar;
    Display display;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        lista = root.findViewById(R.id.recyclerListGallery);
        progressBar = root.findViewById(R.id.progress_circularGallery);
        lista.setHasFixedSize(true);
        lista.setLayoutManager(new GridLayoutManager(getActivity(), widthGrid()));
        galleryViewModel.getLugaresModel().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                progressBar.setVisibility(View.GONE);
                lista.setVisibility(View.VISIBLE);
                lista.setAdapter(new AdapterRecyclerGallery(movies.get(0).getResults(), getActivity()));
            }
        });
        Log.i("tamanio", String.valueOf(widthGrid()));
        return root;
    }

    private int widthGrid() {
        display = getActivity().getWindowManager().getDefaultDisplay();
        return display.getWidth() / 400;
    }
}