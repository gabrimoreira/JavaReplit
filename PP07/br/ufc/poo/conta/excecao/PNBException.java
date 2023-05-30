package br.ufc.poo.conta.excecao;

public class PNBException extends Exception {
  private String numero;
  private double percentagem;
  
  public PNBException(String numero, double percentagem){
    super("Taxa Negativa!");
    this.numero = numero;
    this.percentagem = percentagem;
  }

  public double getPercentagem(){
    return this.percentagem;
  }
  public String getNumero(){
    return this.numero;
  }
}