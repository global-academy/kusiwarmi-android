package com.kusi_warmi.www.kusiwarmi;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CasosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CasosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CasosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<Casos> casos;
    private CasosAdapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CasosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CasosFragment newInstance(String param1, String param2) {
        CasosFragment fragment = new CasosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CasosFragment() {
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


        View fragmentView =  inflater.inflate(R.layout.fragment_casos, container, false);

        casos=new ArrayList<Casos>();
        ListView listView = (ListView)fragmentView.findViewById(R.id.listView);
        adapter = new CasosAdapter(container.getContext(), R.layout.casos, casos);
        listView.setAdapter(adapter);
        ParseQuery query = new ParseQuery("Caso");
        query.addDescendingOrder("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> casos, ParseException e) {
                if (e == null) {
                    Log.d("Caso", "Recuperados " + casos.size() + " casos");
                    for (ParseObject caso : casos) {
                        adapter.add(new Casos((String) caso.get("titulo"), "" + caso.get("fecha"), (String) caso.get("contenido")));
                        try {
                            caso.pin();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    Log.e("Caso", "Error: " + e.getMessage());
                    Toast.makeText(getActivity(), "Ocurrio un error al recuperar los casos, por favor vuelva a intentar", Toast.LENGTH_SHORT).show();
                }
            }
        });
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


            /*
            throw new ClassCastException(activity.toString()
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

}
