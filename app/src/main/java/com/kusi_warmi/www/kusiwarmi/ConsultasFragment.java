package com.kusi_warmi.www.kusiwarmi;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsultasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsultasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<Consultas> consultas;

    EditText textEnviar;
    Button boton;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultasFragment newInstance(String param1, String param2) {
        ConsultasFragment fragment = new ConsultasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ConsultasFragment() {
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
        View fragmentView = inflater.inflate(R.layout.fragment_consultas, container, false);

        textEnviar = (EditText) fragmentView.findViewById(R.id.texto_enviar);
        boton =(Button) fragmentView.findViewById(R.id.button_enviar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"ENVIAR",Toast.LENGTH_LONG).show();
            }
        });


        consultas=new ArrayList<Consultas>();

        consultas.add(new Consultas("pregunta 1", "respuesta 1"));
        consultas.add(new Consultas("pregunta 2", "respuesta 2"));
        consultas.add(new Consultas("pregunta 3", "respuesta 3"));


        ListView listView = (ListView)fragmentView.findViewById(R.id.listView);
        ConsultasAdapter adapter= new ConsultasAdapter(container.getContext(),R.layout.consultas, consultas);
        listView.setAdapter(adapter);

        return fragmentView;

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
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
           /* throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
           */
        }
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
    public void enviarPregunta(View v){
        textEnviar.getText().toString();

    }

}
