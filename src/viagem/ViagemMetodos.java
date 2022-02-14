package viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import conexao.Conection;

public class ViagemMetodos {
	public void Agendar_Viagem(Scanner scan) throws Exception {
		Scanner x = scan;
		
		System.out.println("Ola vamos cadastrar um destino");

		System.out.println("Pra onde você gostaria de viajar ?");
		String var_destino = x.nextLine();
		System.out.println("De onde você gostaria de viajar ? [ Origem ] ");
		String origem = x.nextLine();
		Integer r;
		do {
			System.out.println("É uma viagem de ida e volta ?");
			System.out.println("1- Ida\n2- Ida e Volta");
			r = x.nextInt();
		} while (r != 1 && r != 2);
		if (r == 1) {
			System.out.println("Em que data você gostaria de estar indo ? (dd-mm-aaaa)");
			String data_ida = x.next();

			SimpleDateFormat objeto_de_formatacao = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = objeto_de_formatacao.parse(data_ida);
			long ms = date.getTime();
			java.sql.Date Date_sql_data_ida = new java.sql.Date(ms);

			Viagem destino = new Viagem(Date_sql_data_ida, origem, var_destino);

			String sql = "INSERT INTO viagem( ida, volta, origem, destino) VALUES(?, ?, ?,  ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				/* Agendando a viagem na tabela Destino */
				conn = Conection.createConnection();
				pstm = conn.prepareStatement(sql);

				pstm.setString(1, destino.getOrigem());
				pstm.setString(2, destino.getDestino());
				pstm.setDate(3, destino.getIda());
				pstm.execute();
				
				System.out.println("Viagem agendada com sucesso!");
				
				pstm.close();
				conn.close();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			System.out.println("Em que data você gostaria de estar indo ? (dd-mm-aaaa)");
			String data_ida = x.next();
			// Formantando a data de ida
			SimpleDateFormat objeto_de_formatacao = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = objeto_de_formatacao.parse(data_ida);
			long ms = date.getTime();
			java.sql.Date Date_sql_data_ida = new java.sql.Date(ms);

			System.out.println("Em que data você gostaria de estar voltando ? (dd-mm-aaaa");
			String data_volta = x.next();
			// Formantando a data de Volta
			SimpleDateFormat objeto_de_formatacao2 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date2 = objeto_de_formatacao2.parse(data_volta);
			long ms2 = date2.getTime();
			java.sql.Date Date_sql_data_volta = new java.sql.Date(ms2);

			Viagem destino = new Viagem( Date_sql_data_ida, Date_sql_data_volta, origem, var_destino);

			String sql = "INSERT INTO viagem(origem, destino, ida, volta) VALUES(?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = Conection.createConnection();
				pstm = conn.prepareStatement(sql);

				pstm.setString(1, destino.getOrigem());
				pstm.setString(2, destino.getOrigem());
				pstm.setDate(3, destino.getIda());
				pstm.setDate(4, destino.getVolta());

				pstm.execute();
				
				System.out.println("Viagem agendada com sucesso!");

				pstm.close();
				conn.close();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
