package entities;

import java.time.LocalDate;

public class Animal {
    // Atributos
    private int codigo, idade;
    private String nome, dieta, habitat, especie;
    private float peso;
    private LocalDate dataNascimento;

    // Construtores
    public Animal() {
    }

    public Animal(int codigo, int idade, String nome, String dieta, String habitat, float peso, LocalDate dataNascimento, String especie) {
        this.codigo = codigo;
        this.idade = idade;
        this.nome = nome;
        this.dieta = dieta;
        this.habitat = habitat;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.especie = especie;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void alterarAnimal(int codigo, int idade, String nome, String dieta, String habitat, float peso, LocalDate dataNascimento, String especie) {
        this.codigo = codigo;
        this.idade = idade;
        this.nome = nome;
        this.dieta = dieta;
        this.habitat = habitat;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Código " + codigo + "#\n" +
                "Nome: " + nome +
                "\nIdade: " + idade +
                "\nEspécie: " + especie +
                "\nData de nascimento: " + dataNascimento +
                "\nPeso: " + String.format("%.2f", peso) +
                "\nHabitat: " + habitat +
                "\nDieta: " + dieta;
    }
}
