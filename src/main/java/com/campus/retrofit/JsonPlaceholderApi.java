package com.campus.retrofit;

import com.campus.retrofit.request.PostCreateRequest;
import com.campus.retrofit.request.PostUpdateRequest;
import com.campus.retrofit.response.PostResponse;
import javafx.geometry.Pos;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostResponse>> posts(@Query("userId") Integer usserId);

    @POST("/posts")
    Call<PostResponse> create(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> update(@Path("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);

}
