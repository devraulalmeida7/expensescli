package org.br.expense.models;

import com.google.gson.Gson;
import org.br.expense.ConfigDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private String genero;
    private double saldo = 10000;
    private List<Saque> historicoSaques = new ArrayList<>();
    private List<Deposito> historicoDepositos = new ArrayList<>();




//    // construtor
//    public Cliente(String nome, String email, String senha, String genero, List<Saque> historicosSaques, List<Deposito> historicosDepositos) {
//        this.nome = nome;
//        this.email = email;
//        this.senha = senha;
//        this.genero = genero;
//        this.historicoSaques = historicoSaques;
//        this.historicoDepositos = historicoDepositos;
//    }


    // Metodo de saque


    public double sacar(double valor) {

        if (valor > saldo) throw new IllegalStateException("Saldo Insuficiente!");
        saldo -= valor;

//        // verificação parcelas
//        if (parcelas == 0 || parcelas == 1) {
//            parcelas = 1;
//        }
        return saldo;
    }

    // Depósito

    public double depositar(double valor) {
        saldo += valor;

        return saldo;
    }


    public double exibirSaldo() {
        return saldo;
    }




    //GETTERS


    public List<Deposito> getHistoricoDepositos() {
        return historicoDepositos;
    }

    public List<Saque> getHistoricoSaques() {
        return historicoSaques;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getGenero() {
        return genero;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
