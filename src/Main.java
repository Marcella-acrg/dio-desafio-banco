//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente marcella = new Cliente();
        marcella.setNome("Marcella Araújo Coêlho R. Gomes");

        Conta cc = new ContaCorrente(marcella);
        Conta poupanca = new ContaPoupanca(marcella);

        cc.depositar(100);
        //cc.transferir(90, poupanca);
        cc.sacar(110);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}