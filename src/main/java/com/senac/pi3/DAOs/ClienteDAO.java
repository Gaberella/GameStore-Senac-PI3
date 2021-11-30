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
import com.senac.pi3.Modelos.Filial;
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
        //Comando de inserção no banco de dados, com alguns parâmetros a serem preparados
        String sql = "INSERT INTO usuario (cpf, nome, nascimento, telefone, email, sexo, rg, endereco, senha, tipoacesso, idfilial) " +
                     " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Realiza a conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir os parâmetros do INSERT
            
            //Preparando todos os parâmetros do método INSERT na ordem em que foram definidos na query
            pst.setString(1, c.getCpf());
            pst.setString(2, c.getNome());
            
            Timestamp t = new Timestamp(c.getDtNascimento().getTime());
            pst.setTimestamp(3, t);
            
            pst.setString(4, c.getTelefone());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getSexo() + "");
            pst.setString(7, c.getRg());
            pst.setString(8, c.getEndereco());
            pst.setString(9, c.getSenha());
            pst.setInt(10, c.getTipoAcesso());
            pst.setInt(11, c.getFilial().getId());
            
            pst.execute(); //Executando a query e realizando a inserção no banco de dados.
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método alterar
    //Responsável por realizar a alteração dos dados de um determinado cliente
    public static void alterar(Cliente c) throws SQLException, ClassNotFoundException{
        //Comando de UPDATE no banco de dados com alguns parâmetros que irão receber os novos valores.
        /*String sql = "UPDATE Usuario SET Nome = ?, nascimento = ?, CPF = ?, RG = ?, Telefone = ?, Email = ?, Sexo = ? "
                + "WHERE id = ?";*/
        
        String sql = "UPDATE usuario SET cpf = ?, nome = ?, nascimento = ?, telefone = ?, email = ?, sexo = ?, rg = ?, endereco = ?, senha = ?, tipoacesso = ?, idFilial = ? WHERE idUsuario = ?"; 

        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Abrindo conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir os parâmetros do UPDATE
            
            //Preparando todos os parâmetros do comando UPDATE definido anteriormente
            //Preparando todos os parâmetros do método INSERT na ordem em que foram definidos na query
            pst.setString(1, c.getCpf());
            pst.setString(2, c.getNome());
            
            Timestamp t = new Timestamp(c.getDtNascimento().getTime());
            pst.setTimestamp(3, t);
            
            pst.setString(4, c.getTelefone());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getSexo() + "");
            pst.setString(7, c.getRg());
            pst.setString(8, c.getEndereco());
            pst.setString(9, c.getSenha());
            pst.setInt(10, c.getTipoAcesso());
            pst.setInt(11, c.getFilial().getId());
            pst.setInt(12, c.getId());
            
            pst.execute(); //Executando a instrução SQL e realizando a alteração dos dados
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método excluir
    //Responsável por realizar a exclusão de um deterinado cliente
    public static void excluir(int id) throws SQLException, ClassNotFoundException{
        //Comando DELETE do banco de dados para realizar a exclusão de um determinado cliente utilizando o ID do mesmo
        String sql = "DELETE FROM usuario WHERE idUsuario = ?"; 
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Abrindo conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir o parâmetro do DELETE
            
            //Preparando todos os parâmetros do comando DELETE definido anteriormente
            pst.setInt(1, id);
            
            pst.execute(); //Executando a instrução SQL e realizando a alteração dos dados
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método listar
    //Responsável por resgatar todos os clientes cadastrados e retornar uma lista com os mesmos
    public static List<Cliente> listar(boolean apenasCliente) throws SQLException, ClassNotFoundException{
        String filtro;
        //Comando SELECT para retornar todos os dados de todos os clientes
        if(apenasCliente)
            filtro = "tipoAcesso = 1";
        else
            filtro = "1=1";
        
        String sql = "SELECT * FROM usuario WHERE " + filtro;
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Cliente> listaCliente = new LinkedList<Cliente>(); //Lista de cliente que será retornada ao final do método
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery(); //Executando o comando SELECT e armazenando os dados em um ResultSet
            
            while(rs.next()){ //Enquanto houver registro no ResultSet, criar um cliente e adiciona-lo na lista
                Cliente c = new Cliente(); //Cria um novo cliente
                
                //Armazenando os dados do cliente contidos no ResultSet.
                //Para isso, estamos utilizando os métodos set..() da classe Cliente e os métodos get... do ResultSet passando o nome do campo no banco de dados
                c.setId(rs.getInt("idUsuario"));
                c.setNome(rs.getString("Nome"));
                c.setDtNascimento(rs.getDate("nascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                c.setTipoAcesso(rs.getInt("tipoacesso"));
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                c.setFilial(f);
                
                listaCliente.add(c); //Com todos os dados do cliente armazenado, adiciona o cliente na lista.
            }
            
            return listaCliente; //Depois que todos os clientes estiverem na lista, retorna a lista
        }
        catch(Exception ex){
            return null;
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    
    //Método obterCliente
    //Responsável por retornar os dados de um cliente específico
    public static Cliente obterCliente(int id) throws SQLException{
        //Comando SELECT responsável por selecionar os dados de um determinado cliente filtrado pelo seu ID
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //Caso exista algum registro no ResultSet
                Cliente c = new Cliente(); //Cria um novo cliente
                
                //Armazena seus dados, da mesma forma que foi feito no método listar()
                c.setId(rs.getInt("idUsuario"));
                c.setNome(rs.getString("Nome"));
                c.setDtNascimento(rs.getDate("nascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                c.setTipoAcesso(rs.getInt("tipoacesso"));
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                
                c.setFilial(f);
                
                return c; //Retorna esse cliente depois de armazenar seus dados
            }
        }
        catch(Exception ex){
            return null;
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
        return null;
    }
    
    //Método buscarPorEmail
    //Responsável por retornar os dados de um cliente específico pelo email
    public static Cliente buscarPorEmail(String email) throws SQLException{
        //Comando SELECT responsável por selecionar os dados de um determinado cliente filtrado pelo seu ID
        String sql = "SELECT * FROM usuario WHERE email = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, email);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //Caso exista algum registro no ResultSet
                Cliente c = new Cliente(); //Cria um novo cliente
                
                //Armazena seus dados, da mesma forma que foi feito no método listar()
                c.setId(rs.getInt("idUsuario"));
                c.setNome(rs.getString("Nome"));
                c.setDtNascimento(rs.getDate("nascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                c.setEndereco(rs.getString("endereco"));
                c.setSenha(rs.getString("senha"));
                c.setTipoAcesso(rs.getInt("tipoacesso"));
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                c.setFilial(f);
                
                return c; //Retorna esse cliente depois de armazenar seus dados
            }
        }
        catch(Exception ex){
            return null;
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
        return null;
    }
    
    public static Funcionario obterFuncionario(int id) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE idUsuario = ? AND tipoAcesso = 2";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Funcionario f = new Funcionario();
                
                f.setId(rs.getInt("idUsuario"));
                f.setNome(rs.getString("Nome"));
                f.setDtNascimento(rs.getDate("nascimento"));
                f.setCpf(rs.getString("CPF"));
                f.setRg(rs.getString("RG"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setSexo(rs.getString("sexo").charAt(0));
                f.setEndereco(rs.getString("endereco"));
                f.setSenha(rs.getString("senha"));
                f.setTipoAcesso(rs.getInt("tipoacesso"));
                
                Filial fi = new Filial();
                fi = FilialDAO.obterFilial(rs.getInt("idFilial"));
                
                f.setFilial(fi);
                
                return f;
            }
        }
        catch(Exception ex){
            return null;
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
        return null;
    }
}
