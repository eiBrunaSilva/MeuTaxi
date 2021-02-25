package com.example.alunoinfo.meutaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InicialActivity extends AppCompatActivity {
    private Button btLogin;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
        this.btLogin = findViewById(R.id.bt_entrar_prop);

        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itSelecionarCadastro = new Intent(InicialActivity.this, SelecionarCadastroActivity.class);
                startActivity(itSelecionarCadastro);
                finish();
            }
        });
        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itSelecionarLogin = new Intent(InicialActivity.this, SelecionarLoginActivity.class);
                startActivity(itSelecionarLogin);
                finish();
            }
        });
    }
}
