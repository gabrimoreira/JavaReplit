public class VentiladorTeste{
  Ventilador vent = new Ventilador();
  public void testeAcelerar(){
    int teste = vent.getVelocidade();
    vent.acelerar();
    if(teste + 1 != vent.getVelocidade()){
      System.out.println("Nao passou!");
      return;
    }
    vent.acelerar();
    vent.acelerar();
    vent.acelerar();
    vent.acelerar();
    if(vent.getVelocidade() > 5){
      System.out.println("Nao passou!");
      return;
    }
    System.out.println("Passou!");
  }
  public void testeDesacelerar(){
    int teste = vent.getVelocidade();
    vent.desacelerar();
    if(teste - 1 != vent.getVelocidade()){
      System.out.println("Nao passou!");
      return;
    }
    vent.desacelerar();
    vent.desacelerar();
    vent.desacelerar();
    vent.desacelerar();
    if(vent.getVelocidade() < 1){
      System.out.println("Nao passou!");
      return;
    }
    System.out.println("Passou!");
  }
  public void testeMudaEstado(){
    int teste = vent.getEstado();
    vent.mudaEstado();
    if(teste == vent.getEstado()){
      System.out.println("Nao passou!");
      return;
    }
    System.out.println("Passou!");
    
  }
  public void testeMudaRotacao(){
    int teste = vent.getRotacao();
    vent.mudaRotacao();
    if(teste == vent.getRotacao()){
      System.out.println("Nao passou!");
      return;
    }
    System.out.println("Passou!");
  }
}