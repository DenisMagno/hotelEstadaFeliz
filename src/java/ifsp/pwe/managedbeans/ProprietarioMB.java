package ifsp.pwe.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProprietarioMB extends PessoaMB{
    private Float salario;

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}
