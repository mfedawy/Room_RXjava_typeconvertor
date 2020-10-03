package com.echoman.roomcodingwithnerds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {
    private List<Post> mPosts = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleTV.setText(mPosts.get(position).getTitle());
        holder.bodyTV.setText(mPosts.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void setList(List<Post> mList) {
        this.mPosts = mList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, bodyTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.item_title_textView);
            bodyTV = itemView.findViewById(R.id.item_body_textView);

        }


    }
}
