package com.btk.newsfeed.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;

import com.btk.newsfeed.R;
import com.btk.newsfeed.databinding.ActivityMainBinding;
import com.btk.newsfeed.model.ResponseData;
import com.btk.newsfeed.view.fragments.HeadlinesFragment;
import com.btk.newsfeed.viewmodel.HomeActivityViewModel;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = HomeActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;
    private HomeActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(HomeActivityViewModel.class);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HeadlinesFragment headlinesFragment = new HeadlinesFragment();
        transaction.add(R.id.id_container,headlinesFragment).commit();

        viewModel.getHeadLines().observe(this, new Observer<ResponseData>() {
            @Override
            public void onChanged(ResponseData responseData) {
                Log.v(TAG," Responsedata:"+responseData.getTotalResults());
            }
        });


    }
}
