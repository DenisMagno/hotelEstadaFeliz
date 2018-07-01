package ifsp.pwe.mbs;

import ifsp.pwe.beans.Pessoa;
import ifsp.pwe.beans.Proprietario;
import ifsp.pwe.beans.Recepcionista;
import ifsp.pwe.utils.SessionContext;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class PessoaMB {
    private String senha;
    private String email;
    private Pessoa pessoa;
    private Proprietario proprietario;
    private Recepcionista recepcionista;

    public PessoaMB() {
        this.proprietario = new Proprietario();
        this.recepcionista = new Recepcionista();
    }

    public void entrar() throws IOException{
        Pessoa pessoa = new Pessoa();
        int result = pessoa.login(this.email, this.senha);

        if(result == 1){
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("usuario_logado", pessoa);
            FacesContext.getCurrentInstance().getExternalContext().redirect("ADMIN/proprietario.xhtml");
        }
        
        if(result == 2){
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("usuario_logado", pessoa);
            FacesContext.getCurrentInstance().getExternalContext().redirect("ADMIN/recepcionista.xhtml");
        }
        
        if(result == 0){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }

    public void sair() throws IOException{       
        SessionContext sessao = SessionContext.getInstance();
        sessao.encerrarSessao();

        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
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
