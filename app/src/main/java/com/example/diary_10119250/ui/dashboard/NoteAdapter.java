//Najib Raffi Irdiana
//10119250
//IF-4

package com.example.diary_10119250.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diary_10119250.R;


import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    Context context;
    ArrayList<Note> arrayList;
    OnItemClickListener onItemClickListener;

    public NoteAdapter(Context context, ArrayList<Note> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.category.setText(arrayList.get(position).getCategory());
        holder.desc.setText(arrayList.get(position).getDesc());
        holder.date.setText(arrayList.get(position).getDate());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_item_title);
            category = itemView.findViewById(R.id.list_item_category);
            desc = itemView.findViewById(R.id.list_item_notes);
            date = itemView.findViewById(R.id.list_item_tanggal);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(Note note);
    }

}