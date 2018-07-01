/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.mbs;

import ifsp.pwe.beans.Produto;
import ifsp.pwe.dao.ProdutoDao;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author felipe
 */
@ManagedBean
public class ProdutoMB {
    private String nome;
    private Float preco;
    private String descricao;
    private String Status;
    private Produto produto;
    
    public ProdutoMB(){
        this.produto = new Produto();
    }
    
    public void criar(){
        this.produto.setNome(this.nome);
        this.produto.setPreco(this.preco);
        this.produto.setDescricao(this.descricao);
        this.produto.setStatus(this.Status);
        
        new ProdutoDao().criar(this.produto);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
