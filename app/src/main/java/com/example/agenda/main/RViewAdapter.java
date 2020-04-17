package com.example.agenda.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.event.Event;

import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.ViewHolder> {

    private List<Event> events;
    private Context context;

    public RViewAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = events.get(position);

        holder.textViewHead.setText(event.getName());
        String shortDesc = event.getStartHour() + ": " + event.getStartMin() + ", " +
                event.getStartMonth() + "-" + event.getStartDay() + ", " + event.getStartYear() + " to\n" +
                event.getEndHour() + ": " + event.getEndMin() + ", " +
                event.getEndMonth() + "-" + event.getEndDay();
        holder.textViewTime.setText(shortDesc);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.EventCardName);
            textViewTime = (TextView) itemView.findViewById(R.id.EventCardTime);
        }
    }
}


