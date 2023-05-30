import java.util.Scanner;

public class P1 {

  public void run() {
    // escreva o código da resposta aqui.
    int n1, n2;
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite dois numeros inteiros para descobrirmos o maior!");
    n1 =  sc.nextInt();
    n2 =  sc.nextInt();
    if(n1 == n2){
      System.out.println("Erro! - Digite numeros diferentes");
      run();
    }
    else{
      if(n1>n2){
        System.out.println("Maior numero: " + n1);
        
      }
      else if (n1<n2){
        System.out.println("Maior numero: " + n2);
      }
    }
    sc.close();
  }

}