
package pm_prova2_m;
import java.util.ArrayList;
import java.util.List;

public abstract class Aluguel {

    private static int contadorId = 1;

    private int id;
    private String nomeCliente;
    private String dataInicio;
    private String dataFim;
    private List<Veiculo> veiculos;

    public Aluguel(String nomeCliente, String dataInicio, String dataFim) {
        this.id = contadorId++;
        this.nomeCliente = nomeCliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.veiculos = new ArrayList<>();
    }

    public abstract void exibirDetalhes();
    public abstract String getTipoAluguel();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
    }

    // Getters
    public int getId()               { return id; }
    public String getNomeCliente()   { return nomeCliente; }
    public String getDataInicio()    { return dataInicio; }
    public String getDataFim()       { return dataFim; }
    public List<Veiculo> getVeiculos() { return veiculos; }

    protected void exibirVeiculosAssociados() {
        if (veiculos.isEmpty()) {
            System.out.println("  Nenhum veiculo associado.");
        } else {
            for (Veiculo v : veiculos) {
                System.out.println("  -> " + v.getModelo() + " [" + v.getPlaca() + "]");
            }
        }
    }
}
