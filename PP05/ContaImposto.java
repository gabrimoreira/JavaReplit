public class ContaImposto extends ContaAbstrata {
  private double taxa = 0.001;

  public ContaImposto(String numero) {
    super(numero);
  }

  public void debitar(double valor) {
    if (valor >= 0 && this.saldo >= (valor * (1 + taxa))) {
      this.saldo = this.saldo - (valor*(1 + taxa));
    }
  }

  public double getTaxa() {
    return this.taxa;
  }

  public void setTaxa(double valor) {
    if(valor >= 0){
      this.taxa = valor;
    }
  }
}