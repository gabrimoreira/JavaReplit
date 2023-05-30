package br.ufc.poo.conta;

import br.ufc.poo.conta.excecao.TNPException;
import br.ufc.poo.conta.excecao.VNException;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(String numero) {
    super(numero);
  }

  public void renderJuros(double taxa) throws TNPException {
    try {
      super.creditar(getSaldo() * taxa);
    } catch (VNException vne) {
      throw new TNPException(this.numero, taxa);
    }
  }
}