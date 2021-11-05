/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.VendasDAO;
import com.senac.pi3.Modelos.Venda;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macba
 */
public class VendaBLL {
    
    public static void inserir ( Venda v) throws Exception
    {
        if(v.getNome().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
        if(v.getDataVenda().toString().trim().length() == 0)
        {
            throw new Exception("A data deve ser preenchida!");
        }
        if(v.getTipoPagamento().trim().length() == 0)
        {
            throw new Exception("O cartâo deve ser preenchido!");
        }
        if(v.getEmail().trim().length() == 0)
        {
            throw new Exception(" O código de segurança deve ser preenchido!");
        }
        if(v.getEndereco().trim().length() == 0)
        {
            throw new Exception(" O código de segurança deve ser preenchido!");
        }
           
           VendasDAO.realizarVenda(v);
    }
    
     public static List<Venda> listar() throws SQLException, ClassNotFoundException
   {
       return VendasDAO.listar(false);
   }
    
}
