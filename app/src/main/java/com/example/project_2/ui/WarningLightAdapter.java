package com.example.project_2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_2.Database.entities.WarningLight;
import com.example.project_2.R;

import java.util.ArrayList;
import java.util.List;

public class WarningLightAdapter extends RecyclerView.Adapter<WarningLightAdapter.WarningLightViewHolder>{
    private final List<WarningLight> items = new ArrayList<>();

    public void setItems(List<WarningLight> newItems) {
        items.clear();
        if (newItems != null) {
            items.addAll(newItems);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WarningLightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_warning_light, parent, false);
        return new WarningLightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WarningLightViewHolder holder, int position) {
        WarningLight light = items.get(position);
        holder.bind(light);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class WarningLightViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView descriptionView;

        public WarningLightViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.text_warning_name);
            descriptionView = itemView.findViewById(R.id.text_warning_description);
        }
        public void bind (WarningLight light) {
            nameView.setText(light.getName());
            descriptionView.setText(light.getDescription());
        }

    }


}
