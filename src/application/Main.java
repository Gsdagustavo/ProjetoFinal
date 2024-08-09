package application;

import util.Zoologico;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Zoologico zoologico = new Zoologico();

        System.out.println("=-=-=-=--=- ZOOLÓGICO =-=-=-=--");

        while (true) {
            boolean sair = false;

            showMenu();
            int opc = getInt();

            switch (opc) {
                case 1, 5:
                    zoologico.listarAnimais();
                    break;
                case 2:
                    zoologico.cadastrarAnimal();
                    break;
                case 3:
                    zoologico.consultarPorCodigo();
                    break;
                case 4:
                    zoologico.consultarPorEspecie();
                    break;
                case 6:
                    zoologico.alterarAnimal();
                    break;
                case 7:
                    zoologico.excluirAnimal();
                    break;
                case 8:
                    zoologico.limparLista();
                    break;
                case 9:
                    zoologico.quantidadeAnimais();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.err.println("Opção inválida");
                    break;
            }

            if (sair) { break; }
        }

    }

    public static void showMenu() {
        System.out.print(
                "\n[1] Listar Animais\n" +
                "[2] Cadastrar novo animal\n" +
                "[3] Consultar animal por código\n" +
                "[4] Consultar animal por espécie\n" +
                "[5] Listar todos os animais\n" +
                "[6] Alterar um animal (busca por código)\n" +
                "[7] Excluir animal por número\n" +
                "[8] Limpar lista de animais\n" +
                "[9]Imprimir quantidade de animais cadastrados\n" +
                "[0] Sair\n-> "
        );
    }

    public static int getInt() {
        String input;
        int n = 0;
        boolean valido = false;

        while (!valido) {
            input = sc.nextLine();
            try {
                n = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.print("Numero invalido, tente novamente: ");
            }
        }

        return n;
    }
}
