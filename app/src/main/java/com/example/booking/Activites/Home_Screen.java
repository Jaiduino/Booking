package com.example.booking.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.booking.R;

public class Home_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void viewhistory(View view) {
        startActivity(new Intent(Home_Screen.this, BookingListActivity.class));
    }

    public void gotoworkstation(View view) {
        startActivity(new Intent(Home_Screen.this, DeskWorkActivity.class));
    }

    public void gotomeeting(View view) {
        startActivity(new Intent(Home_Screen.this, MeetingActivity.class));

    }
}