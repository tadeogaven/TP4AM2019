package com.example.tp4am2019;
import android.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Categoria extends Fragment {
    public View OnCreateView (LayoutInflater infladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle Datos){
        View VistaADevolver;
        VistaADevolver=infladorDeLayouts.inflate(R.layout.layout_categorias,GrupoDeLaVista, false);
        return VistaADevolver;
    }

}
