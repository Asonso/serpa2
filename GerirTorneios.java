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
 import java.util.ArrayList;
 import java.util.List;
 
 
 public class GerirTorneios {
     private static List<Torneio> torneios = new ArrayList<>();
     private static int contadorTorneios = 0;
 
     /**
      * Apaga um torneio da lista de torneios.
      */
      public static void apagarTorneios(Scanner scanner) {

        if (torneios.isEmpty()) {
            System.out.println("Não existem torneios para apagar.");
            return;
        }

        while (true) {
            System.out.println("Insira o ID do torneio que deseja apagar (ou digite 'voltar' para retornar):");

            for (int i = 0; i < torneios.size(); i++) {
                System.out.println((i + 1) + ". " + torneios.get(i).getDesporto() + " - " + torneios.get(i).getData());
            }

            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operação cancelada.");
                return; // Voltar ao menu anterior
            }
        
            try {
                int id = Integer.parseInt(input);
                // Verificar se o jogador com o ID especificado existe
                for (int i = 0; i < torneios.size(); i++) {
                    if (torneios.get(i).getId() == id) {
                        System.out.println("Tem certeza que deseja apagar o torneio '" + torneios.get(i).getDesporto() + ", " + torneios.get(i).getData() + "'? (s/n)");
                        String confirmacao = scanner.nextLine().toLowerCase();
                        if (confirmacao.equals("s")) {
                            torneios.remove(i);
                            System.out.println("Torneio removido com sucesso.");
                        } else {
                            System.out.println("Operação cancelada. O torneio não foi removido.");
                        }
                        return; // Sai do método após apagar ou cancelar a operação
                    }
                }
                // Se o jogador com o ID especificado não for encontrado
                System.out.println("Torneio não encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
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
 
         int tipoTorneio = 0;
 
         do {
             try {
                 tipoTorneio = scanner.nextInt();
                 if (tipoTorneio != 1 && tipoTorneio != 2) {
                     System.out.println("Insira '1' ou '2'.");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Insira '1' ou '2'.");
                 scanner.nextLine(); 
             }
         } while (tipoTorneio !=1 && tipoTorneio !=2);
 
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
             Torneio novoTorneio = new Torneio(desporto.toString(), data, local, numeroEquipas, 0, "Knockout");
             torneios.add(novoTorneio);
             contadorTorneios++;
         } else if (tipoTorneio == 2) {
             Torneio novoTorneio = new Torneio(desporto.toString(), data, local, numeroEquipas, 0, "DoubleKnockout");
             torneios.add(novoTorneio);
             contadorTorneios++;
         } else {
             System.out.println("Tipo de torneio inválido. Torneio nao criado.");
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
 
         do {
             try {
                 System.out.print("Digita o número de participantes: ");
                 numeroParticipantes = scanner.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Insira um número válido para o número de participantes.");
                 scanner.nextLine();
                 numeroParticipantes = -1;
             }
         } while (numeroParticipantes <= 0);
 
         String data;
         do {
             System.out.print("Digita a data (formato dd-MM-aaaa): ");
             data = scanner.next();
         } while (!Validacoes.dataValida(data));
 
         Desporto desporto = Validacoes.validarDesporto(scanner);
 
         System.out.print("Digita o local: ");
         String local = scanner.next();
 
         if (tipoTorneio == 1) {
             Torneio novoTorneio = new Torneio(desporto.toString(), data, local, 0, numeroParticipantes, "Knockout");
             torneios.add(novoTorneio);
             contadorTorneios++;
         } else if (tipoTorneio == 2) {
             Torneio novoTorneio = new Torneio(desporto.toString(), data, local, 0, numeroParticipantes, "DoubleKnockout");
             torneios.add(novoTorneio);
             contadorTorneios++;
         }
     }
     /**
      * Mostra os detalhes dos torneios armazenados no sistema, permitindo ao utilizador escolher se deseja mostrar todos os torneios ou apenas um específico.
      * 
      */
     
     public static void mostrarTorneios() {
         Scanner scanner = new Scanner(System.in);
     
         if (contadorTorneios == 0) {
             System.out.println("Nao existem torneios para mostrar.");
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
                 System.out.println((i + 1) + ". " + torneios.get(i).getDesporto() + " - " + torneios.get(i).getData());
             }
             int numeroTorneio = scanner.nextInt();
             dadosTorneio(numeroTorneio - 1);
         } else {
             System.out.println("Opçao inválida.");
         }
     }
     
     /**
      * Mostra os detalhes de um torneio específico com base no índice fornecido.
      * 
      * @param indice O índice do torneio a ser mostrado
      */
     private static void dadosTorneio(int indice) {
         System.out.println("Torneio " + (indice + 1) + ":");
         System.out.println("Desporto: " + torneios.get(indice).getDesporto());
         System.out.println("Data: " + torneios.get(indice).getData());
         System.out.println("Local: " + torneios.get(indice).getLocal());
         
         if (torneios.get(indice).getTipo().equals("Knockout")) {
             System.out.println("Tipo: Knockout");
         } else if (torneios.get(indice).getTipo().equals("DoubleKnockout")) {
             System.out.println("Tipo: Double Knockout");
         }
         
         if (torneios.get(indice).getNumeroEquipas() > 0) {
             System.out.println("Número de Equipas: " + torneios.get(indice).getNumeroEquipas());
         } else {
             System.out.println("Número de Participantes: " + torneios.get(indice).getNumeroParticipantes());
         }
         
         System.out.println();
     }
 }