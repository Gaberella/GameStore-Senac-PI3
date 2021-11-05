/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.ProdutoBLL;
import com.senac.pi3.Modelos.Produto;
import java.io.IOException;
import java.math.BigDecimal;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet 
{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        List<Produto> produtos = null;
        
        try 
        {
            produtos = ProdutoBLL.listar("");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        request.setAttribute("produtos", produtos);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("produtos.jsp");
        dispatcher.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
         Produto p = new Produto();
         List<Produto> produtos = null;

         p.setNomeProduto(request.getParameter("nomeProduto"));
         p.setCategoria(Integer.parseInt(request.getParameter("categoria")));
         p.setPreco(BigDecimal.valueOf(Double.parseDouble(request.getParameter("preco"))));
         p.setFabricante(request.getParameter("fabricante"));
         p.setEstoque(Integer.parseInt(request.getParameter("estoque")));
         p.setModelo(request.getParameter("modelo"));
         p.setCodBarras(request.getParameter("codbarras"));
         
//         Filial f = new Fillial();
//        try 
//        {
//            f = FilialDAO.obterFilial(Integer.parseInt(request.getParameter("filial")));
//        } catch (SQLException e) 
//        {
//            Logger.getLogger(ServicoServlet.class.getName()).log(Level.SEVERE, null, e);
//        }
//        p.setFilial(f);


        try 
        {
         ProdutoBLL.inserir(p);
         produtos = ProdutoBLL.listar("");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
        
    }

 
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}
