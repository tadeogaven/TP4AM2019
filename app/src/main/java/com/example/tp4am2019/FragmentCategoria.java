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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FragmentCategoria extends Fragment implements View.OnClickListener {
    Button Boton;
    ArrayAdapter miAdaptador;

    public View onCreateView(LayoutInflater inflador, ViewGroup grupo, Bundle datos) {
        View VistaADevolver;
        VistaADevolver = inflador.inflate(R.layout.buscarcategorias, grupo, false);
        Boton = VistaADevolver.findViewById(R.id.BotonCat);
        Boton.setOnClickListener(this);
        return VistaADevolver;
    }

    public void onClick(View Vista) {
        tareaAsincronica tarea = new tareaAsincronica();
        tarea.execute();
        Log.d("Fragments", "Entra al fragment");
    }

    public void procesarJSONleido(InputStreamReader streamLeido) {
        JsonReader JSONleido = new JsonReader(streamLeido);
        try {
            JSONleido.beginObject();
            while (JSONleido.hasNext()) {
                String nombreElementoActual = JSONleido.nextName();
                if (nombreElementoActual.equals("cantidad_de_categorias")) {
                    int cantidadCategoria = JSONleido.nextInt();
                    //Log.d("LecturaJSON", "La cant de categorias es " + cantidadCategoria);

                } else {
                    JSONleido.beginArray();
                    while (JSONleido.hasNext()) {
                        JSONleido.beginObject();
                        while (JSONleido.hasNext()) {
                            nombreElementoActual = JSONleido.nextName();
                            if (nombreElementoActual.equals("nombre")) {
                                String valorElementoActual = JSONleido.nextString();
                                ((MainActivity)getActivity()).GetList().add(valorElementoActual);
                                Log.d("LecturaJSON", "valor" + valorElementoActual);
                            } else {
                                JSONleido.skipValue();
                            }
                        }
                        JSONleido.endObject();
                    }
                    JSONleido.endArray();
                }
            }
        } catch (Exception error) {
            Log.d("LecturaJSON", "hubo un error" + error.getMessage());
        }
    }


    class tareaAsincronica extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL miRuta = new URL("http://epok.buenosaires.gob.ar/getCategorias");

                HttpURLConnection miConexion = (HttpURLConnection) miRuta.openConnection();
                Log.d("AccesoApi", "Me Conecto");
                if (miConexion.getResponseCode() == 200) {

                    Log.d("AccesoApi", "Conexion Ok");
                    InputStream cuerpoRespuesta = miConexion.getInputStream();
                    InputStreamReader lectorRespuesta = new InputStreamReader(cuerpoRespuesta, "UTF-8");
                    procesarJSONleido(lectorRespuesta);
                } else {

                    Log.d("AccesoApi", "error");
                }
                miConexion.disconnect();

            } catch (Exception Error) {

                Log.d("AccesoApi", "Hubo un error al conectarse " + Error.getMessage());

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ((MainActivity) getActivity()).cambiarFragmentCategoria(new FragmentResultadoCategoria());
        }

    }
}
