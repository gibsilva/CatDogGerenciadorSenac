package br.senac.tads.catdoggerenciador.entidades;

public class Imagem extends Entidade {

    private String nome;
    private String caminho;
    private String tipo;
    private int idProduto;
    private Produto produto;

    public Imagem(int id, String nome, String caminho, String tipo, int idProduto) {
        super(id);
        this.nome = nome;
        this.caminho = caminho;
        this.tipo = tipo;
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
