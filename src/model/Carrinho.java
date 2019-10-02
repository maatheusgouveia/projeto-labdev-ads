/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author MATHEUSAUGUSTOGOUVEI
 */
public class Carrinho {
    private int Quantidade;
    private int idProduto;

    /**
     * @return the idVenda
     */
    public int getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade
     * @return 
     */
    public boolean setQuantidade(int Quantidade) {
        if (Quantidade >= 0) {
            this.Quantidade = Quantidade;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser igual ou menor que 0");
            return false;
        }
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

}
