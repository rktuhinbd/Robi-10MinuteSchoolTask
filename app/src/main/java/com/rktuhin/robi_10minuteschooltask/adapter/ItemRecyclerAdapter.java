package com.rktuhin.robi_10minuteschooltask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rktuhin.robi_10minuteschooltask.R;
import com.rktuhin.robi_10minuteschooltask.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder> {

    Context context;
    List<ItemModel> itemModelList;
    List<ItemModel> subItemModelList;

    public ItemRecyclerAdapter(Context context, List<ItemModel> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        initSubItemData();

        SubItemRecyclerAdapter subItemRecyclerAdapter = new SubItemRecyclerAdapter(context, subItemModelList);
        holder.subItemRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.subItemRecyclerView.setAdapter(subItemRecyclerAdapter);

        ItemModel itemModel = itemModelList.get(position);

        holder.titleTextView.setText(itemModel.getTitle());

        if (itemModel.getTitle().contains("Chapter")) {
            holder.iconImageView.setImageResource(R.drawable.ic_book_24);
        } else if (itemModel.getTitle().contains("Video")) {
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

        boolean isExpanded = itemModelList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    private void initSubItemData() {
        subItemModelList = new ArrayList<>();
        subItemModelList.add(new ItemModel("Audio 1.0", ""));
        subItemModelList.add(new ItemModel("Video 2.0", ""));
        subItemModelList.add(new ItemModel("Document 3.0", "Md. Rejaul Karim"));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mainLayout, expandableLayout;
        RecyclerView subItemRecyclerView;
        ImageView iconImageView;
        TextView titleTextView, subTitleTextView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            mainLayout = itemView.findViewById(R.id.mainLayout);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            subItemRecyclerView = itemView.findViewById(R.id.subItemRecyclerView);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (itemModelList.get(getAdapterPosition()).getTitle().contains("Chapter")) {
                        ItemModel itemModel = itemModelList.get(getAdapterPosition());
                        itemModel.setExpanded(!itemModel.isExpanded());
                        notifyItemChanged(getAdapterPosition());
                    }
                }
            });
        }
    }
}
