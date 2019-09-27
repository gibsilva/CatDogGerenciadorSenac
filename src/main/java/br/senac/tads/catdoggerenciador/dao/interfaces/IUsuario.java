/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao.interfaces;

import br.senac.tads.catdoggerenciador.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Girlaine
 */
public interface IUsuario {
     Usuario obterPorId(int id);
    List<Usuario> obterTodos();
    void salvar(Usuario usuario);
    void alterar(Usuario usuario);
    void alterarStatus(Usuario usuario);
    Usuario autenticar (String nome, String senha);
    boolean validarLogin (String login, String senha);
    void alterarSenha(Usuario usuario);
}
