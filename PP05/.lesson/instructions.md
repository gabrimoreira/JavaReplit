# Instruções  

## Visão Geral

Nessa prática de programação, cada questão (descrita em cada passo da próxima seção) deve ser implementada nas classes especificadas. Existem testes automatizados para todas as classes a serem implementadas, portanto, você não deve alterar nem o nome e nem a assinatura dos métodos já fornecidos, sejam os completamente implementados ou na forma de stubs (sem implementação funcional de fato).
   
## Passos

1. Implemente a classe `ContaAbstrata` (arquivo `ContaAbstrata.java`), aprensetada no arquivo **Nota de Aula 08**, disponível no [SIGAA](https://si3.ufc.br/). Lembre-se de atender ao seguinte requisito: não permitir operações de crédito com valores negativos.

2. Altere a implementação das classes `BancoArray` e `BancoVector` para que eles passem a lidar com a classe `ContaAbstrata` ao invés de `Conta`. Na classe `BancoArray`, você deverá definir o tributo `contas` como sendo um array de contas `ContaAbstrata` (i.e., `ContaAbstrata[] contas`) e a forma como ele é instanciado no construtor (i.e., `this.contas = new ContaAbstrata[100]`). Na classe `BancoVector`, você deverá definir o tributo `contas` como sendo um `Vector` de contas do tipo `ContaAbstrata` (i.e., `Vector<ContaAbstrata> contas`) e a forma como ele é instanciado no construtor (i.e., `this.contas = new Vector<ContaAbstrata>()`). Em ambas as classes, `BancoArray` e `BancoVector`, você deverá alterar a assinatura do método `private Conta procurar(String numero)`  para que ele possua como tipo de retorno `ContaAbstrata` e o método `public void cadastrar(Conta conta)` para que ele o argumento `conta` seja do tipo `ContaAbstrata`. Em seguida, altere os métodos que fazem chama ao método procurar para fazer os devidos ajustes em função do novo tipo de retorno.

3. Implemente a classe `ContaImposto` (arquivo `ContaImposto.java`), aprensetada no arquivo **Nota de Aula 08**, disponível no [SIGAA](https://si3.ufc.br/). Lembre-se de atender ao seguinte requisito: (i) não permitir que o saldo de uma conta fique negativo; e (ii) não permitir atribuição de taxa de imposto com valores negativos.

4. Altere a implementação da classe `Conta` (arquivo `Conta.java`) para que atenda aos seguintes requisitos: (i) alterar a hierarquia de classes do sistema fazendo com que `Conta` herde de `ContaAbstrata`;  (ii) manter apenas a implementação do método debitar, que será a implementação do método abstrato de `ContaAbstrata`; (iii) não permitir que o saldo de uma conta fique negativo; e (iv) não permitir operações de débito com valores negativos.