package br.com.rafaelwms.kiss.entidades;

import android.os.Parcelable;

import java.io.Serializable;

import br.com.rafaelwms.kiss.R;

/**
 * Created by Rafael on 23/11/2015.
 */
public class Servico implements Serializable {

    private int idServico;
    private int idUsuario;
    private String nomeServico;
    private int icoServico;
    private int usaServidor;
    private int usaPorta;

    public Servico(int idServico, String nomeServico, int icoServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
    }

    public Servico(String nomeServico, int icoServico) {
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
    }

    public Servico(int idUsuario,String nomeServico, int icoServico, int usaServidor, int usaPorta) {
        this.idUsuario = idUsuario;
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
        this.usaServidor = usaServidor;
        this.usaPorta = usaPorta;
    }

    public Servico(int idServico, int idUsuario, String nomeServico, int icoServico, int usaServidor, int usaPorta) {
        this.idUsuario = idUsuario;
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.icoServico = icoServico;
        this.usaServidor = usaServidor;
        this.usaPorta = usaPorta;
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

    @Override
    public String toString() {
        return this.nomeServico;
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

    public int getUsaServidor() {
        return usaServidor;
    }

    public void setUsaServidor(int usaServidor) {
        this.usaServidor = usaServidor;
    }

    public int getUsaPorta() {
        return usaPorta;
    }

    public void setUsaPorta(int usaPorta) {
        this.usaPorta = usaPorta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
