package com.example.tp4am2019;
import android.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

public class Geo extends Fragment {
    public View OnCreateView (LayoutInflater infladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle Datos){
        View VistaADevolver;
        VistaADevolver=infladorDeLayouts.inflate(R.layout.layout_geo,GrupoDeLaVista, false);
        return VistaADevolver;
    }

}
