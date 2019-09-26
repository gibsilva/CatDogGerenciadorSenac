<%-- 
    Document   : listaProduto
    Created on : 22/09/2019, 00:08:25
    Author     : Gi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulta de Produtos</title>
</head>

<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="abab6d38-69e0-098a-7dec-274e5b37e67c">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Consulta de Produtos</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end">
                <ul class="navbar-nav">

                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#pablo" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="material-icons">person</i>
                            <p class="d-lg-none d-md-block">
                                Account
                            </p>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                            <a class="dropdown-item" href="#">Profile</a>
                            <a class="dropdown-item" href="#">Settings</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Log out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-info">
                            <h4 class="card-title ">Produtos</h4>
                            <p class="card-category">Lista de produtos cadastrados</p>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="text-center"><b>ID</b></th>
                                            <th class="text-center"><b>Nome/Título</b></th>
                                            <th class="text-center"><b>Preço Venda</b></th>
                                            <th class="text-center"><b>Quantidade</b></th>
                                            <th class="text-center"><b>Status</b></th>
                                            <th class="text-center"><b>Ação</b></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="c" items="${produtos}">
                                            <tr>
                                                <td class="text-center">${c.id}</td>
                                                <td class="text-center">${c.nome}</td>
                                                <td class="text-center"><fmt:formatNumber value="${c.precoVenda}" type="currency"></fmt:formatNumber></td>
                                                <td class="text-center">${c.quantidade}</td>
                                                <c:if test="${c.ativo == true}">
                                                    <td class="text-center">Ativo</td>
                                                </c:if>
                                                <c:if test="${c.ativo == false}">
                                                    <td class="text-center">Inativo</td>
                                                </c:if>
                                                <td class="td-actions text-center">
                                                    <c:url var="alterarProduto" value="/alterar-produto">
                                                        <c:param name="id" value="${c.id}" />
                                                    </c:url>
                                                    <a href="${alterarProduto}" class="btn btn-success" data-toggle="tooltip" data-placement="left" title="Alterar Produto"><i class="fas fa-pen"></i></a>
                                                        <c:url var="detalhesProduto" value="/detalhes-produto">
                                                            <c:param name="id" value="${c.id}" />
                                                        </c:url>
                                                    <a href="${detalhesProduto}" class="btn btn-warning" data-toggle="tooltip" data-placement="left" title="Detalhes Produto"><i class="material-icons">info</i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
        <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;">            
        </div>            
    </div>
    <div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px; height: 625px;">
        <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 316px;">            
        </div>            
    </div>       
</div>
