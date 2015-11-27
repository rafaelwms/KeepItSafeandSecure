package br.com.rafaelwms.kiss.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelwms.kiss.entidades.Conta;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.sqlite.KissDBHelper;

/**
 * Created by Rafael on 26/11/2015.
 */
public class KissDAO {

    private KissDBHelper helper;

    private final String TB_SERV = "SERVICOS";
    private final String TB_CTA = "CONTAS";
    private final String SELECT_ALL = "SELECT * FROM ";

    public KissDAO(Context ctx){helper = new KissDBHelper(ctx);}

    private ContentValues servicoValues(Servico servico){
        ContentValues values = new ContentValues();
        values.put("nomeServico", servico.getNomeServico());
        values.put("icoServico", servico.getIcoServico());
        values.put("usaServidor", servico.getUsaServidor());
        values.put("usaPorta", servico.getUsaPorta());
        return values;
    }

    private ContentValues contaValues(Conta conta){
        ContentValues values = new ContentValues();
        values.put("idServico", conta.getServico().getIdServico());
        values.put("login", conta.getLogin());
        values.put("senha", conta.getSenha());
        values.put("servidor", conta.getServidor());
        values.put("porta", conta.getPorta());
        return values;
    }

    /**
     * Insert dos objetos
     */
    public void insertServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = servicoValues(servico);
        db.insert(TB_SERV, null, values);
        db.close();
    }

    public void insertConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = contaValues(conta);
        db.insert(TB_CTA, null, values);
        db.close();
    }

    public void alterarServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = servicoValues(servico);
        db.update(TB_SERV, values, "idServico = ?", new String[]{String.valueOf(servico.getIdServico())});
        db.close();
    }

    public void alterarConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = contaValues(conta);
        db.update(TB_CTA, values, "idConta = ?", new String[]{String.valueOf(conta.getIdConta())});
        db.close();
    }

    public void deletarServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TB_SERV, "idServico = ?", new String[]{String.valueOf(servico.getIdServico())});
        db.close();
    }

    public void deletarConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TB_CTA, "idConta = ?", new String[]{String.valueOf(conta.getIdConta())});
        db.close();
    }

    private Servico instanciarServico(Cursor cursor){
        int idServico = cursor.getInt(cursor.getColumnIndex("idServico"));
        String nomeServico = cursor.getString(cursor.getColumnIndex("nomeServico"));
        int icoServico = cursor.getInt(cursor.getColumnIndex("icoServico"));
        int usaServidor = cursor.getInt(cursor.getColumnIndex("usaServidor"));
        int usaPorta = cursor.getInt(cursor.getColumnIndex("usaPorta"));

        Servico servico = new Servico(idServico,nomeServico,icoServico,usaServidor,usaPorta);
        return servico;
    }

    private Conta instanciarConta(Cursor cursor){
        int idConta = cursor.getInt(cursor.getColumnIndex("idConta"));
        Servico servico = obterServicoPorId(cursor.getInt(cursor.getColumnIndex("idServico")));
        String login = cursor.getString(cursor.getColumnIndex("login"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));
        String servidor = cursor.getString(cursor.getColumnIndex("servidor"));
        int porta = cursor.getInt(cursor.getColumnIndex("porta"));

        Conta conta = new Conta(servico, idConta, login, senha, servidor, porta);
        return conta;
    }

    public Servico obterServicoPorId(int id){
        Servico servico = new Servico();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL + TB_SERV + " WHERE idServico = ?",
                new String[]{String.valueOf(id)});

        if (cursor.moveToFirst() && cursor.getCount() >= 1) {

            servico = instanciarServico(cursor);
            cursor.close();
            db.close();
            return servico;

        }else{
            cursor.close();
            db.close();
            return null;
        }
    }

    public List<Servico> listarServicos(){
        List<Servico> servicos = new ArrayList<Servico>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+TB_SERV, null);

        while (cursor.moveToNext()) {

            Servico servico = instanciarServico(cursor);
            servicos.add(servico);
        }
        cursor.close();
        db.close();
        return servicos;
    }

    public List<Conta> listarContas(){
        List<Conta> contas = new ArrayList<Conta>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+TB_CTA, null);

        while (cursor.moveToNext()) {

            Conta conta = instanciarConta(cursor);
            contas.add(conta);
        }
        cursor.close();
        db.close();
        return contas;
    }

    public List<Conta> listarContasPorServico(int idServico){
        List<Conta> contas = new ArrayList<Conta>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+TB_CTA+" WHERE idServico = ?",
                new String[]{String.valueOf(idServico)});

        while (cursor.moveToNext()) {

            Conta conta = instanciarConta(cursor);
            contas.add(conta);
        }
        cursor.close();
        db.close();
        return contas;
    }


}
