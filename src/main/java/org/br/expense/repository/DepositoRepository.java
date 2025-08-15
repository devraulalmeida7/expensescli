package org.br.expense.repository;

import org.br.expense.ConfigDatabase;
import org.br.expense.models.Deposito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositoRepository {

    // CRUD - Create, Read ,Update and Delete

    public void salvarDeposito(String nome, double valor, String categoria) {
        String sqlDeposito = "INSERT INTO deposito (nome,valor,categoria) values (?,?,?)";

        try(
                Connection conn = ConfigDatabase.getConnection();
                PreparedStatement stmtSaque = conn.prepareStatement(sqlDeposito)
        ) {
            System.out.println("Depósito: " + nome + "De valor:" +valor);

            stmtSaque.setString(1, nome);
            stmtSaque.setDouble(2, valor);
            stmtSaque.setString(3, categoria);

            stmtSaque.executeUpdate();
        }
        catch (
                SQLException e) {
            e.printStackTrace();
        }
    }



}
