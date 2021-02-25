package com.example.alunoinfo.meutaxi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DiariaService {
    @POST ("Diaria/salvar")
    Call <Diaria> adicionar (@Body Diaria Diaria);

    @GET ("Diaria/listar")
    Call <List<Diaria>> listarDiaria ();

    @DELETE ("Diaria/excluir/{idDiaria")
    Call <Void> deletar (@Path("idDiaria") Integer idDiaria);

    @PUT("Diaria/editar")
    Call <Diaria> atualizar (@Body Diaria Diaria);

}
