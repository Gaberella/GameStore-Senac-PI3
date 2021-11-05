/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.DAOs;

import com.senac.pi3.Utils.ConnectionUtils;
import com.senac.pi3.Modelos.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author macba
 */
public class VendasDAO {
    
    public static void realizarVenda(Venda venda) throws SQLException, Exception {
        String insertTableSQL = "INSERT INTO venda(dataVenda, nome, tipoPagamento, email ,valorVenda, endereco ) VALUES" + "(?,?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement pst = null;  
        
        try {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(insertTableSQL);
            Timestamp t = new Timestamp(venda.getDataVenda().getTime());
            pst.setTimestamp(1, t);
            pst.setString(2, venda.getNome());
            pst.setString(3, venda.getTipoPagamento());
            pst.setString(4, venda.getEmail());
            pst.setBigDecimal(5, venda.getValorVenda());
            //pst.setDouble(6, venda.getIdProduto());
            //pst.setInt(7, venda.getIdFilial());
            pst.setString(6, venda.getEndereco());
            pst.execute();
            
        } catch (SQLException e) {
            
        } finally
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
    
    public static List<Venda> listar (boolean vendas) throws SQLException, ClassNotFoundException
    {
       
        String sql = "SELECT * FROM venda";
            
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Venda> listaVendas = new LinkedList<>();
        
        
        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            
            return listaVendas;
        }catch(ClassNotFoundException | SQLException e)
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
    
}
