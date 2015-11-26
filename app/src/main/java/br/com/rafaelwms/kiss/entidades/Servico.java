package br.com.rafaelwms.kiss.entidades;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Rafael on 23/11/2015.
 */
public class Servico implements Serializable {

    private int idServico;
    private String nomeServico;
    private int icoServico;

    public Servico(int idServico, String nomeServico, int icoServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
    }

    public Servico(String nomeServico, int icoServico) {
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
    }

    public Servico() {}

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public int getIcoServico() {
        return icoServico;
    }

    public void setIcoServico(int icoServico) {
        this.icoServico = icoServico;
    }
}
