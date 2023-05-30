package br.ufc.poo.conta;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(String numero) {
    super(numero);
  }

  public void renderJuros(double taxa) {
    if (taxa >= 0.0) {
      super.creditar(getSaldo() * taxa);
    }
  }

}