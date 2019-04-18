package model;

/**
 *
 * @author matheusgouveia
 */
public class Anuncio {
    private int idAnuncio;
    private int idProduto;
    private int idUsuario;
    private float Preco;
    private String ValidoDe;
    private String ValidoAte;
    private String Descricao;

    /**
     * @return the idAnuncio
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * @param idAnuncio the idAnuncio to set
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
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
     * @return the Preco
     */
    public float getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    /**
     * @return the ValidoDe
     */
    public String getValidoDe() {
        return ValidoDe;
    }

    /**
     * @param ValidoDe the ValidoDe to set
     */
    public void setValidoDe(String ValidoDe) {
        this.ValidoDe = ValidoDe;
    }

    /**
     * @return the ValidoAte
     */
    public String getValidoAte() {
        return ValidoAte;
    }

    /**
     * @param ValidoAte the ValidoAte to set
     */
    public void setValidoAte(String ValidoAte) {
        this.ValidoAte = ValidoAte;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
