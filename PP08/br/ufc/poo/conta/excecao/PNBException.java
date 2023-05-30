package br.ufc.poo.conta.excecao;

public class PNBException extends Exception {
  private String numero;
  private double percentagem;

  public PNBException(String numero, double percentagem) {
    super("Exceção de Percentagem Negativa do Bonus [Numero: " + numero + ", Percentagem: " + percentagem + "]");
    this.numero = numero;
    this.percentagem = percentagem;
  }

  public String getNumero() {
    return this.numero;
  }

  public double getPercentagem() {
    return this.percentagem;
  }
}