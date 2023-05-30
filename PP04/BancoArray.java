public class BancoArray {
  private Conta[] contas;
  private int indice = 0;
  private double taxaPoupanca = 0.01;
  private double bonusPercentagem = 0.01;

  public BancoArray() {
    contas = new Conta[100];
  }

  public void cadastrar(Conta conta) {
    if (!(existe(conta.getNumero()))) {
      contas[indice] = conta;
      indice++;
    }
  }

  private Conta procurar(String numero) {
    for (int i = 0; i < indice; i++) {
      if (contas[i].getNumero().equals(numero)) {
        return contas[i];
      }
    }
    return null;
  }

  public boolean existe(String numero) {
    return procurar(numero) != null;
  }

  public void creditar(String numero, double valor) {
    Conta conta = procurar(numero);
    if (conta != null) {
      conta.creditar(valor);
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public void debitar(String numero, double valor) {
    Conta conta = procurar(numero);
    if (conta != null) {
      conta.debitar(valor);
    } else {
      System.out.println("Conta Inexistente!");
    }
  }

  public double saldo(String numero) {
    Conta conta = procurar(numero);
    if (conta != null) {
      return conta.getSaldo();
    } else {
      System.out.println("Conta Inexistente!");
    }
    return 0;
  }

  public void transferir(String origem, String destino, double valor) {
    Conta contaOrigem = procurar(origem);
    if (contaOrigem != null) {
      Conta contaDestino = procurar(destino);
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
    Conta conta = procurar(numero);
    if (conta != null) {
      if (conta instanceof ContaPoupanca) {
        ((ContaPoupanca) conta).renderJuros(taxaPoupanca);
      } else {
        System.out.println("Esta conta não é Poupança!");
      }
    } else {
      System.out.println("Conta Inexistente");
    }
  }

  public void renderBonus(String numero) {
    Conta conta = procurar(numero);
    if (conta != null) {
      if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).setBonusPercentagem(bonusPercentagem);
      } else {
        System.out.println("Esta conta não é Especial!");
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
    if (valor >= 0.0) {
      this.bonusPercentagem = valor;
      for (int i = 0; i < indice; i++) {
        if (contas[i] instanceof ContaEspecial) {
          ContaEspecial contaE = (ContaEspecial) contas[i];
          contaE.setBonusPercentagem(valor);
        }
      }
    }
  }

  public double getBonusPercentagem() {
    return this.bonusPercentagem;
  }

  public int quantidade() {
    return this.indice;
  }
}