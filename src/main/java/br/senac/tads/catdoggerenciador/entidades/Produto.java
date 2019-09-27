package br.senac.tads.catdoggerenciador.entidades;

import br.senac.tads.catdoggerenciador.entidades.Entidade;
import br.senac.tads.catdoggerenciador.entidades.enums.EPorteAnimal;
import br.senac.tads.catdoggerenciador.entidades.enums.ETipoAnimal;

import java.util.ArrayList;
import java.util.List;

public class Produto extends Entidade {

    private String nome;
    private String descricao;
    private String especificacao;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private boolean ativo;
    private ETipoAnimal tipoAnimal;
    private int idCategoria;
    private Categoria categoria;
    private int idFornecedor;
    private Fornecedor fornecedor;
    private List<Imagem> imagens;
    private EPorteAnimal porteAnimal;

    public Produto(int id, String nome, String descricao, String especificacao, 
            double precoCompra, double precoVenda, int quantidade, boolean ativo, int idCategoria, 
            int idFornecedor, EPorteAnimal porteAnimal, ETipoAnimal tipoAnimal) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
        this.especificacao = especificacao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.idCategoria = idCategoria;
        this.idFornecedor = idFornecedor;
        this.porteAnimal = porteAnimal;
        this.tipoAnimal = tipoAnimal;
        this.imagens = new ArrayList<Imagem>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double preco) {
        this.precoCompra = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ETipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(ETipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public EPorteAnimal getPorteAnimal(){
        return this.porteAnimal;
    }

    public void setPorteAnimal(EPorteAnimal porteAnimal){
        this.porteAnimal = porteAnimal;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

}
