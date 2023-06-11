package com.example.booking.BackendServices;

import com.example.booking.entity.Credentials;
import com.example.booking.entity.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {
    @POST("digitalflake/api/create_account")
    public Call<JsonObject> create_account(@Body User user);

    @POST("digitalflake/api/login")
    public  Call<JsonObject> login(@Body Credentials cus);
}
