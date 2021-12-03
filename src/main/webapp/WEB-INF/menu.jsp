<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="sidebar">
                <div class="sidebar-header">
                    <img src="assets/images/logo.png">
                    <strong></strong>
                </div>

                <ul class="list-unstyled components">
                    <p style="text-align: center; color: white">${sessionScope.usuario.nome}</p>
                    
                    <c:if test="${sessionScope.usuario.tipoAcesso >= 2 && sessionScope.usuario.tipoAcesso <= 4}">
                        <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("vendas.jsp")){%> class="active" <%}%> >
                            <a href="VendaServlet">
                                <i class="glyphicon glyphicon-shopping-cart"></i>
                                Vender
                            </a>
                        </li>
                    </c:if>
                        
                    <c:if test="${sessionScope.usuario.tipoAcesso == 1}">
                        <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("vendas.jsp")){%> class="active" <%}%> >
                            <a href="VendaServlet">
                                <i class="glyphicon glyphicon-shopping-cart"></i>
                                Comprar
                            </a>
                        </li>
                    </c:if>    

                    <c:if test="${sessionScope.usuario.tipoAcesso == 3 || sessionScope.usuario.tipoAcesso == 4 || sessionScope.usuario.tipoAcesso == 6 || sessionScope.usuario.tipoAcesso == 5}">
                        <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("produtos.jsp")){%> class="active" <%}%> >
                            <a href="ProdutoServlet">
                                <i class="glyphicon glyphicon-heart"></i>
                                Produtos
                            </a>
                        </li>
                    </c:if>
                       
                    <c:if test="${(sessionScope.usuario.tipoAcesso >= 2 && sessionScope.usuario.tipoAcesso <= 5)}">
                        <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("cliente.jsp")){%> class="active" <%}%> >
                            <a href="ClienteServlet">
                                <i class="glyphicon glyphicon-user"></i>
                                Usuários 
                            </a>
                        </li>
                    </c:if>
                    
                   <c:if test="${sessionScope.usuario.tipoAcesso > 2}">
                        <li>
                            <a href="RelatoriosServlet">
                                <i class="glyphicon glyphicon-stats"></i>
                                Relatórios
                            </a>
                        </li>
                   </c:if>
                        
                     <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("sobreEmpresa.jsp")){%> class="active" <%}%> >
                        <a href="SobreEmpresaServlet">
                            <i class="glyphicon glyphicon-exclamation-sign"></i>
                            Sobre a empresa
                        </a>
                    </li>

                    <li>
                        <a href="LogoutServlet">
                            <i class="glyphicon glyphicon-off"></i>
                            Sair
                        </a>
                    </li>
                    
                </ul>
            </nav>
