package br.com.fatec_pdm_chat_com__firebase;

import android.os.RemoteException;

import java.util.Collections;
import java.util.Date;

public class Mensagem implements Comparable <Mensagem>{
    private String usuario;
    private Date date;
    private String texto;

    public int compareTo(Mensagem o) throws NullPointerException {
        if (o.getDate()!=null && !o.getTexto().equals("") && o.getTexto()!=null)
            return this.date.compareTo(o.date);
        else if (this.texto == null && o.texto.equals(""))
            return o.date.compareTo(o.date);
        else
            return this.date.compareTo(this.date);
    }


    public Mensagem(){}

    public Mensagem(String usuario, Date date, String texto) {
        this.usuario = usuario;
        this.date = date;
        this.texto = texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getTexto() {
        return texto;
    }
}
