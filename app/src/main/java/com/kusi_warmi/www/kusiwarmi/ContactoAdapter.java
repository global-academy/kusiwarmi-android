package com.kusi_warmi.www.kusiwarmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by globalstudent on 18-08-15.
 */
public class ContactoAdapter extends ArrayAdapter<Contacto> {

    public ContactoAdapter(Context context, int resource, List<Contacto> objects) {
        super(context, resource, objects);


    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View itemView = LayoutInflater.from(getContext())
                .inflate(R.layout.contactos, parent, false);

        Contacto contacto = getItem(position);

        TextView textViewTitulo =(TextView) itemView.findViewById(R.id.titulo);
        textViewTitulo.setText(contacto.getTitulo());

        TextView textViewDireccion=(TextView) itemView.findViewById(R.id.direccion);
        textViewDireccion.setText(contacto.getDireccion());

        TextView textViewEmail=(TextView) itemView.findViewById(R.id.email);
        textViewEmail.setText(contacto.getEmail());

        TextView textViewNumero=(TextView) itemView.findViewById(R.id.numero);
        textViewNumero.setText(contacto.getNumero());

        return itemView;
    }
}
