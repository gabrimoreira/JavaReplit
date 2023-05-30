package br.ufc.poo.conta;

import br.ufc.poo.conta.excecao.SIException;
import br.ufc.poo.conta.excecao.TNIException;

public class ContaImposto extends ContaAbstrata {
  private double taxa = 0.001;

  public ContaImposto(String numero) {
    super(numero);
  }

public void debitar(double valor) throws SIException {
    if (valor >= 0.0) {
        double valorAcrescidoTaxa = (valor + (valor * this.taxa));
        if (this.saldo >= valorAcrescidoTaxa) {
            this.saldo = this.saldo - valorAcrescidoTaxa;
        } else {
            throw new SIException(saldo,numero);
        }
    }
}


  public double getTaxa() {
    return this.taxa;
  }

  public void setTaxa(double taxa)  throws TNIException {
    if (taxa >= 0.0) {
      this.taxa = taxa;
    }
    else{
      throw new TNIException(numero, taxa);
    }
  }
}