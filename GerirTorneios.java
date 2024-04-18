/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;


public class GerirTorneios {
    private static Torneio[] torneios = new Torneio[100];
    private static int contadorTorneios = 0;
    private static int[][] resultados = new int[100][2]; // Array para armazenar resultados (índice do jogo -> resultado)
    /**
     * Apaga um torneio da lista de torneios.
     */
    public static void apagarTorneios() {
        Scanner scanner = new Scanner(System.in);

        if (contadorTorneios == 0) {
            System.out.println("Nao existem torneios para apagar.");
            return;
        }

        System.out.println("Selecione o torneio que queres apagar:");

        for (int i = 0; i < contadorTorneios; i++) {
            System.out.println((i + 1) + ". " + torneios[i].getDesporto() + " - " + torneios[i].getData());
        }

        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= contadorTorneios) {
            removerTorneio(escolha - 1);
            System.out.println("Torneio removido com sucesso.");
        } else {
            System.out.println("Esse torneio não existe.");
        }
    }

    private static void removerTorneio(int indice) {
        for (int i = indice; i < contadorTorneios ; i++) {
            torneios[i] = torneios[i + 1];
        }
        contadorTorneios--;
    }

    /**
     * Cria um novo torneio com base nas informações dadas pelo utilizador.
     *
     * @param scanner    O scanner é utilizado para ler as entradas do utilizador
     */
    public static void criarTorneio(Scanner scanner) {
        System.out.println("Escolhe o tipo de torneio:");
        System.out.println("1. Knockout");
        System.out.println("2. Double Knockout");
        System.out.print("Digita a tua escolha: ");

        int tipoTorneio = scanner.nextInt();

        System.out.print("O desporto é de equipa? (Digita 'sim' ou 'nao'): ");
        String resposta;

        do {
        resposta = scanner.next().toLowerCase();
            if (resposta.equals("sim")) {
                criarTorneioEquipa(scanner, tipoTorneio);
            } else if (resposta.equals("nao")) {
                criarTorneioIndividual(scanner, tipoTorneio);
            } else {
                System.out.println("Insira 'sim' ou 'nao'");
            }
        } while (!resposta.equals("sim") && !resposta.equals("nao"));
    }

    /**
     * Cria um novo torneio entre equipa com base nas informações dadas pelo utilizador.
     * 
     * @param scanner       O scanner é utilizado para ler as entradas do utilizador
     * @param tipoTorneio       O tipo de torneio selecionado pelo utilizador, Knockout/DoubleKnockout
     */
    private static void criarTorneioEquipa(Scanner scanner, int tipoTorneio) {

        
        int numeroEquipas;

        do {
            try {
                System.out.print("Digite o número de equipas: ");
                numeroEquipas = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.nextLine();
                numeroEquipas = -1;
            }
        } while (numeroEquipas <= 0);
        
        int elementosPorEquipa;
        
        do {
            try {
                System.out.print("Digite o número máximo de elementos por equipe: ");
                elementosPorEquipa = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.nextLine();
                elementosPorEquipa = -1;
            }
        } while (elementosPorEquipa <= 0);

        String data;
        do {
            System.out.print("Digita a data (formato dd-MM-aaaa): ");
            data = scanner.next();
        } while (!Validacoes.dataValida(data));

        Desporto desporto = Validacoes.validarDesporto(scanner);

        System.out.print("Digita o local: ");
        String local = scanner.next();

        if (tipoTorneio == 1) {
            Torneio novoTorneio = new Torneio(desporto.toString(), data, local, numeroEquipas, elementosPorEquipa, 0, "Knockout");
            torneios[contadorTorneios++] = novoTorneio;
        } else if (tipoTorneio == 2) {
            Torneio novoTorneio = new Torneio(desporto.toString(), data, local, numeroEquipas, elementosPorEquipa, 0, "DoubleKnockout");
            torneios[contadorTorneios++] = novoTorneio;
        } else {
            System.out.println("Tipo de torneio inválido. Torneio não criado.");
        }
    }

    /**
     * Cria um novo torneio individual com base nas informações fornecidas pelo utilizador.
     * 
     * @param scanner       O scanner é utilizado para ler as entradas do utilizador
     * @param tipoTorneio       O tipo de torneio selecionado pelo utilizador, Knockout/DOubleKnockout
     */
    private static void criarTorneioIndividual(Scanner scanner, int tipoTorneio) {
        
        int numeroParticipantes;

        try {
            System.out.print("Digita o número de participantes: ");
            numeroParticipantes = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Insira um número válido para o número de participantes.");
            return;
        }

        String data;
        do {
            System.out.print("Digita a data (formato dd-MM-aaaa): ");
            data = scanner.next();
        } while (!Validacoes.dataValida(data));

        Desporto desporto = Validacoes.validarDesporto(scanner);

        System.out.print("Digita o local: ");
        String local = scanner.next();

        if (tipoTorneio == 1) {
            Torneio novoTorneio = new Torneio(desporto.toString(), data, local, 0, 0, numeroParticipantes, "Knockout");
            torneios[contadorTorneios++] = novoTorneio;
        } else if (tipoTorneio == 2) {
            Torneio novoTorneio = new Torneio(desporto.toString(), data, local, 0, 0, numeroParticipantes, "DoubleKnockout");
            torneios[contadorTorneios++] = novoTorneio;
        } else {
            System.out.println("Tipo de torneio inválido.");
        }
    }

    /**
     * Mostra os detalhes dos torneios armazenados no sistema, permitindo ao utilizador escolher se deseja mostrar todos os torneios ou apenas um específico.
     * 
     */
    public static void mostrarTorneios() {
        Scanner scanner = new Scanner(System.in);
    
        if (contadorTorneios == 0) {
            System.out.println("Não existem torneios para mostrar.");
            return;
        }
    
        System.out.println("Prefere mostrar todos os torneios ou apenas um específico?");
        System.out.println("1. Todos os torneios");
        System.out.println("2. Mostrar torneio específico");
        System.out.print("Digita sua escolha: ");
    
        int escolha = scanner.nextInt();
    
        if (escolha == 1) {
            for (int i = 0; i < contadorTorneios; i++) {
                dadosTorneio(i);
            }
        } else if (escolha == 2) {
            System.out.println("Digita o número do torneio que deseja mostrar: ");
            for (int i = 0; i < contadorTorneios; i++) {
                System.out.println((i + 1) + ". " + torneios[i].getDesporto() + " - " + torneios[i].getData());
            }
            int numeroTorneio = scanner.nextInt();
            dadosTorneio(numeroTorneio - 1);
        } else {
            System.out.println("Opção inválida.");
        }
    }
    public static void registarResultado() {
        Scanner scanner = new Scanner(System.in);

        if (contadorTorneios == 0) {
            System.out.println("Não existem torneios para registrar resultados.");
            return;
        }

        System.out.println("Selecione o torneio para registrar resultado:");

        for (int i = 0; i < contadorTorneios; i++) {
            System.out.println((i + 1) + ". " + torneios[i].getDesporto() + " - " + torneios[i].getData());
        }

        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= contadorTorneios) {
            System.out.print("Digite o resultado do jogo (timeA timeB): ");
            int resultadoA = scanner.nextInt();
            int resultadoB = scanner.nextInt();

            // Armazena o resultado na matriz de resultados
            resultados[escolha - 1][0] = resultadoA;
            resultados[escolha - 1][1] = resultadoB;

            System.out.println("Resultado registrado com sucesso.");
        } else {
            System.out.println("Torneio não encontrado.");
        }
    }    

    public static void registrarResultado() {
        Scanner scanner = new Scanner(System.in);

        if (contadorTorneios == 0) {
            System.out.println("Não existem torneios para registrar resultados.");
            return;
        }

        System.out.println("Selecione o torneio para registrar resultado:");

        for (int i = 0; i < contadorTorneios; i++) {
            System.out.println((i + 1) + ". " + torneios[i].getDesporto() + " - " + torneios[i].getData());
        }

        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= contadorTorneios) {
            System.out.print("Digite o resultado do jogo (timeA timeB): ");
            int resultadoA = scanner.nextInt();
            int resultadoB = scanner.nextInt();

            // Armazena o resultado na matriz de resultados
            resultados[escolha - 1][0] = resultadoA;
            resultados[escolha - 1][1] = resultadoB;

            System.out.println("Resultado registrado com sucesso.");
        } else {
            System.out.println("Torneio não encontrado.");
        }
    }

    /**
     * Mostra os detalhes de um torneio específico com base no índice fornecido.
     * 
     * @param indice O índice do torneio a ser mostrado
     */
    private static void dadosTorneio(int indice) {
        System.out.println("Torneio " + (indice + 1) + ":");
        System.out.println("Desporto: " + torneios[indice].getDesporto());
        System.out.println("Data: " + torneios[indice].getData());
        System.out.println("Local: " + torneios[indice].getLocal());
        
        if (torneios[indice].getTipo().equals("Knockout")) {
            System.out.println("Tipo: Knockout");
        } else if (torneios[indice].getTipo().equals("DoubleKnockout")) {
            System.out.println("Tipo: Double Knockout");
        }
        
        if (torneios[indice].getNumeroEquipas() > 0) {
            System.out.println("Número de Equipas: " + torneios[indice].getNumeroEquipas());
            System.out.println("Elementos por Equipa: " + torneios[indice].getElementosPorEquipa());
        } else {
            System.out.println("Número de Participantes: " + torneios[indice].getNumeroParticipantes());
        }
        
        System.out.println();
    }
}