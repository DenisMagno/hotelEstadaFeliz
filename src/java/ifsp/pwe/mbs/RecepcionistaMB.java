package ifsp.pwe.mbs;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RecepcionistaMB {
    private Float salario;
    private String senha;
    private String email;

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
