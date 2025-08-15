package org.br.expense.services;

import org.br.expense.ConfigDatabase;
import org.br.expense.models.Saque;
import org.br.expense.repository.ClienteRepository;
import org.br.expense.repository.SaqueRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ClienteService {
    private ClienteRepository clienteRepository;
    private SaqueRepository saqueRepository;

    public ClienteService(ClienteRepository clienteRepository,SaqueRepository saqueRepository) {
        this.clienteRepository = clienteRepository;
        this.saqueRepository = saqueRepository;

    }


    private List<Saque> historicoSaques = new ArrayList<>();
    public void realizarSaque(String nome, double valor, String categoria, int parcelas) {

    }
}
