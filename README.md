## Simulação de Sistema Bancário

Este projeto é uma simulação de um sistema bancário em que clientes realizam compras em lojas, funcionários recebem salários e há transferências entre contas. O código usa threads e locks para garantir a sincronização em operações de saldo.

### Classes e Estrutura
- **Banco:** Responsável por realizar transferências entre contas.
- **Cliente:** Representa um cliente que realiza compras em uma ou mais lojas.
- **Conta:** Representa a conta bancária de um cliente ou de uma loja.
- **Funcionário:** Representa um funcionário de uma loja, com contas para salário, investimento e dívida.
- **Loja:** Representa uma loja, com contas para gerenciar o saldo e pagar os salários dos funcionários.

### Funcionamento
- Cada cliente tem um saldo inicial e realiza compras em todas as lojas.
- As lojas têm contas para pagar os salários dos funcionários e receber pagamentos das compras.
- Os funcionários recebem salários, investem parte do valor e pagam uma dívida fixa, com o restante indo para a conta de salário.

### Threads e Sincronização
- As classes Cliente, Funcionário e Loja são threads, permitindo que cada entidade funcione de forma independente.
- O uso de locks (Lock e ReentrantLock) garante a sincronização adequada em operações que envolvem alterações de saldo, evitando condições de corrida.

### Execução
- O método main inicia o sistema, criando o banco, lojas, funcionários e clientes.
- Os clientes realizam compras em um loop até que seu saldo seja zero.
- Os funcionários recebem salários, investem parte do valor e pagam a dívida.
- As lojas pagam os salários dos funcionários.

### Observações
- O código tem fins de demonstração e pode ser expandido para incluir mais funcionalidades, como interações mais complexas entre clientes, funcionários e lojas.
- A estrutura de threads pode ser otimizada para um cenário de produção, levando em consideração aspectos como concorrência e desempenho.
