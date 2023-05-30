package br.ufc.poo.banco;

import br.ufc.poo.conta.ContaAbstrata;

import br.ufc.poo.banco.excecao.TIException;
import br.ufc.poo.conta.excecao.PNBException;
import br.ufc.poo.conta.excecao.SIException;
import br.ufc.poo.conta.excecao.TNIException;
import br.ufc.poo.conta.excecao.TNPException;
import br.ufc.poo.conta.excecao.VNException;
import br.ufc.poo.conta.repo.excecao.CEException;
import br.ufc.poo.conta.repo.excecao.CIException;

public interface IBanco {

  public void cadastrar(ContaAbstrata conta) throws PNBException, TNIException, CEException;

  public void fechar(String numero) throws CIException;

  public void creditar(String numero, double valor) throws VNException;

  public void debitar(String numero, double valor) throws SIException, VNException;

  public void transferir(String origem, String destino, double valor) throws TIException;

  public double saldo(String numero);

  public void renderJuros(String numero) throws TNPException;

  public void renderBonus(String numero);

  public void setTaxaPoupanca(double valor);

  public double getTaxaPoupanca();

  public void setTaxaImposto(double valor) throws TNIException;

  public double getTaxaImposto();

  public void setBonusPercentagemGeral(double valor) throws PNBException;

  public double getBonusPercentagemGeral();

  public void setBonusPercentagemConta(String numero, double valor) throws PNBException;

  public double getBonusPercentagemConta(String numero);
}