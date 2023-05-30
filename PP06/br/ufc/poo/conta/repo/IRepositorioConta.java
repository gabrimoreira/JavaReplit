package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;

public interface IRepositorioConta {

  public void inserir(ContaAbstrata conta);

  public void remover(String numero);

  public boolean existe(String numero);

  public ContaAbstrata procurar(String numero);

  public ContaAbstrata[] listar();

  public int tamanho();

}