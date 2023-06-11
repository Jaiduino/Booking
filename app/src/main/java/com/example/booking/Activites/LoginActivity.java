package com.example.booking.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.BackendServices.UserServices;
import com.example.booking.MainActivity;
import com.example.booking.R;
import com.example.booking.URLs.urls;
import com.example.booking.entity.Credentials;
import com.example.booking.entity.User;
import com.google.gson.JsonObject;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
EditText edituserId,editPassword;
    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edituserId = findViewById(R.id.editUserId);
        editPassword = findViewById(R.id.editPassword);

    }

    public void login(View view) {
        Credentials cus = validateUser();
        if (cus != null)
           signinUser(cus);
       // startActivity(new Intent(LoginActivity.this, Home_Screen.class));
    }

    private void signinUser(Credentials cus) {
new Retrofit.Builder().
        addConverterFactory(GsonConverterFactory.create()).
        baseUrl(urls.Log_In).build().
        create(UserServices.class).login(cus).
        enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
               JsonObject jsonObject = response.body().getAsJsonObject();
               int id = jsonObject.get("user_id").getAsInt();
               Toast.makeText(LoginActivity.this,"user_Id = " + id,Toast.LENGTH_SHORT).show();
               saveId(id);
                startActivity(new Intent(LoginActivity.this, Home_Screen.class));
                finish();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Response failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void saveId(int id){
        preferences = getSharedPreferences("store",MODE_PRIVATE);
SharedPreferences.Editor editor = preferences.edit();
editor.putInt("id",id).apply();
    }


    private Credentials validateUser() {
        Credentials cus = new Credentials();
        cus.setEmail((edituserId.getText().toString()));
        cus.setPassword((editPassword.getText().toString()));

       // user.setEmail(editEmail.getText().toString());
       // user.setPassword(editPassword.getText().toString());

        if (!cus.getEmail().equals(""))
            if (!cus.getPassword().equals(""))
                return cus ;
            else
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        return null;
    }

    public void signUp(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}