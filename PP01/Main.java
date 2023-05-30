import java.util.Scanner;


class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha o passo da prática a ser executado.");
    System.out.println("- 1 para Passo 1\n- 2 para Passo 2\n- 3 para Passo 3\n- 4 para Passo 4");
    System.out.print("Digite a opção: ");
    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1:
        P1 passo1 = new P1();
        passo1.run();
        break;

      case 2:
        P2 passo2 = new P2();
        passo2.run();
        break;

      case 3:
        P3 passo3 = new P3();
        passo3.run();
        break;

      case 4:
        P4 passo4 = new P4();
        passo4.run();
        break;
      default:
        System.out.println("Passo inexistente!");
    }
    scanner.close();
  }
}