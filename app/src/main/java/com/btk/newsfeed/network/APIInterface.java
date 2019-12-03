package com.btk.newsfeed.network;

import com.btk.newsfeed.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

/*
    @GET("/api/searchtypes/{Id}/filters")
    Call<FilterResponse> getFilterList(
            @Path("Id") long customerId,
            @Query("Type") String responseType,
            @Query("SearchText") String searchText
    );*/

//www.app.net/api/searchtypes/{Path}/filters?Type={Query}&SearchText={Query}

    //https://newsapi.org/v2/top-headlines?q=india&apiKey=6afcca8a53c447398041d61545310e3f

//    https://api.darksky.net/forecast/7e9e54f22038c6b245aceb3ab734c0ff/37.8267,-122.4233

//    https://newsapi.org/v2/top-headlines?page=1&pagesize=50&q=india&apiKey=6afcca8a53c447398041d61545310e3f

    @GET("top-headlines")
    Call<ResponseData> getHeadLines(
            @Query("q") String query,
            @Query("apiKey") String key);
}
