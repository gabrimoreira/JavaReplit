import static org.junit.Assert.assertEquals;

import br.ufc.poo.conta.ContaAbstrata;
import br.ufc.poo.conta.ContaEspecial;
import br.ufc.poo.conta.ContaImposto;
import br.ufc.poo.conta.ContaPoupanca;

import br.ufc.poo.conta.repo.IRepositorioConta;
import br.ufc.poo.conta.repo.VectorContaArquivo;

class Main {
  public static void main(String[] args) {
    try {
      
      testaSerializacao();
      
      testaDesserializacao();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testaSerializacao() throws Exception {
    IRepositorioConta repo = new VectorContaArquivo();
    
    ContaAbstrata conta = new ContaEspecial("123-X");
    conta.creditar(10.0);
    repo.inserir(conta);

    conta = new ContaImposto("456-X");
    conta.creditar(11.0);
    repo.inserir(conta);

    conta = new ContaPoupanca("789-X");
    conta.creditar(12.0);
    repo.inserir(conta);
  }

  public static void testaDesserializacao() throws Exception {
    IRepositorioConta repo = new VectorContaArquivo();
    
    ContaAbstrata conta = repo.recuperar("123-X");
    assertEquals(10.0, conta.getSaldo(), 0.00);

    conta = repo.recuperar("456-X");
    assertEquals(11.0, conta.getSaldo(), 0.00);

    conta = repo.recuperar("789-X");
    assertEquals(12.0, conta.getSaldo(), 0.00);

  }

}