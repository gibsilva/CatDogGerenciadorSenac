<%-- 
    Document   : incluir-categoria
    Created on : 22/09/2019, 10:40:11
    Author     : Gi
--%>

<%@include file="../header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Cadastro de Fornecedor</title>
<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Cadastro de Fornecedor</a>
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
                            <h4 class="card-title">Novo Fornecedor</h4>
                            <p class="card-category">Adicione um novo fornecedor</p>
                        </div>
                        <div class="card-body">
                            <form action="incluir-categoria" method="post">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome do Fornecedor</label>
                                            <input type="text" class="form-control" id="fornecedor" name="fornecedor" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Raz�o Social</label>
                                            <input type="text" class="form-control" id="razaoSocial" name="razaoSocial" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">CNPJ</label>
                                            <input type="text" class="form-control" id="cnpj" name="cnpj" required>
                                        </div>
                                    </div>  
                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">CEP</label>
                                            <input type="text" class="form-control" id="cep" name="cep" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Logradouro</label>
                                            <input type="text" class="form-control" id="logradouro" name="logradouro" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Numero</label>
                                            <input type="text" class="form-control" id="numero" name="numero" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Complemento</label>
                                            <input type="text" class="form-control" id="complemento" name="complemento">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Bairro</label>
                                            <input type="text" class="form-control" id="bairro" name="bairro" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Cidade</label>
                                            <input type="text" class="form-control" id="cidade" name="cidade" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Estado</label>
                                            <input type="text" class="form-control" id="estado" name="estado" readonly>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-success pull-right">Salvar</button>
                                <a href="listar-categoria" class="btn btn-danger pull-right">Cancelar</a>
                                <div class="clearfix"></div>
                            </form>
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
<div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px; height: 268px;">
    <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 88px;">
    </div>
</div>