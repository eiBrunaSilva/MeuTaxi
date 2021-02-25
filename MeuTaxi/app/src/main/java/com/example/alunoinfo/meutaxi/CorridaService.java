package com.example.alunoinfo.meutaxi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CorridaService {
    @POST ("Corrida/salvar")
    Call <Corrida> adicionar (@Body Corrida corrida);

    @GET ("Corrida/listar")
    Call <List<Corrida>> listarCorrida ();

    @DELETE ("Corrida/excluir/{idCorrida}")
    Call <Void> deletar (@Path("idCorrida") Integer idCorrida);

    @PUT ("Corrida/editar")
    Call <Corrida> atualizar (@Body Corrida Corrida);
}
