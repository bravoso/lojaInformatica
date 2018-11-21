package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.ServicoVO;
import br.senac.dd.cyberimports.model.vo.ServicoVO;

public class ServicoDAO {
public int inserir(ServicoVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO SERVICO (NOME, VALOR) VALUES (?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
                prepStmt.setLong(2, (long) f.getValor());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
					JOptionPane.showMessageDialog(null, "Serviço inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o Serviço. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(ServicoVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE SERVICO F SET NOME=?, VALOR=?, WHERE F.ID = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
				prepStmt.setLong(2, (long) f.getValor());
		
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o serviço");
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM SERVICO "
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
				System.out.println("Erro ao remover servico. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<ServicoVO> listarTodos(){
			String sql = " SELECT * FROM SERVICO ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ServicoVO> servicos = new ArrayList<ServicoVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					ServicoVO c = new ServicoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					c.setId(result.getInt("IDSERVICO"));
					c.setNome(result.getString("NOME"));
                    c.setValor(result.getDouble("VALOR"));
					
					//Outra forma de obter (POSICIONAL)
					// f.setNome(result.getString(4));
					// f.setSalario(result.getDouble(5));
                                        
					servicos.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return servicos;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public ServicoVO obterPorId(int id){
			String sql = " SELECT * FROM SERVICO "
					+ " WHERE ID=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ServicoVO c = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					c = new ServicoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					c.setId(result.getInt("IDservico"));
					c.setNome(result.getString("NOME"));
                    c.setValor(result.getDouble("VALOR"));

					
					//Outra forma de obter (POSICIONAL)
					//f.setNome(result.getString(4));
					//f.setSalario(result.getDouble(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
		}
}
