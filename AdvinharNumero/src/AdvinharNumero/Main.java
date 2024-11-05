package AdvinharNumero;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int nroPalpite = 0;
        int palpite = 0;
        int nroSorteado = 0;
        int numIni = 0;
        int numFim = 0;
        boolean jogar = true;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.printf("Bem vindo(a), %s!!", nome);

        while (jogar == true) {
            while (true) {
                try {
                    System.out.print("\n\nVamos começar o jogo, digite o valor inicial para ser sorteado um numero: ");
                    numIni = sc.nextInt();

                    System.out.print("Agora digite o valor final do intervalo do numero a ser sorteado: ");
                    numFim = sc.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número.");
                    sc.next();
                }
            }

            int min = Math.min(numIni, numFim);
            int max = Math.max(numIni, numFim);

            nroSorteado = random.nextInt(max - min + 1) + min;

            while (true) {
                try {
                    System.out.print("Digite o seu palpite: ");
                    palpite = sc.nextInt();

                    if (palpite == nroSorteado) {
                        nroPalpite++;
                        System.out.printf("\nParabens %s, você acertou o numero sorteado em %d tentativa(s)", nome,
                                nroPalpite);
                        System.out.printf("\nNúmero sorteado: %d", nroSorteado);
                        System.out.printf("\nSeu palpite:  %d", palpite);
                        System.out.printf("\nQuantidade de palpites:  %d", nroPalpite);
                        break;
                    } else if (palpite > nroSorteado) {
                        System.out.printf("Puxa %s, o número sorteado é menor que o palpitado, tente novamente.\n",
                                nome);
                        nroPalpite++;
                    } else {
                        System.out.printf("Puxa %s, o número sorteado é maior que o palpitado, tente novamente.\n",
                                nome);
                        nroPalpite++;
                    }

                    char opcao;

                    while (true) {
                        System.out.println("Deseja realizar outro palpite (s ou n)? ");
                        opcao = sc.next().toLowerCase().charAt(0);

                        if (opcao == 's' || opcao == 'n') {
                            break;
                        } else {
                            System.out.println("Opção inválida! Digite apenas 's' para sim ou 'n' para não.");
                        }
                    }

                    if (opcao == 'n') {
                        System.out.printf("\nObrigado por jogar, %s! O número sorteado era %d.\n", nome, nroSorteado);
                        System.out.printf("\nQuantidade de palpites:  %d", nroPalpite);
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número.");
                    sc.next();
                }
            }
            char jogarNov;

            while (true) {
                System.out.println("\nDeseja jogar novamente (s ou n)? ");
                jogarNov = sc.next().toLowerCase().charAt(0);

                if (jogarNov == 's' || jogarNov == 'n') {
                    break;
                } else {
                    System.out.println("Opção inválida! Digite apenas 's' para sim ou 'n' para não.");
                }
            }

            if (jogarNov == 'n') {
                System.out.printf("\nObrigado por jogar, %s.", nome);
                System.out.println("\nAté a próxima.");
                jogar = false;
            }
        }
        sc.close();
    }
}