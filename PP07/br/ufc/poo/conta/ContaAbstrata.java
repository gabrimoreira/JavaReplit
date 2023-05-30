package br.ufc.poo.conta;
import br.ufc.poo.conta.excecao.SIException;
import br.ufc.poo.conta.excecao.VNException;

public abstract class ContaAbstrata {
  protected String numero;
  protected double saldo;

  public ContaAbstrata(String numero) {
    this.numero = numero;
    this.saldo = 0.0;
  }

  public void creditar(double valor) throws VNException {
    if (valor >= 0.0) {
      this.saldo = this.saldo + valor;
    }
    else{
      throw new VNException(numero,valor);
    }
  }

  public abstract void debitar(double valor) throws SIException, VNException;

  public String getNumero() {
    return this.numero;
  }

  public double getSaldo() {
    return this.saldo;
  }
}