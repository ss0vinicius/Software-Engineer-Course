package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        DatabaseManager gerenciadorBase = new DatabaseManager(getBaseContext());
        Cursor cursor = gerenciadorBase.searchProductData();
        String[] nomeCampos = new String[] {"_id", "descricao", "quantidade", "valor"};
        int[] idViews = new int[] {R.id.tvCodigo, R.id.tvDescricao, R.id.tvQuantidade, R.id.tvValor};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.products_layout,cursor,nomeCampos,idViews, 0);
        ListView lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

    }
}