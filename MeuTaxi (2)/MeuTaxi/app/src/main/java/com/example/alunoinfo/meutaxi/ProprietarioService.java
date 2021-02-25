package com.example.alunoinfo.meutaxi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProprietarioService {

    @POST ("Proprietario/salvar")
    Call <Proprietario> adicionar (@Body Proprietario Proprietario);

    @GET ("Proprietario/listar")
    Call <List<Proprietario>> listarProprietario ();

    @DELETE ("Proprietario/{idProprietario")
    Call <Void> deletar (@Path("idProprietario")Integer idProprietario);

    @PUT ("Proprietario/editar")
    Call <Proprietario> atualizar (@Body Proprietario Proprietario);
}
