package com.wahyu.smartcity.presenter.wisata;

import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class WisataObservable {
    Network network;

    public Observable<ResponseArrayObject> observableWisata(){
        return network.getService().create(WisataService.class)
                .listWisata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseArrayObject> observableLokasi(){
        return network.getService().create(WisataService.class)
                .listLokasi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
