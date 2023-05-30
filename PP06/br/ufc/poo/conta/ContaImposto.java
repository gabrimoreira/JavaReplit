package br.ufc.poo.conta;

public class ContaImposto extends ContaAbstrata {
  private double taxa = 0.001;

  public ContaImposto(String numero) {
    super(numero);
  }

  public void debitar(double valor) {
    if (valor >= 0.0) {
      double valorAcrescidoTaxa = (valor + (valor * this.taxa));
      if (this.saldo >= valorAcrescidoTaxa) {
        this.saldo = this.saldo - valorAcrescidoTaxa;
      }
    }
  }

  public double getTaxa() {
    return this.taxa;
  }

  public void setTaxa(double taxa) {
    if (taxa >= 0.0) {
      this.taxa = taxa;
    }
  }
}