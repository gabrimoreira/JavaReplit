import java.lang.Math;

public class Calculadora {
  public double resultado;

  public double adicionar(double operandoA, double operandoB) {
    resultado = operandoA + operandoB;
    System.out.println(toString());
    return -1;
  }

  public double subtrair(double operandoA, double operandoB) {
    resultado = operandoA - operandoB;
    System.out.println(toString());
    return -1;
  }

  public double multiplicar(double operandoA, double operandoB) {
    resultado = operandoA * operandoB;
    System.out.println(toString());
    return -1;
  }

  public double dividir(double operandoA, double operandoB) {
    resultado = operandoA/operandoB;
    System.out.println(toString());
    return -1;
  }

  public double potencia(double base, int expoente) {
    resultado = Math.pow(base,expoente);
    System.out.println(toString());
    return -1;
  }

  public double raiz(double valor) {
    resultado = Math.sqrt(valor);
    System.out.println(toString());
    return -1;
  }

  public double seno(double angulo) {
    angulo = Math.toRadians(angulo);
    resultado = Math.sin(angulo);
    System.out.println(toString());
    return -1;
  }

  public double coseno(double angulo) {
    angulo = Math.toRadians(angulo);
    resultado = Math.cos(angulo);
    System.out.println(toString());
    return -1;
  }

  public double tangente(double angulo) {
    angulo = Math.toRadians(angulo);
    resultado = Math.tan(angulo);
    System.out.println(toString());
    return -1;
  }

  public String toString(){
    return "Resposta: " + String.format("%.2f", resultado)+ "\n";
    
  } 
}