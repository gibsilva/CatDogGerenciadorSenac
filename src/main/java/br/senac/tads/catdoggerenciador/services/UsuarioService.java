/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.UsuarioDao;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Girlaine
 */
public class UsuarioService {

    private final UsuarioDao usuarioDao;
    private final Notificacao notificacao;

    public UsuarioService() {
        this.usuarioDao = new UsuarioDao();
        this.notificacao = new Notificacao();
    }
    public List<Usuario> obterTodos(){
        return this.usuarioDao.obterTodos();
    }
    
    public List<Notificacao> incluirOuAlterar(Usuario usuario){
        if(usuario.getId() == 0)
            this.usuarioDao.salvar(usuario);
        else
            this.usuarioDao.alterar(usuario);
        
        return notificacao.getNotificacaoes();
    }
    
    public Usuario obterPorId(int id){
        return this.usuarioDao.obterPorId(id);
    }

    public void limparNotificacoes(){
        this.notificacao.limparNotificacoes();
    }
}
