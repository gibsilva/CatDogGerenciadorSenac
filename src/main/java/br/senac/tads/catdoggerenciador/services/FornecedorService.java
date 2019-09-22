/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.FornecedorDao;
import br.senac.tads.catdoggerenciador.entidades.Fornecedor;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import java.util.List;

/**
 *
 * @author Gi
 */
public class FornecedorService {

    private final FornecedorDao fornecedorDao;
    private final Notificacao notificacao;
    
    public FornecedorService(){
        this.fornecedorDao = new FornecedorDao();
        this.notificacao = new Notificacao();
    }
    
    public List<Fornecedor> obterTodos(){
        return this.fornecedorDao.obterTodos();
    }
}
