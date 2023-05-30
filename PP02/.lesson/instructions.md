# Instruções  

## Visão Geral
Nessa prática de programação, cada questão (descrita em cada passo da próxima seção) deve ser implementada nas classes especificadas, mas testadas via métodos de teste da classe ``Main``. Por exemplo, a implementação referente a passo ``1`` deve ser feita dentro da classe ``Calculadora.java``, mas o teste deve ser feito no método ``testaCalculadora()`` na classe ``Main.java``. O método ``main(String[] args)`` da classe ``Main`` não deve ser alterado.

## Passos

1. Criar uma classe chamada Calculadora e um método para cada uma das operações: adicionar, subtrair, multiplicar, dividir, potência, raiz quadrada, seno, cosseno e tangente. (Dica! Utilize a biblioteca de classe ``java.lang.Math`` para o cálculo da potência, raiz quadrada, seno, cosseno e tangente). Além disso, você deve escrever um código que teste todas as operações da ``Calculadora`` dentro do método ``testaCalculadora()`` da classe ``Main``.


```
public class Calculadora{
  public Calculadora(){...} 
  public double adicionar(double operandoA, double operandoB){...}
  public double subtrair(double operandoA, double operandoB){...}
  public double multiplicar(double operandoA, double operandoB){...}
  public double dividir(double operandoA, double operandoB){...}
  public double potencia(double base, int expoente) {...}
  public double raiz(double valor) {...}
  public double seno(double angulo) {...}
  public double coseno(double angulo) {...}
  public double tangente(double angulo) {...}
} 
```

2. Com base na ``Nota de Aula 05.pdf`` disponível no [SIGAA](https://si3.ufc.br/sigaa/verTelaLogin.do), escreva o código da clase ``Conta`` e, em seguida, teste sua implementação no método ``testaConta()`` da classe ``Main``.

```
public class Conta {
  public Conta (String numero){...} 
  public void creditar(double valor){...}
  public void debitar(double valor){...}
  public String getNumero(){...}
  public double getSaldo(){...}
}
```

3. Com base na ``Nota de Aula 05.pdf`` disponível no [SIGAA](https://si3.ufc.br/sigaa/verTelaLogin.do), escreva o código da clase ``Banco`` e, em seguida, teste sua implmentação no método ``testaBanco()`` da classe ``Main``.

```
public class Banco {
  public Banco(){...} 
  public void cadastrar(Conta conta){...}
  private Conta procurar(String numero){...}
  public void creditar(String numero, double valor){...}
  public void debitar(String numero, double valor){...}
  public double saldo(String numero) {...}
  public void transferir(String origem, String destino, double valor){...} 
}
```

