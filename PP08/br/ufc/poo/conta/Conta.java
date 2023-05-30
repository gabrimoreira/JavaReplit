package br.ufc.poo.conta;

import br.ufc.poo.conta.excecao.SIException;
import br.ufc.poo.conta.excecao.VNException;

public class Conta extends ContaAbstrata {

  public Conta(String numero) {
    super(numero);
  }

  public void debitar(double valor) throws SIException, VNException {
    if (valor < 0.0) {
      throw new VNException(this.numero, valor);
    }

    if (valor > this.saldo) {
      throw new SIException(this.numero, this.saldo);
    }

    this.saldo = this.saldo - valor;
  }
}