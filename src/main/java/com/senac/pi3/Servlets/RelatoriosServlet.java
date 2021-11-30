/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.DAOs.RelatorioDAO;
import com.senac.pi3.Modelos.Relatorio;
import com.senac.pi3.Modelos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author macba
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/RelatoriosServlet"})
public class RelatoriosServlet extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int filtro = 7;
        if(request.getParameter("filtro") != null) {
            filtro = Integer.parseInt(request.getParameter("filtro").toString());
        }
        
        request.setAttribute("filtro", filtro);
        
        // Verifica se usuario ja esta logado
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") == null) {
            // Redirecionar para tela de login
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }
        
        Usuario usuariologado = null;
        usuariologado = (Usuario) sessao.getAttribute("usuario");
        
        
        List<Relatorio> relatorio = null; 
        try{
            relatorio = RelatorioDAO.listar(filtro, usuariologado.getTipoAcesso(), usuariologado.getFilial().getId()); 
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        request.setAttribute("relatorio", relatorio);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
        dispatcher.forward(request, response);

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
