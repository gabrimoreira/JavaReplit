package br.ufc.poo.conta.excecao;

public class SIException extends Exception {
  private String numero;
  private double saldo;

  public SIException(String numero, double saldo) {
    super("Exceção de Saldo Insuficiente [Numero: " + numero + ", Saldo: " + saldo + "]");
    this.numero = numero;
    this.saldo = saldo;
  }

  public String getNumero() {
    return this.numero;
  }

  public double getSaldo() {
    return this.saldo;
  }
}