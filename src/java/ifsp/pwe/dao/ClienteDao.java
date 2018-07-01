package ifsp.pwe.dao;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.beans.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao extends ConnectionFactory{
    public Cliente obter(Long id){
        try{
            Pessoa pessoa = new PessoaDao().obter(id);
            
            if(pessoa == null){
                return null;
            }

            String sql = "SELECT * FROM cliente WHERE id_pessoa = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, pessoa.getId());

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id_pessoa"));
            cliente.setCpf(pessoa.getCpf());
            cliente.setTelefone(pessoa.getTelefone());
            cliente.setEndereco(pessoa.getEndereco());
            cliente.setNome(pessoa.getNome());
            cliente.setEmail(pessoa.getEmail());
            cliente.setDataCriacao(rs.getString("dataCriacao"));
            
            rs.close();
            stmt.close();
            this.connection.close();

            return cliente;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Cliente criar(Cliente cliente){
        try {
            Pessoa pessoa = new PessoaDao().criar(cliente);
            
            if(pessoa == null){
                return null;
            }
            
            cliente.setId(pessoa.getId());
            
            String sql = "INSERT INTO cliente (dataCriacao) values(?) WHERE id_pessoa = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getDataCriacao());
            stmt.setLong(2, cliente.getId());

            boolean rs = stmt.execute(sql);

            if(!rs){
                return null;
            }

            stmt.close();
            this.connection.close();

            return cliente;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}