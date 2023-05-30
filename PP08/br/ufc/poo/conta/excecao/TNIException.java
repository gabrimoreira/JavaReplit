package br.ufc.poo.conta.excecao;

public class TNIException extends Exception {
  private String numero;
  private double taxa;

  public TNIException(String numero, double taxa) {
    super("Exceção de Taxa Negativa do Imposto [Numero: " + numero + ", Percentagem: " + taxa + "]");
    this.numero = numero;
    this.taxa = taxa;
  }

  public String getNumero() {
    return this.numero;
  }

  public double getTaxa() {
    return this.taxa;
  }
}