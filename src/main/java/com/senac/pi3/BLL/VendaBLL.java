/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.VendaDAO;
import com.senac.pi3.Modelos.Venda;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macba
 */
public class VendaBLL 
{
    public void inserir(Venda v)
    {

    }

    public static List<Venda> listar() throws SQLException, ClassNotFoundException{
        return VendaDAO.obterVenda(false);
    }
}