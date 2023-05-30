package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.repo.excecao.*;

import java.util.Vector;

public class VectorConta implements IRepositorioConta {
  private Vector<ContaAbstrata> contas;

  public VectorConta() {
    this.contas = new Vector<ContaAbstrata>();
  }

  public void inserir(ContaAbstrata conta) throws CEException{
    if (conta != null && !this.existe(conta.getNumero())) {
      this.contas.add(conta);
    }
    else{
      throw new CEException(conta.getNumero());
    }
  }

  public void remover(String numero) throws CIException{
    if (numero != null && this.existe(numero)) {
      this.contas.remove(this.procurar(numero));
    }
    else{
      throw new CIException(numero);
    }
  }

  public ContaAbstrata procurar(String numero) {
    for (ContaAbstrata conta : this.contas) {
      if (conta.getNumero().equals(numero)) {
        return conta;
      }
    }
    return null;
  }

  public boolean existe(String numero) {
    return this.procurar(numero) != null;
  }

  public ContaAbstrata[] listar() {
    ContaAbstrata[] lista = null;
    if (this.tamanho() > 0) {
      lista = new ContaAbstrata[this.tamanho()];
      int i = 0;
      for (ContaAbstrata conta : this.contas) {
        lista[i] = conta;
        i++;
      }
    }
    return lista;
  }

  public int tamanho() {
    return this.contas.size();
  }
}