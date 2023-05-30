package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.repo.excecao.CEException;
import br.ufc.poo.conta.repo.excecao.CIException;

import java.util.Vector;

public class VectorConta implements IRepositorioConta {
  private Vector<ContaAbstrata> contas;

  public VectorConta() {
    this.contas = new Vector<ContaAbstrata>();
  }

  public void inserir(ContaAbstrata conta) throws CEException {

    if (this.existe(conta.getNumero())) {
      throw new CEException(conta.getNumero());
    }

    this.contas.add(conta);
  }

  public void remover(String numero) throws CIException {

    if (!this.existe(numero)) {
      throw new CIException(numero);
    }

    this.contas.remove(this.procurar(numero));

  }

  public ContaAbstrata procurar(String numero) {
    for (ContaAbstrata conta : this.contas) {
      if (conta.getNumero().equals(numero)) {
        return conta;
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
      int i = 0;
      for (ContaAbstrata conta : this.contas) {
        lista[i++] = conta;
      }
    }
    return lista;
  }

  public int tamanho() {
    return this.contas.size();
  }

}