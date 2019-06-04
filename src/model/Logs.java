/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 */
public class Logs {
    private int idLog;
    private String Acao;
    private String DataHora;
    private String NomeUsuario;

    /**
     * @return the idLog
     */
    public int getIdLog() {
        return idLog;
    }

    /**
     * @param idLog the idLog to set
     */
    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    /**
     * @return the Acao
     */
    public String getAcao() {
        return Acao;
    }

    /**
     * @param Acao the Acao to set
     */
    public void setAcao(String Acao) {
        this.Acao = Acao;
    }

    /**
     * @return the DataHora
     */
    public String getDataHora() {
        return DataHora;
    }

    /**
     * @param DataHora the DataHora to set
     */
    public void setDataHora(String DataHora) {
        this.DataHora = DataHora;
    }

    /**
     * @return the idUsuario
     */
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    /**
     * @param NomeUsuario
     */
    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }
}
