package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;

public class FuncionarioDAO {
	
public int inserir(FuncionarioVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO FUNCIONARIO (NOME, CPF, SALARIO) VALUES (?,?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
                                prepStmt.setString(2, f.getCpf());
				prepStmt.setDouble(3, f.getSalario());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o funcionario. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(FuncionarioVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE FUNCIONARIO F SET NOME=?, CPF=?, SALARIO=?, WHERE F.ID = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
                                prepStmt.setString(2, f.getCpf());
				prepStmt.setDouble(3, f.getSalario());
				prepStmt.setInt(4, f.getIdFuncionario());
				
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o funcionario");
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM FUNCIONARIO "
					+ " WHERE ID = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){//1 - sucesso na execução
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover funcionario. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<FuncionarioVO> listarTodos(){
			String sql = " SELECT * FROM FUNCIONARIO ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					FuncionarioVO f = new FuncionarioVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					f.setIdFuncionario(result.getInt("IDFUNCIONARIO"));
					f.setNome(result.getString("NOME"));
                                        f.setCpf(result.getString("CPF"));
					f.setSalario(result.getDouble("SALARIO"));
					
					//Outra forma de obter (POSICIONAL)
					// f.setNome(result.getString(4));
					// f.setSalario(result.getDouble(5));
                                        
					funcionarios.add(f);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return funcionarios;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public FuncionarioVO obterPorId(int id){
			String sql = " SELECT * FROM FUNCIONARIO "
					+ " WHERE ID=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			FuncionarioVO f = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					f = new FuncionarioVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					f.setIdFuncionario(result.getInt("ID"));
					f.setNome(result.getString("NOME"));
                                        f.setCpf(result.getString("CPF"));
					f.setSalario(result.getDouble("SALARIO"));
					
					//Outra forma de obter (POSICIONAL)
					//f.setNome(result.getString(4));
					//f.setSalario(result.getDouble(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return f;
		}
	}
