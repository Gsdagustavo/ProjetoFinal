package util;

import entities.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zoologico {

    public static Scanner sc = new Scanner(System.in);

    private final ArrayList<Animal> animais = new ArrayList<>();

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        for (Animal animal : animais) {
            System.out.println(animal + "\n");
        }
    }

    public void cadastrarAnimal() {
        System.out.print("=-=-=- CADASTRAR ANIMAL =-=-=-\n");

        Animal animal = criarAnimal();
        animais.add(animal);
    }

    public Animal criarAnimal() {
        System.out.print("Insira o código do animal: ");
        int codigo = getInt();

        while (checarCodigo(codigo) == -1) {
            System.err.print("Já existe um animal com esse código. Insira outro código: ");
            codigo = getInt();
        }

        System.out.print("Insira o nome do animal: ");
        String nome = sc.nextLine();

        System.out.print("Insira a data de nascimento do animal (aaaa-mm-dd): ");
        String data;
        LocalDate date;

        while (true) {
            data = getString();

            try {
                date = LocalDate.parse(data);
                break;
            } catch (DateTimeParseException e) {
                System.err.print("Data inválida, tente novamente: ");
            }
        }

        System.out.print("Insira a espécie do animal: ");
        String especie = sc.nextLine();

        System.out.print("Insira a idade do animal: ");
        int idade = getInt();

        System.out.print("Insira o peso do animal: ");
        float peso = getFloat();

        System.out.print("Insira a dieta do animal: ");
        String dieta = sc.nextLine();

        System.out.print("Insira o habitat do animal: ");
        String habitat = sc.nextLine();

        return new Animal(codigo, idade, nome, dieta, habitat, peso, date, especie);
    }

    public void consultarPorCodigo() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        System.out.println("=-=-=- CONSULTAR POR CODIGO =-=-=-=");
        System.out.print("Insira o código do animal: ");
        int cod = getInt();

        for (Animal animal : animais) {
            if (animal.getCodigo() == cod) {
                System.out.println("Animal encontrado!\n" + animal);
                return;
            }
        }

        System.err.println("Animal não encontrado.");
    }

    public void consultarPorEspecie() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        System.out.print("=-=-=- CONSULTAR POR ESPÉCIE =-=-=-=\nInsira a espécie: ");
        String especie = getString();

        System.out.println("Exibindo todos os animais da espécie " + especie);
        for (Animal animal : animais) {
            if (animal.getEspecie().equals(especie)) {
                System.out.println(animal);
            }
        }
    }

    public void alterarAnimal() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        System.out.print("Insira o código do animal a ser alterado: ");
        int cod = getInt();

        if (checarCodigo(cod) == 0) {
            System.err.println("Não existe nenhum animal com o código " + cod);
            return;
        }

        System.out.print("Insira o código do animal: ");
        int codigo = getInt();

        Animal anim = null;

        for (Animal animal : animais) {

            if (animal.getCodigo() == codigo) {
                anim = animal;
            }

            while (animal.getCodigo() == codigo) {
                System.err.print("Já existe um animal com esse código. Insira outro código: ");
                codigo = getInt();
            }
        }

        System.out.print("Insira o nome do animal: ");
        String nome = sc.nextLine();

        System.out.print("Insira a data de nascimento do animal (aaaa-mm-dd): ");
        String data;
        LocalDate date;

        while (true) {
            data = getString();

            try {
                date = LocalDate.parse(data);
                break;
            } catch (DateTimeParseException e) {
                System.err.print("Data inválida, tente novamente: ");
            }
        }

        System.out.print("Insira a espécie do animal: ");
        String especie = sc.nextLine();

        System.out.print("Insira a idade do animal: ");
        int idade = getInt();

        System.out.print("Insira o peso do animal: ");
        float peso = getFloat();

        System.out.print("Insira a dieta do animal: ");
        String dieta = sc.nextLine();

        System.out.print("Insira o habitat do animal: ");
        String habitat = sc.nextLine();

        if (anim != null) {
            anim.alterarAnimal(codigo, idade, nome, dieta, habitat, peso, date, especie);
            System.out.println("Animal alterado com sucesso");
        }
    }

    public int checarCodigo(int codigo) {
        for (Animal animal : animais) {
            if (animal.getCodigo() == codigo) {
                return -1;
            }
        }
        return 0;
    }

    public void excluirAnimal() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        System.out.print("=-=-=- EXCLUIR ANIMAL =-=-=-\nInsira o código do animal a ser excluído: ");
        int cod = getInt();

        for (Animal animal : animais) {
            if (animal.getCodigo() == cod) {
                animais.remove(animal);
                System.out.println("O animal com o código" + cod + ", de nome " + animal.getNome() + " foi excluído da lista");
                return;
            }
        }

        System.err.println("Animal não encontrado na lista");
    }

    public void limparLista() {
        if (animais.isEmpty()) {
            System.err.println("A lista de animais está vazia\n");
            wait(500);
            return;
        }

        System.out.print("Tem certeza que deseja limpar a lista de animais? [S / N]: ");
        String opc = getString().toUpperCase();

        if (opc.equals("S")) {
            animais.clear();
            System.out.println("A lista de animais foi limpada");
        } else {
            System.err.println("Operação abortada");
        }
    }

    public void quantidadeAnimais() {
        System.out.println("Quantidade de animais na lista: " + animais.size());
    }

    public float getFloat() {
        String input;
        float n = 0F;
        boolean valido = false;

        while (!valido) {
            input = sc.nextLine();
            try {
                n = Float.parseFloat(input);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.print("Numero invalido, tente novamente: ");
            }
        }

        return n;
    }

    public int getInt() {
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

    public String getString() {
        String input = " ";
        boolean valido = false;

        while (!valido) {
            try {
                input = sc.nextLine();
                valido = true;
            } catch (Exception e) {
                System.err.print("Inválido, tente novamente: ");
            }
        }

        return input;
    }

    public void wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (RuntimeException | InterruptedException Ignored) { }
    }
}
