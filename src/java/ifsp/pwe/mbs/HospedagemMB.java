package ifsp.pwe.mbs;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.beans.Hospedagem;
import ifsp.pwe.beans.Quarto;
import ifsp.pwe.dao.HospedagemDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HospedagemMB {
    private Long id;
    private String checkin;
    private String checkout;
    private String dataHoraInicio;
    private String dataHoraFim;
    private Float preco;
    private String status;
    
    private Long idCliente;
    private Long idQuarto;
    private Cliente cliente;
    private Quarto quarto;
    
    private Hospedagem hospedagem;

    public HospedagemMB(){
        this.hospedagem = new Hospedagem();
        this.cliente = new Cliente();
        this.quarto = new Quarto();
    }
    
    public void criar() throws IOException{
        this.hospedagem.setCheckin(this.checkin);
        this.hospedagem.setCheckout(this.checkout);
        this.hospedagem.setDataHoraInicio(this.dataHoraInicio);
        this.hospedagem.setDataHoraFim(this.dataHoraFim);
        this.hospedagem.setPreco(this.preco);
        this.hospedagem.setStatus(this.status);
        this.cliente.setId(this.idCliente);
        this.quarto.setId(this.idQuarto);
        this.hospedagem.setCliente(this.cliente);
        this.hospedagem.setQuarto(this.quarto);
        
        Hospedagem hospedagem = new HospedagemDao().criar(this.hospedagem);
        
        if(hospedagem != null){
            System.out.println("Criou hospedagem");
            FacesContext.getCurrentInstance().getExternalContext().redirect("hospedagem.xhtml");
        }else{
            System.out.println("Não criou hospedagem");
            FacesContext.getCurrentInstance().getExternalContext().redirect("hospedagem.xhtml");
        }
    }
    
    public List<Hospedagem> buscar(){
        List<Hospedagem> clientes = new HospedagemDao().obter();
        return clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(String dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
