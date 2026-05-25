package pm_prova2_m;

/**
 *
 * @author glbra
 */
public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int avaliacao;
    private boolean avaliada;
    private boolean inspecionada;

    public Van(String placa, String modelo, int anoFabricacao,
               double valorDiaria, double quilometragem, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem);
        this.maxPassageiros = maxPassageiros;
        this.avaliacao = 0;
        this.avaliada = false;
        this.inspecionada = false;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("  Nota invalida! Informe um valor entre 1 e 5.");
            return;
        }
        this.avaliacao = nota;
        this.avaliada = true;
        System.out.println("  Van \"" + getModelo() + "\" avaliada com nota " + nota + "/5.");
    }

    @Override
    public void realizarInspecao() {
        System.out.println("  Iniciando inspecao da van \"" + getModelo() + "\" (" + getPlaca() + ")...");
        System.out.println("  [OK] Verificacao de freios");
        System.out.println("  [OK] Verificacao de pneus");
        System.out.println("  [OK] Verificacao de motor");
        System.out.println("  [OK] Capacidade: " + maxPassageiros + " passageiros");
        System.out.println("  [OK] Verificacao de saidas de emergencia");
        System.out.println("  Inspecao concluida com sucesso!");
        this.inspecionada = true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[VAN]  " + toString());
        System.out.printf("        Max. Passageiros: %d | Avaliacao: %s | Inspecionada: %s%n",
            maxPassageiros,
            avaliada ? avaliacao + "/5" : "Nao avaliada",
            inspecionada ? "Sim" : "Nao"
        );
    }

    public int getMaxPassageiros()  { return maxPassageiros; }
    public int getAvaliacao()       { return avaliacao; }
    public boolean isAvaliada()     { return avaliada; }
    public boolean isInspecionada() { return inspecionada; }
}
