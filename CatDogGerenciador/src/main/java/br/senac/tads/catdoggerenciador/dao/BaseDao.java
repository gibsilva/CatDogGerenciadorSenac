package br.senac.tads.catdoggerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senac.tads.catdoggerenciador.conexao.ConexaoBd;

public abstract class BaseDao {

    protected final ConexaoBd conexao;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;

    public BaseDao() {
        conexao = new ConexaoBd();
    }
}
