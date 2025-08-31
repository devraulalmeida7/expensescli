package org.br.expense.repository;

import org.br.expense.ConfigDatabase;
import org.br.expense.models.Cliente;
import org.br.expense.models.Deposito;
import org.br.expense.models.Saque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteRepository {
    // CRUD - Create, Read ,Update and Delete


    Cliente cliente = new Cliente();





    public void salvarCliente(String nome, String email, String senha, String genero) {
        String sql = "INSERT INTO cliente (nome,email,senha,genero) VALUES (?,?,?,?)";
        try(
                Connection connection = ConfigDatabase.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, genero);

            stmt.executeUpdate();

        }
        catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


    // Read - Busca

    public boolean buscarCadastro(int id, String senha) {
        String sql = "SELECT * FROM cliente WHERE id = ? ";

        boolean existeCadastro = false;

        try(Connection connection = ConfigDatabase.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {


            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();


            if(rs.next()) {
                int rsID = rs.getInt(1);
                String rsNome = rs.getString(2);
                String rsEmail = rs.getString(3);
                String rsSenha = rs.getString(4);
                if(Objects.equals(rsSenha, senha)) {
                    System.out.println("Cadastro encontrado!");
                    System.out.println("Seja bem-vindo(a)");
                    existeCadastro = true;

                }
                else {
                    System.out.println("Suas informações estão erradas! Tente novamente");
                }

                System.out.println("ID:" + rsID);
                System.out.println("Nome:" + rsNome);


            }
            return existeCadastro;

        }

        catch(SQLException e) {
            throw new RuntimeException(e);
        }




    }




    public int buscarPorId(int id)  {
        String sql = "SELECT * FROM cliente WHERE id = ? ";

        try(Connection connection = ConfigDatabase.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {


            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();


           if(rs.next()) {
               int rsID = rs.getInt(1);
               System.out.println("ID:" + rsID);
          }


        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return id;
    }




    public void atualizarSaldo(double saldoUp) {
        String sqlUpdate = "UPDATE cliente SET saldo = ? WHERE id = ? ";

        try(Connection connectionUp = ConfigDatabase.getConnection();
            PreparedStatement stmtUp = connectionUp.prepareStatement(sqlUpdate)
        ) {
            stmtUp.setDouble(1,saldoUp);
            stmtUp.executeUpdate();

        }
        catch(SQLException e ) {
            e.printStackTrace();
        }
    }
    //Opções Financeiras - Saque e Depósito



}
