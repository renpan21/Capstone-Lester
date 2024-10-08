package com.example.pathfit2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class pathfitHealthRelatedAdapter extends RecyclerView.Adapter<pathfitHealthRelatedAdapter.CardViewHolder> {

    Context context;

    ArrayList<pathfitCardItem> cardItemList;
    int expandedPosition = -1;


    public pathfitHealthRelatedAdapter(Context context, ArrayList<pathfitCardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.pathfit_cardview, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {


        pathfitCardItem cardItem = cardItemList.get(position);
        holder.card_title.setText(cardItem.title);
        holder.description.setText(cardItem.description);
//
//        // Set unique content for expandable section
        holder.topic.setText(cardItem.topic);
        holder.image.setImageResource(cardItem.imageResource);


        boolean isExpanded = position == expandedPosition;
        Log.d("HistoryOfDanceAdapter", "Position: " + position + " Visibility: " + (isExpanded)); // checking visibility
        holder.expandableContent.setVisibility(isExpanded ? View.VISIBLE : View.GONE);


        // para makita sa terminal yung visibility state
        Log.d("HistoryOfDanceAdapter", "Position: " + position + " Visibility1: " + (isExpanded ? "VISIBLE" : "GONE"));

        holder.itemView.setOnClickListener(v -> {

            if (expandedPosition == holder.getAdapterPosition()) {
                // Collapse the currently expanded item
                int prevExpandedPosition = expandedPosition;
                expandedPosition = -1;  // collapse the item
                notifyItemChanged(prevExpandedPosition);  // notify change
            } else {
                // Expand the new item and collapse the old one
                int prevExpandedPosition = expandedPosition;
                expandedPosition = holder.getAdapterPosition();
                notifyItemChanged(prevExpandedPosition);  // Collapse the old item
                notifyItemChanged(expandedPosition);  // Expand the new item
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView card_title;
        TextView description;
        TextView topic; // For diff lesson topics
        ImageView image; // For diff images in diff topics
        LinearLayout expandableContent;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            card_title = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_description);
            topic = itemView.findViewById(R.id.card_topic);
            image = itemView.findViewById(R.id.card_image);
            expandableContent = itemView.findViewById(R.id.card_expandable_content);


        }
    }
}


