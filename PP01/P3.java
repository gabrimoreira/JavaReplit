import java.util.Scanner;

public class P3 {

  public void run() {
    // escreva o código da resposta aqui.
    Scanner sc = new Scanner(System.in);
    float n1, n2;
    char operacao;
    
    System.out.println("Vamos utilizar uma calculadora!");
    
    System.out.println("Digite 2 numeros: ");
    n1 = sc.nextFloat();
    n2 = sc.nextFloat();
    sc.nextLine();
    
    System.out.println("Digite a operacao que deseja: ");
    operacao = sc.next().charAt(0);

    switch(operacao){
      case '+':
      System.out.println("Resultado da soma: " + (n1+n2));
      break;
    }

    switch(operacao){
      case '*':
      System.out.println("Resultado da multiplicacao: " + (n1*n2));
        break;
    }

    switch(operacao){
      case '/':
      System.out.println("Resultado da divisao: " + (n1/n2));
        break;
    }

    switch(operacao){
      case '-':
      System.out.println("Resultado da subtracao: " + (n1-n2));
        break;
      default:
        System.out.println("Operacao invalida!");
    }

  }

}