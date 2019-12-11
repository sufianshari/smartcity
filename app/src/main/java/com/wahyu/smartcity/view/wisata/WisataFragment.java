package com.wahyu.smartcity.view.wisata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.wisata.WisataContract;
import com.wahyu.smartcity.presenter.wisata.WisataPresenter;
import com.wahyu.smartcity.view.home.LokasiAdapter;
import com.wahyu.smartcity.view.home.RekomendasiWisataAdapter;
import com.wahyu.smartcity.view.wisata.WisataAdapter;

import java.util.List;

public class WisataFragment extends BaseFragment implements WisataContract.View{

    private RecyclerView rvWisata, rvLokasi, rvRekomendasi;
    private WisataAdapter wisataAdapter;
    private LokasiAdapter lokasiAdapter;
    private WisataContract.Presenter presenter;

    public WisataFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wisata, container, false);
        findViews(view);
        initViews(view);
        initListeners(view);
        return view;
    }

    @Override
    public void findViews(View view) {
        rvWisata = view.findViewById(R.id.rv_wisata);
        rvLokasi = view.findViewById(R.id.rv_lokasi);
    }

    @Override
    public void initViews(View view) {
        new WisataPresenter(this);
        presenter.start();
    }

    @Override
    public void initListeners(View view) {

    }

    @Override
    public void setPresenter(@NonNull WisataContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void listLokasi(List<Lokasi> lokasiList) {
        lokasiAdapter = new LokasiAdapter(getContext(), lokasiList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvLokasi.setLayoutManager(layoutManager);
        rvLokasi.setAdapter(lokasiAdapter);
    }


    @Override
    public void listWisata(List<Wisata> wisataList) {
        wisataAdapter = new WisataAdapter(getContext(), wisataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvWisata.setLayoutManager(layoutManager);
        rvWisata.setAdapter(wisataAdapter);
    }

    @Override
    public void onSuccess() {
        //Toast
    }

    @Override
    public void onFailure() {
        //Toast
    }

    @Override
    public void onFailed() {
        //Toast
    }

    @Override
    public void onResume() {
        presenter.start();
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
