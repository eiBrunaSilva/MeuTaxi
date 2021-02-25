package com.example.alunoinfo.meutaxi;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaMotoristaActivity extends AppCompatActivity {
    private TextView tvOla;
    private Button btIniciarDiaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_motorista);
        this.btIniciarDiaria = findViewById(R.id.bt_iniciar_diaria);
        this.tvOla = findViewById(R.id.tv_ola);
        this.btIniciarDiaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itDiaria = new Intent(TelaMotoristaActivity.this, DiariaActivity.class);
                startActivity(itDiaria);
                finish();
            }
        });
    }
}
