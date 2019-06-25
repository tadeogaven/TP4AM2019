package com.example.tp4am2019;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentResultadoCategoria extends Fragment {
    ArrayList<String> listaCat = new ArrayList();
    ListView miListadeCategorias;

    ArrayAdapter miAdaptador;

    public View onCreateView(LayoutInflater inflador, ViewGroup GrupodeVista, Bundle datos) {
        View VistaDevolver;
        VistaDevolver = inflador.inflate(R.layout.layout_categoria, GrupodeVista, false);

        miListadeCategorias = (ListView) VistaDevolver.findViewById(R.id.MiListaDeCategorias);

        miAdaptador = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ((MainActivity) getActivity()).GetList());

        miListadeCategorias.setAdapter(miAdaptador);


        return VistaDevolver;
    }
}
