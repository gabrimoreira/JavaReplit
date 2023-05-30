public class Conta {
  private String numero;
  private double saldo;

  public Conta(String numero) {
    this.numero = numero;
    this.saldo = 0.0;
  }

  public void creditar(double valor) {
    if (valor >= 0) {
      this.saldo = this.saldo + valor;
    }
  }

  public void debitar(double valor) {
    if (valor >= 0.0 && this.saldo >= valor) {
      this.saldo -= valor;
    }
  }


  public String getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }
}