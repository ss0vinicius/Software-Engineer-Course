package com.example.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "shoppinglist.db";
    private static final int VERSAO = 1;
    // construtor da classe
    public DatabaseManager(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }
    // método que cria a tabela, caso ainda não exista
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE product ("
                + " codigo integer primary key autoincrement,"
                + " descricao text,"
                + " quantidade integer,"
                + " valor double"
                +")";
        db.execSQL(sql);
    }
    // método que recria a tabela, caso sua estrutura tenha sido mudada
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS product");
        onCreate(db);
    }
    // função utilitária que cria um novo registro para um animal
    public String addProduct(String codigo, String descricao, String quantidade, String
            valor) {
        // associando os novos dados aos campos das tabelas
        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("descricao", descricao);
        valores.put("quantidade", quantidade);
        valores.put("valor", valor);
        // inserindo um novo registro (equivalente ao INSERT to SQL)
        SQLiteDatabase db = getWritableDatabase();
        long resultado = db.insert("product", null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor searchProductData(){

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select codigo as _id, descricao, quantidade, valor from product", null);
        // String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}