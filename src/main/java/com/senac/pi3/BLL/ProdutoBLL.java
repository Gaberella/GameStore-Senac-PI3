
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.ProdutoDAO;
import com.senac.pi3.Modelos.Produto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProdutoBLL 
{
    public static void inserir(Produto p) throws Exception
    {
        if(p.getNomeProduto().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
      
        if(p.getPreco() == null || p.getPreco().compareTo(BigDecimal.ZERO) < 0)
        {
            throw new Exception("O preço deve ser preenchido e o valor deve ser maior que zero!");
        }
        if(p.getFabricante().trim().length() == 0)
        {
            throw new Exception("O fabricante deve ser preenchido!");
        }
        if(p.getEstoque() < 0)
        {
            throw new Exception("A quantidade deve ser preenchida e maior que zero!");        
        }
        if(p.getModelo().trim().length() == 0)
        {
            throw new Exception("O modelo deve ser preenchido!");
        }
        
        ProdutoDAO.inserir(p);
    }
    
    
    
    
    public static void alterar(Produto p) throws Exception
    {
        if(p.getNomeProduto().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
        
        if(p.getPreco() == null || p.getPreco().compareTo(BigDecimal.ZERO) < 0)
        {
            throw new Exception("O preço deve ser preenchido e o valor deve ser maior que zero!");
        }
        
        if(p.getFabricante().trim().length() == 0) 
        {
        	throw new Exception("O fabricante deve ser preenchido!");
        }
        
        if( p.getEstoque()< 0)
        {
            throw new Exception("A quantidade deve ser preenchida e maior que zero!");
        }
        
        if(p.getModelo().trim().length() == 0) 
        {
        	throw new Exception("O modelo deve ser preenchido!");
        }

        ProdutoDAO.alterar(p);        
    }
    
    
    public static void excluir(int id)throws SQLException, ClassNotFoundException
    {
        ProdutoDAO.excluir(id);
    }
    
    
    public static List<Produto> listar(String filtro)throws SQLException,ClassNotFoundException
    {
        return ProdutoDAO.listar(filtro);
    }
    
    
    public static Produto obterProduto(int id) throws SQLException
    {
        return ProdutoDAO.obterProduto(id);
    }
    
}
