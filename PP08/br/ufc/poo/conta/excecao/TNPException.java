package br.ufc.poo.conta.excecao;

public class TNPException extends Exception {
  private String numero;
  private double taxa;

  public TNPException(String numero, double taxa) {
    super("Exceção de Taxa Negativa da Poupanca [Numero: " + numero + ", Taxa: " + taxa + "]");
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