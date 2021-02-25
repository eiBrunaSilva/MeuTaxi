package com.example.alunoinfo.meutaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginProprietarioActivity extends AppCompatActivity {
    private EditText etLoginProp;
    private EditText etSenhaProp;
    private Button btEntrarProp;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_proprietario);
        this.inicializaComponentes();
//        Buscar o login no banco


    }
    private void inicializaComponentes () {
        this.etLoginProp = findViewById(R.id.et_login_prop);
        this.etSenhaProp = findViewById(R.id.et_senha_prop);
        this.btEntrarProp = findViewById(R.id.bt_entrar_prop);
    }
}
