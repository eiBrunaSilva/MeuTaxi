package com.example.alunoinfo.meutaxi;

import android.service.autofill.Validator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginMotoristaActivity extends AppCompatActivity {

    private EditText etLoginMotora;
    private EditText etSenhaMotora;
    private Button btEntrarMotora;
    private MotoristaService service;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_motorista);
        this.inicializaComponentes();
//        Buscar o login no banco
        Motorista motorista = new Motorista();
        motorista.setLogin(etLoginMotora.getText().toString());
        motorista.setSenha(etSenhaMotora.getText().toString());



    }
    private void inicializaComponentes () {
        this.etLoginMotora= findViewById(R.id.et_login_motora);
        this.etSenhaMotora = findViewById(R.id.et_senha_motora);
        this.btEntrarMotora = findViewById(R.id.bt_entrar_motora);
        service = retrofit.create(MotoristaService.class);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/MeuTaxi")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
