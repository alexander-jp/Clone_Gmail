package com.mundet.gmail.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mundet.gmail.R;
import com.mundet.gmail.model.BaseUrl;
import com.mundet.gmail.model.Movie;
import com.mundet.gmail.model.Results;

import java.util.ArrayList;
import java.util.Collections;
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
        Glide.with(context).load(BaseUrl.URL_IMG + arrayList.get(position).getPoster_path()).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            holder.eventListener(arrayList, position);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtTitleMovie);
            imageView = itemView.findViewById(R.id.imgMovie);
        }

        public void eventListener(List<Results> array, int position) {
            Intent intent = new Intent(context, DetailMovie.class);
            intent.putExtra("Movie", array.get(position));
            context.startActivity(intent);
        }
    }
}
