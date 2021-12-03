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


@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //listando produtos para a venda
          List<Produto> produtos = null;
        
        // Verifica se usuario ja esta logado
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") == null) {
            // Redirecionar para tela de login
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }
        
        Usuario usuariologado = null;
        usuariologado = (Usuario) sessao.getAttribute("usuario");
        
        try {
            produtos = ProdutoDAO.listar("idFilial = " + usuariologado.getFilial().getId());
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("produtos", produtos);
         
        //Listando clientes
        List<Cliente> clientes =null;
              try {
            clientes = ClienteDAO.listar(true);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        request.setAttribute("clientes", clientes);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/vendas.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        Venda v = new Venda();
        
        int idCliente = Integer.parseInt(request.getParameter("cliente"));
        Float valor_venda = Float.parseFloat(request.getParameter("valor_venda"));
        String produtos = request.getParameter("produtos");

        Cliente c = new Cliente();
        try {
            c = ClienteDAO.obterCliente(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        v.setCliente(c);
        
        v.setValorTotal(valor_venda);
        
        HttpSession sessao = request.getSession();
        Usuario logado = (Usuario) sessao.getAttribute("usuario");
        
        v.setFuncionario(logado);
        
        try {
            VendaDAO.inserir(v);
          
        } catch (Exception ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}