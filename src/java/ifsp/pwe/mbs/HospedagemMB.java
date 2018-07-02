package ifsp.pwe.mbs;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.beans.Hospedagem;
import ifsp.pwe.beans.Quarto;
import ifsp.pwe.dao.HospedagemDao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HospedagemMB {
    private Long id;
    private Date checkin;
    private Date checkout;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private Float preco;
    private String status;
    
    private Long idCliente;
    private Long idQuarto;
    private Cliente cliente;
    private Quarto quarto;
    
    private Hospedagem hospedagem;
    
    public HospedagemMB(){
        this.hospedagem = new Hospedagem();
    }
    
    public void criar() throws IOException{
        this.hospedagem.setCheckin(this.checkin);
        this.hospedagem.setCheckout(this.checkout);
        this.hospedagem.setDataHoraInicio(this.dataHoraInicio);
        this.hospedagem.setDataHoraFim(this.dataHoraFim);
        this.hospedagem.setPreco(this.preco);
        this.hospedagem.setStatus(this.status);
        this.hospedagem.setCliente(this.cliente);
        this.hospedagem.setQuarto(this.quarto);
        
        Hospedagem hospedagem = new HospedagemDao().criar(this.hospedagem);
        if(hospedagem == null){
            System.out.println("Não cadastrou");
        }else{
            System.out.println("Não cadastrou");
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

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
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
