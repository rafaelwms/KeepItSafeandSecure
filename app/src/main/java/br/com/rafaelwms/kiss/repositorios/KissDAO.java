package br.com.rafaelwms.kiss.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelwms.kiss.entidades.Conta;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.entidades.Usuario;
import br.com.rafaelwms.kiss.localDB.KissLocalDataBaseHelper;

/**
 * Created by Rafael on 26/11/2015.
 */
public class KissDAO {

    private KissLocalDataBaseHelper helper;

    private final String TB_SERVICOS = "SERVICOS";
    private final String TB_CONTAS = "CONTAS";
    private final String TB_USERS = "USUARIOS";
    private final String SELECT_ALL = "SELECT * FROM ";

    public KissDAO(Context ctx){helper = new KissLocalDataBaseHelper(ctx);}

    private ContentValues servicoValues(Servico servico){
        ContentValues values = new ContentValues();
        values.put("nomeServico", servico.getNomeServico());
        values.put("idUsuario", servico.getIdUsuario());
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

    private ContentValues usuarioValues(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("idUsuario", usuario.getId());
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("nivel", usuario.getNivelSeguranca());
        return values;
    }

    /**
     * Insert dos objetos
     */
    public void insertServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = servicoValues(servico);
        db.insert(TB_SERVICOS, null, values);
        db.close();
    }

    public void insertConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = contaValues(conta);
        db.insert(TB_CONTAS, null, values);
        db.close();
    }

    public void insertUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = usuarioValues(usuario);
        db.insert(TB_USERS, null, values);
        db.close();
    }

    public void alterarServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = servicoValues(servico);
        db.update(TB_SERVICOS, values, "idServico = ?", new String[]{String.valueOf(servico.getIdServico())});
        db.close();
    }

    public void alterarConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = contaValues(conta);
        db.update(TB_CONTAS, values, "idConta = ?", new String[]{String.valueOf(conta.getIdConta())});
        db.close();
    }

    public void alterarUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = usuarioValues(usuario);
        db.update(TB_USERS, values, "idUsuario = ?", new String[]{String.valueOf(usuario.getId())});
        db.close();
    }

    public void deletarServico(Servico servico) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TB_SERVICOS, "idServico = ?", new String[]{String.valueOf(servico.getIdServico())});
        db.close();
    }

    public void deletarConta(Conta conta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TB_CONTAS, "idConta = ?", new String[]{String.valueOf(conta.getIdConta())});
        db.close();
    }

    public void deletarUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TB_USERS, "idUsuario = ?", new String[]{String.valueOf(usuario.getId())});
        db.close();
    }

    private Servico instanciarServico(Cursor cursor){
        int idServico = cursor.getInt(cursor.getColumnIndex("idServico"));
        int idUsuario = cursor.getInt(cursor.getColumnIndex("idUsuario"));
        String nomeServico = cursor.getString(cursor.getColumnIndex("nomeServico"));
        int icoServico = cursor.getInt(cursor.getColumnIndex("icoServico"));
        int usaServidor = cursor.getInt(cursor.getColumnIndex("usaServidor"));
        int usaPorta = cursor.getInt(cursor.getColumnIndex("usaPorta"));

        Servico servico = new Servico(idServico,idUsuario,nomeServico,icoServico,usaServidor,usaPorta);
        return servico;
    }

    private Conta instanciarConta(Cursor cursor){
        int idConta = cursor.getInt(cursor.getColumnIndex("idConta"));
        Usuario usuario = obterUsuarioPorId(cursor.getInt(cursor.getColumnIndex("isUsuario")));
        Servico servico = obterServicoPorId(cursor.getInt(cursor.getColumnIndex("idServico")));
        String login = cursor.getString(cursor.getColumnIndex("login"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));
        String servidor = cursor.getString(cursor.getColumnIndex("servidor"));
        int porta = cursor.getInt(cursor.getColumnIndex("porta"));

        Conta conta = new Conta(servico, usuario,idConta, login, senha, servidor, porta);
        return conta;
    }

    private Usuario instanciarUsuario(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex("idUsuario"));
        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        String email = cursor.getString(cursor.getColumnIndex("email"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));
        int nivel = cursor.getInt(cursor.getColumnIndex("nivel"));

        Usuario usuario = new Usuario(id,email,nome,senha,nivel);
        return usuario;
    }

    public Servico obterServicoPorId(int idServico){
        Servico servico = new Servico();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL + TB_SERVICOS + " WHERE idServico = ?",
                new String[]{String.valueOf(idServico)});

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

    public Usuario obterUsuarioPorId(int idUsuario){
        Usuario usuario = new Usuario();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL + TB_USERS + " WHERE idUsuario = ?",
                new String[]{String.valueOf(idUsuario)});

        if (cursor.moveToFirst() && cursor.getCount() >= 1) {

            usuario = instanciarUsuario(cursor);
            cursor.close();
            db.close();
            return usuario;

        }else{
            cursor.close();
            db.close();
            return null;
        }
    }

    public List<Servico> listarServicos(int idUsuario){
        List<Servico> servicos = new ArrayList<Servico>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+ TB_SERVICOS +" WHERE idUsuario = ? AND idUsuario = 0",
                new String[]{String.valueOf(idUsuario)});

        while (cursor.moveToNext()) {

            Servico servico = instanciarServico(cursor);
            servicos.add(servico);
        }
        cursor.close();
        db.close();
        return servicos;
    }

    public List<Conta> listarContas(int idUsuario){
        List<Conta> contas = new ArrayList<Conta>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+ TB_CONTAS +" WHERE idUsuario = ?",
                new String[]{String.valueOf(idUsuario)});

        while (cursor.moveToNext()) {

            Conta conta = instanciarConta(cursor);
            contas.add(conta);
        }
        cursor.close();
        db.close();
        return contas;
    }

    public List<Conta> listarContasPorServico(int idUsuario, int idServico){
        List<Conta> contas = new ArrayList<Conta>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                SELECT_ALL+ TB_CONTAS +" WHERE idUsuario = ? AND idServico = ?",
                new String[]{String.valueOf(idUsuario), String.valueOf(idServico)});

        while (cursor.moveToNext()) {

            Conta conta = instanciarConta(cursor);
            contas.add(conta);
        }
        cursor.close();
        db.close();
        return contas;
    }


}
