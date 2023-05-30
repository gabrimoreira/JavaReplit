package br.ufc.poo.conta.excecao;

public class TNPException extends Exception {
  private double taxa;
  private String numero;
  
  public TNPException(double taxa, String numero){
     super("Taxa Negativa!");
     this.taxa = taxa; 
     this.numero = numero;
  }

  public double getTaxa(){
    return this.taxa;
  }
  public String getNumero(){
    return this.numero;
  }
}