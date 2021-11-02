/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.VendaBLL;
import com.senac.pi3.Modelos.Venda;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macba
 */
@WebServlet(name = "RealizarVendaServlet", urlPatterns = {"/RealizarVendaServlet"})
public class RealizarVendaServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        Venda venda = new Venda();
        List<Venda> vendas = null;
        
        venda.setNomeComprador(request.getParameter("nome"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            venda.setData(sdf.parse(request.getParameter("data")));
        } catch (Exception e) {
        }
        venda.setCodSegurancaComprador(request.getParameter("codSegurancaComprador"));
        venda.setIdVenda(Integer.parseInt(request.getParameter("idVenda")));
        venda.setCartaoComprador(request.getParameter("cartaoComprador"));
        venda.setIdProduto(Integer.parseInt("idProduto"));
        venda.setIdFilial(Integer.parseInt(request.getParameter("idFilial")));
        
        try {
            VendaBLL.inserir(venda);
        } catch (Exception e) {
        }
        
        request.setAttribute("vendas", vendas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("venda.jsp");
        dispatcher.forward(request, response);
        
    }

}
