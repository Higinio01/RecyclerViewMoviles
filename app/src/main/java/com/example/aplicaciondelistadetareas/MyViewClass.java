package com.example.aplicaciondelistadetareas;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewClass extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView tareaView;
    Button btnEliminar;
    public MyViewClass(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        tareaView = itemView.findViewById(R.id.tarea);
        btnEliminar = itemView.findViewById(R.id.btnEliminar);
    }
}
