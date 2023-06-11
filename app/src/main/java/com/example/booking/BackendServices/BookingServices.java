package com.example.booking.BackendServices;

import com.example.booking.entity.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookingServices {
    @GET("digitalflake/api/get_bookings")
    public Call<JsonObject> bookingList(@Query("user_id") int id);

    @GET("digitalflake/api/get_slots")
    public Call<JsonObject> slotList(@Query("date") String date);
}
