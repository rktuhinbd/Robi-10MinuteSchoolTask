package com.rktuhin.robi_10minuteschooltask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rktuhin.robi_10minuteschooltask.R;
import com.rktuhin.robi_10minuteschooltask.model.ItemModel;

import java.util.List;

public class SubItemRecyclerAdapter extends RecyclerView.Adapter<SubItemRecyclerAdapter.MovieVH> {

    Context context;
    List<ItemModel> itemModelList;

    public SubItemRecyclerAdapter(Context context, List<ItemModel> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_item_list, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        ItemModel itemModel = itemModelList.get(position);

        holder.titleTextView.setText(itemModel.getTitle());

        if (itemModel.getTitle().contains("Video")) {
            holder.iconImageView.setImageResource(R.drawable.ic_video_library_24);
        } else if (itemModel.getTitle().contains("Audio")) {
            holder.iconImageView.setImageResource(R.drawable.ic_audio_24);
        } else if (itemModel.getTitle().contains("Document")) {
            holder.iconImageView.setImageResource(R.drawable.ic_document_24);
        }

        if (itemModel.getSubTitle() != null) {
            if (!itemModel.getSubTitle().isEmpty()) {
                holder.subTitleTextView.setVisibility(View.VISIBLE);
                holder.subTitleTextView.setText(itemModel.getSubTitle());
            } else {
                holder.subTitleTextView.setVisibility(View.GONE);
                holder.subTitleTextView.setText("");
            }
        } else {
            holder.subTitleTextView.setVisibility(View.GONE);
            holder.subTitleTextView.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        ImageView iconImageView;
        TextView titleTextView, subTitleTextView;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            iconImageView = itemView.findViewById(R.id.iconImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "A sub-item clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

