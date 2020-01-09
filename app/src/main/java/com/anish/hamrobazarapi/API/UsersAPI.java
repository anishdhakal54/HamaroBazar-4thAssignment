package com.anish.hamrobazarapi.API;

import com.anish.hamrobazarapi.model.User;
import com.anish.hamrobazarapi.serverresponse.ImageResponse;
import com.anish.hamrobazarapi.serverresponse.SignupResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {
    @POST("users/signup")
    Call<SignupResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignupResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization")String token);
}
