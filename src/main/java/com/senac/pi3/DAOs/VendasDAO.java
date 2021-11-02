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

/**
 *
 * @author macba
 */
public class VendasDAO {
    
    public static void realizarVenda(Venda venda) throws SQLException, Exception {
        String insertTableSQL = "INSERT INTO vendas" + "(data, nomeComprador, cartaoComprador, "
                + "codSegurancaComprador, valor, idProduto, idFilial) VALUES" + "(?,?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement pst = null;  
        
        try {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(insertTableSQL);
            Timestamp t = new Timestamp(venda.getData().getTime());
            pst.setTimestamp(1, t);
            pst.setString(2, venda.getNomeComprador());
            pst.setString(3, venda.getCartaoComprador());
            pst.setString(4, venda.getCodSegurancaComprador());
            pst.setBigDecimal(5, venda.getValor());
            pst.setDouble(6, venda.getIdProduto());
            pst.setInt(7, venda.getIdFilial());
            pst.executeUpdate();
            
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
    
}
