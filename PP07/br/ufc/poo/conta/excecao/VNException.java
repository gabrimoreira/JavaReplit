package br.ufc.poo.conta.excecao;

public class VNException extends Exception {
    private String numero;
    private double valor;
    
    public VNException(String numero, double valor) {
        super("Valor negativo para a operação na conta " + numero + ": " + valor);
        this.numero = numero;
        this.valor = valor;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public double getValor() {
        return valor;
    }
}
