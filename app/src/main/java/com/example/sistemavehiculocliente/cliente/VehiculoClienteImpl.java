package com.example.sistemavehiculocliente.cliente;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sistemavehiculocliente.R;
import com.example.sistemavehiculocliente.model.Vehiculo;
import com.example.sistemavehiculocliente.util.EndPoint;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VehiculoClienteImpl {

    private Context context;

    public VehiculoClienteImpl(Context context){
        this.context = context;
    }

    public void insertar(Vehiculo vehiculo){

        Retrofit retrofit = getInstance();
        /**Ensamblar nuestro cliente*/
        VehiculoCliente vehiculoCliente = retrofit.create(VehiculoCliente.class);
        /**Hace implicitamente el llamado POST para insertar ese vehiculo*/

        Call<Void> response = vehiculoCliente.insertar(EndPoint.CONTENT_TYPE_APPLICATION_JSON, vehiculo);
        response.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, R.string.informacion_insertada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, R.string.ocurrio_un_error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void eliminar(final String placa){
        Retrofit retrofit = getInstance();
        VehiculoCliente vehiculoCliente = retrofit.create(VehiculoCliente.class);
        Call<Void> response = vehiculoCliente.eliminar(placa);
        response.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, R.string.elimino_correctamente, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, R.string.no_elimino, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void obtenerTarifas(final ListView listView){

        //Patron Builder
        Retrofit retrofit = getInstance();
        VehiculoCliente vehiculoCliente = retrofit.create(VehiculoCliente.class);
        Call<List<Vehiculo>> response = vehiculoCliente.listar();
        response.enqueue(new Callback<List<Vehiculo>>() {
            @Override
            public void onResponse(Call<List<Vehiculo>> call, Response<List<Vehiculo>> response) {
//                Toast.makeText(context, R.string.listar, Toast.LENGTH_SHORT).show();
                    List<Vehiculo> vehiculos = response.body();
                    String[] arrayVehiculos = new String[vehiculos.size()];
                    int i = 0;
                for (Vehiculo vehiculo: vehiculos) {
                    arrayVehiculos[i] = "Placa: "+ vehiculos.get(i).getPlaca()+ "->"+
                            "Modelo: "+ vehiculos.get(i).getModelo();
                    i++;
                }

                ArrayAdapter<String> arrayAdapter = new
                        ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, arrayVehiculos);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Vehiculo>> call, Throwable t) {
                Toast.makeText(context, R.string.no_listar, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(EndPoint.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(simpleClient).build();
    }

    private final OkHttpClient simpleClient = new OkHttpClient.Builder()
            .readTimeout(EndPoint.CONNECTION_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .connectTimeout(EndPoint.CONNECTION_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .build();

}
