/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.VendasDAO;
import com.senac.pi3.Modelos.Venda;

/**
 *
 * @author macba
 */
public class VendaBLL {
    
    public static void inserir ( Venda v) throws Exception
    {
        if(v.getNomeComprador().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
        if(v.getData().toString().trim().length() == 0)
        {
            throw new Exception("A data deve ser preenchida!");
        }
        if(v.getCartaoComprador().trim().length() == 0)
        {
            throw new Exception("O cartâo deve ser preenchido!");
        }
        if(v.getCodSegurancaComprador().trim().length() == 0)
        {
            throw new Exception(" O código de segurança deve ser preenchido!");
        }
           
           VendasDAO.realizarVenda(v);
    }
    
}
