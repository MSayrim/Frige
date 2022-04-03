package com.example.frige.WebApi;


import com.example.frige.models.FrigeItemModel;
import com.example.frige.models.LoginModel;
import com.example.frige.models.LoginRespondModel;
import com.example.frige.models.RegisterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {
    @POST("login")
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    Call<LoginRespondModel> loginControl(@Body LoginModel loginModel);

    @POST("api/Users")
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    Call<RegisterModel> register(@Body RegisterModel registerModel);

    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @GET("MyFrige/{userID}")
    Call<List<FrigeItemModel>> frigeLoader(@Path("userID") int userID);

}
