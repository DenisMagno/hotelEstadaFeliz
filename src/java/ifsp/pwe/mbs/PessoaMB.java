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
        }else{
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("usuario_logado", proprietario);
            
            /*
            TODO - Descomentar quando pagina do admin estiver pronta
            TODO - Verificar se pessoa e recepcionista ou proprietário e
            redirecionar para página correta
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
             */
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
