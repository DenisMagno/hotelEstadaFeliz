package ifsp.pwe.mbs;

import ifsp.pwe.beans.Proprietario;
import ifsp.pwe.utils.SessionContext;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class PessoaMB {
    private String senha;
    private String email;
    private Proprietario proprietario;

    public PessoaMB(){
        this.proprietario = new Proprietario();
    }

    public void entrar() throws IOException{
        Proprietario proprietario = this.proprietario.login(this.email, this.senha);
        
        if(proprietario == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            System.out.println("Não entrou!");
        }else{
            System.out.println("Entrou!");
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("usuario_logado", proprietario);

            FacesContext.getCurrentInstance().getExternalContext().redirect("ADMIN/proprietario.xhtml");
        }
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
