package com.kusi_warmi.www.kusiwarmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by globalstudent on 20-08-15.
 */
public class ConsultasAdapter extends ArrayAdapter<Consultas> {

    public ConsultasAdapter(Context context,int resource,List<Consultas> objects){
        super(context,resource,objects);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View itemView = LayoutInflater.from(getContext())
                .inflate(R.layout.consultas, parent, false);

        Consultas consultas = getItem(position);

        TextView textViewTitulo =(TextView) itemView.findViewById(R.id.pregunta_consultas);
        textViewTitulo.setText(consultas.getPregunta());

        TextView textViewDireccion=(TextView) itemView.findViewById(R.id.respuesta_consultas);
        textViewDireccion.setText(consultas.getRespuesta());



        return itemView;
    }

}
