package ifsp.pwe.mbs;

import ifsp.pwe.beans.Hospedagem;
import ifsp.pwe.beans.Produto;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsumoMB {
    private Long id;
    private Long idHospedagem;
    private Long idProduto;
    private Hospedagem hospedagem;
    private Produto produto;

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
