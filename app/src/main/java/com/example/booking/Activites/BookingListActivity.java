package com.example.booking.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.booking.Adapter.BookingListAdapter;
import com.example.booking.BackendServices.BookingServices;
import com.example.booking.BackendServices.UserServices;
import com.example.booking.R;
import com.example.booking.URLs.urls;
import com.example.booking.entity.Bookings;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookingListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Bookings> bookingsList;
    SharedPreferences sharedPreferences;

    BookingListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);
        recyclerView = findViewById(R.id.BookinglistRecycleView);
        getdata();
        bookingsList = new ArrayList<>();
        adapter = new BookingListAdapter(this,bookingsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
    public void getdata(){
       int id = getid();
        Log.e("userid","inside_get_data"+id);
        new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl(urls.Log_In).build().
                create(BookingServices.class).bookingList(id).
                enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonArray jsonArray = response.body().getAsJsonArray("bookings");
                        JsonObject object;
                       if(jsonArray.size()>0){
                           for(int i =0;i<jsonArray.size();i++){
                               object = jsonArray.get(i).getAsJsonObject();
                               Bookings bookings = new Bookings();
                               bookings.setWorkspace_id(object.get("workspace_id").getAsInt());
                               bookings.setWorkspace_name(object.get("workspace_name").getAsString());
                               bookings.setBooking_date(object.get("booking_date").getAsString());
                               bookingsList.add(bookings);
                           }
                           adapter.notifyDataSetChanged();
                       }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(BookingListActivity.this, "Response failed", Toast.LENGTH_SHORT).show();

                    }
                });
    }

public int getid(){
     sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
     int id = sharedPreferences.getInt("id",1);
     return id;
}

}