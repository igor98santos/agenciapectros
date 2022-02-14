package services;

import java.util.Scanner;

import pessoa.PessoaCadastro;
import viagem.ViagemMetodos;

public class services {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		PessoaCadastro pessoa = new PessoaCadastro();
		ViagemMetodos lets = new ViagemMetodos();
		Integer escolha;
		do {
		System.out.println("================================================");
		System.out.println("Olá seja bem vindo a Agencia/Pectros");
		System.out.println("================================================");
		System.out.println("Digite o Numero Correspondente a sua Escolha");
		System.out.println("1 - Cadastrar pessoa");
		System.out.println("2 - Consultar Dados  de cadastro");
		System.out.println("3 -  Atualizar Cadastro Pessoa");
		System.out.println("4 -  Deletar Cadastro");
		System.out.println("5 -  Cadastrar Viagem");
		System.out.println("6 -  Sair");
		System.out.println("================================================");
		escolha = ler.nextInt();
		switch (escolha) {
		case 1:
			pessoa.cadastrarPessoa();
			break;
		case 2:
			pessoa.consultarPessoas();
			break;
		case 3:
			pessoa.atualizarPessoa();
			break;
		case 4:
			pessoa.deletarPessoa();
			break;
		case 5:
			lets.Agendar_Viagem(ler);
			break;
		case 6:
			pessoa.sair();
			break;
		default:
			System.out.println("Escolha invalida");
		}
		}while(escolha != 6);
	}
}
