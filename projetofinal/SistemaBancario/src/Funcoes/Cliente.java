package Funcoes;

//Classe responsável pela representação de um Cliente
class Cliente extends Thread {
 private String nome;
 private Conta conta;
 private Banco banco;
 private Loja[] lojas;

 // Construtor da classe Cliente
 public Cliente(String nome, double saldoInicial, Banco banco, Loja... lojas) {
     this.nome = nome;
     this.conta = new Conta(saldoInicial);
     this.banco = banco;
     this.lojas = lojas;
 }

 // Método que será executado pela thread do Cliente
 @Override
 public void run() {
     while (conta.getSaldo() > 0) {
         double valorCompra = 200;
         for (Loja loja : lojas) {
             banco.transferencia(conta, loja.getConta(), valorCompra);
             loja.receberPagamento(valorCompra);
             System.out.println("Transferência de R$" + valorCompra + " da conta do " + nome + " para a conta da " + loja.getNome());
         }
         try {
             Thread.sleep(1000); // Aguarda um segundo entre as compras
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     System.out.println(nome + " concluiu suas compras.");
 }
}