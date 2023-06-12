package com.example.booking.Activites;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.booking.Adapter.BookingListAdapter;
import com.example.booking.Adapter.SlotListAdapter;
import com.example.booking.BackendServices.BookingServices;
import com.example.booking.R;
import com.example.booking.URLs.urls;
import com.example.booking.entity.Bookings;
import com.example.booking.entity.Slots;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import com.harrywhewell.scrolldatepicker.DayScrollDatePicker;

public class DeskWorkActivity extends AppCompatActivity {
    // private DayScrollDatePicker mPicker;
    RecyclerView recyclerView;
    List<Slots> slotsLists;
    SlotListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desk_work);
        recyclerView = findViewById(R.id.workrecycleView);
        getdata();
        slotsLists = new ArrayList<>();

        adapter = new SlotListAdapter(this, slotsLists);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        //   mPicker = findViewById(R.id.day_date_picker);
        // ActionBar bar = getSupportActionBar();
        // getSupportActionBar().setTitle("Select Date And Slot");
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //ActionBar bar = getSupportActionBar();
        // bar.setTitle("Hello");


    }

    public void getdata() {
        //   int id = getid();
         Log.e("desk","get_Data Call");
        new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl(urls.Log_In).build().
                create(BookingServices.class).slotList("2023-05-01").
                enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonArray jsonArray = response.body().getAsJsonArray("slots");
                        JsonObject object;
                        if (jsonArray.size() > 0) {
                            for (int i = 0; i < jsonArray.size(); i++) {
                                object = jsonArray.get(i).getAsJsonObject();
                                Slots slots = new Slots();
                                slots.setSlot_name(object.get("slot_name").getAsString());
                                slots.setSlot_active(object.get("slot_active").getAsBoolean());
                                slots.setSlot_id(object.get("slot_id").getAsInt());

                                slotsLists.add(slots);
                            }
                            adapter.notifyDataSetChanged();
                            Log.e("slots","Slots list"+slotsLists);
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(DeskWorkActivity.this, "Response failed", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}