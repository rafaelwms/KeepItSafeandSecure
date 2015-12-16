package br.com.rafaelwms.kiss.localDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Rafael on 26/11/2015.
 */
public class KissLocalDataBaseHelper extends SQLiteOpenHelper {

    public KissLocalDataBaseHelper(Context ctx) {
        super(ctx, "KeepItSafeSecure", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL( "CREATE TABLE SERVICOS (" +
                "idServico      INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idUsuario      INTEGER NOT NULL, " +
                "nomeServico    TEXT NOT NULL UNIQUE, " +
                "icoServico     INTEGER NOT NULL, " +
                "usaServidor    INTEGER NOT NULL," +
                "usaPorta       INTEGER NOT NULL);");

        db.execSQL( "CREATE TABLE CONTAS (" +
                "idConta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idServico INTEGER NOT NULL REFERENCES SERVICOS(idServico) ON DELETE CASCADE, " +
                "idUsuario INTEGER NOT NULL REFERENCES USUARIOS(idUsuario) ON DELETE CASCADE, " +
                "login TEXT NOT NULL, " +
                "senha TEXT NOT NULL, " +
                "servidor TEXT NULL, " +
                "porta INTEGER NULL);");

        db.execSQL( "CREATE TABLE USUARIOS (" +
                "idUsuario INTEGER PRIMARY KEY, " +
                "nivel INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "senha TEXT NOT NULL);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

