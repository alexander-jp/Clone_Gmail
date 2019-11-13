package com.mundet.gmail.ui.gallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mundet.gmail.R;
import com.mundet.gmail.model.Movie;
import com.mundet.gmail.model.Results;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerGallery extends RecyclerView.Adapter<AdapterRecyclerGallery.MyViewHolder> {

    List<Results> arrayList = new ArrayList<>();
    Context context;

    public AdapterRecyclerGallery(List<Results> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterRecyclerGallery.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_gallery, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerGallery.MyViewHolder holder, int position) {
        holder.textViewNombre.setText(arrayList.get(position).getTitle());
        holder.textViewDescripcion.setText(arrayList.get(position).getOriginal_title());
        holder.textViewUbicacion.setText(arrayList.get(position).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + arrayList.get(position).getPoster_path()).into(holder.imageView);
        //holder.eventListener(arrayList);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, textViewDescripcion, textViewUbicacion;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.lugaresNombre);
            textViewDescripcion = itemView.findViewById(R.id.lugaresDescripcion);
            textViewUbicacion = itemView.findViewById(R.id.lugaresUbicacion);
            imageView = itemView.findViewById(R.id.imgMovie);
        }

        public void eventListener(ArrayList<Movie> arrayList) {

        }
    }
}
