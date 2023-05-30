package br.ufc.poo.conta.repo;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.repo.excecao.CEException;
import br.ufc.poo.conta.repo.excecao.CIException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;

public class VectorContaArquivo implements IRepositorioConta, Serializable {
  private static final long serialVersionUID = 1L;
  private Vector<ContaAbstrata> contas;
  private String filePath;
  
  public VectorContaArquivo() {
    this.contas = new Vector<ContaAbstrata>();
    filePath = "./arquivo/contas.bin";
    File file = new File(filePath);
    if(file.exists()){
    this.desserializar();
    }
  }


  public void inserir(ContaAbstrata conta) throws CEException {
    
    if (this.existe(conta.getNumero())) {
      throw new CEException(conta.getNumero());
    }

    this.contas.add(conta);
    this.serializar();
  }

  public void remover(String numero) throws CIException {

    if (!this.existe(numero)) {
      throw new CIException(numero);
    }
    
    this.contas.remove(this.procurar(numero));
    this.serializar();

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

  private void serializar() {
    String pathDir = "./arquivo";
    File diretorio = new File(pathDir);
    if(!diretorio.isDirectory()){
      diretorio.mkdir();
    }

    try{
      FileOutputStream gravador = new FileOutputStream(filePath);
      ObjectOutputStream conversor = new ObjectOutputStream(gravador);
      conversor.writeObject(this.contas);
      conversor.close();
      gravador.close();
    }
    catch(IOException ioe){
      ioe.printStackTrace();
    }
  }

  private void desserializar() {
      String pathDir = "./arquivo";
      File diretorio = new File(pathDir);
      if(!diretorio.isDirectory()){
        diretorio.mkdir();
      }
    try{
      FileInputStream leitor = new FileInputStream(filePath);
      ObjectInputStream conversor = new ObjectInputStream(leitor);
      //Vector<ContaAbstrata> contas = (Vector<ContaAbstrata>) conversor.readObject();

      this.contas = (Vector<ContaAbstrata>) conversor.readObject();


      for(ContaAbstrata conta : this.contas){
        System.out.println("Numero: " + conta.getNumero() + "\nSaldo: " + conta.getSaldo());
      }
      conversor.close();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
    catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

}