/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.dao;

import ifsp.pwe.beans.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class ProdutoDao extends ConnectionFactory {
    public Produto obter(Long id){
        
        try {
            String sql = "SELECT * FROM produto WHERE id = ?";
            PreparedStatement stmt = stmt = this.connection.prepareStatement(sql);;
            stmt.setString(1, sql);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }
            
            Produto produto = new Produto();
            
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setStatus(rs.getString("status"));
            rs.close();
            stmt.close();
            this.connection.close();
            
            return produto;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
       
    }
    public Produto criar(Produto produto){
        try {
            String sql = "INSERT INTO hotel (nome,preco,descricao,status) values(?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.setString(4, produto.getStatus());
            
            boolean rs = stmt.execute(sql);
            
            if(!rs){
                return null;
            }
            stmt.close();
            this.connection.close();
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
