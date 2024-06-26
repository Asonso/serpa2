/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */

 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.util.Scanner;
 
 public class Validacoes {
 
     /**
      * Verifica se a data fornecida é válida e posterior à data atual.
      *
      * @param data      A data a ser validada
      * @return true se a data for válida e posterior à data atual, false caso contrário
      */
     public static boolean dataValida(String data) {
         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         try {
             LocalDate dataDigitada = LocalDate.parse(data, dateFormatter);
             LocalDate dataAtual = LocalDate.now();
 
             if (dataDigitada.isBefore(dataAtual)) {
                 System.out.println("A data deve ser posterior à data atual.");
                 return false;
             }
 
             return true;
         } catch (Exception e) {
             System.out.println("Formato de data inválido.");
             return false;
         }
     }
 
     /**
      * Valida o desporto inserido pelo utilizador.
      *
      * @param scanner       O scanner utilizado para ler a entrada do utilizador
      * @return O desporto validado
      */
    public static Desporto validarDesporto(Scanner scanner) {
        Desporto desportoEscolhido = null;
        boolean desportoValido = false;

        while (!desportoValido) {
            System.out.println("\nDesportos disponíveis:");
            for (Desporto d : Desporto.values()) {
                System.out.println("- " + d.name());
            }
            System.out.print("Escolha o desporto: ");
            String inputDesporto = scanner.next();

            try {
                desportoEscolhido = Desporto.valueOf(inputDesporto.toUpperCase());
                desportoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Desporto inválido. Por favor, escolha um desporto da lista.");
            }
        }

        return desportoEscolhido;
    }
 }
 