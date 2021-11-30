package com.senac.pi3.DAOs;

import com.senac.pi3.Modelos.Cliente;
import com.senac.pi3.Modelos.Filial;
import com.senac.pi3.Modelos.Funcionario;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FuncionarioDAO 
{
    public static void inserir (Funcionario f)
    {
        
    }
    public static void alterar(Funcionario f)
    {
        
    }
    public static void excluir (int id)
    {
        
    }
    public static List<Cliente> listar(boolean apenasFuncionario) throws SQLException, ClassNotFoundException{
        String filtro;
        //Comando SELECT para retornar todos os dados de todos os clientes
        if(apenasFuncionario)
            filtro = "tipoAcesso = 4";
        else
            filtro = "4=4";
        
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
    
    //Método obterFuncionario
    //Responsável por retornar os dados de um funcionario específico
    public static Cliente obterFuncionario(int id) throws SQLException{
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
}

