package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking.R;
import com.example.booking.entity.Bookings;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.MyViewHolder>  {
Context context;
List<Bookings> bookingsList;

    public BookingListAdapter(Context context, List<Bookings> bookingsList) {
        this.context = context;
        this.bookingsList = bookingsList;
    }

    @NonNull
    @Override
    public BookingListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.booking_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingListAdapter.MyViewHolder holder, int position) {
        Bookings bookings = bookingsList.get(position);
        holder.textName.setText(bookings.getWorkspace_name());
        holder.textDate.setText(bookings.getBooking_date());
        holder.textDesk.setText(""+bookings.getWorkspace_id());


    }



    @Override
    public int getItemCount() {
        return bookingsList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
   TextView textName,textDesk,textDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.NameView);
            textDesk = itemView.findViewById(R.id.DeskIdView);
            textDate = itemView.findViewById(R.id.BookedDateView);
        }
    }
}
