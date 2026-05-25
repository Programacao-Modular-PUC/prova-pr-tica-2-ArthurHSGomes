package pm_prova2_m;


public class Moto extends Veiculo implements Inspecionavel {

    private int cilindrada;
    private boolean inspecionada;

    public Moto(String placa, String modelo, int anoFabricacao,
                double valorDiaria, double quilometragem, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status); 
        this.cilindrada = cilindrada;
        this.inspecionada = false;
    }

    @Override
    public void realizarInspecao() {
        System.out.println("  Iniciando inspecao da moto \"" + getModelo() + "\" (" + getPlaca() + ")...");
        System.out.println("  [OK] Verificacao de freios");
        System.out.println("  [OK] Verificacao de pneus");
        System.out.println("  [OK] Verificacao de motor (" + cilindrada + "cc)");
        System.out.println("  [OK] Verificacao de iluminacao");
        System.out.println("  Inspecao concluida com sucesso!");
        this.inspecionada = true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[MOTO] " + toString());
        System.out.printf("        Cilindrada: %dcc | Inspecionada: %s%n",
            cilindrada,
            inspecionada ? "Sim" : "Nao"
        );
    }

    public int getCilindrada()       { return cilindrada; }
    public boolean isInspecionada()  { return inspecionada; }

    @Override
    public boolean possuiSeguroEspecial() {
 
        throw new UnsupportedOperationException("Unimplemented method 'possuiSeguroEspecial'");
    }
}
