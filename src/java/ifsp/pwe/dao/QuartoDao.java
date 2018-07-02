package ifsp.pwe.dao;

import ifsp.pwe.beans.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoDao extends ConnectionFactory{
    public Quarto obter(Long id){
        try {
            String sql = "SELECT * FROM quarto WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }
            
            Quarto quarto = new Quarto() {};
            quarto.setId(rs.getLong("id"));
            quarto.setTipo(rs.getString("tipo"));
            quarto.setNumero(rs.getString("numero"));
            quarto.setPreco(rs.getFloat("preco"));
            quarto.setDescricao(rs.getString("descricao"));
            
            rs.close();
            stmt.close();
            this.connection.close();
            
            return quarto;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }   
    }
    
    public List<Quarto> obter(){
        try {
            String sql = "SELECT * FROM quarto";
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            List<Quarto> quartos = new ArrayList<Quarto>();
            while(rs.next()){
                Quarto quarto = new Quarto();
                
                quarto.setId(rs.getLong("id"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setNumero(rs.getString("numero"));
                quarto.setPreco(rs.getFloat("preco"));
                quarto.setDescricao(rs.getString("descricao"));
                
                quartos.add(quarto);
            }

            rs.close();
            stmt.close();
            this.connection.close();
            
            return quartos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }   
    }
    
    public Quarto criar(Quarto quarto){
        
        try {
            String sql = "INSERT INTO quarto (tipo, numero, preco, descricao, id_hotel) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, quarto.getTipo());
            stmt.setString(2, quarto.getNumero());
            stmt.setFloat(3, quarto.getPreco());
            stmt.setString(4, quarto.getDescricao());
            stmt.setLong(5, quarto.getHotel().getId());
            
            boolean rs = stmt.execute();
            
            if(!rs){
                return null;
            }
            
            stmt.close();
            this.connection.close();
         
            return quarto;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }   
    }
}
