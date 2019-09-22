package br.senac.tads.catdoggerenciador.dao.interfaces;

import java.util.List;

import br.senac.tads.catdoggerenciador.entidades.Categoria;

public interface ICategoriaDao {
	Categoria obterPorId(int id);
        Categoria obterPorNome(String nome);
	List<Categoria> obterTodas();
	void salvar(Categoria categoria);
	void alterar(Categoria categoria);
	void excluir(Categoria categoria);
}
