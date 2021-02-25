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

public class CadastrarProprietarioActivity extends AppCompatActivity {

    private EditText etNomeProprietario;
    private EditText etTelefoneProprietario;
    private EditText etRuaProprietario;
    private EditText etNumeroProprietario;
    private EditText etBairroProprietario;
    private EditText etCidadeProprietario;
    private EditText etEstadoProprietario;
    private EditText etCepProprietario;
    private EditText etEmailProprietario;
    private EditText etLoginProprietario;
    private EditText etSenhaProprietario;
    private Button btCadastrarProprietarioFinal;
    private Retrofit retrofit;
    private ProprietarioService proprietarioService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_proprietario);
        this.inicializaComponentes();
        this.btCadastrarProprietarioFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(etNomeProprietario.getText().toString());
                proprietario.setTelefone(Integer.parseInt(etTelefoneProprietario.getText().toString()));
                proprietario.setRua(etRuaProprietario.getText().toString());
                proprietario.setNumero(Integer.parseInt(etNumeroProprietario.getText().toString()));
                proprietario.setBairro(etBairroProprietario.getText().toString());
                proprietario.setCidade(etCidadeProprietario.getText().toString());
                proprietario.setEstado(etEstadoProprietario.getText().toString());
                proprietario.setCep(Integer.parseInt(etCepProprietario.getText().toString()));
                proprietario.setEmail(etEmailProprietario.getText().toString());
                proprietario.setLogin(etLoginProprietario.getText().toString());
                proprietario.setSenha(etSenhaProprietario.getText().toString());

                proprietarioService = retrofit.create(ProprietarioService.class);

                proprietarioService.adicionar(proprietario).enqueue(new Callback<Proprietario>() {
                    @Override
                    public void onResponse(Call<Proprietario> call, Response<Proprietario> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(CadastrarProprietarioActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                            Intent itTelaProprietario = new Intent(CadastrarProprietarioActivity.this, TelaProprietarioActivity.class);
                            startActivity(itTelaProprietario);
                            finish();
                        } else {
                            Toast.makeText(CadastrarProprietarioActivity.this, "Falha no cadastro, tente novamente", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Proprietario> call, Throwable t) {
                        Toast.makeText(CadastrarProprietarioActivity.this, "Falha na comunicação com o servidor, verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();



                    }
                });



            }
        });
    }
    private void inicializaComponentes () {
        this.etNomeProprietario = findViewById(R.id.et_nome_proprietario);
        this.etTelefoneProprietario = findViewById(R.id.et_telefone_proprietario);
        this.etRuaProprietario = findViewById(R.id.et_rua_proprietario);
        this.etNumeroProprietario = findViewById(R.id.et_numero_proprietario);
        this.etBairroProprietario = findViewById(R.id.et_bairro_proprietario);
        this.etCidadeProprietario = findViewById(R.id.et_cidade_proprietario);
        this.etEstadoProprietario = findViewById(R.id.et_estado_proprietario);
        this.etCepProprietario = findViewById(R.id.et_cep_proprietario);
        this.etEmailProprietario = findViewById(R.id.et_email_proprietario);
        this.etLoginProprietario = findViewById(R.id.et_login_proprietario);
        this.etSenhaProprietario = findViewById(R.id.et_senha_proprietario);
        this.btCadastrarProprietarioFinal = findViewById(R.id.bt_cadastrar_proprietario_final);



        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
