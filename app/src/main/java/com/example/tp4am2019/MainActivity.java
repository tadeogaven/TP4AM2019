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
    List<String> listaCat;

    public void setAdminFragments(FragmentManager adminFragments) {
        this.adminFragments = adminFragments;
    }

    String NombreProcesar;


    public List<String> GetList(){
        return  listarta;
    }
    public List<String> GetListCAT(){
        return  listaCat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listarta = new ArrayList();
        listaCat = new ArrayList();
        ListView miListadeResultados;
        ListView miListadeCategorias;
        ArrayAdapter miAdaptador;
        String nombre;
        EditText Nombre;
        Button boton;
        adminFragments=getFragmentManager();
        Fragment NombreCat;
        NombreCat= new FragmentNombre();

        transacFragments=adminFragments.beginTransaction();
        transacFragments.replace(R.id.AlojadorDeFragmentsNOMBRE, NombreCat );
        transacFragments.commit();

        Fragment Cat;
        Cat= new FragmentCategoria();
        transacFragments=adminFragments.beginTransaction();
        transacFragments.replace(R.id.AlojadorDeFragmentsCATEGORIA, Cat );
        transacFragments.commit();


    }



    public void cambiarFragmentNombre(Fragment f){
        transacFragments=adminFragments.beginTransaction();
        transacFragments.replace(R.id.AlojadorDeFragmentsNOMBRE, f);
        transacFragments.commit();
    }
    public void cambiarFragmentCategoria(Fragment f){
        transacFragments=adminFragments.beginTransaction();
        transacFragments.replace(R.id.AlojadorDeFragmentsCATEGORIA, f);
        transacFragments.commit();
    }
}
