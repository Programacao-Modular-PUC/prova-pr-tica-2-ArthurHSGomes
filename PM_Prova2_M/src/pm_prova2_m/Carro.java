package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int avaliacao;
    private boolean avaliado;

    public Carro(String placa, String modelo, int anoFabricacao,
             double valorDiaria, double quilometragem,
             StatusVeiculo status, int quantidadePortas) {
    super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status); 
    this.quantidadePortas = quantidadePortas;
    this.avaliacao = 0;
    this.avaliado = false;
}

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("  Nota invalida! Informe um valor entre 1 e 5.");
            return;
        }
        this.avaliacao = nota;
        this.avaliado = true;
        System.out.println("  Carro \"" + getModelo() + "\" avaliado com nota " + nota + "/5.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[CARRO] " + toString());
        System.out.printf("         Portas: %d | Avaliacao: %s%n",
            quantidadePortas,
            avaliado ? avaliacao + "/5" : "Nao avaliado"
        );
    }

    public int getQuantidadePortas() { return quantidadePortas; }
    public int getAvaliacao()        { return avaliacao; }
    public boolean isAvaliado()      { return avaliado; }

    @Override
    public boolean possuiSeguroEspecial() {

        throw new UnsupportedOperationException("Unimplemented method 'possuiSeguroEspecial'");
    }
}
