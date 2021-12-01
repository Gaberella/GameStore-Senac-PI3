/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.DAOs;

import com.senac.pi3.Modelos.Cliente;
import com.senac.pi3.Modelos.Funcionario;
import com.senac.pi3.Modelos.Relatorio;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabri
 */
public class RelatorioDAO 
{
   public static List<Relatorio> listar(int filtro, int tipoAcesso, int idFilial) throws SQLException, ClassNotFoundException
   {
       String filtroFilial = "";
       if(tipoAcesso == 2 || tipoAcesso == 3 || tipoAcesso == 5 || tipoAcesso == 7)
       {
           filtroFilial = "AND idFilial = " + idFilial;
       }
       String sql = "SELECT *FROM pedido WHERE data >= (curdate() - INTERVAL " + filtro  + " day)" + filtroFilial;
       
       
       Connection conn = null;
       PreparedStatement pst = null;
       
       List<Relatorio> listaRelatorio = new LinkedList<Relatorio>();
       
       try
       {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Relatorio r = new Relatorio();
                
                r.setIdPedido(rs.getInt("idPedido"));
                int idCliente = rs.getInt("id_cliente");
                int idFuncionario = rs.getInt("idFuncionario");
                
                Cliente c = ClienteDAO.obterCliente(idCliente);
                Funcionario f = ClienteDAO.obterFuncionario(idFuncionario);
                
                r.setCliente(c);
                r.setFuncionario(f);
                r.setIdFilial(rs.getInt("idFilial"));
                r.setData(rs.getDate("data"));
                r.setPrecoVenda(rs.getDouble("precoVenda"));
                
                listaRelatorio.add(r);
                
            }
            
            return listaRelatorio;
            
       }catch(Exception e)
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
           
       
   }
    
}
