package ifsp.pwe.dao;

import ifsp.pwe.beans.Pessoa;
import ifsp.pwe.beans.Recepcionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecepcionistaDao extends ConnectionFactory{
    public Recepcionista obter(String email, String senha){
        try{
            Pessoa pessoa = new PessoaDao().obter(email);
            
            if(pessoa == null){
                return null;
            }

            String sql = "SELECT * FROM recepcionista WHERE id_pessoa = ? AND senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, pessoa.getId());
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setId(rs.getLong("id_pessoa"));
            recepcionista.setCpf(pessoa.getCpf());
            recepcionista.setTelefone(pessoa.getTelefone());
            recepcionista.setEndereco(pessoa.getEndereco());
            recepcionista.setNome(pessoa.getNome());
            recepcionista.setEmail(pessoa.getEmail());
            recepcionista.setSenha(rs.getString("senha"));
            recepcionista.setSalario(rs.getFloat("salario"));
            
            rs.close();
            stmt.close();
            this.connection.close();

            return recepcionista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}