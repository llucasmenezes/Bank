package lucca.bank;


import java.util.Scanner;
import java.util.List;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank Malu = new Bank("0001");
        while(true) {
            System.out.println(" O que deseja fazer? C=Criar conta, E=Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite seu nome");
                String name = scanner.nextLine();
                Account account = Malu.generateAccount(name);
                System.out.println(account);
                Malu.insertAccount(account);

                operateAccount(account);

            }
            else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!");
            }
        }


            List<Account> accountList = Malu.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }
        Malu.outputTotal();

    }

    static void operateAccount (Account account) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("O que deseja fazer? D=Deposito, S=Saque, E=Sair da conta V=valor na conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual o valor deseja depositar?S");
                double value = scanner.nextDouble();
                account.deposit(value);
            }
            else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops! não foi possível sacar o valor " + value);
                }
            }
            else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!");
            }

        }


    }
}
