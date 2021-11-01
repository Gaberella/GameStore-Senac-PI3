/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.DAOs;

/**
 *
 * @author Gabri
 */
import com.senac.pi3.Modelos.Cliente;
import com.senac.pi3.Modelos.Funcionario;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
//import java.util.List;

public class ClienteDAO 
{
    public static void inserir(Cliente c) throws SQLException, Exception
    {
        String sql = "INSERT INTO cliente(nome, cpf, dataNascimento, telefone, email, sexo, rg, endereco, senha)" + " VALUES(?,?,?,?,?,?,?,?,?);";
        
        Connection conn = null;
        // conexão com o banco de dados
        
        PreparedStatement pst = null;  
        //Preparação de comandos SQL
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCpf());
            
            Timestamp t = new Timestamp(c.getDataNascimento().getTime());
            pst.setTimestamp(3, t);
            
            pst.setString(4, c.getTelefone());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getSexo() + "");
            pst.setString(7, c.getRg());
            pst.setString(8, c.getEndereco());
            pst.setString(9, c.getSenha());
            
            pst.execute();
            
        } 
        finally
        {
            if(pst != null && pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
        
    }
    
    
    public static void alterar(Cliente c) throws SQLException, ClassNotFoundException
    {
        String sql = "UPDATE cliente SET cpf = ?, nome = ?, dataNascimento = ?, sexo = ?, rg = ?, email = ? , endereco = ? , senha = ? WHERE id_cliente = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, c.getCpf());
            pst.setString(2, c.getNome());

            Timestamp t = new Timestamp(c.getDataNascimento().getTime());
            pst.setTimestamp(3, t);
            
            pst.setString(4, c.getSexo() + "");
            pst.setString(5, c.getRg());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getEndereco());
            pst.setString(8, c.getSenha());
            pst.setInt(9, c.getId());
            
            pst.execute();

        }
        finally 
        {
            if(pst != null && pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
    }
    
    
    public static void excluir (int id) throws SQLException, ClassNotFoundException
    {
        String sql = "DELETE FROM cliente Where id_cliente = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            pst.execute();
            
            
        }
        finally 
        {
            if(pst != null && pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
    }
    
    public static List<Cliente> listar (boolean apenasCliente) throws SQLException, ClassNotFoundException
    {
        String filtro;
        
        if(apenasCliente)
        {
            filtro = "tipoAcesso = 1";
        }
        else
        {
            filtro = "1 = 1";
            
        }
        String sql = "SELECT * FROM cliente WHERE " + filtro;
            
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Cliente> listaCliente = new LinkedList<Cliente>();
        
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            
            while (rs.next()) 
            {                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getDate("dataNascimento"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                
                listaCliente.add(c);
            }
            return listaCliente;
        }catch(Exception e)
        {
            return null;
        }
        finally 
        {
            if(pst != null && pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
    }
    
    
    
    
    public static Cliente obterCliente(int id) throws SQLException
    {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                Cliente c = new Cliente();
                
                
                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("Nome"));
                c.setDataNascimento(rs.getDate("dataNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                
                return c;
            }
            
           
        } catch (Exception e) 
        {
            return null;
        }
        finally
        {
            if(pst != null && !pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
        
        return null;
    }
    
    public static Cliente buscaPorEmail(String email) throws SQLException
    {
        String sql = "SELECT * FROM Cliente WHERE email = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, email);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                Cliente c = new Cliente();
                
                
                c.setId(rs.getInt("idUsuario"));
                c.setNome(rs.getString("Nome"));
                c.setDataNascimento(rs.getDate("Data nascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                
                return c;
            }
            
        } catch (Exception e) 
        {
            return null;
        }finally
        {
             if(pst != null && !pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
        return null;
    }
    
    public static Funcionario obterFuncionario(int id) throws SQLException
    {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?  ";  //(tipoAcesso = 2)
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                Funcionario f = new Funcionario();
                
                f.setId(rs.getInt("idUsuario"));
                f.setNome(rs.getString("Nome"));
                f.setDataNascimento(rs.getDate("Data nascimento"));
                f.setCpf(rs.getString("CPF"));
                f.setRg(rs.getString("RG"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setSexo(rs.getString("sexo").charAt(0));
                f.setEndereco(rs.getString("endereco"));
                f.setSenha(rs.getString("senha"));
                
                
                return f;
            }
        } 
        catch (Exception e) 
        {
            return null;
        }
        finally
        {
            if(pst != null && !pst.isClosed())
            {
                pst.close();
            }
            if(conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
        return null;
    }
}
