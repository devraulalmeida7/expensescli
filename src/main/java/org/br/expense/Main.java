package org.br.expense;
import org.br.expense.models.Cliente;
import org.br.expense.models.Deposito;
import org.br.expense.models.Saque;
import org.br.expense.repository.ClienteRepository;
import org.br.expense.repository.DepositoRepository;
import org.br.expense.repository.SaqueRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);




            System.out.println("Bem-vindo ao Expense!");
            System.out.println("");

            System.out.println("Selecione alguma das opções:" );
            System.out.println("1 -Cadastrar conta ");
            System.out.println("2 - Logar no sistema");
            System.out.println("0 - Sair do sistema");

        ClienteRepository clienteRepository = new ClienteRepository();
        SaqueRepository saqueRepository = new SaqueRepository();
        DepositoRepository depositoRepository = new DepositoRepository();
        Cliente cliente = new Cliente();



            int op = leitura.nextInt();
            switch(op) {
                case 1:
                    System.out.println("Digite o seu nome: ");
                    String nome = leitura.nextLine();

                    if(nome == "") {
                        nome = leitura.nextLine();
                    }

                    System.out.println("Digite seu o email: ");
                    String email = leitura.nextLine();

                    System.out.println("Digite sua senha: ");
                    String senha = leitura.nextLine();

                    if(senha == "") {
                        senha = leitura.nextLine();
                    }

                    System.out.println("Digite o seu gênero: ");
                    String genero = leitura.nextLine();





                    clienteRepository.salvarCliente(nome,email,senha,genero);

                    break;


                case 2:
                    System.out.println("Buscar por id");
                    int id = leitura.nextInt();

                    if(id == 0) {
                        id = leitura.nextInt();
                    }
                    clienteRepository.buscarPorId(id);

                case 3:
                    System.out.println("Digite seu o ID:");
                    int idLogin = leitura.nextInt();

                    System.out.println("Digite a sua senha: ");
                    String senhaLogin = leitura.nextLine();

                    if(senhaLogin == "") {
                        senhaLogin = leitura.nextLine();
                    }

                    boolean accountExists = clienteRepository.buscarCadastro(idLogin,senhaLogin);


                    if(accountExists) {
                        System.out.println("Cadastro encontrado!");
                        break;
                    }
                    else {
                        System.out.println("Seu cadastro não foi encontrado! Preencha os dados novamente");
                    }





                case 0:
                    break;
            }




            // Operações financeiras


            System.out.println("Para fazer uma operação, digite umas das opções");
        System.out.println("3 - Sacar");
        System.out.println("4 - Depositar");
        System.out.println("0 - Sair do sistema");


        int option = leitura.nextInt();
            switch (option) {
                case 3:

                    System.out.println("Opção Saque selecionada!");
                    System.out.println("");

                    System.out.println("Qual o nome do seu saque?");
                    String nomeSaque = leitura.nextLine();
                    if(nomeSaque == "") {
                        nomeSaque = leitura.nextLine();
                    }

                    System.out.println("Qual o valor do seu saque?");
                    double valorSaque = leitura.nextDouble();


                    System.out.println("Qual é a categoria do seu saque?");
                    String categoriaSaque = leitura.nextLine();
                    if(categoriaSaque == "") {
                        categoriaSaque = leitura.nextLine();
                    }

                    System.out.println("O saque foi parcelado?" +
                            " Pressione S para sim ou N para não ");
                    String saqueFoiParcelado = leitura.nextLine();
                    int parcelasSaque = 1;

                    if(saqueFoiParcelado == "S") {
                        System.out.println("Digite o número de parcelas:");
                        parcelasSaque = leitura.nextInt();
                    }

                    double saque = cliente.sacar(valorSaque);
                    clienteRepository.atualizarSaldo(saque);
                    saqueRepository.salvarSaque(nomeSaque,valorSaque,categoriaSaque,parcelasSaque);


                break;

                case 4:
                    System.out.println("Opção Depósito selecionada!");

                    System.out.println("Digite o nome do seu depósito");
                    String nomeDeposito = leitura.nextLine();

                    if(nomeDeposito == "") {
                        nomeDeposito = leitura.nextLine();
                    }


                    System.out.println("Digite o valor  do seu depósito");
                    double valorDeposito = leitura.nextDouble();


                    System.out.println("Digite a categoria do seu depósito");
                    String categoriaDeposito = leitura.nextLine();


                    if(categoriaDeposito == "") {
                        categoriaDeposito = leitura.nextLine();
                    }

                    double deposito = cliente.depositar(valorDeposito);
                    clienteRepository.atualizarSaldo(deposito);
                   depositoRepository.salvarDeposito(nomeDeposito,valorDeposito,categoriaDeposito);

                case 0:
                    break;
            }



        }

    }