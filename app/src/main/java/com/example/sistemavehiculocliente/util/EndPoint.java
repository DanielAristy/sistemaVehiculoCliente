package com.example.sistemavehiculocliente.util;

public class EndPoint {

    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final long CONNECTION_TIMEOUT_RETROFIT = 40;
    public static final String URL_BASE = "http://192.168.1.55:8080/";

    public static final String INSERTAR_VEHICULO = "control-vehiculo/vehiculo";
//    public static final String ACTUALIZAR_VEHICULO = "control-vehiculo/{placa}/vehiculo";
    public static final String ELIMINAR_VEHICULO = "control-vehiculo/{placa}/vehiculo";
    public static final String LISTAR = "control-vehiculo/vehiculos";

}
