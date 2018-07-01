/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.dao;

import ifsp.pwe.beans.Hotel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author felipe
 */
public class HotelDao extends ConnectionFactory{
    public Hotel obter(Long id){
        try {
            String sql = "Select * FROM hotel WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sql);
            
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }
            Hotel hotel = new Hotel();
            
            hotel.setId(rs.getLong("id"));
            hotel.setNome(rs.getString("nome"));
            hotel.setEndereco(rs.getString("endereco"));
            hotel.setCnpj(rs.getLong("cnpj"));
            rs.close();
            stmt.close();
            this.connection.close();
            
            return hotel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Hotel criar(Hotel hotel){
        try {
            String sql = "INSERT INTO hotel values(?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sql);
            stmt.setString(2, sql);
            stmt.setString(3, sql);
            
            boolean rs = stmt.execute(sql);
            
            if(!rs){
                return null;
            }
            stmt.close();
            this.connection.close();
            return hotel;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
