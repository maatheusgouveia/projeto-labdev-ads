/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author matheusgouveia
 */
public class Categoria {
    private int idCategoria;
    private String NomeCategoria;

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the NomeCategoria
     */
    public String getNomeCategoria() {
        return NomeCategoria;
    }

    /**
     * @param NomeCategoria the NomeCategoria to set
     */
    public void setNomeCategoria(String NomeCategoria) {
        this.NomeCategoria = NomeCategoria;
    }
    
}
