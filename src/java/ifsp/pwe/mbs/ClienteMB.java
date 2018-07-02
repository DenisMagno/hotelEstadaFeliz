package ifsp.pwe.mbs;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.dao.ClienteDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ClienteMB {
    private Long id;
    private Integer cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String dataCriacao;
    
    private Cliente cliente;
    
    public ClienteMB(){
        this.cliente = new Cliente();
    }
    
    public void criar() throws IOException{
        this.cliente.setCpf(this.cpf);
        this.cliente.setTelefone(this.telefone);
        this.cliente.setNome(this.nome);
        this.cliente.setEmail(this.email);
        this.cliente.setEndereco(this.endereco);

        Cliente cliente = new ClienteDao().criar(this.cliente);
        
        if(cliente != null){
            System.out.println("Criou cliente");
            FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
        }else{
            System.out.println("Não criou cliente");
            FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
        }
    }
    
    public List<Cliente> buscar(){
        List<Cliente> clientes = new ClienteDao().obter();
        return clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    
}
