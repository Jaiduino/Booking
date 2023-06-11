package com.example.booking.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.booking.BackendServices.UserServices;
import com.example.booking.R;
import com.example.booking.URLs.urls;
import com.example.booking.entity.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {
EditText editName,editMobile,editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editName = findViewById(R.id.userName);
        editEmail = findViewById(R.id.userEmail);
        editMobile = findViewById(R.id.userMobileNo);
    }

    public void register(View view) {
        User user = validateData();
        if(user!=null)
            registerUser(user);
    }

    private void registerUser(User user) {
        new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(urls.Log_In).build().create(UserServices.class).create_account(user)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(RegistrationActivity.this, "User Registerd Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(RegistrationActivity.this, "haha.. You failed", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private User validateData() {
        User user = new User();
        user.setName(editName.getText().toString());
        user.setEmailId(editEmail.getText().toString());
        user.setMobile(editMobile.getText().toString());
        if(!user.getName().equals("")){
            if(!user.getEmailId().equals("")){
                if(!user.getMobile().equals("")){
                    return user;
                }
                else {
                    Toast.makeText(this,"Please Enter Mobile No",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this,"Please Enter Email_ID",Toast.LENGTH_SHORT).show();

            }
            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();

        }

        return null;
    }

    public void toLoginPage(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}