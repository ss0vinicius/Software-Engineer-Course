package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShoppingListCrudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_crud);
    }

    public void cadastrar(View view) {
        // acesso aos componentes da atividade
        EditText etCodigo = (EditText)findViewById(R.id.etCodigo);
        EditText etDescricao = (EditText)findViewById(R.id.etDescricao);
        EditText etQuantidade = (EditText)findViewById(R.id.etQuantidade);
        EditText etValor = (EditText)findViewById(R.id.etValor);
        // criação do gerenciador do bd
        DatabaseManager gerenciadorBase = new DatabaseManager(getBaseContext());
        // chamada á função de inserção
        String resultado = gerenciadorBase.addProduct(
                etCodigo.getText().toString(),
                etDescricao.getText().toString(),
                etQuantidade.getText().toString(),
                etValor.getText().toString());
        // apresentação de mensagem do resultado da chamada ao método
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }
}