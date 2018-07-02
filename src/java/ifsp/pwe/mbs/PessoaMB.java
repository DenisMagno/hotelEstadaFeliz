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
            Proprietario proprietario = new Proprietario(pessoa);
            sessao.setAttribute("usuario_logado", proprietario);
            FacesContext.getCurrentInstance().getExternalContext().redirect("ADMIN/proprietario.xhtml");
        }
        
        if(result == 2){
            SessionContext sessao = SessionContext.getInstance();
            Recepcionista recepcionista = new Recepcionista(pessoa);
            sessao.setAttribute("usuario_logado", recepcionista);
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
    
    public int verificarFuncionario(){
        SessionContext sessao = SessionContext.getInstance();
        Object pessoa = sessao.getAttribute("usuario_logado");

        if(pessoa instanceof Proprietario){
            System.out.println("É um proprietário");
            return 1;
        }else if(pessoa instanceof Recepcionista){
            System.out.println("É um recepcionista");
            return 2;
        }else{
            System.out.println("Não é proprietário nem recepcionista");
            return 0;
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
