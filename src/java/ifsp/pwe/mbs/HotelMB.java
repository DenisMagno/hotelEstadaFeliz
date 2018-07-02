package ifsp.pwe.mbs;

import ifsp.pwe.beans.Hotel;
import ifsp.pwe.dao.HotelDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HotelMB {
    private Long id;
    private String nome;
    private String endereco;
    private Long cnpj;
    private Hotel hotel;
    
    public HotelMB(){
        this.hotel = new Hotel();
    }
    
    public void criar() throws IOException{
        this.hotel.setNome(this.nome);
        this.hotel.setEndereco(this.endereco);
        this.hotel.setCnpj(this.cnpj);
        
        new HotelDao().criar(hotel);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("hotel.xhtml");
    }
    
    public List<Hotel> buscar(){
        List<Hotel> hoteis = new HotelDao().obter();
        return hoteis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    
}
