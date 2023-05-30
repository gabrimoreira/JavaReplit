public class Conta extends ContaAbstrata {
  
  public Conta(String numero) {
    super(numero);
  }
  public void debitar(double valor){
      if (valor >= 0 && this.saldo >= valor) {
      this.saldo = this.saldo - valor;
    }
  }

}