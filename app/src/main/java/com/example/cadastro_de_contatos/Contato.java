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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getNome(){
        return nome;
     }
     public void setNome(String nome){
        this.nome = nome;
     }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
