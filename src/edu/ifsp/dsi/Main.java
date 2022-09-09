package edu.ifsp.dsi;


import java.sql.Connection;
import java.sql.SQLException;

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
						
			// TODO: inserir contas aqui
			
			
			/* 
			 * Tarefa 2
			 * Usando `PreparedStatement`, registre uma sequência de movimentações, da 
			 * primeira para a segunda conta. 
			 * 
			 * Use os valores contidos no vetor a seguir.
			 * Não é necessário atualizar o saldo. Apenas registre as movimentações.  
			 */
			double[] valores = {50, 1200, -300, 100, -73, -41, 80, 15, -20};
			
			// TODO: registrar movimentações aqui
			
			
		} catch (SQLException e) {
			System.err.println("Problemas com o banco de dados.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().executar();
	}
}
