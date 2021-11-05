
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.ProdutoBLL;
import com.senac.pi3.Modelos.Produto;
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
@WebServlet(name = "ListaProdutoServlet", urlPatterns = {"/ListaProdutoServlet"})
public class ListaProdutoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       List<Produto> produtos = null;
        try
        {
            produtos = ProdutoBLL.listar(""); 
        }
        catch(Exception e)
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
      
    }

}
