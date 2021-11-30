/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.DAOs;

import com.senac.pi3.Modelos.Cliente;
import com.senac.pi3.Modelos.Funcionario;
import com.senac.pi3.Modelos.Produto;
import com.senac.pi3.Modelos.Usuario;
import com.senac.pi3.Modelos.Venda;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author macba
 */
public class VendaDAO {
    public static void inserir(Venda v) throws SQLException, Exception{
      String sql = "INSERT INTO pedido (idcliente, idfuncionario, idFilial, data, precoVenda) " +
                     " VALUES (?, ?, ?, ?, ?);";
        
//     String sql2 = "INSERT INTO detalhes_pedido(idPedido,idProduto, idServico,quantidade) VALUES(?,?,?,?) ";
     
        Connection conn = null;
        PreparedStatement pst = null;
        conn = ConnectionUtils.getConnection();
        pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        
        try{
            
        pst.setInt(1, v.getCliente().getId());
        pst.setInt(2, v.getFuncionario().getId());
        pst.setInt(3, 1);
        Timestamp t = new Timestamp(System.currentTimeMillis());
        pst.setTimestamp(4, t);
        

        pst.setFloat(5, v.getValorTotal());
        pst.execute();
        
        ResultSet rs = pst.getGeneratedKeys();
        int idPedido = 0;
	if(rs.next()){
            idPedido = rs.getInt(1);
	}	
        
        pst = null;

        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
        
    }
    
    public static List<Venda> obterVenda(boolean apenasGerente) throws SQLException, ClassNotFoundException{
        
        String filtro;
        //Comando SELECT para retornar todos os dados de todos os clientes
        if(apenasGerente)
            filtro = "tipoAcesso = 1";
        else
            filtro = "1=1";
        
        String sql = "SELECT * FROM pedido " + filtro;
        
        try {
            
            Connection conn = null;
            PreparedStatement pst = null;

            List<Venda> listaVenda = new LinkedList<Venda>(); //Lista de cliente que será retornada ao final do método

            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(); //Executando o comando SELECT e armazenando os dados em um ResultSet

            while(rs.next()){ //Enquanto houver registro no ResultSet, criar um cliente e adiciona-lo na lista

                Venda v = new Venda();
                Usuario c = new Cliente();
                c = ClienteDAO.obterCliente(rs.getInt("idcliente"));
                v.setCliente((Cliente) c);
                Usuario f = new Funcionario();
                f = FuncionarioDAO.obterFuncionario(rs.getInt("idfuncionario"));
                v.setFuncionario(f);
                v.setData(rs.getDate("data"));
                v.setProdutos((List<Produto>) rs.getArray("produtos"));
                v.setValorTotal(rs.getFloat("precoVenda"));

                listaVenda.add(v);
            }
            return listaVenda;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Venda obterVenda(int id) throws SQLException{
        return null;
    }
}
