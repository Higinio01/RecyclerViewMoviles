package com.example.aplicaciondelistadetareas;

public class RicyclerViewItem {
    String Tarea;
    int image;

    public RicyclerViewItem(String tarea, int image) {
        this.Tarea = tarea;
        this.image = image;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String tarea) {
        Tarea = tarea;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
