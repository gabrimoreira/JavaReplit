public class ContaEspecial extends Conta {
  private double bonus;
  private double percentagem = 0.01;

  public ContaEspecial(String numero) {
    super(numero);
    this.bonus = 0.0;
  }

  public void renderBonus() {
    super.creditar(this.bonus);
    this.bonus = 0.0;
  }

  public void creditar(double valor) {
    if (valor >= 0) {
      this.bonus = this.bonus + (valor * this.percentagem);
      super.creditar(valor);
    }
  }

  public double getBonus() {
    return this.bonus;
  }

  public double getBonusPercentagem() {
    return this.percentagem;
  }

  public void setBonusPercentagem(double percentagem) {
    if (percentagem >= 0) {
      this.percentagem = percentagem;
    }
  }
}