package com.example.booking.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking.R;
import com.example.booking.entity.Slots;

import java.util.List;

public class SlotListAdapter extends RecyclerView.Adapter<SlotListAdapter.MyViewHolder> {
    Context context;
    List<Slots> slotsList;

    public SlotListAdapter(Context context, List<Slots> slotsList) {
        this.context = context;
        this.slotsList = slotsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slotlist,null);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SlotListAdapter.MyViewHolder holder, int position) {
      Slots slots = slotsList.get(position);
      holder.viewTime.setText(slots.getSlot_name());
      if(slots.isSlot_active()==true){
          holder.viewTime.setBackgroundColor(Color.parseColor("#3c7ee8"));
      }
      else {
          holder.viewTime.setBackgroundColor(Color.parseColor("#00000000"));
      }

    }

    @Override
    public int getItemCount() {
        return slotsList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView viewTime;
       // RadioButton isAvailable;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTime = itemView.findViewById(R.id.stationslotName);
           // isAvailable = itemView.findViewById(R.id.rb1);
        }
    }
}
