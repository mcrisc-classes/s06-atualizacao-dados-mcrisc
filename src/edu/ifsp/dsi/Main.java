package edu.ifsp.dsi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public void executar() {		
		try (Connection conn = ConnectionProvider.getConnection()) {

			/*
			 * Tarefa 1
			 * Implemente a inserção de duas novas contas, usando `Statement`s simples.
			 * 
			 * Antes, você vai precisar cadastrar pessoas, caso sua tabela `pessoa` esteja
			 * vazia. Use o seu cliente MySQL para fazer isso.
			 */
						
			String queryTemplate = "INSERT INTO conta (numero, saldo, titular)"
					+ " VALUES (%d, %d, %d);";
			try (Statement stmt = conn.createStatement()) {
				String query = String.format(queryTemplate,
						10, 500, 1);
				System.out.println(query);
				stmt.executeUpdate(query);
				
				query = String.format(queryTemplate,
						11, 700, 2);
				stmt.executeUpdate(query);
				
			}
			
			
			/* 
			 * Tarefa 2
			 * Usando `PreparedStatement`, registre uma sequência de movimentações, da 
			 * primeira para a segunda conta. 
			 * 
			 * Use os valores contidos no vetor a seguir.
			 * Não é necessário atualizar o saldo. Apenas registre as movimentações.  
			 */
			double[] valores = {50, 1200, -300, 100, -73, -41, 80, 15, -20};
			
			String query = "INSERT INTO movimentacao (origem, destino, valor) "
					+ "VALUES (?, ?, ?);";
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				for (double valor : valores) {
					ps.setInt(1, 10);
					ps.setInt(2, 11);
					ps.setDouble(3, valor);
					ps.executeUpdate();
				}
			}
			
			
		} catch (SQLException e) {
			System.err.println("Problemas com o banco de dados.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().executar();
	}
}
