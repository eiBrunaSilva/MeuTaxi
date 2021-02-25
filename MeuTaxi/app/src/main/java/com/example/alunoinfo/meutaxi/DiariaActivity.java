package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiariaActivity extends AppCompatActivity {
    private EditText etData;
    private EditText etHoraInicio;
    private EditText etKmInicial;
    private Button btNovaCorrida;
    private Button btNovoGasto;
    private Button btListarCorridas;
    private EditText etKmFinal;
    private EditText etPrecoKm;
    private EditText etCombustivel;
    private EditText etComissao;
    private EditText etHoraFim;
    private Button btEncerrarDiaria;
    private Retrofit retrofit;
    private DiariaService diariaService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaria);
        this.inicializaComponentes();
        this.btNovaCorrida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itCorrida = new Intent(DiariaActivity.this, CorridaActivity.class);
                startActivity(itCorrida);
                        finish();
            }
        });
        this.btNovoGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itGasto = new Intent(DiariaActivity.this, GastoActivity.class);
                startActivity(itGasto);
                finish();
            }
        });
        this.btListarCorridas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itListarCorridas = new Intent(DiariaActivity.this, ListarCorridasActivity.class);
                startActivity(itListarCorridas);
                finish();
            }
        });
        this.btEncerrarDiaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Diaria diaria = new Diaria();
                diaria.setDia(Integer.parseInt(etData.getText().toString()));
                diaria.setHoraInicial(Integer.parseInt(etHoraInicio.getText().toString()));
                diaria.setKmInicial(Integer.parseInt(etKmInicial.getText().toString()));
                diaria.setKmFinal(Integer.parseInt(etKmFinal.getText().toString()));
                diaria.setPrecoKm(Integer.parseInt(etPrecoKm.getText().toString()));
                diaria.setCombustivel(Integer.parseInt(etCombustivel.getText().toString()));
                diaria.setComissao(Integer.parseInt(etComissao.getText().toString()));
                diaria.setHoraFinal(Integer.parseInt(etHoraFim.getText().toString()));

                diariaService.adicionar(diaria).enqueue(new Callback<Diaria>() {
                    @Override
                    public void onResponse(Call<Diaria> call, Response<Diaria> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(DiariaActivity.this, "Diária adicionada com sucesso", Toast.LENGTH_LONG).show();
                            Intent itTelaMotorista= new Intent(DiariaActivity.this, TelaMotoristaActivity.class);
                            startActivity(itTelaMotorista);
                            finish();
                        } else {
                            Toast.makeText(DiariaActivity.this, "Falha no cadastro, tente novamente", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Diaria> call, Throwable t) {

                    }
                });


            }
        });





    }
    private void inicializaComponentes () {
        this.etData = findViewById(R.id.et_data);
        this.etHoraInicio = findViewById(R.id.et_hora_inicio);
        this.etKmInicial = findViewById(R.id.et_km_inicial);
        this.btNovaCorrida = findViewById(R.id.bt_nova_corrida);
        this.btNovoGasto = findViewById(R.id.bt_novo_gasto);
        this.btListarCorridas = findViewById(R.id.bt_listar_corridas);
        this.etKmFinal = findViewById(R.id.et_km_final);
        this.etPrecoKm = findViewById(R.id.et_preco_km);
        this.etCombustivel = findViewById(R.id.et_combustivel);
        this.etComissao = findViewById(R.id.et_comissão);
        this.etHoraFim = findViewById(R.id.et_hora_fim);
        this.btEncerrarDiaria = findViewById(R.id.bt_encerrar_diaria);

        diariaService = retrofit.create(DiariaService.class);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
