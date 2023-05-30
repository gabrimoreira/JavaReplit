import java.util.Vector;

public class BancoVector {
  private Vector<Conta> contas;
  private double taxaPoupanca = 0.01;
  private double bonusPercentagem = 0.01;

  public BancoVector() {
    contas = new Vector<Conta>();
  }

  public void cadastrar(Conta conta) {
      if (!(existe(conta.getNumero()))) {
        contas.add(conta);
    }
  }

  private Conta procurar(String numero) {
    for (Conta contaAux : contas) {
      if (contaAux.getNumero().equals(numero)) {
        return contaAux;
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
    Conta contaAux = procurar(numero);
    if(contaAux != null){
      return contaAux.getSaldo();
    }
    return -1;
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
      for (Conta contaAux : contas) {
        if (contaAux instanceof ContaEspecial) {
          ContaEspecial contaE = (ContaEspecial) contaAux;
          contaE.setBonusPercentagem(valor);
        }
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