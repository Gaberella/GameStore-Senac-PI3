package com.senac.pi3.DAOs;

import com.senac.pi3.Modelos.Filial;
import com.senac.pi3.Modelos.Produto;
import com.senac.pi3.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {

    public static void inserir(Produto p) throws SQLException, Exception 
    {
        String sql = "INSERT INTO produto(nomeProduto,categoria,preco,fabricante,estoque,modelo,codBarras,idFilial)" + "VALUES(?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pst = null;

        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, p.getNomeProduto());
            pst.setInt(2, p.getCategoria());
            pst.setBigDecimal(3, p.getPreco());
            pst.setString(4, p.getFabricante());
            pst.setInt(5, p.getEstoque());
            pst.setString(6, p.getModelo());
            pst.setString(7, p.getCodBarras());
            pst.setLong(8, p.getFilial().getId());
            
            pst.execute();

        } finally {
            if (pst != null && pst.isClosed()) 
            {
                pst.close();
            }
            if (conn != null && !conn.isClosed()) 
            {
                conn.close();
            }
        }
    }

    public static void alterar(Produto p) throws SQLException, ClassNotFoundException 
    {
        String sql = "UPDATE produto SET nomeProduto = ?, categoria =? ,preco = ?, fabricante = ? , estoque = ?, modelo = ?, codBarras = ?, idFilial= ? WHERE idProduto = ?;";

        Connection conn = null;
        PreparedStatement pst = null;

        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, p.getNomeProduto());
            pst.setInt(2, p.getCategoria());
            pst.setBigDecimal(3, p.getPreco());
            pst.setString(4, p.getFabricante());
            pst.setInt(5, p.getEstoque());
            pst.setString(6, p.getModelo());
            pst.setString(7, p.getCodBarras());
            pst.setInt(8, p.getIdProduto());
            pst.setLong(9, p.getFilial().getId());
            
            pst.execute();
        } finally 
        {
            if (pst != null && pst.isClosed()) 
            {
                pst.close();
            }
            if (conn != null && !conn.isClosed()) 
            {
                conn.close();
            }
        }
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException 
    {
        String sql = "DELETE FROM produto WHERE idProduto = ?;";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();
        } finally {
            if (pst != null && pst.isClosed()) 
            {
                pst.close();
            }
            if (conn != null && !conn.isClosed()) 
            {
                conn.close();
            }

        }
    }

    public static List<Produto> listar(String filtro) throws SQLException, ClassNotFoundException 
    {
        String sql = "SELECT * FROM produto";
        if (filtro.length() > 0) {
            sql = sql + "WHERE " + filtro;
        }
        Connection conn = null;
        PreparedStatement pst = null;

        List<Produto> listaProduto = new LinkedList<Produto>();

        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
                Produto p = new Produto();

                p.setIdProduto(rs.getInt("idProduto"));
                p.setNomeProduto(rs.getString("nomeProduto"));
                p.setCategoria(rs.getInt("categoria"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setFabricante(rs.getString("fabricante"));
                p.setEstoque(rs.getInt("estoque"));
                p.setModelo(rs.getString("modelo"));
                p.setCodBarras(rs.getString("codBarras"));
                
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                p.setFilial(f);
                
                
                listaProduto.add(p);
            }
            return listaProduto;
        } catch (Exception e) 
        {
            return null;
        } finally {
            if (pst != null && pst.isClosed()) 
            {
                pst.close();
            }
            if (conn != null && !conn.isClosed()) 
            {
                conn.close();
            }

        } 
    }    
  
    public static Produto obterProduto(int id)throws SQLException
    {
        String sql = "SELECT * FROM produto WHERE idProduto= ?  ";

        Connection conn = null;
        PreparedStatement pst = null;

        try 
        {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) 
            {
                Produto p = new Produto();

                p.setIdProduto(rs.getInt("idProduto"));
                p.setCodBarras(rs.getString("codBarras"));
                p.setFabricante(rs.getString("fabricante"));
                p.setModelo(rs.getString("modelo"));
                p.setNomeProduto(rs.getString("nomeProduto"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setEstoque(rs.getInt("estoque"));
                p.setCategoria(rs.getInt("categoria"));

                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                p.setFilial(f);

                return p;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        } 
        finally 
        {
            if (pst != null && !pst.isClosed()) 
            {
                pst.close();
            }

            if (conn != null && !conn.isClosed()) 
            {
                conn.close();
            }
        }

        return null;
    }

}
