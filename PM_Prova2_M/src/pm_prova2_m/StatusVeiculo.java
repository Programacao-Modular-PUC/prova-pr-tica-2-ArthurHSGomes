/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pm_prova2_m;

/**
 *
 * @author glbra
 */
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
