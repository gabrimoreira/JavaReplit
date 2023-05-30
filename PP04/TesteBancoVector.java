public class TesteBancoVector {
  
  public void testaCadastrarBancoVector() {
    BancoVector banco = new BancoVector();
    ContaPoupanca cp1 = new ContaPoupanca("123");
    banco.cadastrar(cp1);
    
    if(!(banco.existe("123"))){
      System.out.println("Erro no método CreditarBancoVector!");
      return;
    }

    ContaEspecial ce1 = new ContaEspecial("456");
    banco.cadastrar(ce1);
    if(!(banco.existe("456"))){
      System.out.println("Erro no método CreditarBancoVector!");
      return;
    }
    Conta cp2 = new Conta("789");
    banco.cadastrar(cp2);
    if(!(banco.existe("789"))){
      System.out.println("Erro no método CreditarBancoVector!");
      return;
    }

    System.out.println("Método creditarBancoVector CORRETO!");
  }
  
  public void testaDebitarBancoVector() {
    BancoVector banco = new BancoVector();
    ContaPoupanca cp1 = new ContaPoupanca("123");
    banco.cadastrar(cp1);

    ContaEspecial ce1 = new ContaEspecial("456");
    banco.cadastrar(ce1);     

    Conta cp2 = new Conta("789");
    banco.cadastrar(cp2);

    banco.creditar("123", 800.0);
    banco.debitar("123", 500.0);
    if(banco.saldo("123") != 300.0){
      System.out.println("Erro no método DebitarBancoVector!");
      return;
    }

    banco.creditar("456", 1200.0);
    banco.debitar("456", 1000.0);
    if(banco.saldo("456") != 200.0){
      System.out.println("Erro no método DebitarBancoVector!");
      return;
    }

    banco.debitar("123", 10000.0);
    if(banco.saldo("123") != 300.0){
      System.out.println("Erro no método DebitarBancoVector!");
      return;
    }
    
    System.out.println("Método DebitarBancoVector CORRETO!");
  }

  public void testaCreditarBancoVector() {
    BancoVector banco = new BancoVector();
    ContaPoupanca cp1 = new ContaPoupanca("123");
    banco.cadastrar(cp1);

    ContaEspecial ce1 = new ContaEspecial("456");
    banco.cadastrar(ce1);     

    Conta cp2 = new Conta("789");
    banco.cadastrar(cp2);

    banco.creditar("123", 500.0);
    if(banco.saldo("123") != 500.0){
      System.out.println("Erro no método CreditarBancoVector!");
      return;
    }

    banco.creditar("456", 1000.0);
    if(banco.saldo("456") != 1000.0){
      System.out.println("Erro no método CreditarBancoVector!");
      return;
    }
    
    System.out.println("Método CreditarBancoVector CORRETO!");
  }

  public void testaTransferirBancoVector() {
    BancoVector banco = new BancoVector();
    ContaPoupanca cp1 = new ContaPoupanca("123");
    banco.cadastrar(cp1);

    ContaEspecial ce1 = new ContaEspecial("456");
    banco.cadastrar(ce1);     

    Conta cp2 = new Conta("789");
    banco.cadastrar(cp2);

    banco.creditar("123", 1000.0);
    banco.creditar("456", 2000.0);

    banco.transferir("123", "789", 400.0);
    if(banco.saldo("123") != 600.0 || banco.saldo("789") != 400.0){
      System.out.println("Erro no método TransferirBancoVector!");
      return;
    }

    banco.transferir("456", "789", 1000.0);
    if(banco.saldo("456") != 1000.0 || banco.saldo("789") != 1400.0){
      System.out.println("Erro no método TransferirBancoVector!");
      return;
    }

    banco.transferir("789", "123", 1300.0);
    
    if(banco.saldo("123") != 1900.0 || banco.saldo("789") != 100.0){
      System.out.println("Erro no método TransferirBancoVector!");  
      return;
    }

    System.out.println("Método TransferirBancoVector CORRETO!");
}
}
