package ifsp.pwe.beans;

import ifsp.pwe.dao.ProprietarioDao;
import ifsp.pwe.dao.RecepcionistaDao;

public class Pessoa {
    protected Long id;
    protected Integer cpf;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;
    
    public int login(String email, String senha){
        Proprietario proprietario = new ProprietarioDao().obter(email, senha);
        if(proprietario != null){
            return 1;
        }
        
        Recepcionista recepcionista = new RecepcionistaDao().obter(email, senha);
        if(recepcionista != null){
            return 2;
        }
        
        return 0;
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
}
