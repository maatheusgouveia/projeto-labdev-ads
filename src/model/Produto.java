package model;

public class Produto {
    //Atributos

    private int idProduto;
    private String NomeProduto;
    private int idSubcategoria;
    private int idMarca;
    private float PrecoProduto;

    public int getIdProduto() {
        return idProduto;
    }


    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }


    public String getNomeProduto() {
        return NomeProduto;
    }


    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }


    public int getidSubcategoria() {
        return idSubcategoria;
    }


    public void setidSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
    
    
    public int getidMarca() {
        return idMarca;
    }
        public void setidMarca(int idMarca) {
        this.idMarca = idMarca;
    }
        
    public float getPrecoProduto() {
        return PrecoProduto;
    }
        public void setPrecoProduto(float PrecoProduto) {
        this.PrecoProduto = PrecoProduto;
    }    
        
}
