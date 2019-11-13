package com.mundet.gmail.ui.gallery;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mundet.gmail.model.Movie;
import com.mundet.gmail.model.Results;
import com.mundet.gmail.services.BaseRetrofitUrl;
import com.mundet.gmail.services.Url;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class GalleryViewModel extends ViewModel {
    //MutableLiveData getter and setter
    MutableLiveData<List<Movie>> listMutableLiveData;
    List<Movie> modelList;
    CompositeDisposable compositeDisposable;

    public GalleryViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<Movie>> getLugaresModel() {
        getFetchDataServer();
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            modelList = new ArrayList<>();
        }
        return listMutableLiveData;
    }

    //    public void addLugares(Movie lugaresModel) {
//        modelList.add(lugaresModel);
//        listMutableLiveData.setValue(modelList);
//    }
    private void getFetchDataServer() {
        Url service = new BaseRetrofitUrl().getBaseurl().create(Url.class);
        compositeDisposable.add(service.getDataLugares(1).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe((lugaresModels) -> {
            modelList.add(lugaresModels);
            this.listMutableLiveData.setValue(modelList);
        }, e -> e.printStackTrace()));
    }




/*public LiveData<List<Movie>> getLugaresModel() {
        Movie model = new Movie("Playa del carmen",
                "Playa mas cercano al mar","Cancun playa del carmen");
        return lugaresModel.setValue(new Movie("","",""));
    }

    //LiveData getter
    public LiveData<List<Movie>> getDataList() {
        return lugaresModel;
    }*/

//    Observer<List<Movie>> listObserver = new Observer<List<Movie>>() {
//        @Override
//        public void onChanged(List<Movie> lugaresModels) {
//
//        }
//    };
//        galleryViewModel.getLugaresModel().observe(this, listObserver);
}