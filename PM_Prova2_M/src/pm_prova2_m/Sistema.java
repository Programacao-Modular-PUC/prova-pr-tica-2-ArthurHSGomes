import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    private List<Veiculo> veiculos;
    private List<Aluguel> alugueis;
    private Scanner scanner;

    public Sistema(Scanner scanner) {
        this.veiculos = new ArrayList<>();
        this.alugueis = new ArrayList<>();
        this.scanner = scanner;
    }


    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }



    public void associarVeiculoAoAluguel() {
        System.out.println("\n--- Associar Veiculo ao Aluguel ---");

        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }

        List<Veiculo> disponiveis = listarDisponiveis();
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veiculo disponivel no momento.");
            return;
        }

        System.out.println("Alugueis cadastrados:");
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel a = alugueis.get(i);
            System.out.printf("  %d. [%s] ID:%d - Cliente: %s%n",
                i + 1, a.getTipoAluguel(), a.getId(), a.getNomeCliente());
        }
        System.out.print("Selecione o aluguel: ");
        int idxAluguel = lerOpcao(1, alugueis.size()) - 1;
        if (idxAluguel < 0) return;

        System.out.println("\nVeiculos disponiveis:");
        for (int i = 0; i < disponiveis.size(); i++) {
            Veiculo v = disponiveis.get(i);
            System.out.printf("  %d. %s - %s (R$%.2f/dia)%n",
                i + 1, v.getModelo(), v.getPlaca(), v.getValorDiaria());
        }
        System.out.print("Selecione o veiculo: ");
        int idxVeiculo = lerOpcao(1, disponiveis.size()) - 1;
        if (idxVeiculo < 0) return;

        alugueis.get(idxAluguel).adicionarVeiculo(disponiveis.get(idxVeiculo));
        System.out.println("Veiculo associado com sucesso!");
    }



    public void exibirTodosVeiculos() {
        System.out.println("\n--- Todos os Veiculos (" + veiculos.size() + ") ---");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
            System.out.println();
        }
    }



    public void exibirTodosAlugueis() {
        System.out.println("\n--- Todos os Alugueis (" + alugueis.size() + ") ---");
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
            System.out.println();
        }
    }



    public void exibirVeiculosDisponiveis() {
        System.out.println("\n--- Veiculos Disponiveis ---");
        List<Veiculo> disponiveis = listarDisponiveis();
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veiculo disponivel no momento.");
            return;
        }
        for (Veiculo v : disponiveis) {
            v.exibirDetalhes();
            System.out.println();
        }
    }



    public void avaliarObjeto() {
        System.out.println("\n--- Avaliar ---");

        // Coleta todos os objetos que implementam Avaliavel
        List<Avaliavel> avaliaveis = new ArrayList<>();
        List<String> descricoes = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (v instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) v);
                descricoes.add("[Veiculo] " + v.getModelo() + " (" + v.getPlaca() + ")");
            }
        }
        for (Aluguel a : alugueis) {
            if (a instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) a);
                descricoes.add("[Aluguel " + a.getTipoAluguel() + "] Cliente: " + a.getNomeCliente());
            }
        }

        if (avaliaveis.isEmpty()) {
            System.out.println("Nenhum objeto avaliavel encontrado.");
            return;
        }

        System.out.println("Selecione o item para avaliar:");
        for (int i = 0; i < descricoes.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + descricoes.get(i));
        }
        System.out.print("Opcao: ");
        int idx = lerOpcao(1, avaliaveis.size()) - 1;
        if (idx < 0) return;

        System.out.print("Digite a nota (1 a 5): ");
        int nota = lerOpcao(1, 5);
        if (nota < 0) return;

        avaliaveis.get(idx).avaliar(nota);
    }



    public void realizarInspecao() {
        System.out.println("\n--- Realizar Inspecao ---");

        List<Inspecionavel> inspecionaveis = new ArrayList<>();
        List<String> descricoes = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel) {
                inspecionaveis.add((Inspecionavel) v);
                descricoes.add(v.getModelo() + " (" + v.getPlaca() + ") - " + v.getStatus().getDescricao());
            }
        }

        if (inspecionaveis.isEmpty()) {
            System.out.println("Nenhum veiculo inspecionavel cadastrado.");
            return;
        }

        System.out.println("Selecione o veiculo para inspecao:");
        for (int i = 0; i < descricoes.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + descricoes.get(i));
        }
        System.out.print("Opcao: ");
        int idx = lerOpcao(1, inspecionaveis.size()) - 1;
        if (idx < 0) return;

        inspecionaveis.get(idx).realizarInspecao();
    }



    public void removerVeiculosEmManutencao() {
        System.out.println("\n--- Remover Veiculos em Manutencao ---");
        Iterator<Veiculo> iterator = veiculos.iterator();
        int removidos = 0;

        while (iterator.hasNext()) {
            Veiculo v = iterator.next();
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                System.out.println("  Removendo: " + v.getModelo() + " [" + v.getPlaca() + "]");
                iterator.remove();
                removidos++;
            }
        }

        if (removidos == 0) {
            System.out.println("Nenhum veiculo em manutencao encontrado.");
        } else {
            System.out.println(removidos + " veiculo(s) removido(s) com sucesso.");
        }
    }



    private List<Veiculo> listarDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                disponiveis.add(v);
            }
        }
        return disponiveis;
    }

    // Le e valida uma opcao numerica dentro do intervalo [min, max]; retorna -1 se invalido
    private int lerOpcao(int min, int max) {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            if (valor < min || valor > max) {
                System.out.println("Opcao invalida. Deve estar entre " + min + " e " + max + ".");
                return -1;
            }
            return valor;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Entrada invalida. Digite um numero.");
            return -1;
        }
    }
}
