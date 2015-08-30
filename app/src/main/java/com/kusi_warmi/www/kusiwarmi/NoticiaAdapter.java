package com.kusi_warmi.www.kusiwarmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by globalstudent on 13-08-15.
 */
public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    public NoticiaAdapter(Context context, int resource, List<Noticia> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View itemView = LayoutInflater.from(getContext())
                .inflate(R.layout.noticia, parent, false);
        Noticia noticia = getItem(position);
        TextView textViewTitulo =(TextView) itemView.findViewById(R.id.titulo);
        textViewTitulo.setText(noticia.titulo);
        TextView textViewContenido=(TextView) itemView.findViewById(R.id.contenido);
        textViewContenido.setText(noticia.contenido);
        TextView textViewFecha=(TextView) itemView.findViewById(R.id.fecha);
        textViewFecha.setText(noticia.fecha);

        return itemView;
    }
}
