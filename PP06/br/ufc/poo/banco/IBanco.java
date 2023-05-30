package br.ufc.poo.banco;

import br.ufc.poo.conta.ContaAbstrata;

public interface IBanco {

  public void cadastrar(ContaAbstrata conta);

  public void fechar(String numero);

  public void creditar(String numero, double valor);

  public void debitar(String numero, double valor);

  public void transferir(String origem, String destino, double valor);

  public double saldo(String numero);

  public void renderJuros(String numero);

  public void renderBonus(String numero);

  public void setTaxaPoupanca(double valor);

  public double getTaxaPoupanca();

  public void setTaxaImposto(double valor);

  public double getTaxaImposto();

  public void setBonusPercentagemGeral(double valor);

  public double getBonusPercentagemGeral();

  public void setBonusPercentagemConta(String numero, double valor);

  public double getBonusPercentagemConta(String numero);
}