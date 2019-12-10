package com.wahyu.smartcity.presenter.wisata;

import com.wahyu.smartcity.base.BasePresenter;
import com.wahyu.smartcity.base.BaseView;
import com.wahyu.smartcity.model.Kategori;
import com.wahyu.smartcity.model.Wisata;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class WisataContract {
    public interface View extends BaseView<Presenter> {
        void listKategori(List<Kategori> kategoriList);
        void listWisata(List<Wisata> wisataList);
        void onSuccess();
        void onFailure();
        void onFailed();
    }

    public interface Presenter extends BasePresenter {
        void loadWisata();
        void loadKategori();

    }
}
