package ifsp.pwe.dao;

import ifsp.pwe.beans.Proprietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProprietarioDao extends ConnectionFactory{
    public Proprietario obter(String email, String senha){
        try{
            String sql = "SELECT * FROM proprietario WHERE email = ? AND senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            Proprietario proprietario = new Proprietario();
            proprietario.setId(rs.getInt("id"));
            proprietario.setCpf(rs.getInt("cpf"));
            proprietario.setSenha(rs.getString("senha"));
            proprietario.setTelefone(rs.getString("telefone"));
            proprietario.setEndereco(rs.getString("endereco"));
            proprietario.setNome(rs.getString("nome"));
            proprietario.setEmail(rs.getString("email"));
            proprietario.setSalario(rs.getFloat("salario"));
            rs.close();
            stmt.close();
            this.connection.close();
            
            return proprietario;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }        
    }
}