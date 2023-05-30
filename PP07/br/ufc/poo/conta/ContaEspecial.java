package br.ufc.poo.conta;

import br.ufc.poo.conta.excecao.PNBException;
import br.ufc.poo.conta.excecao.VNException;

public class ContaEspecial extends Conta {
  private double bonus;
  private double percentagem = 0.01;

  public ContaEspecial(String numero) {
    super(numero);
    this.bonus = 0.0;
  }

  public void renderBonus() throws VNException{
    super.creditar(this.bonus);
    this.bonus = 0.0;
  }

  public void creditar(double valor) throws VNException{
    if (valor >= 0) {
      this.bonus = this.bonus + (valor * this.percentagem);
      super.creditar(valor);
    }
    else{
      throw new VNException(numero,valor);
    }
  }

  public double getBonus() {
    return this.bonus;
  }

  public double getBonusPercentagem() {
    return this.percentagem;
  }

  public void setBonusPercentagem(double percentagem) throws PNBException {
    if (percentagem >= 0) {
      this.percentagem = percentagem;
    }
    else{
      throw new PNBException(numero, percentagem);
    }
  }
}