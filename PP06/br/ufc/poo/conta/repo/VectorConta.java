package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;

import java.util.Vector;

public class VectorConta implements IRepositorioConta {
  private Vector<ContaAbstrata> contas;

  public VectorConta() {
    this.contas = new Vector<ContaAbstrata>();
  }

  public void inserir(ContaAbstrata conta) {
    if (conta != null && !this.existe(conta.getNumero())) {
      this.contas.add(conta);
    }
  }

  public void remover(String numero) {
    if (numero != null && this.existe(numero)) {
      contas.remove(procurar(numero));
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
    int tam = tamanho();
    if(tam > 0){
      lista = new ContaAbstrata[tam];
      for(int i = 0; i < tam; i++){
        lista[i] = contas.get(i);
      }
      return lista;
    }
    return null;
  }

  public int tamanho() {
    return this.contas.size();
  }
}