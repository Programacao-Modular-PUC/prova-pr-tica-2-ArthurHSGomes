
package pm_prova2_m;


public enum StatusVeiculo {
    DISPONIVEL("Disponível"),
    ALUGADO("Alugado"),
    MANUTENCAO("Em Manutenção");

    private final String descricao;

    StatusVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

}
