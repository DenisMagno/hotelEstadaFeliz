/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.dao;

import ifsp.pwe.beans.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class PessoaDao extends ConnectionFactory {
    public Pessoa obter(String email, String senha){
        
        try {
            String sql = "SELECT * FROM pessoa WHERE email = ? AND senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sql);
            stmt.setString(2, sql);

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
