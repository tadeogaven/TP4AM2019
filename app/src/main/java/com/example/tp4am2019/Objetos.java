package com.example.tp4am2019;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Objetos extends Fragment {
    public View OnCreateView (LayoutInflater infladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle Datos){
        View VistaADevolver;
        VistaADevolver=infladorDeLayouts.inflate(R.layout.layout_nombre,GrupoDeLaVista, false);
        return VistaADevolver;
    }

}
