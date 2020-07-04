package com.example.sistemavehiculocliente.ui.insercion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sistemavehiculocliente.R;
import com.example.sistemavehiculocliente.cliente.VehiculoClienteImpl;
import com.example.sistemavehiculocliente.model.Vehiculo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsercionFragment extends Fragment {

    private Vehiculo vehiculo;
    private VehiculoClienteImpl vehiculoCliente;
    @BindView(R.id.txtPlaca)
    public EditText txtPlaca;
    @BindView(R.id.txtMarca)
    public EditText txtMarca;
    @BindView(R.id.txtModelo)
    public EditText txtModelo;
    @BindView(R.id.txtColor)
    public EditText txtColor;
    @BindView(R.id.btnEnviar)
    public Button btnEnviar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_insercion, container, false);
        initComponent(root);
        btnEnviar.setOnClickListener(v -> enviar());
        return root;
    }

    private void enviar() {
        vehiculo.setPlaca(txtPlaca.getText().toString());
        vehiculo.setMarca(txtMarca.getText().toString());
        vehiculo.setModelo(txtModelo.getText().toString());
        vehiculo.setColor(txtColor.getText().toString());
        vehiculoCliente.insertar(vehiculo);

    }

    private void initComponent(View root) {
        ButterKnife.bind(this, root);
        vehiculo = new Vehiculo();
        vehiculoCliente = new VehiculoClienteImpl(getContext());
    }
}