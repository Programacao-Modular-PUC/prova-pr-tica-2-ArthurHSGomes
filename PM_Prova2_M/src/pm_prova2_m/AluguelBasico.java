package pm_prova2_m;

/**
 *
 * @author glbra
 */

public class AluguelBasico extends Aluguel {

    private static final int KM_LIMITE_POR_DIA = 100;
    private static final boolean SEGURO_INCLUSO = false;

    public AluguelBasico(String nomeCliente, String dataInicio, String dataFim) {
        super(nomeCliente, dataInicio, dataFim);
    }

    @Override
    public String getTipoAluguel() {
        return "Basico";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL BASICO [ID: " + getId() + "]");
        System.out.println(" Cliente    : " + getNomeCliente());
        System.out.println(" Periodo    : " + getDataInicio() + " a " + getDataFim());
        System.out.println("Limite KM  : " + KM_LIMITE_POR_DIA + " km/dia");
        System.out.println("Seguro     : Nao incluso");
        System.out.println("Veiculos (" + getVeiculos().size() + "):");
        exibirVeiculosAssociados();
        
    }

    public int getKmLimitePorDia()   { return KM_LIMITE_POR_DIA; }
    public boolean isSeguroIncluso() { return SEGURO_INCLUSO; }
}
