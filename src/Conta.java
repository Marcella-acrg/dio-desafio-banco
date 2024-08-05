public abstract class Conta implements Iconta {

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1 ;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo >= valor) {
            System.out.println("Saldo total R$: " + this.saldo);
        this.saldo -= valor;
            System.out.println("Valor da operação R$: " + valor);
            System.out.println("Saldo atualizado R$: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente! O valor da operação é superior ao limite disponível na conta para saque.");
            System.out.println("Valor da operação R$: " + valor);
            System.out.println("Saldo total R$: " + this.saldo);
        }
    }

    @Override
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }

    @Override
    public void transferir(double valor, Iconta contaDestino) {
        if(this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente! O valor da operação é superior ao limite disponível na conta para transferência.");
            System.out.println("Valor da operação R$: " + valor);
            System.out.println("Saldo total R$: " + this.saldo);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
