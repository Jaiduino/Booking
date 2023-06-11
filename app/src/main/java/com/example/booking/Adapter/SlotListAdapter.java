package com.example.booking.Adapter;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Slots slots = new Slots();
      holder.viewTime.setText(slots.getSlot_name());
      if(slots.isSlot_active()==true){
          holder.isAvailable.isChecked();
      }

    }

    @Override
    public int getItemCount() {
        return slotsList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView viewTime;
        RadioButton isAvailable;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTime = itemView.findViewById(R.id.stationslotName);
            isAvailable = itemView.findViewById(R.id.rb1);
        }
    }
}
