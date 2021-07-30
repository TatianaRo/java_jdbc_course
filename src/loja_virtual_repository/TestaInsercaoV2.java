package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoV2 {
	
	// Adição do PreparedStatement que cria a possibilidade de criar parametros
	//parar as queries e evita sql injection
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		//O try com parâmetros - try with resources - vai fechar as conexões e statement 
		//ao final da transação, isso só é possível pq as classe  estedem a classe AutoCloseable
		try (Connection con = connectionFactory.createConnection()) {
			
			//colocando essa opção como false o commit e o fechamento
			//da conexão deixam de ser automaticos
			con.setAutoCommit(false);

			try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionaProduto("Fone de ouvido", "Fone de ouvido philips", stm);
				adicionaProduto("Hacker", "Hacker marrom", stm);

				con.commit(); 
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Fazendo o rollback");
				con.rollback();
			}

		}

	}
	
	public static void adicionaProduto(String produto, String descricao, PreparedStatement stm) throws SQLException {

		stm.setString(1, produto);

		stm.setString(2, descricao);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				System.out.println("O id adicionado foi: " + rst.getInt(1));
			}
		}
	}		
}
