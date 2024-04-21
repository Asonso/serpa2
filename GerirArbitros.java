import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class GerirArbitros {
    private static List<Arbitro> arbitros = new ArrayList<>();

    public static List<Arbitro> getArbitros() {
        return arbitros;
    }
 
    public static boolean arbitroEstaEmTorneio(Arbitro arbitro) {
        // Verifica se o árbitro está presente no mainBracket ou no losersBracket de algum torneio
        for (Torneio torneio : GerirTorneios.getTorneios()) {
            if (torneio.getArbitros().contains(arbitro)) {
                return true; // O árbitro está em algum torneio
            }
        }
        return false; // O árbitro não está em nenhum torneio
    }
    
    
    public static void criarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Insira o nome do Arbitro: ");
        String nome = scanner.nextLine();
  // Limpar o buffer do scanner
 
        List<Desporto> desportos = new ArrayList<>();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Desportos disponíveis:");
            for (Desporto d : Desporto.values()) {
                System.out.println("- " + d.name());
            }
            System.out.print("Insira um desporto que o Arbitro esta alocado (ou digite 'fim' para terminar): ");            
            System.out.println();
            String desportoInput = scanner.nextLine().toUpperCase();
            if (desportoInput.equals("FIM")) {
                if (desportos.isEmpty()) {
                    System.out.println();
                    System.out.println("É necessário inserir pelo menos um desporto.");
                } else {
                    continuar = false;
                }
            } else {
                boolean encontrado = false;
                for (Desporto d : Desporto.values()) {
                    if (desportoInput.equals(d.name())) {
                        desportos.add(d);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Desporto inválido. Por favor, insira um desporto válido.");
                }
            }
        }
 
        Arbitro Arbitro = new Arbitro(nome, desportos, 0);
        arbitros.add(Arbitro);
    }
 
    public static void modificarArbitro(Scanner scanner) {
        if (arbitros.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem arbitros registrados.");
            return;
        }
 
       
        System.out.println();
        System.out.println("Lista de Arbitros:");
        for (Arbitro Arbitro : arbitros) {
            System.out.println("(" + Arbitro.getId() + ") - " + Arbitro.getNome());
        }
 
        while (true) {
            System.out.println();
            System.out.println("Insira o ID do Arbitro que deseja modificar (ou digite 'voltar' para retornar):");
            String input = scanner.nextLine();
 
            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operaçao cancelada.");
                return; // Voltar ao menu anterior
            }
 
            try {
                int id = Integer.parseInt(input);
                // Verificar se o Arbitro com o ID especificado existe
                boolean arbitroEncontrado = false;
                for (Arbitro Arbitro : arbitros) {
                    if (Arbitro.getId() == id) {
                        arbitroEncontrado = true;

                        if (arbitroEstaEmTorneio(Arbitro)) {
                            System.out.println("Este árbitro está associado a um torneio e não pode ser modificado.");
                            return; // Sai do método sem modificar o árbitro
                        }

                        System.out.println();
                        System.out.println("Insira o novo nome do Arbitro:");
                        String nome = scanner.nextLine();
                                                                           
                        List<Desporto> desportos = Arbitro.getDesportos();
                        desportos.clear();
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("Desportos disponíveis:");
                            for (Desporto d : Desporto.values()) {
                                System.out.println("- " + d.name());
                            }
                            System.out.print("Insira um desporto que o Arbitro esta alocado (ou digite 'fim' para terminar): ");            
                            System.out.println();
                            String desportoInput = scanner.nextLine().toUpperCase();
                            if (desportoInput.equals("FIM")) {
                                if (desportos.isEmpty()) {
                                    System.out.println();
                                    System.out.println("É necessário inserir pelo menos um desporto.");
                                } else {
                                    continuar = false;
                                }
                            } else {
                                boolean encontrado = false;
                                for (Desporto d : Desporto.values()) {
                                    if (desportoInput.equals(d.name())) {
                                        desportos.add(d);
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Desporto inválido. Por favor, insira um desporto válido.");
                                }
                            }
                        }
 
                        Arbitro.setNome(nome);
                        System.out.println("Arbitro modificado com sucesso.");
                        return; // Sai do método após modificar o Arbitro
                    }
                }
 
                if (!arbitroEncontrado) {
                    System.out.println("Arbitro nao encontrado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }
 
    public static void apagarArbitro(Scanner scanner) {
 
        if (arbitros.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem arbitros para apagar.");
            return;
        }
 
        System.out.println();
        System.out.println("Lista de Arbitros:");
        for (Arbitro Arbitro : arbitros) {
            System.out.println("(" + Arbitro.getId() + ") - " + Arbitro.getNome());
        }
       
        while (true) {
            System.out.println();
            System.out.println("Insira o ID do Arbitro que deseja apagar (ou digite 'voltar' para retornar):");
            String input = scanner.nextLine();
           
            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operaçao cancelada.");
                return; // Voltar ao menu anterior
            }
           
            try {
                int id = Integer.parseInt(input);
                // Verificar se o Arbitro com o ID especificado existe
                for (int i = 0; i < arbitros.size(); i++) {
                    if (arbitros.get(i).getId() == id) {

                        if (arbitroEstaEmTorneio(arbitros.get(i))) {
                            System.out.println("Este árbitro está associado a um torneio e não pode ser apagado.");
                            return; // Sai do método sem apagar o árbitro
                        }

                        System.out.println("Tem certeza que deseja apagar o Arbitro '" + arbitros.get(i).getNome() + "'? (s/n)");
                        String confirmacao = scanner.nextLine().toLowerCase();
                        if (confirmacao.equals("s")) {
                            arbitros.remove(i);
                            System.out.println("Arbitro removido com sucesso.");
                        } else {
                            System.out.println("Operaçao cancelada. O Arbitro nao foi removido.");
                        }
                        return; // Sai do método após apagar ou cancelar a operaçao
                    }
                }
                // Se o Arbitro com o ID especificado nao for encontrado
                System.out.println("Arbitro nao encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }
   
    public static void mostrarTodosArbitros() {
        if (arbitros.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem árbitros registrados.");
        } else {
            System.out.println();
            System.out.println("Arbitros:");
            for (Arbitro arbitro : arbitros) {
                String desportosAsString = String.join(", ", arbitro.getDesportosAsString());
                System.out.println("(" + arbitro.getId() + ") - " + arbitro.getNome() +  ", Arbitra: " + desportosAsString);
                System.out.println("Arbitrou " + arbitro.getJogos() + " jogos\n");
            }
        }
    }
   
 
    public static void mostrarArbitrosPorDesporto(Scanner scanner) {
        System.out.println();
        System.out.println("Desportos existentes:");
        for (Desporto d : Desporto.values()) {
            System.out.println("- " + d.name());
        }
 
        System.out.print("Insira o desporto para visualizar os arbitros: ");
        String desportoInput = scanner.nextLine().toUpperCase();
        Desporto desportoDesejado = null;
 
        // Verificar se o desporto inserido existe
        for (Desporto d : Desporto.values()) {
            if (desportoInput.equals(d.name())) {
                desportoDesejado = d;
                break;
            }
        }
 
        // Se o desporto existir, mostrar arbitros que praticam esse desporto
        if (desportoDesejado != null) {
            boolean encontrouArbitros = false;
            System.out.println();
            System.out.println("Arbitros que podem arbitrar " + desportoDesejado.name() + ":");
            for (Arbitro Arbitro : arbitros) {
                if (Arbitro.getDesportosAsString().contains(desportoDesejado.name())) {
                    encontrouArbitros = true;
                    String desportosAsString = String.join(", ", Arbitro.getDesportosAsString());
                    System.out.println("(" + Arbitro.getId() + ") - " + Arbitro.getNome() + ", Arbitra: " + desportosAsString);
                    System.out.println("Arbitrou " + Arbitro.getJogos() + " jogos\n");
                }
            }
            if (!encontrouArbitros) {
                System.out.println("Nenhum Arbitro pode arbitrar " + desportoDesejado.name() + ".");
            }
        } else {
            System.out.println("Desporto inválido.");
        }
    }

    public static void criarArbitrosFromFile() {
        String fileName = "arbitros.txt"; // Nome do arquivo dos árbitros

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");

                // Primeiro token é o nome do árbitro
                String nome = tokens[0];

                // Restante dos tokens são os desportos do árbitro
                List<Desporto> desportos = new ArrayList<>();
                for (int i = 1; i < tokens.length; i++) {
                    Desporto desporto = Desporto.valueOf(tokens[i].toUpperCase());
                    desportos.add(desporto);
                }

                // Cria o árbitro com as informações lidas e adiciona à lista de árbitros
                Arbitro arbitro = new Arbitro(nome, desportos, 0);
                arbitros.add(arbitro);
            }

            System.out.println("Árbitros criados a partir do arquivo com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Desporto inválido encontrado no arquivo.");
        }
    }

}