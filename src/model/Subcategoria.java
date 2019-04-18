package model;

/**
 *
 * @author matheusgouveia
 */
public class Subcategoria {
    private int idSubcategoria;
    private int idCategoria;
    private String NomeSubcategoria;

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
     * @return the NomeSubcategoria
     */
    public String getNomeSubcategoria() {
        return NomeSubcategoria;
    }

    /**
     * @param NomeSubcategoria the NomeSubcategoria to set
     */
    public void setNomeSubcategoria(String NomeSubcategoria) {
        this.NomeSubcategoria = NomeSubcategoria;
    }
    
}
