package com.example.aplicaciondelistadetareas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTask extends AppCompatActivity {

    private EditText editNuevaTarea;
    private Button btnAgregar;
    private RecyclerView recyclerView;
    private List<RicyclerViewItem> items;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_task);

        recyclerView = findViewById(R.id.recyclerview);
        btnAgregar = findViewById(R.id.btnAgregar);
        editNuevaTarea = findViewById(R.id.editTextNuevaTarea);

        items = new ArrayList<>();
        items.add(new RicyclerViewItem("Tarea Predeterminada", R.drawable.icon));

        adapter = new MyAdapter(getApplicationContext(), items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevaTarea = editNuevaTarea.getText().toString();
                items.add(new RicyclerViewItem(nuevaTarea, R.drawable.icon));
                adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado

                editNuevaTarea.setText("");
                System.out.println("Se guardó la tarea");
            }
        });
    }
}