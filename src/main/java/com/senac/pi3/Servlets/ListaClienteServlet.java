/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.ClienteBLL;
import com.senac.pi3.Modelos.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabri
 */
@WebServlet(name = "ListaClienteServlet", urlPatterns = {"/ListaClienteServlet"})
public class ListaClienteServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        boolean manutencao = true;
        
        List<Cliente> clientes = null;
        
        try 
        {
            clientes = ClienteBLL.listar();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        request.setAttribute("manutencao", manutencao);
        request.setAttribute("clientes", clientes);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }
}
