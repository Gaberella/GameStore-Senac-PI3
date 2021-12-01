/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;


import com.senac.pi3.DAOs.ClienteDAO;
import com.senac.pi3.DAOs.ProdutoDAO;
import com.senac.pi3.DAOs.VendaDAO;
import com.senac.pi3.Modelos.Cliente;
import com.senac.pi3.Modelos.Produto;
import com.senac.pi3.Modelos.Usuario;
import com.senac.pi3.Modelos.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gabri
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        List<Produto> produtos = null;
        
        
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("usuario") == null)
        {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        Usuario usarioLogado = null;
        usarioLogado = (Usuario) sessao.getAttribute("usuario");
        
        try 
        {
            produtos = ProdutoDAO.listar("idFilial = " + usarioLogado.getFilial().getId());
        } 
        catch (SQLException| ClassNotFoundException e) 
        {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
        request.setAttribute("produtos", produtos);
        
        List<Cliente> clientes =null;
              
        try 
        {
            clientes = ClienteDAO.listar(true);
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
        }
        request.setAttribute("clientes", clientes);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vendas.jsp");
        dispatcher.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        Venda v = new Venda();
    
        int idCliente = Integer.parseInt(request.getParameter("cliente"));
        Float valor_venda = Float.parseFloat(request.getParameter("valor_venda"));
        String produtos = request.getParameter("produtos");
        
        JSONObject obj = new JSONObject(produtos);
        JSONArray arr = obj.getJSONArray("venda");
        
        Cliente c = new Cliente();
        try 
        {
            c = ClienteDAO.obterCliente(idCliente);
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        v.setCliente(c);
        
        v.setValorTotal(valor_venda);
        
        HttpSession sessao = request.getSession();
        Usuario logado = (Usuario) sessao.getAttribute("usuario");
        
        v.setFuncionario(logado);
        
        try 
        {
            VendaDAO.inserir(v);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
}
