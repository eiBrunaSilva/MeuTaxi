package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CorridaActivity extends AppCompatActivity {
    private TextView tvSelecionarPagamento;
    private EditText etValorCorrida;
    private RadioGroup rgPagamento;
    private RadioButton rbDinheiro;
    private RadioButton rbCartao;
    private EditText etHrInicioCorrida;
    private EditText etHrFimCorrida;
    private Button btAdicionarCorrida;
    private Retrofit retrofit;
    private CorridaService corridaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrida);
        this.inicializaComponentes();

        corridaService = retrofit.create(CorridaService.class);

        this.btAdicionarCorrida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Corrida corrida = new Corrida();
                corrida.setPreco(Integer.parseInt(etValorCorrida.getText().toString()));
                corrida.setHoraInicial(Integer.parseInt(etHrInicioCorrida.getText().toString()));
                corrida.setHoraFinal(Integer.parseInt(etHrFimCorrida.getText().toString()));
                if (rgPagamento.getCheckedRadioButtonId()== R.id.rb_cartao ){
                corrida.setCartao(true);
                }
                if (rgPagamento.getCheckedRadioButtonId() == R.id.rb_dinheiro) {
                    corrida.setCartao(false);
                }
                corridaService.adicionar(corrida).enqueue(new Callback<Corrida>() {
                    @Override
                    public void onResponse(Call<Corrida> call, Response<Corrida> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(CorridaActivity.this, "Corrida cadastrada com sucesso", Toast.LENGTH_LONG).show();
                            Intent itDiaria = new Intent(CorridaActivity.this, DiariaActivity.class);
                            startActivity(itDiaria);
                            finish();
                        } else {
                            Toast.makeText(CorridaActivity.this, "Falha no cadastro, tente novamente", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Corrida> call, Throwable throwable) {
                        Toast.makeText(CorridaActivity.this, "Falha na comunicação com o servidor, verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


    }
    private void inicializaComponentes () {
        this.tvSelecionarPagamento = findViewById(R.id.tv_selecionar_pagamento);
        this.etValorCorrida = findViewById(R.id.et_valor_corrida);
        this.rgPagamento = findViewById(R.id.rg_pagamento);
        this.rbDinheiro = findViewById(R.id.rb_dinheiro);
        this.rbCartao = findViewById(R.id.rb_cartao);
        this.etHrInicioCorrida = findViewById(R.id.et_hr_inicio_corrida);
        this.etHrFimCorrida = findViewById(R.id.et_hr_fim_corrida);



        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
