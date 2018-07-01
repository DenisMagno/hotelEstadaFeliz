package ifsp.pwe.beans;

public class Consumo {
    private Long id;
    private Long idHospedagem;
    private Long idProduto;
    private Hospedagem hospedagem;
    private Produto produto;
    
    public void obterProdutos(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Long idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
