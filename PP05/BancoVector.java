import java.util.Vector;

public class BancoVector {
  private Vector<ContaAbstrata> contas;
  private double taxaPoupanca = 0.01;
  private double bonusPercentagem = 0.01;

  public BancoVector() {
    this.contas = new Vector<ContaAbstrata>();
  }

  public void cadastrar(ContaAbstrata conta) {
    if (conta != null && !this.existe(conta.getNumero())) {
      if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).setBonusPercentagem(this.bonusPercentagem);
      }
      this.contas.add(conta);
    }
  }

  private ContaAbstrata procurar(String numero) {
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

  public void creditar(String numero, double valor) {
    ContaAbstrata conta = this.procurar(numero);
    if (conta != null) {
      conta.creditar(valor);
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public void debitar(String numero, double valor) {
    ContaAbstrata conta = this.procurar(numero);
    if (conta != null) {
      conta.debitar(valor);
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public double saldo(String numero) {
    ContaAbstrata conta = this.procurar(numero);
    if (conta != null) {
      return conta.getSaldo();
    } else {
      System.out.println("Conta Inexistente!");
    }
    return 0;
  }

  public void transferir(String origem, String destino, double valor) {
    ContaAbstrata contaOrigem = this.procurar(origem);
    if (contaOrigem != null) {
      ContaAbstrata contaDestino = this.procurar(destino);
      if (contaDestino != null) {
        if (contaOrigem.getSaldo() > valor) {
          contaOrigem.debitar(valor);
          contaDestino.creditar(valor);
        } else {
          System.out.println("Saldo Insuficiente!");
        }
      } else {
        System.out.println("Conta Destino nº " + destino + " Inexistente!");
      }
    } else {
      System.out.println("Conta Origem nº " + origem + " Inexistente!");
    }
  }

  public void renderJuros(String numero) {
    ContaAbstrata conta = this.procurar(numero);
    if (conta != null) {
      if (conta instanceof ContaPoupanca) {
        ((ContaPoupanca) conta).renderJuros(this.taxaPoupanca);
      } else {
        System.out.println("Ésta não é uma Conta Poupança!");
      }
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public void renderBonus(String numero) {
    ContaAbstrata conta = this.procurar(numero);
    if (conta != null) {
      if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).renderBonus();
      } else {
        System.out.println("Ésta não é uma Conta Especial!");
      }
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public void setTaxaPoupanca(double valor) {
    this.taxaPoupanca = valor;
  }

  public double getTaxaPoupanca() {
    return this.taxaPoupanca;
  }

  public void setBonusPercentagem(double valor) {
    this.bonusPercentagem = valor;
    for (ContaAbstrata conta : this.contas) {
      if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).setBonusPercentagem(this.bonusPercentagem);
      }
    }
  }

  public double getBonusPercentagem() {
    return this.bonusPercentagem;
  }

  public int quantidade() {
    return this.contas.size();
  }
}