package com.example.alunoinfo.meutaxi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VeiculoService {

    @POST ("Veiculo")
    Call <Veiculo> adicionar (@Body Veiculo Veiculo);

    @GET ("Veiculo")
    Call <List<Veiculo>> listarVeiculo ();

    @DELETE ("Veiculo/{idVeiculo}")
    Call <Veiculo> deletar (@Path("idVeiculo") Integer idVeiculo);

    @PUT ("Veiculo")
    Call <Veiculo> atualizar (@Body Veiculo veiculo);

}
