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

public class VisualizarDiariaActivity extends ListActivity {
    private DiariaService service;
    private List<Diaria> listaDiaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_visualizar_diaria);
        service = RetrofitUtils.retrofit.create(DiariaService.class);

        service.listarDiaria().enqueue(new Callback<List<Diaria>>() {
            @Override
            public void onResponse(Call<List<Diaria>> call, Response<List<Diaria>> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Veiculo> adapter = new ArrayAdapter(VisualizarDiariaActivity.this, android.R.layout.simple_list_item_1, listaDiaria);
                    setListAdapter(adapter);
                } else {
                    Toast.makeText(VisualizarDiariaActivity.this, "Não foi possível buscar a lista de veículos. Tente novamente!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Diaria>> call, Throwable t) {
                Toast.makeText(VisualizarDiariaActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

            }
        });

    }
}
