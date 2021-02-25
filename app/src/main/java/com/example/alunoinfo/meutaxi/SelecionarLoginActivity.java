package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelecionarLoginActivity extends AppCompatActivity {
    private TextView tvSelecioneLogin;
    private Button btLoginProprietario;
    private Button btLoginMotorista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_login);
        this.inicializaCompomemtes();
        this.btLoginProprietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itLoginProprietario = new Intent(SelecionarLoginActivity.this, LoginProprietarioActivity.class);
                startActivity(itLoginProprietario);
                finish();
            }
        });
        this.btLoginMotorista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itLoginMotorista = new Intent(SelecionarLoginActivity.this, LoginMotoristaActivity.class);
                startActivity(itLoginMotorista);
                finish();
            }
        });
    }
    private void inicializaCompomemtes () {
        this.tvSelecioneLogin = findViewById(R.id.tv_selecione_login);
        this.btLoginMotorista = findViewById(R.id.bt_login_motorista);
        this.btLoginProprietario = findViewById(R.id.bt_login_proprietario);
    }
}
