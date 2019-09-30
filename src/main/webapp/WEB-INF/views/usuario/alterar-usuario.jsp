<%-- 
    Document   : alterarUsuario
    Created on : 21/09/2019, 22:11:39
    Author     : Gi
--%>
<%@include file="../header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Alteração de Usuário</title>
</head>


<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Alteração de Usuário</a>
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
                            <i class="fas fa-user"></i>
                            <p class="d-lg-none d-md-block">
                                Account
                            </p>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                            <a class="dropdown-item" href="#">Perfil</a>
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
            <div class="container">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-info">
                            <h4 class="card-title">Alterar Usuário</h4>
                            <p class="card-category">Altere os dados dos usuários</p>
                        </div>
                        <div class="card-body">
                            <form action="alterar-usuario" method="post">
                                <input type="hidden" value="${usuario.id}" name="id">
                                <div class="row">

                                    <div class="col-md-6">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome</label>
                                            <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">CPF</label>
                                            <input type="text" class="form-control" id="cpf" name="cpf" value="${usuario.cpf}" readonly>
                                        </div>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">E-mail</label>
                                            <input type="email" class="form-control" id="email" name="email" value="${usuario.email}">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Permissão</label>
                                        <select id="persmissao" name="permissao" class="form-control" value="${usuario.permissao}">
                                            <option selected>Selecione</option>
                                            <option>Administrador</option>
                                            <option>Auxiliar</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputAtivo">Status</label>
                                        <select id="ativo" name="ativo" class="custom-select" value="${usuario.ativo}" required>
                                            <option value="true">Ativo</option>
                                            <option value="false">Inativo</option>
                                        </select>
                                    </div>
                                    <br>
                                    <br>
                                    <button type="submit" class="btn btn-success pull-right" id="alterarUser" name="alterarUser">Alterar</button>
                                    <a href="listar-usuario" type="" class="btn btn-danger pull-right">Cancelar</a>
                                    <div class="clearfix"></div>
                            </form>
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
    <div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px; height: 268px;">
        <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 88px;">
        </div>
    </div>
</div>
</body>