package pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conexao.Conection;

public class PessoaCadastro {
	Pessoa pessoa = new Pessoa();

	public void cadastrarPessoa() throws SQLException {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o seu nome ");
		pessoa.setNome(ler.nextLine());
		System.out.println("Digite o seu email");
		pessoa.setEmail(ler.nextLine());
		System.out.println("Digite a sua senha");
		pessoa.setSenha(ler.nextLine());
		ler.close();
		String sql = "INSERT INTO cadastrop (nome, email, senha)VALUES(?, ?, ?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = Conection.createConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getEmail());
			pstm.setString(3, pessoa.getSenha());

			pstm.execute();

			System.out.println("Pessoa Criada com sucesso!");

			pstm.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println("Não foi possivel fazer o cadastro");
			System.out.println("O Erro foi\n:" + ex.getMessage());
		}
	}

	public void consultarPessoas() throws Exception {

		Scanner ler = new Scanner(System.in);

		String sql = "SELECT * FROM cadastrop";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = Conection.createConnection();
			pstm = conn.prepareStatement(sql);

			ResultSet r = pstm.executeQuery(sql);
			List<Pessoa> pessoas = new ArrayList<>();

			while (r.next()) {
				int id = r.getInt("id");
				String nome = r.getString("nome");
				String email = r.getString("email");
				String senha = r.getString("senha");
				pessoas.add(new Pessoa(id, nome, email, senha));
			}
			for (Pessoa p : pessoas) {
				System.out.println("ID da pessoa: " + p.getId() + "; nome da pessoa: " + p.getNome()
						+ "; Email da pessoa: " + p.getEmail() + "; Senha Da Pessoa: " + p.getSenha());
			}
			pstm.execute();

			System.out.println("Consulta consultada com sucesso!");

			pstm.close();
			conn.close();
			ler.close();

		} catch (Exception ex) {
			System.out.println("Não foi possivel fazer o cadastro");
			System.out.println("O Erro foi\n:" + ex.getMessage());
		}

	}

	public void atualizarPessoa() throws SQLException {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o seu nome, e lembrando ao começar a atualizar "
				+ "todos os seus dados terão que ser atualizados");
		String nomeAntigo = ler.nextLine();
		pessoa.setNome(nomeAntigo);

		String selectSQL = "SELECT * FROM cadastrop WHERE nome = ?";
		String updateSQL = "UPDATE cadastrop SET nome = ?, email = ?, senha = ?  WHERE nome = ?";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = Conection.createConnection();
			pstm = conn.prepareStatement(selectSQL);
			pstm.setString(1, pessoa.getNome());
			ResultSet r = pstm.executeQuery();
			if (r.next()) {
				System.out.println("===============================================");
				System.out.println("O nome atual é " + r.getString("nome"));
				System.out.println("O email atual é " + r.getString("email"));
				System.out.println("a senha atual é " + r.getString("senha"));
				System.out.println("================================================");
				System.out.println("Digite seu nome ");
				System.out.print("Informe o novo nome: ");
				pessoa.setNome(ler.nextLine());
				System.out.println("Iforme o Novo Email");
				pessoa.setEmail(ler.nextLine());
				System.out.println("Iforme a nova senha");
				pessoa.setSenha(ler.nextLine());

				pstm = conn.prepareStatement(updateSQL);
				pstm.setString(1, pessoa.getNome());
				pstm.setString(2, pessoa.getEmail());
				pstm.setString(3, pessoa.getSenha());
				pstm.setString(4, nomeAntigo);

				pstm.execute();

				System.out.println("Pessoa alterada com sucesso!");
				pstm.close();
				ler.close();

			} else {
				System.out.println("Pessoa não encontrada!");
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Não foi possivel fazer a atualização");
			System.out.println("O Erro foi\n:" + ex.getMessage());
		}
	}

	public void deletarPessoa() throws SQLException {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o seu nome, para deletarmos seus dados");
		String nomeAntigo = ler.nextLine();
		pessoa.setNome(nomeAntigo);

		String deleteSQL = "DELETE FROM cadastrop WHERE nome = ?";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = Conection.createConnection();
			pstm = conn.prepareStatement(deleteSQL);
			pstm.setString(1, pessoa.getNome());
			pstm.execute();

			System.out.println("Pessoa deletada  com sucesso!");
			pstm.close();
			ler.close();

			conn.close();
		} catch (Exception ex) {
			System.out.println("Não foi possivel fazer a atualização");
			System.out.println("O Erro foi\n:" + ex.getMessage());
		}
	}


	public void sair() {
		System.out.println("Obrigado por escolher a Agencia/Pectros");
	}
}
