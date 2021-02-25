package com.example.alunoinfo.meutaxi;

import java.util.List;
import java.util.logging.FileHandler;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MotoristaService {
    @POST ("Motorista/salvar")
    Call <Motorista> adicionar (@Body Motorista Motorista);

    @GET ("Motorista/listar")
    Call <List<Motorista>> listarMotorista ();

    @DELETE ("Motorista/{idMotorista}")
    Call <Void> deletar (@Path("idMotorista") Integer idMotorista);

    @PUT ("Motorista/editar")
    Call <Motorista> atualizar (@Body Motorista Motorista);




}
