package model;

/**
 *
 * @author matheusgouveia
 */
public class Produto {
    private int idProduto;
    private String NomeProduto;
    private Float PrecoProduto;
    private int EstoqueProduto;
    private String DescricaoProduto;
    
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

    /**
     * @return the PrecoProduto
     */
    public Float getPrecoProduto() {
        return PrecoProduto;
    }

    /**
     * @param PrecoProduto the PrecoProduto to set
     */
    public void setPrecoProduto(Float PrecoProduto) {
        this.PrecoProduto = PrecoProduto;
    }

    /**
     * @return the EstoqueProduto
     */
    public int getEstoqueProduto() {
        return EstoqueProduto;
    }

    /**
     * @param EstoqueProduto the EstoqueProduto to set
     */
    public void setEstoqueProduto(int EstoqueProduto) {
        this.EstoqueProduto = EstoqueProduto;
    }
 
    /**
     * @return the DescricaoProduto
     */
    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    /**
     * @param DescricaoProduto the EstoqueProduto to set
     */
    public void setDescricaoProduto(String DescricaoProduto) {
        this.DescricaoProduto = DescricaoProduto;
    }
}
