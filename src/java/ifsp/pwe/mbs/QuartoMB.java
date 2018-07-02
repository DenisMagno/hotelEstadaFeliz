package ifsp.pwe.mbs;

import ifsp.pwe.beans.Hotel;
import ifsp.pwe.beans.Quarto;
import ifsp.pwe.dao.QuartoDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class QuartoMB {
    private Long id;
    private String tipo;
    private String numero;
    private Float preco;
    private String descricao;
    private Long idHotel;
    private Quarto quarto;
    private Hotel hotel;
    
    public QuartoMB(){
        this.quarto = new Quarto();
        this.hotel = new Hotel();
    }
    
    public void criar() throws IOException{
        this.quarto.setNumero(this.numero);
        this.quarto.setDescricao(this.descricao);
        this.quarto.setPreco(this.preco);
        this.quarto.setTipo(this.tipo);
        this.hotel.setId(this.idHotel);
        this.quarto.setHotel(this.hotel);
        
        Quarto quarto = new QuartoDao().criar(this.quarto);
        
        if(quarto != null){
            System.out.println("Criou quarto");
            FacesContext.getCurrentInstance().getExternalContext().redirect("quarto.xhtml");
        }else{
            System.out.println("Não criou quarto");
            FacesContext.getCurrentInstance().getExternalContext().redirect("quarto.xhtml");
        }
    }
    
    public List<Quarto> buscar(){
        List<Quarto> quartos = new QuartoDao().obter();
        return quartos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
