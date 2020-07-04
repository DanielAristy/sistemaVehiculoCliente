package com.example.sistemavehiculocliente.cliente;

import com.example.sistemavehiculocliente.model.Vehiculo;
import com.example.sistemavehiculocliente.util.EndPoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VehiculoCliente {

    /**Aqui le decimos al sistema que le vamos a enviar un objeto Json*/
    @POST(EndPoint.INSERTAR_VEHICULO)
    Call<Void> insertar(@Header("Content-Type") String contentTYype, @Body Vehiculo vehiculo);

    @DELETE(EndPoint.ELIMINAR_VEHICULO)
    Call<Void> eliminar(@Path("placa") String placa_vehiuclo);

    @GET(EndPoint.LISTAR)
    Call<List<Vehiculo>> listar();
}
