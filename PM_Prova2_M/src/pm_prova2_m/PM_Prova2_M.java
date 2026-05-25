/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pm_prova2_m;
import java.util.Scanner;

/**
 *
 * @author glbra
 */
public class PM_Prova2_M {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema(scanner);

       
        inicializarDados(sistema);


        executarMenu(sistema, scanner);

        scanner.close();
    }

   
    private static void inicializarDados(Sistema sistema) {



        Carro carro = new Carro(
            "ABC-1234", "Honda Civic", 2022,
            150.00, 28500.0, null, 4
        );

        Moto moto = new Moto(
            "XYZ-5678", "Honda CB 500F", 2023,
            80.00, 9800.0, 500
        );

        Van van = new Van(
            "DEF-9012", "Ford Transit", 2021,
            280.00, 61000.0, 15
        );

        
        van.setStatus(StatusVeiculo.MANUTENCAO);

        sistema.adicionarVeiculo(carro);
        sistema.adicionarVeiculo(moto);
        sistema.adicionarVeiculo(van);

        

        AluguelBasico planoBasico = new AluguelBasico(
            "Joao Silva", "01/06/2026", "05/06/2026"
        );

        AluguelExecutivo planoExecutivo = new AluguelExecutivo(
            "Maria Oliveira", "10/06/2026", "17/06/2026"
        );

       
        planoBasico.adicionarVeiculo(carro);

        sistema.adicionarAluguel(planoBasico);
        sistema.adicionarAluguel(planoExecutivo);

        System.out.println("=========================================");
        System.out.println("  Sistema de Aluguel de Automoveis");
        System.out.println("=========================================");
        System.out.println("Dados iniciais carregados:");
        System.out.println("  - 3 veiculos cadastrados (Carro, Moto, Van)");
        System.out.println("  - 2 alugueis cadastrados (Basico, Executivo)");
        System.out.println("  - Van em manutencao (use opcao 7 para remover)");
        System.out.println("=========================================");
    }

    
    private static void executarMenu(Sistema sistema, Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=========================================");
            System.out.println("             MENU PRINCIPAL");
            System.out.println("=========================================");
            System.out.println("  1. Associar veiculo a um aluguel");
            System.out.println("  2. Exibir todos os veiculos");
            System.out.println("  3. Exibir todos os alugueis");
            System.out.println("  4. Exibir veiculos disponiveis");
            System.out.println("  5. Avaliar veiculo ou aluguel executivo");
            System.out.println("  6. Realizar inspecao em veiculo");
            System.out.println("  7. Remover veiculos em manutencao");
            System.out.println("  0. Sair");
            System.out.println("=========================================");
            System.out.print("Opcao: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Digite um numero de 0 a 7.");
                continue;
            }

            switch (opcao) {
                case 1 -> sistema.associarVeiculoAoAluguel();
                case 2 -> sistema.exibirTodosVeiculos();
                case 3 -> sistema.exibirTodosAlugueis();
                case 4 -> sistema.exibirVeiculosDisponiveis();
                case 5 -> sistema.avaliarObjeto();
                case 6 -> sistema.realizarInspecao();
                case 7 -> sistema.removerVeiculosEmManutencao();
                case 0 -> System.out.println("Encerrando o sistema. Ate logo!");
                default -> System.out.println("Opcao invalida. Escolha entre 0 e 7.");
            }
        }
    }
}
