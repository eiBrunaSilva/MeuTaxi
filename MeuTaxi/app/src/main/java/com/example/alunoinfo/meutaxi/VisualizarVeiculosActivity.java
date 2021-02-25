
package com.example.alunoinfo.meutaxi;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VisualizarVeiculosActivity extends ListActivity {
    private VeiculoService service;
    private List<Veiculo> listaVeiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_visualizar_veiculos);
        service = RetrofitUtils.retrofit.create(VeiculoService.class);

        service.listarVeiculo().enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Veiculo> adapter = new ArrayAdapter<>(VisualizarVeiculosActivity.this, android.R.layout.simple_list_item_1, listaVeiculo);
                    setListAdapter(adapter);
                } else {
                    Toast.makeText(VisualizarVeiculosActivity.this, "Não foi possível buscar a lista de veículos. Tente novamente!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                Toast.makeText(VisualizarVeiculosActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

            }
             });


    }
}

