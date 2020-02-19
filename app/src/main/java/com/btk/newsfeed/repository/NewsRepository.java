package com.btk.newsfeed.repository;

import android.util.Log;

import com.btk.newsfeed.model.ResponseData;
import com.btk.newsfeed.network.APIInterface;
import com.btk.newsfeed.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private final String TAG = NewsRepository.class.getSimpleName();

    public NewsRepository() {
    }

    public void getData() {

        APIInterface apiInterface = RetrofitClient.getInstance().create(APIInterface.class);

        apiInterface.getHeadLines("india",RetrofitClient.API_KEY).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.v(TAG,"onResponse:"+response.body().getStatus());
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });
    }
}
