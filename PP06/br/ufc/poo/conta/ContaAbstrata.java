package br.ufc.poo.conta;

public abstract class ContaAbstrata {
  protected String numero;
  protected double saldo;

  public ContaAbstrata(String numero) {
    this.numero = numero;
    this.saldo = 0.0;
  }

  public void creditar(double valor) {
    if (valor >= 0.0) {
      this.saldo = this.saldo + valor;
    }
  }

  public abstract void debitar(double valor);

  public String getNumero() {
    return this.numero;
  }

  public double getSaldo() {
    return this.saldo;
  }
}