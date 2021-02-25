package com.example.alunoinfo.meutaxi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GastoService {
    @POST ("Gasto")
    Call <Gasto> adicionar (@Body Gasto Gasto);

    @GET ("Gasto")
    Call <List<Gasto>> listarGastos();

    @DELETE ("filmes/{idGasto}")
    Call <Void> deletar (@Path("idGasto") Integer idGasto);

    @PUT ("Gastos")
    Call <Gasto> atualizar (@Body Gasto Gasto);


}
