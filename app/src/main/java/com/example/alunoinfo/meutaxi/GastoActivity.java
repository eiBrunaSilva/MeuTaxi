package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GastoActivity extends AppCompatActivity {
    private EditText etValorGasto;
    private EditText etDescricaoGasto;
    private Button btAdicionarGasto;
    private Retrofit retrofit;
    private GastoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);
        this.inicializaComponentes();

        this.btAdicionarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gasto gasto = new Gasto();
                gasto.setValor(Integer.parseInt(etValorGasto.getText().toString()));
                gasto.setDescricao(etDescricaoGasto.getText().toString());
                Intent itCorrida = new Intent(GastoActivity.this, CorridaActivity.class);
                startActivity(itCorrida);
                finish();
            }
        });

    }
    private void inicializaComponentes () {
        this.etValorGasto = findViewById(R.id.et_valor_gasto);
        this.etDescricaoGasto = findViewById(R.id.et_descricao_gasto);
        this.btAdicionarGasto = findViewById(R.id.bt_adicionar_gasto);
        service = retrofit.create(GastoService.class);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
