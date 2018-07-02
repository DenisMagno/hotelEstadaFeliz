package ifsp.pwe.dao;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.beans.Hospedagem;
import ifsp.pwe.beans.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDao extends ConnectionFactory{
    public Hospedagem obter(Long id){
        try {
            String sql = "SELECT * FROM hospedagem WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }
            
            Hospedagem hospedagem = new Hospedagem();
            
            hospedagem.setId(rs.getLong("id"));
            hospedagem.setCheckin(rs.getString("checkin"));
            hospedagem.setCheckout(rs.getString("checkout"));
            hospedagem.setDataHoraInicio(rs.getString("dataHoraInicio"));
            hospedagem.setDataHoraFim(rs.getString("dataHoraFim"));
            hospedagem.setPreco(rs.getFloat("preco"));
            hospedagem.setStatus(rs.getString("status"));
            
            Cliente cliente = new ClienteDao().obter(rs.getLong("id_cliente"));
            hospedagem.setCliente(cliente);
                
            Quarto quarto = new QuartoDao().obter(rs.getLong("id_quarto"));
            hospedagem.setQuarto(quarto);
            
            rs.close();
            stmt.close();
            this.connection.close();
            
            return hospedagem;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<Hospedagem> obter(){
        try {
            String sql = "SELECT * FROM hospedagem";
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
            
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem();
                
                hospedagem.setId(rs.getLong("id"));
                hospedagem.setCheckin(rs.getString("checkin"));
                hospedagem.setCheckout(rs.getString("checkout"));
                hospedagem.setDataHoraInicio(rs.getString("dataHorarioInicio"));
                hospedagem.setDataHoraFim(rs.getString("dataHorarioFim"));
                hospedagem.setPreco(rs.getFloat("preco"));
                hospedagem.setStatus(rs.getString("status"));
                
                Cliente cliente = new ClienteDao().obter(rs.getLong("id_cliente"));
                hospedagem.setCliente(cliente);
                
                Quarto quarto = new QuartoDao().obter(rs.getLong("id_quarto"));
                hospedagem.setQuarto(quarto);
                
                hospedagens.add(hospedagem);
            }

            rs.close();
            stmt.close();
            this.connection.close();
            
            return hospedagens;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Hospedagem criar(Hospedagem hospedagem){
        try {           
            String sql = "INSERT INTO hospedagem (checkIn, checkOut, dataHorarioInicio, dataHorarioFim, preco, status, id_cliente, id_quarto) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, hospedagem.getCheckin());
            stmt.setString(2, hospedagem.getCheckout());
            stmt.setString(3, hospedagem.getDataHoraInicio());
            stmt.setString(4, hospedagem.getDataHoraFim());
            stmt.setFloat(5, hospedagem.getPreco());
            stmt.setString(6, "1");
            stmt.setLong(7, hospedagem.getCliente().getId());
            stmt.setLong(8, hospedagem.getQuarto().getId());

            int rs = stmt.executeUpdate();
            if(rs == 0){
                return null;
            }

            stmt.close();
            this.connection.close();

            return hospedagem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
