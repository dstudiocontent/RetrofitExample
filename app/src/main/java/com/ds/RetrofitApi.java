package com.ds;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitApi {

    @GET()
    Call<List<Post>> getAllPosts(@Url String url);

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int postId);

    @GET("posts/")
    Call<List<Post>> getPostByUserId(@Query("userId") int[] userId);

    @GET("posts/")
    Call<List<Post>> getPostByUserIdsSorted(@QueryMap Map<String, String> parameters);
}
