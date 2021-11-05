/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.ProdutoBLL;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabri
 */
@WebServlet(name = "ExcluirProdutoServlet", urlPatterns = {"/ExcluirProdutoServlet"})
public class ExcluirProdutoServlet extends HttpServlet 
{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
         int id = Integer.parseInt(request.getParameter("id"));
        
        try
        {
            ProdutoBLL.excluir(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

    
    @Override
    public String getServletInfo() 
    {
        
        return "Short description";
        
    }

}
