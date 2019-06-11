package com.example.tp4am2019;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FragmentsResultadoNombre extends Fragment {

    ArrayList<String> listarta = new ArrayList();
    ListView miListadeResultados;
    ArrayAdapter miAdaptador;

    public View onCreateView(LayoutInflater inflador, ViewGroup GrupodeVista, Bundle datos){
        View VistaDevolver;
        VistaDevolver=inflador.inflate(R.layout.activity_nombre,GrupodeVista,false);


        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        miAdaptador = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, actPrincipal.listarta);
        miListadeResultados.setAdapter(miAdaptador);
        String NombreAPocesar;





        return VistaDevolver;
    }

}
