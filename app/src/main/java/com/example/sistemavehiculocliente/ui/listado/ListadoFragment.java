package com.example.sistemavehiculocliente.ui.listado;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sistemavehiculocliente.R;
import com.example.sistemavehiculocliente.cliente.VehiculoClienteImpl;
import com.example.sistemavehiculocliente.model.Vehiculo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoFragment extends Fragment {

    @BindView(R.id.listViewVehiculos)
    public ListView listViewVehiculos;
    VehiculoClienteImpl vehiculoCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listado, container, false);
        ButterKnife.bind(this, root);
        vehiculoCliente = new VehiculoClienteImpl(getContext());
        listarVehiculos();
        return root;
    }

    private void listarVehiculos() {
        vehiculoCliente.obtenerTarifas(listViewVehiculos);
    }
}