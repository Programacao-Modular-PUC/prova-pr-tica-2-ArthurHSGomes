package pm_prova2_m;

/**
 *
 * @author glbra
 */
public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private static final boolean MOTORISTA_PARTICULAR = true;
    private static final boolean SEGURO_INCLUSO = true;

    private int avaliacao;
    private boolean avaliado;

    public AluguelExecutivo(String nomeCliente, String dataInicio, String dataFim) {
        super(nomeCliente, dataInicio, dataFim);
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
        System.out.println("  Aluguel Executivo [ID: " + getId() + "] do cliente \""
            + getNomeCliente() + "\" avaliado com nota " + nota + "/5.");
    }

    @Override
    public String getTipoAluguel() {
        return "Executivo";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL EXECUTIVO [ID: " + getId() + "] ");
        System.out.println(" Cliente    : " + getNomeCliente());
        System.out.println(" Periodo    : " + getDataInicio() + " a " + getDataFim());
        System.out.println(" Quilometrag: Ilimitada");
        System.out.println(" Seguro     : Incluso");
        System.out.println(" Motorista  : Particular");
        System.out.println(" Avaliacao  : " + (avaliado ? avaliacao + "/5" : "Nao avaliado"));
        System.out.println("Veiculos (" + getVeiculos().size() + "):");
        exibirVeiculosAssociados();
    }

    public int getAvaliacao()            { return avaliacao; }
    public boolean isAvaliado()          { return avaliado; }
    public boolean isMotoristaParticular() { return MOTORISTA_PARTICULAR; }
    public boolean isSeguroIncluso()     { return SEGURO_INCLUSO; }
}
