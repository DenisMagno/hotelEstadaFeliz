package ifsp.pwe.dao;

import ifsp.pwe.beans.Pessoa;
import ifsp.pwe.beans.Proprietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProprietarioDao extends ConnectionFactory{
    public Proprietario obter(String email, String senha){
        try{
            Pessoa pessoa = new PessoaDao().obter(email);
            
            if(pessoa == null){
                return null;
            }

            String sql = "SELECT * FROM proprietario WHERE id_pessoa = ? AND senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, pessoa.getId());
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            Proprietario proprietario = new Proprietario();
            proprietario.setId(rs.getLong("id_pessoa"));
            proprietario.setCpf(pessoa.getCpf());
            proprietario.setTelefone(pessoa.getTelefone());
            proprietario.setEndereco(pessoa.getEndereco());
            proprietario.setNome(pessoa.getNome());
            proprietario.setEmail(pessoa.getEmail());
            proprietario.setSenha(rs.getString("senha"));
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