package com.example.aplicaciondelistadetareas;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewClass> {

    Context context;
    List<RicyclerViewItem> items;


    public MyAdapter(Context context, List<RicyclerViewItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewClass(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, @SuppressLint("RecyclerView") int position) {
        holder.tareaView.setText(items.get(position).getTarea());
        holder.imageView.setImageResource(items.get(position).getImage());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Elimina el elemento de la lista en la posición correspondiente
                items.remove(position);
                notifyDataSetChanged(); // Notifica al adaptador que los datos han cambiado
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    class eventoEliminar implements View.OnClickListener{
        private RicyclerViewItem item;
        public eventoEliminar(){
            this.item=item;

        }

        @Override
        public void onClick(View v){

        }
    }

}
