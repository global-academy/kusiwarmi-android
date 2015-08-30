package com.kusi_warmi.www.kusiwarmi;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<Contacto> contacto;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactosFragment newInstance(String param1, String param2) {
        ContactosFragment fragment = new ContactosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ContactosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView =  inflater.inflate(R.layout.fragment_contactos, container, false);



        contacto=new ArrayList<Contacto>();

        contacto.add(new Contacto("ADELA ZAMUDIO", "DIRECCION:Plaza Colon este N°482","", "Telf:4258030"));
        contacto.add(new Contacto("OFICINA JURIDICA PARA LA MUJER", "DIRECCION:Costanera esquina La paz y Hamiraya", "Email:ojmujer@entelnet.bo","TELF:4228928"));
        contacto.add(new Contacto("DEFENSORIA DEL PUEBLO", "DIRECCION:Calle Colombia N°440 entre Heroinas del Acre y Gral. Gonzales","", "Telf:2112600"));
        contacto.add(new Contacto("INSTITUTO DE FORMACION FEMENINA INTEGRAL","DIRECCION:Calle Benjamin n°20,Plazuela Rivera Luna(Detras del Col.Pedro Poveda)","Email:direccion@iffi.org.bo","Telf:4010241"));
        contacto.add(new Contacto("OBSERVATORIO DE GENERO","DIRECCION:Coordinadora de la Mujer-Av.Arce 2132 Edif.Illampu,Piso1-oficina A","Email:observatoriocoordinadora@gmail.com","TELF.:2444923"));
        contacto.add(new Contacto("INFANTE","DIRECCION:Calle Julio Arauco Prado 230 Zona de las cuadras","","TELF.:4233783"));
        contacto.add(new Contacto("BRIGADA PROTECCION A LA FAMILIA","DIRECCION:Calle Baptista entre Colombia y Heroinas","","TELF.:4233133"));

        ListView listView = (ListView)fragmentView.findViewById(R.id.listView);
        ContactoAdapter adapter= new ContactoAdapter(container.getContext(),R.layout.contactos, contacto);
        listView.setAdapter(adapter);

        return  fragmentView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
