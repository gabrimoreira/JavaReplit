import br.ufc.poo.banco.excecao.*;
import br.ufc.poo.banco.*;
import br.ufc.poo.conta.*;
import br.ufc.poo.conta.excecao.*;
import br.ufc.poo.conta.repo.*;
import br.ufc.poo.conta.repo.excecao.*;

class Main {
    public static void main(String[] args) {
        testaPasso1();
        testaPasso2();
        testaPasso3();
        testaPasso4();
        testaPasso5();
        testaPasso6();
        testaPasso7();
        testaPasso8();
    }
  public static void testaPasso1() {
      System.out.println("TESTE 1: ");
    
      Conta conta = new Conta("12345");
      try {
          conta.creditar(100);
          conta.debitar(1000);
          System.out.println("Débito realizado com sucesso.");
      } catch (SIException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " || Saldo: " + e.getSaldo());
      } catch (VNException e){
        System.out.println(e.getMessage());
        System.out.println("Conta: " + e.getNumero() + " Valor negativo: " + e.getValor());
      }
  }
  
  
  public static void testaPasso2() {
      System.out.println("TESTE 2: ");
    
      Conta conta = new Conta("12345");
      try {
          conta.creditar(-100);
          System.out.println("Débito realizado com sucesso.");
      } catch (VNException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " || Valor Negativo: " + e.getValor());
      }
  }
  
  public static void testaPasso3() {
      System.out.println("TESTE 3: ");
    
      ContaPoupanca contaP = new ContaPoupanca("12345");
      
      try {
          contaP.renderJuros(-10);
          System.out.println("Mudança de Taxa poupanaça realizada!");
      } catch (TNPException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " || Valor Negativo: " + e.getTaxa());
      }catch (VNException e){
        System.out.println(e.getMessage());
        System.out.println("Conta: " + e.getNumero() + " Valor negativo: " + e.getValor());
      }
  }


  public static void testaPasso4() {
      System.out.println("TESTE 4: ");
      ContaEspecial conta = new ContaEspecial("12345");
      try {
          conta.setBonusPercentagem(-10);
          System.out.println("Percentagem do bônus definida com sucesso.");
      } catch (PNBException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " || Percentagem Negativa: " + e.getPercentagem());
      }
  }


  public static void testaPasso5() {
      System.out.println("TESTE 5: ");
      ContaImposto conta = new ContaImposto("12345");
      try {
          conta.setTaxa(-10);
          System.out.println("Taxa definida com sucesso.");
      } catch (TNIException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " || Taxa Negativa: " + e.getTaxa());
      }
  }


public static void testaPasso6() {
    System.out.println("TESTE 6: ");
    ArrayConta banco = new ArrayConta();

    try {
        banco.remover("1234");
        System.out.println("Remoção realizada com sucesso.");
    } catch (CIException e) {
        System.out.println(e.getMessage());
        System.out.println("Conta: " + e.getNumero() + " não existe.");
    }
}


  public static void testaPasso7() {
      System.out.println("TESTE 7: ");
      ArrayConta banco = new ArrayConta();
      Conta conta = new Conta("12345");
      try {
          banco.inserir(conta);
          banco.inserir(conta);
          System.out.println("Inserção realizada com sucesso.");
      } catch (CEException e) {
          System.out.println(e.getMessage());
          System.out.println("Conta: " + e.getNumero() + " já existe.");
      }
  }


  public static void testaPasso8() {
      System.out.println("TESTE 8: ");
      IRepositorioConta repositorio = new ArrayConta();
      IBanco banco = new BancoIndependente(repositorio);
      String origem = "12345";
      String destino = "54321";
      double valor = 1000.0;
      
      //Tratamento necessário ao cadastrar as contas
      try{
        banco.cadastrar(new Conta(origem));
        banco.cadastrar(new Conta(destino));
        }catch (PNBException e) {
            System.out.println(e.getMessage());
            System.out.println("Conta: " + e.getNumero() + " || Percentagem Negativa: " + e.getPercentagem());
        }catch (TNIException e) {
            System.out.println(e.getMessage());
            System.out.println("Conta: " + e.getNumero() + " || Taxa Negativa: " + e.getTaxa());
        }catch (CEException e) {
            System.out.println(e.getMessage());
            System.out.println("Conta: " + e.getNumero() + " já existe.");
        }
      
      try {
            banco.transferir(origem, destino, valor);
            System.out.println("Transferência realizada com sucesso.");
        } catch (TIException e) {
            System.out.println("Transferência inválida: " + e.getCause().getMessage());
        } 
    }

}