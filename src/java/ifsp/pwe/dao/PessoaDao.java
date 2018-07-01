package ifsp.pwe.dao;

import ifsp.pwe.beans.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDao extends ConnectionFactory {
    public Pessoa obter(String email){
        try {
            String sql = "SELECT * FROM pessoa WHERE email = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }
            
            Pessoa pessoa = new Pessoa() {};
            pessoa.setId(rs.getLong("id"));
            pessoa.setCpf(rs.getInt("cpf"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setEndereco(rs.getString("endereco"));
            
            rs.close();
            stmt.close();
            this.connection.close();
            
            return pessoa;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }   
    }
}
