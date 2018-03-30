package com.sih.startupmitra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sih.startupmitra.R;
import com.sih.startupmitra.pojo.MyPojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanshusingh on 02/02/18.
 */

public class CustomBlogAdapter extends RecyclerView.Adapter<CustomBlogAdapter.MyViewHolder> {
    private Context context;

    private List<MyPojo> list = new ArrayList<>();

    public CustomBlogAdapter(Context context, List<MyPojo> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CustomBlogAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_detail, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomBlogAdapter.MyViewHolder holder, int position) {
//        holder.bind
        final MyPojo blogModel = list.get(position);
        holder.blog_title.setText(blogModel.getScheme_name());
        holder.blog_desc.setText(blogModel.getHeaded_by());
        holder.itemView.setOnClickListener(view -> {
//            Intent setToDetailedActivity = new Intent(context, BlogDetailedActivity.class);
//            setToDetailedActivity.putExtra(Constants.Blog.Blog_URL, blogModel.getURL());
//            context.startActivity(setToDetailedActivity);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView blog_title, blog_desc;

        MyViewHolder(View itemView) {
            super(itemView);
            blog_title = itemView.findViewById(R.id.name);
            blog_desc = itemView.findViewById(R.id.dep);

        }

    }
}
