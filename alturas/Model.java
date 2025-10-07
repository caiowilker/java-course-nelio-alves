package org.example.alturas;

public class Model {
    private String name;
    private int idade;
    private double altura;
    private int quantidade;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
    }

    public Model(int idade) {
        this.idade = idade;
    }

    public Model(double altura) {
        this.altura = altura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
