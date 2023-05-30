public class Ventilador{
  private int velocidade;
  private int estado;
  private int rotacao;

  public Ventilador(){
    velocidade = 1;
    estado = 0;
    rotacao = 0;
  }

  public void mudaEstado(){
    if(estado == 1){
      estado = 0;
    }
    else{
      estado = 1;
    }
  }
  public void mudaRotacao(){
    if(rotacao == 1){
      rotacao = 0;
    }
    else{
      rotacao = 1;
    }
  }
  public void acelerar(){
    if(velocidade == 5){
      System.out.println("Não é possivel acelerar. VELOCIDADE MÁXIMA");
      return;
    }
    velocidade ++;
  }
  public void desacelerar(){
    if(velocidade ==  1){
      System.out.println("Não é possivel desacelerar. VELOCIDADE MINIMA");
      return;
    }
    velocidade --;
    return;
  }
  public int getEstado(){
    return estado;
  }
  public int getVelocidade(){
    return velocidade;
  }
  public int getRotacao(){
    return rotacao;
  }
  

  
}