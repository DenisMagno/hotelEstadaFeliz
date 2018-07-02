/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.mbs;

import ifsp.pwe.beans.Hotel;
import ifsp.pwe.dao.HotelDao;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author felipe
 */
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
    
    public void criar(){
        this.hotel.setNome(this.nome);
        this.hotel.setEndereco(this.endereco);
        this.hotel.setCnpj(this.cnpj);
        
        new HotelDao().criar(hotel);
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
