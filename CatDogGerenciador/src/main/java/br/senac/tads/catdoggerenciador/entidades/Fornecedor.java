package br.senac.tads.catdoggerenciador.entidades;

public class Fornecedor extends Entidade {

    private String nome;
    private String razaoSocial;
    private String documento;
    private boolean ativo;
    private String cep;

    public Fornecedor(int id, String nome, String razaoSocial, String documento, 
            boolean ativo, String cep) {
        super(id);
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.documento = documento;
        this.ativo = ativo;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
