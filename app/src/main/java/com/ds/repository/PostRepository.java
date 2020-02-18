package com.ds.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ds.model.Post;
import com.ds.model.Resource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRepository {
    private ApiCalls retrofitApi;

    public PostRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitApi = retrofit.create(ApiCalls.class);
    }

    public LiveData<Resource<Post>> getAllPosts() {
        final MutableLiveData<Resource<Post>> resource = new MutableLiveData<>();
        retrofitApi.getAllPosts("posts").enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    resource.setValue(new Resource<Post>().error(new Exception("Bad response")));
                    return;
                }
                if (response.body() != null)
                    resource.setValue(new Resource<Post>().success(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call,@NonNull Throwable t) {
                resource.setValue(new Resource<Post>().error(new Exception("Api call failed")));
            }
        });

        return resource;
    }
}
