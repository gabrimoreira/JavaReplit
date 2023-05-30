import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha a opção desejada:\n 1) Testa Claculadora\n 2) Testa Banco");
    int opcao = scanner.nextInt();
    switch(opcao) {
      case 1: testaCalculadora();
              break;
              
      case 2: testaBanco();
              break;
              
      default: System.out.println("Opção inexistente!");
              break;
    }
  }


  public static void testaCalculadora() {
    Calculadora testCalc;
    testCalc = new Calculadora();
    testCalc.adicionar(5.0,3.5);
    testCalc.subtrair(5.0,3.5);
    testCalc.multiplicar(4.0,3.2);
    testCalc.dividir(27.3,5.2);
    testCalc.potencia(5.3,3);
    testCalc.raiz(23.5);
    testCalc.seno(30);
    testCalc.coseno(30);
    testCalc.tangente(30);
  }

  //Teste das classes Banco e Conta feitas no mesmo método.
  //Considerei que a conta pode ficar negativada.
  //Execeções não foram tratadas, portanto, quando a conta for inexistente no método saldo, retornará -1.
  
  public static void testaBanco() {
    //Instanciando o Banco.
    Banco gBank;
    gBank = new Banco();

    //Instanciando as contas.
    Conta conta1;
    conta1 = new Conta("1-X");

    Conta conta2;
    conta2 = new Conta("2-X");

    //Cadastrando as contas
    gBank.cadastrar(conta1);
    gBank.cadastrar(conta2);
    
    //Operações básicas em uma conta.
    
    gBank.creditar("1-X", 350);
    System.out.println("Saldo: " + gBank.saldo("1-X"));
    gBank.debitar("1-X", 123);
    System.out.println("Saldo: " + gBank.saldo("1-X"));
    
    gBank.creditar("2-X", 450);
    System.out.println("Saldo: " + gBank.saldo("2-X"));
    gBank.debitar("2-X", 123);
    System.out.println("Saldo: " + gBank.saldo("2-X"));

    //Saldo de conta existente.
    System.out.println("Saldo: " + gBank.saldo("1-X"));
    System.out.println("Saldo: " + gBank.saldo("2-X"));


    //Testando transferência da conta1 para conta2.
    gBank.transferir("1-X", "2-X", 200);
    System.out.println("Saldo: " + gBank.saldo("1-X"));
    System.out.println("Saldo: " + gBank.saldo("2-X"));
    
    
  }

}