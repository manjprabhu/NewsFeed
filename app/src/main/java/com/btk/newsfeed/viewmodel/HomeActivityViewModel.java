package com.btk.newsfeed.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.btk.newsfeed.model.ResponseData;
import com.btk.newsfeed.repository.NewsRepository;

public class HomeActivityViewModel extends ViewModel {

    private final String TAG =  HomeActivityViewModel.class.getSimpleName();
    private MutableLiveData<ResponseData> liveData = new MutableLiveData<>();
    NewsRepository repository;

    public HomeActivityViewModel() {
        repository = new NewsRepository();
    }

    public MutableLiveData<ResponseData> getHeadLines() {
        repository.getData();
        return liveData;
    }
}
