package br.ufc.poo.conta.excecao;

public class VNException extends Exception {
  private String numero;
  private double valor;

  public VNException(String numero, double valor) {
    super("Exceção de Valor Negativo [Numero: " + numero + ", Valor: " + valor + "]");
    this.numero = numero;
    this.valor = valor;
  }

  public String getNumero() {
    return this.numero;
  }

  public double getValor() {
    return this.valor;
  }
}