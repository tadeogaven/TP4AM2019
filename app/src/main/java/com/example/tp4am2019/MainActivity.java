package com.example.tp4am2019;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager adminFragments;
    FragmentTransaction transacFragments;

     List<String> listarta;

    String NombreProcesar;


    public List<String> GetList(){
        return  listarta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> listarta = new ArrayList();
        ListView miListadeResultados;
        ArrayAdapter miAdaptador;
        String nombre;
        EditText Nombre;
        Button boton;
        adminFragments=getFragmentManager();

        Fragment frgIngreso;
        frgIngreso=new FragmentsResultadoNombre();

        transacFragments=adminFragments.beginTransaction();
        transacFragments.replace(R.id.AlojadorDeFragments, frgIngreso);
        transacFragments.commit();
    }

        public void  onClick(View VistaRecibida) {


        }
}
