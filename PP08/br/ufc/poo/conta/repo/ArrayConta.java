package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.repo.excecao.CEException;
import br.ufc.poo.conta.repo.excecao.CIException;

public class ArrayConta implements IRepositorioConta {
  private ContaAbstrata[] contas;
  private int indice = 0;

  public ArrayConta() {
    this.contas = new ContaAbstrata[100];
  }

  public ArrayConta(int capacidade) {
    this.contas = new ContaAbstrata[capacidade];
  }

  public void inserir(ContaAbstrata conta) throws CEException {

    if (this.existe(conta.getNumero())) {
      throw new CEException(conta.getNumero());
    }

    this.contas[indice] = conta;
    this.indice++;

  }

  public void remover(String numero) throws CIException {

    if (!this.existe(numero)) {
      throw new CIException(numero);
    }

    int posicao = this.procurarPosicao(numero);
    this.contas[posicao] = this.contas[--this.indice];
  }

  private int procurarPosicao(String numero) {
    for (int i = 0; i < this.indice; i++) {
      if (contas[i].getNumero().equals(numero)) {
        return i;
      }
    }
    return -1;
  }

  public ContaAbstrata procurar(String numero) {
    for (int i = 0; i < this.indice; i++) {
      if (contas[i].getNumero().equals(numero)) {
        return contas[i];
      }
    }
    return null;
  }

  public ContaAbstrata recuperar(String numero) throws CIException {
    if (!this.existe(numero)) {
      throw new CIException(numero);
    }

    return this.procurar(numero);
  }

  public boolean existe(String numero) {
    return numero != null && this.procurar(numero) != null;
  }

  public ContaAbstrata[] listar() {
    ContaAbstrata[] lista = null;
    if (this.tamanho() > 0) {
      lista = new ContaAbstrata[this.tamanho()];
      for (int i = 0; i < this.tamanho(); i++) {
        lista[i] = this.contas[i];
      }
    }
    return lista;
  }

  public int tamanho() {
    return this.indice;
  }

}