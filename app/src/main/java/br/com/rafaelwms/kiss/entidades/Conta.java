package br.com.rafaelwms.kiss.entidades;

import java.io.Serializable;

/**
 * Created by Rafael on 23/11/2015.
 */
public class Conta implements Serializable {


    private Servico servico;
    private Usuario usuario;
    private int idConta;
    private String login;
    private String senha;
    private String servidor;
    private int porta;

    public Conta() { }

    public Conta(Servico servico, Usuario usuario, int idConta, String login, String senha) {
        this.servico = servico;
        this.usuario = usuario;
        this.idConta = idConta;
        this.login = login;
        this.senha = senha;
    }

    public Conta(Servico servico, Usuario usuario, String login, String senha) {
        this.servico = servico;
        this.login = login;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Conta(Servico servico, Usuario usuario, int idConta, String login, String senha, String servidor, int porta) {
        this.servico = servico;
        this.usuario = usuario;
        this.idConta = idConta;
        this.login = login;
        this.senha = senha;
        this.servidor = servidor;
        this.porta = porta;
    }

    public Conta(Servico servico, String login, String senha, String servidor, int porta) {
        this.servico = servico;
        this.login = login;
        this.senha = senha;
        this.servidor = servidor;
        this.porta = porta;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
