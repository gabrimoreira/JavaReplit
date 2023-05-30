package br.ufc.poo.banco;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.ContaEspecial;
import br.ufc.poo.conta.ContaImposto;
import br.ufc.poo.conta.ContaPoupanca;

import br.ufc.poo.conta.repo.IRepositorioConta;

import br.ufc.poo.banco.excecao.TIException;
import br.ufc.poo.conta.excecao.*;
import br.ufc.poo.conta.repo.excecao.*;

public class BancoIndependente implements IBanco, IAuditavel {
  private IRepositorioConta repositorio;
  private double taxaPoupanca = 0.01;
  private double taxaImposto = 0.01;
  private double bonusPercentagem = 0.01;

  public BancoIndependente(IRepositorioConta repositorio) {
    this.repositorio = repositorio;
  }

  public double saldoTotal() {
    double saldoTotal = 0.0;
    for (ContaAbstrata conta : this.repositorio.listar()) {
      saldoTotal += conta.getSaldo();
    }
    return saldoTotal;
  }

  public int numeroContas() {
    return this.repositorio.tamanho();
  }

  public void cadastrar(ContaAbstrata conta) throws PNBException, TNIException, CEException {
    if (conta instanceof ContaEspecial) {
      ((ContaEspecial) conta).setBonusPercentagem(this.bonusPercentagem);
    }

    if (conta instanceof ContaImposto) {
      ((ContaImposto) conta).setTaxa(this.taxaImposto);
    }

    this.repositorio.inserir(conta);
  }

  public void fechar(String numero) throws CIException {
    this.repositorio.remover(numero);
  }

  public void creditar(String numero, double valor) throws VNException{
    ContaAbstrata conta = this.repositorio.procurar(numero);
    conta.creditar(valor);
  }

  public void debitar(String numero, double valor) throws SIException, VNException {
    ContaAbstrata conta = this.repositorio.procurar(numero);
    conta.debitar(valor);
  }

  public double saldo(String numero) {
    ContaAbstrata conta = this.repositorio.procurar(numero);
    return conta.getSaldo();
  }

  
  //Acredito que seja um erro tratar o erro CIException aqui, visto que, ele nunca vai ser atingido nesse método, já que ele é levantado somente no método remover.
  public void transferir(String origem, String destino, double valor) throws TIException{
    ContaAbstrata contaOrigem = this.repositorio.procurar(origem);
    ContaAbstrata contaDestino = this.repositorio.procurar(destino);
    try{
    contaOrigem.debitar(valor);
    contaDestino.creditar(valor);
    }catch (SIException e) {
        throw new TIException(e);
    } catch (VNException e) {
        throw new TIException(e);
    }
  }

  public void renderJuros(String numero) throws TNPException, VNException{
    ContaAbstrata conta = this.repositorio.procurar(numero);
    if (conta instanceof ContaPoupanca) {
      ((ContaPoupanca) conta).renderJuros(this.taxaPoupanca);
    }
  }

  public void renderBonus(String numero) throws VNException {
    ContaAbstrata conta = this.repositorio.procurar(numero);
    if (conta instanceof ContaEspecial) {
      ((ContaEspecial) conta).renderBonus();
    }
  }

  public void setTaxaPoupanca(double valor) {
    this.taxaPoupanca = valor;
  }

  public double getTaxaPoupanca() {
    return this.taxaPoupanca;
  }

  public void setTaxaImposto(double valor) throws TNIException {
    this.taxaImposto = valor;
    for (ContaAbstrata conta : this.repositorio.listar()) {
      if (conta instanceof ContaImposto) {
        ((ContaImposto) conta).setTaxa(this.taxaImposto);
      }
    }

  }

  public double getTaxaImposto() {
    return this.taxaImposto;
  }

  public void setBonusPercentagemGeral(double valor) throws PNBException {
    this.bonusPercentagem = valor;
    for (ContaAbstrata conta : this.repositorio.listar()) {
      if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).setBonusPercentagem(this.bonusPercentagem);
      }
    }
  }

  public double getBonusPercentagemGeral() {
    return this.bonusPercentagem;
  }

  public void setBonusPercentagemConta(String numero, double valor) throws PNBException {
    ContaAbstrata conta = this.repositorio.procurar(numero);
    ((ContaEspecial) conta).setBonusPercentagem(valor);

  }

  public double getBonusPercentagemConta(String numero) {
    ContaAbstrata conta = this.repositorio.procurar(numero);
    return ((ContaEspecial) conta).getBonusPercentagem();
  }
}