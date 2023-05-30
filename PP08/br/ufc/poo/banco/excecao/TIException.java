package br.ufc.poo.banco.excecao;

public class TIException extends Exception {
  private String origem;
  private String destino;
  private double valor;

  public TIException(String origem, String destino, double valor, Throwable cause) {
    super("Exceção de Transferência Invália [Origem: " + origem + ", Destino: " + destino + ", Valor: " + valor + "]",
        cause);
    this.origem = origem;
    this.destino = destino;
    this.valor = valor;
  }

  public String getNumeroOrigem() {
    return this.origem;
  }

  public String getNumeroDestino() {
    return this.destino;
  }

  public double getvalor() {
    return this.valor;
  }
}