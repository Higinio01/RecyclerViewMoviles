package com.example.aplicaciondelistadetareas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.aplicaciondelistadetareas.R;

import java.util.ArrayList;

public class ListTarea extends AppCompatActivity {

    private ArrayList<String> tareas;
    //private ArrayAdapter<String> adapter;
    private EditText editText;
    private Button btnAddTask;
    private Button btnEliminar;
    private ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tarea);

        tareas = new ArrayList<>();
        editText = (EditText) findViewById(R.id.editTextText);
        btnAddTask = (Button) findViewById(R.id.btnAddTask);
        listView = (ListView) findViewById(R.id.lv1);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        tareas.add("Tarea predeterminada");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_tarea, R.id.textViewTarea, tareas);
        listView.setAdapter(adapter);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevaTarea = editText.getText().toString();
                tareas.add(nuevaTarea);
                adapter.notifyDataSetChanged();
                editText.setText("");
                System.out.println("Se guardó la tarea");
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.list_item_tarea, R.id.textViewTarea, tareas) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                Button btnEliminar = view.findViewById(R.id.btnEliminar);
                btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Eliminar la tarea cuando se haga clic en el botón de eliminar
                        tareas.remove(position);
                        notifyDataSetChanged(); // Actualizar el adaptador para reflejar los cambios en la lista
                    }
                });

                return view;
            }
        };


        listView.setAdapter(adapter1);

    }

}
