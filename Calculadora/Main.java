import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
  //Observação, os métodos foram utilizados como private static, para permitir que o método possa ser chamdo sem a instância da classe "Main".
  
  private static JTextField txtDisplay; // Campo de texto onde são exibidos os resultados e números
  private static double firstNumber, secondNumber, result;
  private static String operator;
  
  private static void createAndShowGUI() {
    JFrame jFrame = new JFrame("Calculadora"); // Janela com título "Calculadora"
    jFrame.setLayout(new BorderLayout()); // Tipo de Layout que separa em 5 regiões: NORTH SOUTH EAST WEST CENTER

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao fechar a janela, o programa para.
    
    txtDisplay = new JTextField(15); //Cria um campo de text com 15 colunas 
    txtDisplay.setEditable(false); //Tornar o não editável, ou seja, vai pode ser modificado somente via botões.
    jFrame.add(txtDisplay, BorderLayout.NORTH);

    JPanel panelMain = new JPanel();
    panelMain.setLayout(new GridLayout(1,2));
    JPanel panelButtonsNumbers = new JPanel();
    panelButtonsNumbers.setLayout(new GridLayout(4,3));
    JPanel panelButtonsOperations = new JPanel();
    panelButtonsOperations.setLayout(new GridLayout(4,1));
      
    JButton btn7 = createButton("7");
    JButton btn8 = createButton("8");
    JButton btn9 = createButton("9");
    JButton btn4 = createButton("4");
    JButton btn5 = createButton("5");
    JButton btn6 = createButton("6");
    JButton btn1 = createButton("1");
    JButton btn2 = createButton("2");
    JButton btn3 = createButton("3");
    JButton btn0 = createButton("0");
    JButton btnClear = createButton("C");
    JButton btnEquals = createButton("=");
    
    panelButtonsNumbers.add(btn7);
    panelButtonsNumbers.add(btn8);
    panelButtonsNumbers.add(btn9);
    panelButtonsNumbers.add(btn4);
    panelButtonsNumbers.add(btn5);
    panelButtonsNumbers.add(btn6);
    panelButtonsNumbers.add(btn1);
    panelButtonsNumbers.add(btn2);
    panelButtonsNumbers.add(btn3);
    panelButtonsNumbers.add(btn0);
    panelButtonsNumbers.add(btnClear);
    panelButtonsNumbers.add(btnEquals);

    JButton btnDiv = createButton("/");
    JButton btnMult = createButton("*");
    JButton btnSub = createButton("-");
    JButton btnAdd = createButton("+");
  
    panelButtonsOperations.add(btnDiv);
    panelButtonsOperations.add(btnMult);
    panelButtonsOperations.add(btnSub);
    panelButtonsOperations.add(btnAdd);

    panelMain.add(panelButtonsNumbers);
    panelMain.add(panelButtonsOperations);

    jFrame.add(panelMain, BorderLayout.CENTER);
    jFrame.pack(); // Redimensiona a janela do conteúdo ao ajustar-se ao conteúdo

    jFrame.setVisible(true); // torna a janela visível.
    jFrame.setSize(400,400);


  }
  
  private static JButton createButton(String label) {
    JButton button = new JButton(label);
    button.addActionListener(e -> buttonClick(label)); // Adiciona um evento listener ao botão para que ele execute uma ação ao ser clicado. Ao cilcar nesse botão, a String label será passada para o buttonClick lidar com ele. 
    return button;
  }
  
  private static void buttonClick(String label) {

      switch (label) {
        case "+":
        case "-":
        case "*":
        case "/":
          if(!txtDisplay.getText().isEmpty()){
          operator = label;
          firstNumber = Double.parseDouble(txtDisplay.getText()); // Pega o texto do visor e transfomar para o Double e coloca no firstNumber.
          txtDisplay.setText("");
          }
          break;
        case "=":
          //If para evitar que o uma operação seja transformada em double, o que geraria um problema no código
          if(!txtDisplay.getText().isEmpty()){
          secondNumber = Double.parseDouble(txtDisplay.getText());
          calculateResult();
          }
          break;
        case "C":
          resetCalculator();
          break;
        default:
          txtDisplay.setText(txtDisplay.getText() + label); // Caso outro número seja adicionado, garante que o número seja concantenado com outro.
          break;
      }
    }

  private static void calculateResult() {
    switch (operator) {
      case "+":
        result = firstNumber + secondNumber;
        break;
      case "-":
        result = firstNumber - secondNumber;
        break;
      case "*":
        result = firstNumber * secondNumber;
        break;
      case "/":
        result = firstNumber / secondNumber;
        break;
    }
    txtDisplay.setText(String.valueOf(result));
  }
  private static void resetCalculator() {
    txtDisplay.setText("");
    firstNumber = 0;
    secondNumber = 0;
    result = 0;
    operator = "";
  }


  public static void main(String[] args) {
    createAndShowGUI();
  }
}