package ifsp.pwe.dao;

import ifsp.pwe.beans.Cliente;
import ifsp.pwe.beans.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Cliente> obter(){
        try{
            String sql = "SELECT * FROM cliente";
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            List<Cliente> clientes = new ArrayList<Cliente>();
            while(rs.next()){
                Pessoa pessoa = new PessoaDao().obter(rs.getLong("id_pessoa"));
                Cliente cliente = new Cliente();
                cliente.setId(pessoa.getId());
                cliente.setCpf(pessoa.getCpf());
                cliente.setNome(pessoa.getNome());
                cliente.setTelefone(pessoa.getTelefone());
                cliente.setEmail(pessoa.getEmail());
                cliente.setEndereco(pessoa.getEndereco());
                cliente.setDataCriacao(rs.getString("dataCriacao"));
                clientes.add(cliente);
            }

            rs.close();
            stmt.close();
            this.connection.close();

            return clientes;
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

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");         
            Date date = new Date();
            String data = dateFormat.format(date);
            cliente.setId(pessoa.getId());
            cliente.setDataCriacao(data);
            
            String sql = "INSERT INTO cliente (id_pessoa, dataCriacao) values(?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, cliente.getId());
            stmt.setString(2, cliente.getDataCriacao());

            int rs = stmt.executeUpdate();
            if(rs == 0){
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