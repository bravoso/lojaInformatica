package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.FaturaVO;

public class FaturaDAO {
	
public int inserir(FaturaVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO FATURA (VALOR, DATA_COMPRA, TIPO) VALUES (?,?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setDouble(1, f.getValor());
                prepStmt.setDate(2, f.getData_compra());
				prepStmt.setString(3, f.getTipo());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
					JOptionPane.showMessageDialog(null, "Fatura inserida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir a fatura. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(FaturaVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE FATURA F SET VALOR=?, DATA_COMPRA=?, TIPO=? WHERE F.IDFATURA = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setDouble(1, f.getValor());
				prepStmt.setDate(2, f.getData_compra());
				prepStmt.setString(3, f.getTipo());
				prepStmt.setInt(4, f.getId());
				
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a fatura" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM FATURA "
					+ " WHERE IDFATURA = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){//1 - sucesso na execução
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover fatura. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<FaturaVO> listarTodos(){
			String sql = " SELECT * FROM FATURA ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<FaturaVO> faturas = new ArrayList<FaturaVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					FaturaVO f = new FaturaVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					f.setId(result.getInt("IDCLIENTE"));
					f.setValor(result.getDouble("VALOR"));
                    f.setData_compra(result.getDate("DATA_COMPRA"));
					f.setTipo(result.getString("TIPO"));
					
					//Outra forma de obter (POSICIONAL)
					// f.setNome(result.getString(4));
					// f.setSalario(result.getDouble(5));
                                        
					faturas.add(f);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return faturas;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public FaturaVO obterPorId(int id){
			String sql = " SELECT * FROM FATURA "
					+ " WHERE IDFATURA=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			FaturaVO f = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					f = new FaturaVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					f.setId(result.getInt("IDCLIENTE"));
					f.setValor(result.getDouble("VALOR"));
                    f.setData_compra(result.getDate("DATA_COMPRA"));
					f.setTipo(result.getString("TIPO"));
					
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
