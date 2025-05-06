package com.example.cadastro_de_contatos;

public class Contato {

    //Atributos
    private int id;
    private String nome;
    private String celular;
    private String email;

    //Construtores
    public Contato(){
        id = 0;
        nome = "";
        celular = "";
        email = "";
    }
    public Contato(String nome, String celular, String email){
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }
}
