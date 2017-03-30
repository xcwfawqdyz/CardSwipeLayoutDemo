package com.example.cardswipelayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 2017/3/15.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Person> mPersons;
    public MyAdapter(List<Person> mPersons){
        this.mPersons=mPersons;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.head);
            mTextView= (TextView) itemView.findViewById(R.id.name);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person=mPersons.get(position);
        holder.mImageView.setImageResource(person.img);
        holder.mTextView.setText(person.name);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }
}
