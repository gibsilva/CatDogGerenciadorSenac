package br.senac.tads.catdoggerenciador.entidades.enums;

public enum ETipoAnimal {
    Cachorro(1), Gato(2), Ave(3), Peixe(4), Roedor(5);

    private final int opcao;

    ETipoAnimal(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return this.opcao;
    }
}
