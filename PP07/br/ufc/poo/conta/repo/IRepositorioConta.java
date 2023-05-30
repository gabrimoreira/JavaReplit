package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.repo.excecao.*;

public interface IRepositorioConta {

  public void inserir(ContaAbstrata conta) throws CEException;

  public void remover(String numero) throws CIException;

  public boolean existe(String numero);

  public ContaAbstrata procurar(String numero);

  public ContaAbstrata[] listar();

  public int tamanho();
}