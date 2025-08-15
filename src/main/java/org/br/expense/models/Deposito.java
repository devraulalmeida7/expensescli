package org.br.expense.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Deposito {
    private String nome;
    private String categoria;
    private double valor;
//    private LocalDateTime dataDeposito = LocalDateTime.now();

    public Deposito(String nome, double valor, String categoria ) {
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
    }


}
