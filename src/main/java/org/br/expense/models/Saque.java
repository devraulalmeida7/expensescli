package org.br.expense.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Saque  {
    private String nome;
    private double valor;
    private String categoria;
   // private LocalDateTime dataSaque = LocalDateTime.now();
    // opcional
    private  int parcelas;



    public Saque(String nome, double valor, String categoria, int parcelas) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.parcelas = parcelas;
    }
}
