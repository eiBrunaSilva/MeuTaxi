package com.example.alunoinfo.meutaxi;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaProprietarioActivity extends ListActivity {
    private String vetMenu[] = {"Visualizar veículos", "Visualizar diárias", "Cadastrar novo veículo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vetMenu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent itTelaListar;
        switch (position) {
            case 0:
                Intent itVisualizarVeiculos = new Intent(TelaProprietarioActivity.this, VisualizarVeiculosActivity.class);
                startActivity(itVisualizarVeiculos);
                break;
            case 1:
                Intent itVisualizarDiarias = new Intent(TelaProprietarioActivity.this, VisualizarDiariaActivity.class);
                startActivity(itVisualizarDiarias);
                break;
            case 2:
                Intent itCadastrarVeiculo = new Intent(TelaProprietarioActivity.this, VeiculoActivity.class);
                startActivity(itCadastrarVeiculo);
                break;
        }


    }
}
