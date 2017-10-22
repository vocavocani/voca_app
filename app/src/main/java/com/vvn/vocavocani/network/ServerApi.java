package com.vvn.vocavocani.network;

import com.vvn.vocavocani.network.format.DTOUserRegister;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by soo13 on 2017-10-23.
 */

public class ServerApi {
    public ServerApi() {

    }

    public void getCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

        ApiList service = retrofit.create(ApiList.class);
        Call<List<DTOUserRegister>> result = service.listRepos();
    }

    public void postCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiList service = retrofit.create(ApiList.class);
    }
}
