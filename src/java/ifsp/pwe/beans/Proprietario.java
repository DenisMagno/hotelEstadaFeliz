package ifsp.pwe.beans;

import ifsp.pwe.dao.ProprietarioDao;

public class Proprietario extends Pessoa implements IFuncionario {

    private Float salario;
    private String senha;
    private String email;

    @Override
    public Proprietario login(String email, String senha) {
        Proprietario proprietario = new ProprietarioDao().obter(email, senha);

        if (proprietario == null) {
            return null;
        }

        return proprietario;
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
