package ifsp.pwe.dao;

import ifsp.pwe.beans.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PessoaDao extends ConnectionFactory {
    public Pessoa criar(Pessoa pessoa){
        try {
            String sql = "INSERT INTO pessoa (cpf, telefone, endereco, nome, email) values(?,?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getTelefone());
            stmt.setString(3, pessoa.getEndereco());
            stmt.setString(4, pessoa.getNome());
            stmt.setString(5, pessoa.getEmail());
            
            int rs = stmt.executeUpdate();
            if(rs == 0){
                return null;
            }
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
		pessoa.setId(result.getLong(1));
            }
            
            stmt.close();
            result.close();
            this.connection.close();
            return pessoa;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
    
    public Pessoa obter(Long id){
        try {
            String sql = "SELECT * FROM pessoa WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);

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