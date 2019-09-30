/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.entidades;

import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Girlaine
 */
public class Usuario extends Entidade {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String permissao;
    private boolean ativo;

    public Usuario(int id, String nome, String cpf, String email,
            String senha, String permissao, boolean ativo) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
        this.ativo = ativo;
    }

    public Usuario(int id, String nome, String cpf, String email, String permissao, boolean ativo) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.permissao = permissao;
        this.ativo = ativo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    public void setSenhaEncriptada(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt(12));
    }

    public boolean validarSenha(String senha) {
        boolean senhaValida = BCrypt.checkpw(senha, this.getSenha());
        return senhaValida;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

}
