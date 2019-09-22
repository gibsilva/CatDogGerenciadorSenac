<%-- 
    Document   : listaProduto
    Created on : 22/09/2019, 00:08:25
    Author     : Gi
--%>
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
                                            <th class="text-center"><b>Nome/Titulo</b>s</th>
                                            <th class="text-center"><b>Preço Venda</b></th>
                                            <th class="text-center"><b>Quantidade</b></th>
                                            <th class="text-center"><b>Status</b></th>
                                            <th class="text-center"><b>Ação</b></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-center">1</td>
                                            <td class="text-center">Andrew Mike</td>
                                            <td class="text-center">Develop</td>
                                            <td class="text-center">2013</td>
                                            <td class="text-center">&euro; 99,225</td>
                                            <td class="td-actions text-center">
                                                <button type="button" rel="tooltip" class="btn btn-success">
                                                    <i class="fas fa-pen"></i>
                                                </button>
                                                <button type="button" rel="tooltip" class="btn btn-danger">
                                                    <i class="material-icons">close</i>
                                                </button>
                                            </td>
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

    <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
        <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;">            
        </div>            
    </div>
    <div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px; height: 625px;">
        <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 316px;">            
        </div>            
    </div>       
</div>
