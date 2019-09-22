package br.senac.tads.catdoggerenciador.entidades;

import java.util.ArrayList;
import java.util.List;

public class Notificacao {

    private String mensagem;
    private final List<Notificacao> notificacoes;

    public Notificacao(){
        this.notificacoes = new ArrayList<>();
    }
    
    public Notificacao(String mensagem) {
        this.mensagem = mensagem;
        this.notificacoes = new ArrayList<>();
    }

    public void adicionaNotificacao(String valor) {
        this.notificacoes.add(new Notificacao(valor));
    }

    public void limparNotificacoes() {
        if (!notificacoes.isEmpty()) {
            for (Notificacao n : this.notificacoes) {
                this.notificacoes.remove(n);
            }
        }
    }

    public String getMensagem() {
        return this.mensagem;
    }
    
    public List<Notificacao> getNotificacaoes(){
        return this.notificacoes;
    }

    public int getQuantidadeNotificacoes() {
        return this.notificacoes.size();
    }

    public boolean temNotificacoes() {
        return this.notificacoes.isEmpty();
    }
}
