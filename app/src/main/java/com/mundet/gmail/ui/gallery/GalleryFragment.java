package com.mundet.gmail.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mundet.gmail.R;
import com.mundet.gmail.model.Movie;
import com.mundet.gmail.model.Results;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        RecyclerView lista = root.findViewById(R.id.recyclerListGallery);
        lista.setHasFixedSize(true);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        galleryViewModel.getLugaresModel().observe(this, new Observer<List<Results>>() {
            @Override
            public void onChanged(List<Results> movies) {
                lista.setAdapter(new AdapterRecyclerGallery(movies, getActivity()));
            }
        });
        return root;
    }
}