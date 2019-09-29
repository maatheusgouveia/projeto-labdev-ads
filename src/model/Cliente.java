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
public class Cliente {
    private int idCliente;
    private String NomeCLiente;
    private String Cpf;
    private String Rg;
    private Date DataNascimento;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the NomeCLiente
     */
    public String getNomeCLiente() {
        return NomeCLiente;
    }

    /**
     * @param NomeCLiente the NomeCLiente to set
     */
    public void setNomeCLiente(String NomeCLiente) {
        this.NomeCLiente = NomeCLiente;
    }

    /**
     * @return the Cpf
     */
    public String getCpf() {
        return Cpf;
    }

    /**
     * @param Cpf the Cpf to set
     */
    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    /**
     * @return the Rg
     */
    public String getRg() {
        return Rg;
    }

    /**
     * @param Rg the Rg to set
     */
    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    /**
     * @return the DataNascimento
     */
    public Date getDataNascimento() {
        return DataNascimento;
    }

    /**
     * @param DataNascimento the DataNascimento to set
     */
    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
}
