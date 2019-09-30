<%-- 
    Document   : listaProduto
    Created on : 22/09/2019, 00:08:25
    Author     : Gi
--%>
<%@include file="../header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulta de Usuário</title>
</head>

<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="abab6d38-69e0-098a-7dec-274e5b37e67c">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Consulta de Usuário</a>
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
                            <h4 class="card-title ">Usuários</h4>
                            <p class="card-category">Lista de usuários cadastrados</p>
                        </div>
                        <div class="card-body">
                            <span class="bmd-form-group col-md-8">
                                <div class="input-group no-border">
                                    <input type="text" value="" class="form-control" placeholder="Pesquisar">
                                    <button type="submit" class="btn btn-info btn-round btn-just-icon">
                                        <i class="material-icons">search</i>
                                        <div class="ripple-container"></div>
                                    </button>
                                </div>
                            </span>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="text-center"><b>ID</b></th>
                                            <th class="text-center"><b>Nome</b></th>
                                            <th class="text-center"><b>CPF</b></th>
                                            <th class="text-center"><b>Permissão</b></th>
                                            <th class="text-center"><b>Status</b></th>
                                            <th class="text-center"><b>Ação</b></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <c:forEach var="c" items="${usuarios}">
                                                <td class="text-center">${c.id}</td>
                                                <td class="text-center">${c.nome}</td>
                                                <td class="text-center">${c.cpf}</td>
                                                <td class="text-center">${c.permissao}</td>
                                                <c:if test="${c.ativo == true}">
                                                    <td class="text-center">Ativo</td>
                                                </c:if>
                                                <c:if test="${c.ativo == false}">
                                                    <td class="text-center">Inativo</td>
                                                </c:if>
                                                <td class="td-actions text-center">
                                                    <c:url var="alterarUsuario" value="/alterar-usuario">
                                                        <c:param name="id" value="${c.id}" />
                                                    </c:url>
                                                    <a href="${alterarUsuario}" class="btn btn-link btn-success" data-toggle="tooltip" data-placement="left" title="Alterar Usuário"><i class="fas fa-pen"></i></a>
                                                        <c:url var="excluirFornecedor" value="/excluir-fornecedor">
                                                            <c:param name="id" value="${c.id}" />
                                                        </c:url>
                                                    <a href="${excluirUsuario}" class="btn btn-link btn-danger" data-toggle="tooltip" data-placement="left" title="Alterar Cliente"><i class="material-icons">close</i></a>
                                                </td>
                                            </c:forEach>
                                        </tr> 
                                    </tbody>
                                </table>
                            </div>
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