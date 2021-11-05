/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Servlets;

import com.senac.pi3.BLL.VendaBLL;
import com.senac.pi3.Modelos.Venda;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
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
        
        //Flag manutenção. Essa flag está sendo utilizada para que a página cliente.jsp saiba quando
        //montar o formulário para inserção dos dados ou montar a listagem dos clientes já cadastrados.
        //Sendo assim, quando manutencao == FALSE, deverá ser montado o formulário. Caso contrário, será montada a listagem.
        //Ele começa com FALSE para que seja montado o formulário por padrão toda vez que a página for executada pela primeira vez
        boolean manutencao = false; 
        
//        //Essa flag é então enviada como um atributo para a página que será chamada, que no caso é a página cliente.jsp
        List<Venda> vendas = null; //É criado uma lista de clientes para que sejam exibidos na página cliente.jsp
        try
        {
            vendas = VendaBLL.listar(); //É chamado o método listar que irá montar a lista com os clientes já existentes
        }
        catch(ClassNotFoundException | SQLException e)
        {
        }
        
        request.setAttribute("manutencao", manutencao);
        request.setAttribute("vendas", vendas);
        
        
        //Enviando a requisição para a página cliente.jsp, nesse momento, a página será exibida no navegador do usuário,
        //mostrando o formulario para inserção dos dados de um novo cliente.
        RequestDispatcher dispatcher = request.getRequestDispatcher("venda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        Venda venda = new Venda();
        List<Venda> vendas = null;
        
        venda.setNome(request.getParameter("nome"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            venda.setDataVenda(sdf.parse(request.getParameter("dataVenda")));
        } catch (ParseException e) {
        }
        venda.setTipoPagamento(request.getParameter("tipoPagamento"));
        venda.setEmail(request.getParameter("email"));
        venda.setValorVenda(BigDecimal.valueOf(Double.parseDouble(request.getParameter("valorVenda"))));
        venda.setEndereco(request.getParameter("endereco"));
        
        try {
            VendaBLL.inserir(venda);
        } catch (Exception e) {
        }
        
        request.setAttribute("vendas", vendas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("venda.jsp");
        dispatcher.forward(request, response);
        
    }

}
