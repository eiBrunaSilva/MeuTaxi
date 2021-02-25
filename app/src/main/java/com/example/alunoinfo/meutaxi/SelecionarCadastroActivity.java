package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelecionarCadastroActivity extends AppCompatActivity {
    private TextView tvSelecioneUsuario;
    private Button btCadastrarProprietario;
    private Button btCadastrarMotorista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_cadastro);
        this.inicializaComponentes();
               this.btCadastrarMotorista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itCadastrarMotorista = new Intent(SelecionarCadastroActivity.this, CadastrarMotoristaActivity.class);
                startActivity(itCadastrarMotorista);
                finish();
            }
        });
               this.btCadastrarProprietario.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent itCadastrarProprietario = new Intent(SelecionarCadastroActivity.this, CadastrarProprietarioActivity.class);
                       startActivity(itCadastrarProprietario);
                       finish();
                   }
               });
    }
    private void inicializaComponentes () {
        this.btCadastrarMotorista = findViewById(R.id.bt_cadastrar_motorista);
        this.btCadastrarProprietario = findViewById(R.id.bt_cadastrar_proprietario);
        this.tvSelecioneUsuario = findViewById(R.id.tv_selecione_usuario);
    }
}
