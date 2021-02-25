package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VeiculoActivity extends AppCompatActivity {
    private EditText etPlaca;
    private EditText etMarca;
    private EditText etModelo;
    private EditText etAno;
    private EditText etPrefixo;
    private Button btCadastrarVeiculo;
    private VeiculoService service;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);
        this.inicializaComponentes();
        this.btCadastrarVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(etPlaca.getText().toString());
                veiculo.setMarca(etMarca.getText().toString());
                veiculo.setModelo(etModelo.getText().toString());
                veiculo.setAno(Integer.parseInt(etAno.getText().toString()));
                veiculo.setPrefixo(Integer.parseInt(etPrefixo.getText().toString()));

                service.adicionar(veiculo).enqueue(new Callback<Veiculo>() {
                    @Override
                    public void onResponse(Call<Veiculo> call, Response<Veiculo> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(VeiculoActivity.this, "Veículo cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                            Intent itTelaMotorista = new Intent(VeiculoActivity.this, TelaMotoristaActivity.class);
                            startActivity(itTelaMotorista);
                            finish();
                        } else {
                            Toast.makeText(VeiculoActivity.this, "Falha no cadastro, tente novamente mais tarde", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Veiculo> call, Throwable t) {
                        Toast.makeText(VeiculoActivity.this, "Falha no cadastro, tente novamente mais tarde!", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });
    }
    private void inicializaComponentes () {
        this.etPlaca = findViewById(R.id.et_placa);
        this.etMarca = findViewById(R.id.et_marca);
        this.etModelo = findViewById(R.id.et_modelo);
        this.etAno = findViewById(R.id.et_ano);
        this.etPrefixo = findViewById(R.id.et_prefixo);
        this.btCadastrarVeiculo = findViewById(R.id.bt_cadastrar_veiculo);
        service = retrofit.create(VeiculoService.class);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}


