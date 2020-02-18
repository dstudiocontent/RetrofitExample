package com.ds.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ds.model.Resource;
import com.ds.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRepository {

    private ApiCalls retrofitApi;

    public UserRepository() {
        Retrofit retrofit = RetrofitInstance.getInstance().getRetrofit();
        retrofitApi = retrofit.create(ApiCalls.class);
    }

    public LiveData<Resource<User>> getAllUsers() {
        final MutableLiveData<Resource<User>> resource = new MutableLiveData<>();
        retrofitApi.getAllUsers("users").enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    resource.setValue(new Resource<User>().error(new Exception("Bad response")));
                    return;
                }
                if (response.body() != null)
                    resource.setValue(new Resource<User>().success(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                resource.setValue(new Resource<User>().error(new Exception("Api call failed")));
            }
        });

        return resource;
    }
}
