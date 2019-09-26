/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.CategoriaDao;
import br.senac.tads.catdoggerenciador.entidades.Categoria;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import java.util.List;

/**
 *
 * @author Gi
 */
public class CategoriaService {

    private final CategoriaDao categoriaDao;
    private final Notificacao notificacao;

    public CategoriaService() {
        this.categoriaDao = new CategoriaDao();
        this.notificacao = new Notificacao();
    }

    private void validaNomeExistente(String nome) {
        if (categoriaDao.obterPorNome(nome) != null) {
            this.notificacao.adicionaNotificacao("Nome já está cadastrado");
        }
    }

    private boolean validarCategoria(Categoria categoria) {
        validaNomeExistente(categoria.getNome());

        return this.notificacao.temNotificacoes();
    }

    public List<Notificacao> salvarOuAlterar(Categoria categoria) {
        if (validarCategoria(categoria)) {
            if(categoria.getId() == 0)
                this.categoriaDao.salvar(categoria);
            else
                this.categoriaDao.alterar(categoria);
        }

        return this.notificacao.getNotificacaoes();
    }
    
    public List<Categoria> obterTodas(){
        return this.categoriaDao.obterTodas();
    }
    
    public Categoria obterPorId(int id){
        return this.categoriaDao.obterPorId(id);
    }
    
    public void limparNotificacoes(){
        this.notificacao.limparNotificacoes();
    }
}
