package com.example.sistemavehiculocliente.cliente;

import com.example.sistemavehiculocliente.model.Vehiculo;
import com.example.sistemavehiculocliente.util.EndPoint;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VehiculoCliente {

    public void insertar(Vehiculo vehiculo){

        Retrofit retrofit = getInstance();

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
