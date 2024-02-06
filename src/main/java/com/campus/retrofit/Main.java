package com.campus.retrofit;

import com.campus.retrofit.request.PostCreateRequest;
import com.campus.retrofit.request.PostUpdateRequest;
import com.campus.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public  static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().api();

        System.out.println("GET: /posts ---------------------");
        Response<List<PostResponse>> postsResponce = api.posts(null).execute();
        System.out.println(postsResponce.isSuccessful());
        System.out.println(postsResponce.code());
        System.out.println(postsResponce.headers());
        List<PostResponse> posts = postsResponce.body();
        System.out.println(posts);

        System.out.println("POST: /posts ---------------------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("Body");
        createRequest.setTitle("Title");
        createRequest.setUserId(1);
        Response<PostResponse> createResponce = api.create(createRequest).execute();
        System.out.println(createResponce.body());

        System.out.println("PUT: /posts ---------------------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("Body");
        updateRequest.setTitle("Title");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        Response<PostResponse> updateResponse = api.update(1, updateRequest).execute();
        System.out.println(updateResponse.body());

        System.out.println("DELETE: /posts ---------------------");
        Integer statusCode = api.delete(1).execute().code();
        System.out.println(statusCode);

    }
}
