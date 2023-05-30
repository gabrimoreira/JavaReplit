package br.ufc.poo.conta;

import br.ufc.poo.conta.excecao.TNPException;
import br.ufc.poo.conta.excecao.VNException;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(String numero) {
    super(numero);
  }

  public void renderJuros(double taxa) throws TNPException, VNException {
    if (taxa >= 0.0) {
      super.creditar(getSaldo() * taxa);
    }
    else{
      throw new TNPException(taxa, numero);
    }
  }

}