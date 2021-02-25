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

public class CadastrarMotoristaActivity extends AppCompatActivity {
    private EditText etNomeMotorista;
    private EditText etTelefoneMotorista;
    private EditText etRuaMotorista;
    private EditText etNumeroMotorista;
    private EditText etBairroMotorista;
    private EditText etCidadeMotorista;
    private EditText etEstadoMotorista;
    private EditText etCepMotorista;
    private EditText etEmailMotorista;
    private EditText etLoginMotorista;
    private EditText etSenhaMotorista;
    private Button btCadastrarMotoristaFinal;
    private Retrofit retrofit;
    private MotoristaService motoristaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_motorista);
        this.inicializaComponentes();

        motoristaService = retrofit.create(MotoristaService.class);

        this.btCadastrarMotoristaFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Motorista motorista = new Motorista();
                motorista.setNome(etNomeMotorista.getText().toString());
                motorista.setTelefone(Integer.parseInt(etTelefoneMotorista.getText().toString()));
                motorista.setRua(etRuaMotorista.getText().toString());
                motorista.setNumero(Integer.parseInt(etNumeroMotorista.getText().toString()));
                motorista.setBairro(etBairroMotorista.getText().toString());
                motorista.setCidade(etCidadeMotorista.getText().toString());
                motorista.setEstado(etEstadoMotorista.getText().toString());
                motorista.setCep(Integer.parseInt(etCepMotorista.getText().toString()));
                motorista.setEmail(etEmailMotorista.getText().toString());
                motorista.setLogin(etLoginMotorista.getText().toString());
                motorista.setSenha(etSenhaMotorista.getText().toString());

                motoristaService.adicionar(motorista).enqueue(new Callback<Motorista>() {
                    @Override
                    public void onResponse(Call<Motorista> call, Response<Motorista> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(CadastrarMotoristaActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                            Intent itTelaMotorista = new Intent(CadastrarMotoristaActivity.this, TelaMotoristaActivity.class);
                            startActivity(itTelaMotorista);
                            finish();
                        } else {
                            Toast.makeText(CadastrarMotoristaActivity.this, "Falha no cadastro, tente novamente", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Motorista> call, Throwable t) {
                        Toast.makeText(CadastrarMotoristaActivity.this, "Falha na comunicação com o servidor, verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });
    }
    private void inicializaComponentes () {
        this.etNomeMotorista = findViewById(R.id.et_nome_motorista);
        this.etTelefoneMotorista = findViewById(R.id.et_telefone_motorista);
        this.etRuaMotorista = findViewById(R.id.et_rua_motorista);
        this.etNumeroMotorista = findViewById(R.id.et_numero_motorista);
        this.etBairroMotorista = findViewById(R.id.et_bairro_motorista);
        this.etCidadeMotorista = findViewById(R.id.et_cidade_motorista);
        this.etEstadoMotorista = findViewById(R.id.et_estado_motorista);
        this.etCepMotorista = findViewById(R.id.et_cep_motorista);
        this.etEmailMotorista = findViewById(R.id.et_email_motorista);
        this.etLoginMotorista = findViewById(R.id.et_login_motorista);
        this.etSenhaMotorista = findViewById(R.id.et_senha_motorista);
        this.btCadastrarMotoristaFinal = findViewById(R.id.bt_cadastrar_motorista_final);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
