
package com.senac.pi3.DAOs;

import com.senac.pi3.Modelos.Venda;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


public class VendaDAO 
{
    public static void inserir(Venda v) throws SQLException, Exception
    {
        String sql = "INSERT INTO pedido(idCliente, idFuncionario,idFilial,data,precoVenda) " + "VALUES(?,?,?,?,?);";
        
        String sql2 = "INSERT INTO detalhesPedido(idPedido,idProduto,quantidade) " + "VALUES(?,?,?,?);";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        conn = ConnectionUtils.getConnection();
        pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, v.getCliente().getId());
        pst.setInt(2, 3);
        pst.setInt(3, 1);
        
        Timestamp t = new Timestamp(System.currentTimeMillis());
        pst.setTimestamp(4, t);
        
        pst.setFloat(5, v.getValorTotal());
        pst.execute();
        
        ResultSet rs = pst.getGeneratedKeys();
        int idPedido = 0;
        
        if(rs.next())
        {
            idPedido = rs.getInt(1);
        }
        
        pst = null;
        
        
        if(pst != null && !pst.isClosed())
       {
            pst.close();
       }


       if(conn != null && !conn.isClosed())
       {
           conn.close();
       }
    }
    public static void listar(String filtro)
    {
        
    }
    
    public static Venda obterVenda(int id) throws SQLException
    {
        return null;
    }
}
