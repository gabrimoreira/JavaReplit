import java.util.Scanner;
import java.lang.Math;
public class P4 {

  public void run() {
    // escreva o código da resposta aqui.
    Scanner sc = new Scanner(System.in);
    float a, b, c;
    double delta;

    System.out.println("Vamos calcular as raizes de uma equacao do grau 2!");
    
    System.out.println("Digite o valor de a: ");
    a = sc.nextFloat();

    System.out.println("Digite o valor de b: ");
    b = sc.nextFloat();
    
    System.out.println("Digite o valor de c: ");
    c = sc.nextFloat();

    delta = Math.pow(b,2) - (4*a*c);

    if(delta < 0){
      System.out.println("ERRO! - Valor nao real!");
    }
    else if(delta == 0){
      double raiz = (-b)/(2*a);
      System.out.println("Existe apenas uma raiz e eh: " + raiz);
    }
    else if(delta > 0){
      double raiz1 = ((-b) + Math.sqrt(delta))/(2*a);
      double raiz2 = ((-b) - Math.sqrt(delta))/(2*a);

      System.out.println("Existem 2 raizes, sao elas: " + raiz1 + "  " + raiz2);
    }

    sc.close();
  }

}