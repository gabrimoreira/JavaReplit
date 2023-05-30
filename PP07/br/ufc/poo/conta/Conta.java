package br.ufc.poo.conta;
import br.ufc.poo.conta.excecao.SIException;
import br.ufc.poo.conta.excecao.VNException;

public class Conta extends ContaAbstrata {

  public Conta(String numero) {
    super(numero);
  }

  public void debitar(double valor) throws SIException, VNException {
    if( valor < 0){
      throw new VNException(numero, valor);
    }  
    if (saldo >= valor) {
          saldo -= valor;
      } else {
          throw new SIException(saldo,numero);
      }
  }
}
  