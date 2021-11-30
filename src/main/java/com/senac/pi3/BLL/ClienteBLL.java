
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.ClienteDAO;
import com.senac.pi3.Modelos.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteBLL 
{
    //Classe ClienteBLL. É a classe onde serão feitas todas as validações necessárias
    //antes de chamar a classe que é responsável por realizar alterações no banco de dados
    
    //Método inserir, responsável por validar os dados de um novo cliente antes dos dados serem enviados para o banco de dados
    public static void inserir(Cliente c) throws Exception{
        
        if(c.getNome().trim().length() == 0){
            throw new Exception("O nome deve ser preenchido!");
        }
        if(c.getDtNascimento().toString().trim().length() == 0){
            throw new Exception("A data de nascimento deve ser preenchida!");
        }
        if(c.getCpf().trim().length() == 0){
            throw new Exception("O CPF deve ser preenchido!");
        }
        if(c.getRg().trim().length() == 0){
            throw new Exception("O RG deve ser preenchido!");
        }
        if(c.getTelefone().trim().length() == 0){
            throw new Exception("O telefone deve ser preenchido!");
        }
        if(c.getEmail().trim().length() == 0){
            throw new Exception("O email deve ser preenchido!");
        }
        if(c.getSexo() != 'M' && c.getSexo() != 'F'){
            throw new Exception("O sexo deve ser selecionado!");
        }
        
        //Caso todos os dados estejam corretos, o cliente é enviado para o método inserir da classe ClienteDAO.
        //Essa classe é responsável por realizar operações no banco de dados.
        ClienteDAO.inserir(c);
    }
    
    //Método alterar.
    //Valida todos os dados antes de serem enviados para alteração no banco de dados.
    public static void alterar(Cliente c) throws Exception{
        if(c.getNome().trim().length() == 0){
            throw new Exception("O nome deve ser preenchido!");
        }
        if(c.getDtNascimento().toString().trim().length() == 0){
            throw new Exception("A data de nascimento deve ser preenchida!");
        }
        if(c.getCpf().trim().length() == 0){
            throw new Exception("O CPF deve ser preenchido!");
        }
        if(c.getRg().trim().length() == 0){
            throw new Exception("O RG deve ser preenchido!");
        }
        if(c.getTelefone().trim().length() == 0){
            throw new Exception("O telefone deve ser preenchido!");
        }
        if(c.getEmail().trim().length() == 0){
            throw new Exception("O email deve ser preenchido!");
        }
        if(c.getSexo() != 'M' && c.getSexo() != 'F'){
            throw new Exception("O sexo deve ser selecionado!");
        }
        
        //Caso todos os dados estejam corretos, o cliente é enviado para o método alterar() da classe ClienteDAO.
        //Nesse momento, a alteração é realizada no banco de dados.
        ClienteDAO.alterar(c); 
    }
    
    //Método excluir.
    //Responsável por realizar a exclusão de algum cadastro no banco de dados
    public static void excluir(int id) throws SQLException, ClassNotFoundException{
        ClienteDAO.excluir(id);
    }
    
    //Método listar, responsável por listar todos os clientes cadastrados
    public static List<Cliente> listar() throws SQLException, ClassNotFoundException{
        return ClienteDAO.listar(false);
    }
    
    //Método obterCliente().
    //Responsável por obter um determinado cliente através de seu ID no banco de dados
    public static Cliente obterCliente(int id) throws SQLException{
        return ClienteDAO.obterCliente(id);
    }
}
