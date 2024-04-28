package Funcoes;

//Classe responsável pela representação de um Funcionário
class Funcionario extends Thread {
 private String nome;
 private Conta contaSalario;
 private Conta contaInvestimento;
 private Conta contaDivida;

 // Construtor da classe Funcionário
 public Funcionario(String nome) {
     this.nome = nome;
     this.contaSalario = new Conta(0); // Saldo inicial da conta de salário é zero
     this.contaInvestimento = new Conta(0); // Saldo inicial da conta de investimento é zero
     this.contaDivida = new Conta(0); // Saldo inicial da conta de investimento é zero
 }

 // Método para obter o salário fixo do funcionário
 public static double getSalario() {
     return 1400.0;
 }

 // Métodos getters para os atributos da classe Funcionário
 public String getNome() {
     return nome;
 }

 public Conta getContaSalario() {
     return contaSalario;
 }

 // Métodos para realizar operações relacionadas ao salário e investimento
 public void setContaSalario(Conta contaSalario) {
     this.contaSalario = contaSalario;
 }

 public double getSaldoInvestimento() {
     return contaInvestimento.getSaldo();
 }

 public boolean recebeuSalario() {
     return contaSalario.getSaldo() > 0;
 }

 public double getValorConta(double valorSalario) {
     double valorInvestimento = valorSalario * 0.2; // 20% do salário para investimento
     double valorConta = valorSalario - valorInvestimento;
     return valorConta;
 }

 public double getSaldoDivida() {
     return contaDivida.getSaldo();
 }

 // Método para receber o pagamento (salário)
 public void receberPagamento(double valorSalario) {
     contaSalario.creditar(valorSalario);
     double valorInvestimento = valorSalario * 0.2; // 20% do salário para investimento
     double valorDivida = 180.0; // Valor fixo da dívida
     contaSalario.debitar(valorInvestimento); // Deduzindo o valor do investimento
     contaDivida.debitar(valorDivida); // Deduzindo o valor da dívida
     double valorConta = getValorConta(valorSalario) - valorDivida; // Calculando o valor da conta após pagar a dívida
     contaInvestimento.creditar(valorInvestimento);
     System.out.println(nome + " recebeu o salário e investiu R$" + valorInvestimento);
     System.out.println(nome + " recebeu o salário e pagou a dívida de R$" + valorDivida);
     System.out.println("Valor na conta após investir e pagar a dívida: R$" + valorConta);
 }

 // Método para simular a demissão do funcionário
 public void pedirDemissao() {
     System.out.println(nome + " pediu demissão.");
 }
}