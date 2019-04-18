package model;

/**
 *
 * @author matheusgouveia
 */
public class Produto {
    private int idProduto;
    private int idMarca;
    private int idSubcategoria;
    private String NomeProduto;

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

    /**
     * @return the idMarca
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the idSubcategoria
     */
    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    /**
     * @param idSubcategoria the idSubcategoria to set
     */
    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    /**
     * @return the NomeProduto
     */
    public String getNomeProduto() {
        return NomeProduto;
    }

    /**
     * @param NomeProduto the NomeProduto to set
     */
    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }
}
