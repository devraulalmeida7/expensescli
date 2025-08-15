package org.br.expense.repository;

import org.br.expense.ConfigDatabase;
import org.br.expense.models.Saque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaqueRepository {

    // CRUD - Create, Read ,Update and Delete

    ClienteRepository clienteRepository = new ClienteRepository();

    public void salvarSaque(String nomeSaque, double valorSaque, String categoriaSaque, int parcelasSaque) {
        String sqlSaque = "INSERT INTO saque (nome,valor,categoria,parcelas) VALUES (?,?,?,?)";
        Saque novoSaque = null;
        try (Connection conn = ConfigDatabase.getConnection();
             PreparedStatement stmtSaque = conn.prepareStatement(sqlSaque)) {


            novoSaque = new Saque(nomeSaque, valorSaque, categoriaSaque, parcelasSaque);
//



//            Saque sacar = cliente.sacar(nomeSaque,valorSaque,categoriaSaque,parcelasSaque);

            System.out.println("Saque realizado: " + novoSaque);


            stmtSaque.setString(1, nomeSaque);
            stmtSaque.setDouble(2, valorSaque);
            stmtSaque.setString(3, categoriaSaque);
            stmtSaque.setInt(4, parcelasSaque);

            stmtSaque.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
