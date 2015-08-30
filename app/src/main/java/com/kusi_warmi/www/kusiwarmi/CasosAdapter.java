package com.kusi_warmi.www.kusiwarmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by globalstudent on 27-08-15.
 */
public class CasosAdapter extends ArrayAdapter<Casos> {

    public CasosAdapter(Context context, int resource, List<Casos> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View itemView = LayoutInflater.from(getContext())
                .inflate(R.layout.casos, parent, false);

        Casos casos = getItem(position);

        TextView textViewTitulo =(TextView) itemView.findViewById(R.id.titulo);
        textViewTitulo.setText(casos.titulo);
        TextView textViewFecha=(TextView) itemView.findViewById(R.id.fecha);
        textViewFecha.setText(casos.fecha);
        TextView textViewContenido=(TextView) itemView.findViewById(R.id.contenido);
        textViewContenido.setText(casos.contenido);


        return itemView;

        /*
        View itemView = LayoutInflater.from(getContext())
                .inflate(R.layout.casos, parent, false);
        Casos casos = getItem(position);
        TextView textViewTitulo =(TextView) itemView.findViewById(R.id.titulo);
        textViewTitulo.setText(casos.titulo);
        TextView textViewFecha=(TextView) itemView.findViewById(R.id.fecha);
        textViewFecha.setText(casos.fecha);
        TextView textViewContenido=(TextView) itemView.findViewById(R.id.contenido);
        textViewContenido.setText(casos.contenido);

        return itemView;
        */
    }
}
