package ifsp.pwe.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hospedagem {
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
      
    public Hospedagem(){
        this.cliente = new Cliente();
        this.quarto = new Quarto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    
    public String getCheckin() {
        return checkin;
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

    public void setQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
