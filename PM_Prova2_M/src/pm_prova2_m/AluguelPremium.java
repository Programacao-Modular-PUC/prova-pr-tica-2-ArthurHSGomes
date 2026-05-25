package pm_prova2_m;

/**
 *
 * @author glbra
 */
public class AluguelPremium extends Aluguel {

    private static final boolean SEGURO_INCLUSO = true;

    public AluguelPremium(String nomeCliente, String dataInicio, String dataFim) {
        super(nomeCliente, dataInicio, dataFim);
    }

    @Override
    public String getTipoAluguel() {
        return "Premium";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL PREMIUM [ID: " + getId() + "] ");
        System.out.println(" Cliente    : " + getNomeCliente());
        System.out.println(" Periodo    : " + getDataInicio() + " a " + getDataFim());
        System.out.println(" Quilometrag: Ilimitada");
        System.out.println(" Seguro     : Incluso");
        System.out.println(" Veiculos (" + getVeiculos().size() + "):");
        exibirVeiculosAssociados();
        System.out.println("");
    }

    public boolean isSeguroIncluso() { return SEGURO_INCLUSO; }
}
