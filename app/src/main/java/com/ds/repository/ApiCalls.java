package com.ds.repository;

import com.ds.model.Post;
import com.ds.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

interface ApiCalls {

    @GET()
    Call<List<Post>> getAllPosts(@Url String url);

    @GET()
    Call<List<User>> getAllUsers(@Url String url);

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int postId);

    @GET("posts/")
    Call<List<Post>> getPostByUserId(@Query("userId") int[] userId);

    @GET("posts/")
    Call<List<Post>> getPostByUserIdsSorted(@QueryMap Map<String, String> parameters);
}
