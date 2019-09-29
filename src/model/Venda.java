/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author MATHEUSAUGUSTOGOUVEI
 */
public class Venda {
    private int idVenda;
    private int idUsuario;
    private String Status;
    private Date DataHora;
    private Date ModificadoEm;

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the DataHora
     */
    public Date getDataHora() {
        return DataHora;
    }

    /**
     * @param DataHora the DataHora to set
     */
    public void setDataHora(Date DataHora) {
        this.DataHora = DataHora;
    }

    /**
     * @return the ModificadoEm
     */
    public Date getModificadoEm() {
        return ModificadoEm;
    }

    /**
     * @param ModificadoEm the ModificadoEm to set
     */
    public void setModificadoEm(Date ModificadoEm) {
        this.ModificadoEm = ModificadoEm;
    }
}
