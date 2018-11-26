package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;

public class ProdutoDAO {
	
public int inserir(ProdutoVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO PRODUTO (NOME, CUSTO, PREÇO, QUANTIDADE) VALUES (?,?,?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
                prepStmt.setDouble(2, f.getCusto());
				prepStmt.setDouble(3, f.getPreco());
				prepStmt.setInt(4, f.getQuantidade());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o produto. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(ProdutoVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE PRODUTO F SET NOME=?, CUSTO=?, PREÇO=?, QUANTIDADE=?, WHERE F.ID = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
				prepStmt.setDouble(2, f.getCusto());
				prepStmt.setDouble(3, f.getPreco());
				prepStmt.setInt(4, f.getQuantidade());
				
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o produto" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM PRODUTO "
					+ " WHERE IDPRODUTO = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){//1 - sucesso na execução
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover produto. Id = " + id + ". causa: " + e.getMessage());
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<ProdutoVO> listarTodos(){
			String sql = " SELECT * FROM PRODUTO ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					ProdutoVO p = new ProdutoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					p.setId(result.getInt("IDPRODUTO"));
					p.setNome(result.getString("NOME"));
                    p.setCusto(result.getDouble("CUSTO"));
					p.setPreco(result.getDouble("PREÇO"));
					p.setQuantidade(result.getInt("QUANTIDADE"));
                                        
					produtos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public ProdutoVO obterPorId(int id){
			String sql = " SELECT * FROM PRODUTO "
					+ " WHERE ID=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ProdutoVO p = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					p = new ProdutoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					p.setId(result.getInt("IDPRODUTO"));
					p.setNome(result.getString("NOME"));
                    p.setCusto(result.getDouble("CUSTO"));
					p.setPreco(result.getDouble("PREÇO"));
					p.setQuantidade(result.getInt("QUANTIDADE"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}

}
