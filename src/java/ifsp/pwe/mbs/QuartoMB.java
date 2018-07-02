package ifsp.pwe.mbs;

import ifsp.pwe.beans.Quarto;
import ifsp.pwe.dao.QuartoDao;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class QuartoMB {
    private Long id;
    private String tipo;
    private String numero;
    private Float preco;
    private String descricao;
    private Quarto quarto;
    
    public QuartoMB(){
        this.quarto = new Quarto();
    }
    
    public void criar(){
        this.quarto.setNumero(this.numero);
        this.quarto.setDescricao(this.descricao);
        this.quarto.setPreco(this.preco);
        this.quarto.setTipo(this.tipo);
        
        new QuartoDao().criar(this.quarto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
}
