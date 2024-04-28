package Funcoes;

//Classe responsável pela representação de uma Conta
class Conta {
 private double saldo;

 // Construtor da classe Conta
 public Conta(double saldoInicial) {
     this.saldo = saldoInicial;
 }

 // Método para obter o saldo da conta
 public double getSaldo() {
     return saldo;
 }

 // Método para creditar um valor na conta
 public synchronized void creditar(double valor) {
     saldo += valor;
 }

 // Método para debitar um valor da conta
 public synchronized void debitar(double valor) {
     if (valor <= saldo) {
         saldo -= valor;
     } else {
         System.out.println("Saldo insuficiente para realizar a operação.");
     }
 }
}
