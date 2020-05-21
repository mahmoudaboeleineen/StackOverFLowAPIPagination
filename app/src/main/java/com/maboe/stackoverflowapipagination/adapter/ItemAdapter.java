package com.maboe.stackoverflowapipagination.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maboe.stackoverflowapipagination.R;
import com.maboe.stackoverflowapipagination.UserDetailsActivity;
import com.maboe.stackoverflowapipagination.model.Item;


public class ItemAdapter extends PagedListAdapter<Item, ItemAdapter.itemViewHolder> {

    private Context context;

    public ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);

        return new itemViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        final Item item = getItem(position);


        if (item != null) {
            holder.userReputation.setText("Reputation : " + item.getOwner().getReputation());
            if (item.getOwner().getAcceptRate() == null) {
                holder.userAcceptRate.setText("Accept Rate : 0 ");
            } else {
                holder.userAcceptRate.setText("Accept Rate : " + item.getOwner().getAcceptRate());
            }
            Glide.with(context)
                    .load(item.getOwner().getProfileImage())
                    .into(holder.profileImage);
            holder.userName.setText(item.getOwner().getDisplayName());
        } else {
            Toast.makeText(context, "Item is null", Toast.LENGTH_LONG).show();
        }

//        Log.d("location", "location" + getItem(position).getOwner().getLocation());


    }

    private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getAnswerId() == newItem.getAnswerId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.equals(newItem);
        }
    };


    public class itemViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage;
        TextView userName;
        TextView userReputation;
        TextView userAcceptRate;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.user_avatar);
            userName = itemView.findViewById(R.id.user_name);
            userReputation = itemView.findViewById(R.id.user_Reputation);
            userAcceptRate = itemView.findViewById(R.id.user_acceptrate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(context, UserDetailsActivity.class);
                        intent.putExtra("userName", getItem(position).getOwner().getDisplayName());
                        intent.putExtra("userEmail", getItem(position).getOwner().getLink());
                        intent.putExtra("userImage", getItem(position).getOwner().getProfileImage());
                        intent.putExtra("lastDate", getItem(position).getLastActivityDate());
                        intent.putExtra("creationDate", getItem(position).getCreationDate());
                        intent.putExtra("editDate", getItem(position).getLastEditDate());
                        intent.putExtra("score", getItem(position).getScore());
                        intent.putExtra("reputation", getItem(position).getOwner().getReputation());
                        intent.putExtra("acceptRate", getItem(position).getOwner().getAcceptRate());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}