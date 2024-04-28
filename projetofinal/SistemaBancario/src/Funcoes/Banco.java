package Funcoes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Classe responsável pela representação do Banco
class Banco {
    private Lock lock;

    // Construtor da classe Banco
    public Banco() {
        this.lock = new ReentrantLock();
    }

    // Método para realizar a transferência entre contas
    public void transferencia(Conta origem, Conta destino, double valor) {
        lock.lock(); // Bloqueia o acesso ao recurso compartilhado
        try {
            if (origem.getSaldo() >= valor) {
                origem.debitar(valor);
                destino.creditar(valor);
            } else {
                System.out.println("Transferência não realizada devido a saldo insuficiente na conta de origem.");
            }
        } finally {
            lock.unlock(); // Libera o acesso ao recurso compartilhado
        }
    }
}