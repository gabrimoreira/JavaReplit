package br.ufc.poo.conta.repo.excecao;

public class CIException extends Exception {
  private String numero;

  public CIException(String numero) {
    super("Exceção de Conta Inexistente [Numero: " + numero + "]");
    this.numero = numero;
  }

  public String getNumero() {
    return this.numero;
  }
}